package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.exceptions.AdmissionsHadmIdNotFoundException;
import com.albot.ventilator.manager.exceptions.BadStatusRequestException;
import com.albot.ventilator.manager.model.web.Admissions;
import com.albot.ventilator.manager.model.dto.AdmissionsEntity;
import com.albot.ventilator.manager.repos.postgres.AdmissionsRepository;
import com.albot.ventilator.manager.service.AdmissionsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AdmissionsServiceImp implements AdmissionsService {

    private static final Logger logger = LoggerFactory.getLogger(AdmissionsServiceImp.class);

    private final AdmissionsRepository admissionsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AdmissionsServiceImp(AdmissionsRepository admissionsRepository) {
        logger.info("Initialization of the admissionsRepository object in admissions service");
        this.admissionsRepository = admissionsRepository;
    }

    @Override
    public List<Admissions> getAllAdmissions() {
        logger.info("Making call to database for fetching list of admissions information");
        return convertToListAdmissions(admissionsRepository.findAll());
    }

    @Override
    public Admissions getAdmissionsByhadmId(Integer hadmId) {
        AdmissionsEntity admissionsEntity = admissionsRepository.findByhadmId(hadmId);
        logger.info("Successfully retrieved admissions information based on condition : hadmId : {} and data : {} ", hadmId, admissionsEntity);
        if (!Objects.isNull(admissionsEntity)) {
            if (admissionsEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve admissions information based on condition : hadmId : {} because of  data is deleted and  flag status is {}",
                        hadmId, admissionsEntity.getStatusFlag());
                throw new BadStatusRequestException(
                        String.format("Invalid  hadmId value as a %d, Please provide correct hadmId", hadmId));
            }
        } else {
            logger.error("Admissions information data not found in database based on condition : hadmId = {} ", hadmId);
            throw new AdmissionsHadmIdNotFoundException(
                    String.format("Given hadmId not found in admissions information with value  %d", hadmId));
        }
        return convertToAdmissions(admissionsEntity);
    }

    @Override
    public Admissions createAdmissions(Admissions admissions) {
        AdmissionsEntity admissionsEntity = convertToAdmissionsEntity(admissions);
        admissionsEntity.setStatusFlag(Boolean.FALSE);
        logger.info("Making call to database for saving admission information : {}", admissions);
        Admissions admissionsInfo = convertToAdmissions(
                admissionsRepository
                        .save(admissionsEntity));
        /*try {
            ElasticSearchUtility.restClient(Util.IndexType.ADMISSIONS.name().toLowerCase(),
                    String.valueOf(admissionsInfo.getHadmId()), Util.toObjectToJson(admissionsInfo));
        } catch (JsonProcessingException e) {
            logger.error("Failed to process object mapper to converter java object to json: {}", e);
        }*/
        log.info("Return admissionsInfo response");
        return admissionsInfo;
    }

    @Override
    public Admissions updateAdmissions(Admissions admissions) {
        logger.info("Making call to database for updating admission information : {}", admissions);
        return convertToAdmissions(
                admissionsRepository
                        .save(convertToAdmissionsEntity(admissions)));
    }

    @Override
    public void deleteAdmissionsByhadmId(Integer hadmId) {
        AdmissionsEntity admissionsEntity = admissionsRepository.findByhadmId(hadmId);
        logger.info("Successfully retrieved admissions information based on condition : hadmId : {} and data : {} for deleting", hadmId, admissionsEntity);
        if (!Objects.isNull(admissionsEntity) && hadmId.equals(admissionsEntity.getHadmId())) {
            admissionsEntity.setStatusFlag(Boolean.TRUE);
            logger.info("Making call to databased for updating flag : {}  and data : {} ", admissionsEntity.getStatusFlag(), admissionsEntity);
            admissionsRepository.save(admissionsEntity);
            logger.info("Successfully updated flag in admissions service based on condition : hadmId = {} in case of delete", hadmId);
        } else {
            throw new AdmissionsHadmIdNotFoundException(
                    String.format("Given hadmId with value %d not " +
                            "found in admissions information, Please provide correct hadmId", hadmId));
        }
    }

    private AdmissionsEntity convertToAdmissionsEntity(Admissions admissions) {
        return modelMapper
                .map(admissions, AdmissionsEntity.class);
    }

    private Admissions convertToAdmissions(AdmissionsEntity admissionsEntity) {
        if (Objects.isNull(admissionsEntity)) {
            return new Admissions();
        }
        return modelMapper
                .map(admissionsEntity, Admissions.class);
    }

    private List<Admissions> convertToListAdmissions(List<AdmissionsEntity> admissionsEntities) {
        return modelMapper
                .map(admissionsEntities, List.class);
    }
}
