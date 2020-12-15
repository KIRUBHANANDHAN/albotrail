package io.albot.ventilator.manager.service.impl;


import io.albot.ventilator.manager.model.dto.HospitalRegistrationEntity;
import io.albot.ventilator.manager.model.web.HospitalRegistration;
import io.albot.ventilator.manager.repos.postgres.HospitalRegistrationRepository;
import io.albot.ventilator.manager.service.HospitalRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HospitalRegistrationServiceImp implements HospitalRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(GenerateOneTimePassword.class);

    private final ModelMapper modelMapper;

    private final HospitalRegistrationRepository hospitalRegistrationRepository;

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

    @Override
    public String getContact(String hosp_id) {

        String number = hospitalRegistrationRepository.findContact(Long.parseLong(hosp_id));
        return number;
    }

    @Override
    public List<HospitalRegistration> getAllHospitals() {
        List<HospitalRegistrationEntity>  hosps=  hospitalRegistrationRepository.findAll();
         return convertToHospList(hosps);
    }

    private HospitalRegistrationEntity convertToHospitalRegistrationEntity(HospitalRegistration hospitalRegistration) {
        return modelMapper
                .map(hospitalRegistration, HospitalRegistrationEntity.class);
    }

    private HospitalRegistration convertToHospitalRegistration(HospitalRegistrationEntity hospitalRegistrationEntity) {
        return modelMapper
                .map(hospitalRegistrationEntity, HospitalRegistration.class);
    }

    private List<HospitalRegistration> convertToHospList(List<HospitalRegistrationEntity> hospitalRegistrationEntity) {
        return modelMapper
                .map(hospitalRegistrationEntity, List.class);
    }
}
