package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.CareGiversEntity;
import com.albot.contentorchestrationservice.cassandra.repository.CareGiversRepository;
import com.albot.contentorchestrationservice.dto.CareGivers;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.CareGiversCgIdNotFoundException;
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
public class ContentOrchestrationCareGiversServiceImp implements ContentOrchestrationCareGiversService {

    private static final Logger logger = LoggerFactory.getLogger(ContentOrchestrationCareGiversServiceImp.class);

    private CareGiversRepository careGiversRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContentOrchestrationCareGiversServiceImp(CareGiversRepository careGiversRepository) {
        logger.info("Initialization of the careGiversRepository object in careGiver service");
        this.careGiversRepository = careGiversRepository;
    }

    @Override
    public List<CareGivers> getAllCareGivers() {
        logger.info("Making call to database for fetching list of careGivers information");
        return convertToListCareGivers(careGiversRepository.findAll());
    }

    @Override
    public CareGivers getCareGiversByCgId(Integer cgId) {
        CareGiversEntity careGiversEntity = careGiversRepository.findBycgId(cgId);
        logger.info("Successfully retrieved careGivers information based on condition : cgId : {} and data : {} ", cgId ,careGiversEntity);
        if (!Objects.isNull(careGiversEntity)) {
            if (careGiversEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve careGivers information based on condition : cgId : {} because of  data is deleted and  flag status is {}",
                        cgId, careGiversEntity.getStatusFlag());
                throw new CareGiversCgIdNotFoundException(
                        String.format("Invalid  cgId value as a %d, Please provide correct cgId", cgId));
            }
        } else {
            logger.error("CareGivers information data not found in database based on condition : cgId = {} ", cgId);
           throw new BadStatusRequestException(
                   String.format("Given cgId not found in callGivers information with value  %d", cgId));
        }
        return convertToCareGivers(careGiversEntity);
    }

    @Override
    public CareGivers createCareGivers(CareGivers careGivers) {
        CareGiversEntity careGiversEntity = convertToCareGiversEntity(careGivers);
        careGiversEntity.setStatusFlag(false);
        logger.info("Making call to database for saving careGiver information : {}" ,careGiversEntity);
        return convertToCareGivers(
                careGiversRepository.insert(careGiversEntity));
    }

    @Override
    public CareGivers updateCareGivers(CareGivers careGivers) {
        logger.info("Making call to database for updating careGiver information : {}" ,careGivers);
        return convertToCareGivers(
                careGiversRepository.save(convertToCareGiversEntity(careGivers)));
    }

    @Override
    public void deleteCareGiversByCgId(Integer cgid) {
        CareGiversEntity careGiversEntity =
                careGiversRepository.findBycgId(cgid);
        logger.info("Successfully retrieved careGivers information based on condition : cgid : {} and data : {} for deleting", cgid ,careGiversEntity);
        if (!Objects.isNull(careGiversEntity) && cgid.equals(careGiversEntity.getCgId())) {
            careGiversEntity.setStatusFlag(true);
            logger.info("Making call to databased for updating flag : {}  and data : {} ", careGiversEntity.getStatusFlag(), careGiversEntity);
            careGiversRepository.save(careGiversEntity);
            logger.info("Successfully updated flag in careGivers service based on condition : cgid = {} in case of delete", cgid);
        } else {
            throw new CareGiversCgIdNotFoundException(
                    String.format("Given cgid with value %d not found in careGivers information," +
                            "Please provide correct cgId", cgid));
        }
    }

    private CareGiversEntity convertToCareGiversEntity(CareGivers careGivers) {
        return modelMapper
                .map(careGivers, CareGiversEntity.class);
    }

    private CareGivers convertToCareGivers(CareGiversEntity careGiversEntityvers) {
        return modelMapper
                .map(careGiversEntityvers, CareGivers.class);
    }

    private List<CareGivers> convertToListCareGivers(List<CareGiversEntity> careGiversList) {
        return modelMapper
                .map(careGiversList, List.class);
    }
}
