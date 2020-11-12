package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.exceptions.BadStatusRequestException;
import com.albot.ventilator.manager.exceptions.CurrentProceduralTerminologyRowIdNotFoundException;
import com.albot.ventilator.manager.model.CurrentProceduralTerminology;
import com.albot.ventilator.manager.model.CurrentProceduralTerminologyEntity;
import com.albot.ventilator.manager.repos.postgres.CurrentProceduralTerminologyRepository;
import com.albot.ventilator.manager.service.CurrentProceduralTerminologyService;
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
public class CurrentProceduralTerminologyServiceImp implements CurrentProceduralTerminologyService {

    private static final Logger logger = LoggerFactory.getLogger(CurrentProceduralTerminologyServiceImp.class);

    @Autowired
    private ModelMapper modelMapper;

    private final CurrentProceduralTerminologyRepository proceduralTerminologyRepository;

    @Autowired
    public CurrentProceduralTerminologyServiceImp(CurrentProceduralTerminologyRepository proceduralTerminologyRepository) {
        logger.info("Initialization of the currentProceduralTerminologyRepository object in currentProceduralTerminology service");
        this.proceduralTerminologyRepository = proceduralTerminologyRepository;
    }


    @Override
    public List<CurrentProceduralTerminology> getAllCurrentProceduralTerminology() {
        logger.info("Making call to database for fetching list of CurrentProceduralTerminology information");
        return convertToListCpts(
                proceduralTerminologyRepository.findAll());
    }

    @Override
    public CurrentProceduralTerminology getByRowId(Integer rowId) {
        CurrentProceduralTerminologyEntity cptEntity = proceduralTerminologyRepository.findByRowId(rowId);
        logger.info("Successfully retrieved currentProceduralTerminology information based on condition : RowId : {} and data : {} ", rowId, cptEntity);
        if (!Objects.isNull(cptEntity)) {
            if (cptEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve currentProceduralTerminology information based on condition : RowId : {} because of  data is deleted and  flag status is {}",
                        rowId, cptEntity.getStatusFlag());
                throw new BadStatusRequestException(
                        String.format("Invalid  rowId value as a %d, Please provide correct rowId", rowId));
            }
        } else {
            logger.error("currentProceduralTerminology information data not found in database based on condition : RowId = {} ", rowId);
            throw new CurrentProceduralTerminologyRowIdNotFoundException(
                    String.format("Given rowId not found in currentProceduralTerminology information with value  %d", rowId));
        }
        return convertToCpt(cptEntity);
    }

    @Override
    public CurrentProceduralTerminology createCurrentProceduralTerminology(CurrentProceduralTerminology cpt) {
        CurrentProceduralTerminologyEntity cptEntity = convertToCptEntity(cpt);
        cptEntity.setStatusFlag(Boolean.FALSE);
        logger.info("Making call to database for saving currentProceduralTerminology information : {}", cptEntity);
        CurrentProceduralTerminology proceduralTerminologyInfo = convertToCpt(
                proceduralTerminologyRepository.save(cptEntity));
       /* try {
            ElasticSearchUtility.restClient(Util.IndexType.CPT.name().toLowerCase(),
                    String.valueOf(proceduralTerminologyInfo.getRowId()), Util.toObjectToJson(proceduralTerminologyInfo));
        } catch (JsonProcessingException e) {
            logger.error("Failed to process object mapper to converter java object to json: {}", e);
        }*/
        log.info("Return cptInfo response");
        return proceduralTerminologyInfo;
    }

    @Override
    public CurrentProceduralTerminology updateCurrentProceduralTerminology(CurrentProceduralTerminology cpt) {
        logger.info("Making call to database for updating currentProceduralTerminology information : {}", cpt);
        return convertToCpt(
                proceduralTerminologyRepository.save(convertToCptEntity(cpt)));
    }

    @Override
    public void deleteCurrentProceduralTerminologyByRowId(Integer rowId) {
        CurrentProceduralTerminologyEntity cptEntity = proceduralTerminologyRepository.findByRowId(rowId);
        logger.info("Successfully retrieved currentProceduralTerminology information based on condition : RowId : {} and data : {} for deleting", rowId, cptEntity);
        if (!Objects.isNull(cptEntity) && rowId.equals(cptEntity.getRowId())) {
            cptEntity.setStatusFlag(Boolean.TRUE);
            logger.info("Making call to databased for updating flag : {}  and data : {} ", cptEntity.getStatusFlag(), cptEntity);
            proceduralTerminologyRepository.save(cptEntity);
            logger.info("Successfully updated flag in currentProceduralTerminology service based on condition : RowId = {} in case of delete", rowId);
        } else {
            throw new CurrentProceduralTerminologyRowIdNotFoundException(
                    String.format("Given rowId with value %d not found in currentProceduralTerminology information, Please provide correct rowId", rowId));
        }
    }

    private CurrentProceduralTerminologyEntity convertToCptEntity(CurrentProceduralTerminology cpt) {
        return modelMapper
                .map(cpt, CurrentProceduralTerminologyEntity.class);
    }

    private CurrentProceduralTerminology convertToCpt(CurrentProceduralTerminologyEntity cptEntity) {
        return modelMapper
                .map(cptEntity, CurrentProceduralTerminology.class);
    }

    private List<CurrentProceduralTerminology> convertToListCpts(List<CurrentProceduralTerminologyEntity> listOfCpt) {
        return modelMapper
                .map(listOfCpt, List.class);
    }
}
