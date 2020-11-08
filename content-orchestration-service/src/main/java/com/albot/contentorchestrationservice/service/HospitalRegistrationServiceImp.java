package com.albot.contentorchestrationservice.service;


import com.albot.contentorchestrationservice.postgres.entity.HospitalRegistrationEntity;
import com.albot.contentorchestrationservice.postgres.repository.HospitalRegistrationRepository;
import com.albot.contentorchestrationservice.model.HospitalRegistration;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HospitalRegistrationServiceImp implements HospitalRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(GenerateOneTimePassword.class);

    private ModelMapper modelMapper;

    private HospitalRegistrationRepository hospitalRegistrationRepository;

    @Autowired
    public HospitalRegistrationServiceImp(ModelMapper modelMapper, HospitalRegistrationRepository hospitalRegistrationRepository) {
        this.modelMapper = modelMapper;
        this.hospitalRegistrationRepository = hospitalRegistrationRepository;
    }


    @Override
    public HospitalRegistration createHospital(HospitalRegistration hospitalRegistration) {
        return convertToHospitalRegistration(
                hospitalRegistrationRepository
                        .save(convertToHospitalRegistrationEntity(hospitalRegistration)));
    }

    private HospitalRegistrationEntity convertToHospitalRegistrationEntity(HospitalRegistration hospitalRegistration) {
        return modelMapper
                .map(hospitalRegistration, HospitalRegistrationEntity.class);
    }

    private HospitalRegistration convertToHospitalRegistration(HospitalRegistrationEntity hospitalRegistrationEntity) {
        return modelMapper
                .map(hospitalRegistrationEntity, HospitalRegistration.class);
    }
}
