package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.exceptions.FailedToSendOneTimePassword;
import com.albot.ventilator.manager.exceptions.FailedToValidateOneTimePassword;
import com.albot.ventilator.manager.exceptions.UserCredentialNotFound;
import com.albot.ventilator.manager.model.OneTimePassword;
import com.albot.ventilator.manager.model.UserCredentialEntity;
import com.albot.ventilator.manager.repos.postgres.UserCredentialRepository;
import com.albot.ventilator.manager.service.Impl.OtpService;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class OtpServiceImp implements OtpService {

    private static final Logger logger = LoggerFactory.getLogger(OtpServiceImp.class);

    private final UserCredentialRepository userCredentialRepository;

    private final GenerateOneTimePassword generateOneTimePassword;

    private final AmazonSNS amazonSNS;

    @Autowired
    public OtpServiceImp(UserCredentialRepository userCredentialRepository, GenerateOneTimePassword generateOneTimePassword, AmazonSNS amazonSNS) {
        this.userCredentialRepository = userCredentialRepository;
        this.generateOneTimePassword = generateOneTimePassword;
        this.amazonSNS = amazonSNS;
    }

    @Override
    public String getRandomNumber(String userName) {
        UserCredentialEntity userCredentialEntity = userCredentialRepository.getByUserName(userName);
        if (Objects.isNull(userCredentialEntity)) {
            throw new UserCredentialNotFound("Given userName or password account not found, Please provide correct userName");
        }
        Integer otpNumber = generateOneTimePassword.generateOTP(userName);
        if (!Objects.isNull(otpNumber)) {
            String message = "Your OTP is " + otpNumber + ".This is valid for only 1 minute and can be used only once.";
            Map<String, MessageAttributeValue> map = new HashMap<>();
          /*  map.put("AWS.SNS.SMS.SenderID",
                        new  MessageAttributeValue().withStringValue("MyWebsite").withDataType("String"));*/
            map.put("AWS.SNS.SMS.SMSType",
                    new MessageAttributeValue().withStringValue("Transactional").withDataType("String"));
            PublishResult res = amazonSNS.publish(new PublishRequest().withMessage(message).withPhoneNumber(String.valueOf(userCredentialEntity.getUserMobileNumber())).withMessageAttributes(map));
            logger.info("message Id: {} ", res.getMessageId());

            return "Successfully send otp to your mobile number";
        } else {
            logger.error("Failed to send one time password, user : {} ", userName);
            throw new FailedToSendOneTimePassword("Given user " + userName + " don't have mobile");
        }
    }

    @Override
    public OneTimePassword validateGivenOtp(OneTimePassword oneTimePassword) {
        Integer getOTP = generateOneTimePassword.getOTPByKey(oneTimePassword.getUserName());
        logger.info("Started validate given OTP......{}, {}", getOTP, getOTP.equals(oneTimePassword.getOtpNumber()));
        if (getOTP.equals(oneTimePassword.getOtpNumber())) {
            logger.info("Successfully validate otp for given user {}", oneTimePassword.getUserName());
            generateOneTimePassword.clearOTPFromCache(oneTimePassword.getUserName());
            return oneTimePassword;
        } else {
            logger.info("Failed validate otp for given user {}", oneTimePassword.getUserName());
            throw new FailedToValidateOneTimePassword("Failed to validate OTP for given user " + oneTimePassword.getUserName());
        }
    }
}
