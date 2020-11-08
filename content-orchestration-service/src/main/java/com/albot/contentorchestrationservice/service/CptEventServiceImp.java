package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.postgres.entity.CptEventEntity;
import com.albot.contentorchestrationservice.postgres.repository.CptEventRepository;
import com.albot.contentorchestrationservice.model.CptEvent;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.CptEventSubjectIdNotFoundException;
import com.albot.contentorchestrationservice.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class CptEventServiceImp implements CptEventService {

    private static final Logger logger = LoggerFactory.getLogger(CptEventServiceImp.class);

    @Autowired
    private ModelMapper modelMapper;

    private CptEventRepository cptEventRepository;

    @Autowired
    public CptEventServiceImp(CptEventRepository cptEventRepository) {
        logger.info("Initialization of the cptEventRepository object in cptEvent service");
        this.cptEventRepository = cptEventRepository;
    }

    @Override
    public List<CptEvent> getAllCptEvent() {
        logger.info("Making call to database for fetching list of cptEvent information");
        return convertToListCptEvent(cptEventRepository.findAll());
    }

    @Override
    public CptEvent getCptEventBySubjectId(Integer subjectId) {
        CptEventEntity cptEventEntity = cptEventRepository.findBySubjectId(subjectId);
        logger.info("Successfully retrieved cptEvent information based on condition : subjectId : {} and data : {} ", subjectId, cptEventEntity);
        if(!Objects.isNull(cptEventEntity)) {
            if (cptEventEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve cptEvent information based on condition : subjectId : {} because of  data is deleted and  flag status is {}",
                        subjectId, cptEventEntity.getStatusFlag());
                throw new BadStatusRequestException(
                        String.format("Invalid  subjectId value as a %d, Please provide correct subjectId", subjectId));
            }
        } else{
            logger.error("cptEvent information data not found in database based on condition : subjectId = {} ", subjectId);
            throw new CptEventSubjectIdNotFoundException(
                    String.format("Given subjectId not found in cptEvent information with value  %d", subjectId));
        }
        return convertToCptEvent(
                cptEventEntity);
    }

    @Override
    public CptEvent createCptEvent(CptEvent cptEvent) {
        CptEventEntity cptEventEntity = convertToCptEventEntity(cptEvent);
        cptEventEntity.setStatusFlag(Boolean.FALSE);
        logger.info("Making call to database for saving cptEvent information : {}" ,cptEventEntity);
        CptEvent cptEventInfo =  convertToCptEvent(
                cptEventRepository.save(cptEventEntity));
        try {
            ElasticSearchUtility.restClient(Util.IndexType.CPTEVENT.name().toLowerCase(),
                    String.valueOf(cptEventInfo.getSubjectId()), Util.toObjectToJson(cptEventInfo));
        } catch (JsonProcessingException e) {
            logger.error("Failed to process object mapper to converter java object to json: {}", e);
        }
        log.info("Return cptEventInfo response");
        return cptEventInfo;
    }

    @Override
    public CptEvent updateCptEvent(CptEvent cptEvent) {
        logger.info("Making call to database for updating cptEvent information : {}" ,cptEvent);
        return convertToCptEvent(
                cptEventRepository.save(convertToCptEventEntity(cptEvent)));
    }

    @Override
    public void deleteCptEventBySubjectId(Integer subjectId) {
        CptEventEntity cptEventEntity = cptEventRepository.findBySubjectId(subjectId);
        logger.info("Successfully retrieved cptEvent information based on condition : subjectId : {} and data : {} for deleting", subjectId ,cptEventEntity);
        if (!Objects.isNull(cptEventEntity) && subjectId.equals(cptEventEntity.getSubjectId()) ) {
            cptEventEntity.setStatusFlag(Boolean.TRUE);
            logger.info("Making call to database for updating flag : {}  and data : {} ", cptEventEntity.getStatusFlag(), cptEventEntity);
            cptEventRepository.save(cptEventEntity);
            logger.info("Successfully updated flag in cptEvent service based on condition : subjectId = {} in case of delete", subjectId);
        } else {
            throw new CptEventSubjectIdNotFoundException(
                    String.format("Given subjectId with value %d not found in cptEvent information, Please provide correct subjectId", subjectId));
        }
    }

    private CptEventEntity convertToCptEventEntity(CptEvent cptEvent) {
        return modelMapper
                .map(cptEvent, CptEventEntity.class);
    }

    private CptEvent convertToCptEvent(CptEventEntity cptEventEntity) {
        return modelMapper
                .map(cptEventEntity, CptEvent.class);
    }

    private List<CptEvent> convertToListCptEvent(List<CptEventEntity> cptEventEntity) {
        return modelMapper
                .map(cptEventEntity, List.class);
    }
}
