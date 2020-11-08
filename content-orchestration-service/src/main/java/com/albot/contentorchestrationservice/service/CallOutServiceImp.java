package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.postgres.entity.CallOutEntity;
import com.albot.contentorchestrationservice.postgres.repository.CallOutRepository;
import com.albot.contentorchestrationservice.model.CallOut;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.CallOutHadmIdNotFoundException;
import com.albot.contentorchestrationservice.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
public class CallOutServiceImp implements CallOutService {

    private static final Logger logger = LoggerFactory.getLogger(CallOutServiceImp.class);

    private CallOutRepository callOutRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    public CallOutServiceImp(CallOutRepository callOutRepository) {
        logger.info("Initialization of the callOutRepository object in callOut service");
        this.callOutRepository = callOutRepository;
    }

    @Override
    public List<CallOut> getAllCallOut() {
        logger.info("Making call to database for fetching list of callOut information");
        return convertToListCallOut(callOutRepository.findAll());
    }

    @Override
    public CallOut getCallOutByhadmId(Integer hadmId) {
        CallOutEntity callOutEntity = callOutRepository.findByhadmId(hadmId);
        logger.info("Successfully retrieved callOut information based on condition : hadmId : {} and data : {} ", hadmId ,callOutEntity);
        if (!Objects.isNull(callOutEntity)) {
            if (callOutEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve callOut information based on condition : hadmId : {} because of  data is deleted and  flag status is {}",
                        hadmId, callOutEntity.getStatusFlag() );
                throw new BadStatusRequestException(
                        String.format("Invalid  hadmId value as a %d, Please provide correct hadmId", hadmId));
            }
        } else {
            logger.error("CallOut information data not found in database based on condition : hadmId = {} ", hadmId);
            throw new CallOutHadmIdNotFoundException(
                    String.format("Given hadmId not found in callOut information with value  %d", hadmId));
        }
        return convertToCallOut(callOutEntity);
    }

    @Override
    public CallOut createCallOut(CallOut callOut)  {
        CallOutEntity callOutEntity = convertToCallOutEntity(callOut);
        callOutEntity.setStatusFlag(Boolean.FALSE);
        logger.info("Making call to database for saving callOut information : {}" ,callOutEntity);
         CallOut callOutInfo = convertToCallOut(
                callOutRepository.save(callOutEntity));
        try {
            ElasticSearchUtility.restClient(Util.IndexType.CALLOUT.name().toLowerCase(),
                    String.valueOf(callOutInfo.getHadmId()), Util.toObjectToJson(callOutInfo));
        } catch (JsonProcessingException e) {
            logger.error("Failed to process object mapper to converter java object to json: {}", e);
        }
        log.info("Returned call out response");
        return callOutInfo;
    }

    @Override
    public CallOut updateCallOut(CallOut callOut) {
        logger.info("Making call to database for updating callOut information : {}" ,callOut);
        return convertToCallOut(
                callOutRepository.save(
                        convertToCallOutEntity(callOut)));
    }

    @Override
    public void deleteCallOutByhadmId(Integer hadmId) {
        CallOutEntity callOutEntity = callOutRepository.findByhadmId(hadmId);
        logger.info("Successfully retrieved callOut information based on condition : hadmId : {} and data : {} for deleting", hadmId ,callOutEntity);
        if(!Objects.isNull(callOutEntity) && hadmId.equals(callOutEntity.getHadmId())){
               callOutEntity.setStatusFlag(Boolean.TRUE);
               logger.info("Making call to databased for updating flag : {}  and data : {} ", callOutEntity.getStatusFlag(), callOutEntity);
               callOutRepository.save(callOutEntity);
            logger.info("Successfully updated flag in callOut service based on condition : hadmId = {} in case of delete", hadmId);
        } else {
            throw new CallOutHadmIdNotFoundException(
                    String.format("Given hadmId with value %d not " +
                               "found in callOut information, Please provide correct hadmId", hadmId));
        }
    }

    private CallOutEntity convertToCallOutEntity(CallOut callOut) {
        return modelMapper
                .map(callOut, CallOutEntity.class);
    }

    private CallOut convertToCallOut(CallOutEntity callOutEntity) {
        return modelMapper
                .map(callOutEntity, CallOut.class);
    }

    private List<CallOut> convertToListCallOut(List<CallOutEntity> callOutEntities) {
        return modelMapper
                .map(callOutEntities, List.class);
    }
}
