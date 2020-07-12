package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.CareGiversEntity;
import com.albot.contentorchestrationservice.cassandra.repository.CareGiversRepository;
import com.albot.contentorchestrationservice.dto.CareGivers;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.CareGiversCgIdNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ContentOrchestrationCareGiversServiceImp implements ContentOrchestrationCareGiversService {

    private CareGiversRepository careGiversRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContentOrchestrationCareGiversServiceImp(CareGiversRepository careGiversRepository) {
        this.careGiversRepository = careGiversRepository;
    }

    @Override
    public List<CareGivers> getAllCareGivers() {
        return convertToListCareGivers(careGiversRepository.findAll());
    }

    @Override
    public CareGivers getCareGiversByCgId(Integer cgId) {
        CareGiversEntity careGiversEntity = careGiversRepository.findBycgId(cgId);
        if (!Objects.isNull(careGiversEntity)) {
            if (careGiversEntity.isStatusFlag() == Boolean.TRUE) {
                throw new CareGiversCgIdNotFoundException(
                        String.format("Invalid  cgId value as a %d, Please provide correct cgId", cgId));
            }
        } else {
           throw new BadStatusRequestException(
                   String.format("Given cgId not found in callGivers information with value  %d", cgId));
        }
        return convertToCareGivers(careGiversEntity);
    }

    @Override
    public CareGivers createCareGivers(CareGivers careGivers) {
        CareGiversEntity careGiversEntity = convertToCareGiversEntity(careGivers);
        careGiversEntity.setStatusFlag(false);
        return convertToCareGivers(
                careGiversRepository.insert(careGiversEntity));
    }

    @Override
    public CareGivers updateCareGivers(CareGivers careGivers) {
        return convertToCareGivers(
                careGiversRepository.save(convertToCareGiversEntity(careGivers)));
    }

    @Override
    public void deleteCareGiversByCgId(Integer cgid) {
        CareGiversEntity careGiversEntity =
                careGiversRepository.findBycgId(cgid);
        if (!Objects.isNull(careGiversEntity) && cgid.equals(careGiversEntity.getCgId())) {
            careGiversEntity.setStatusFlag(true);
            careGiversRepository.save(careGiversEntity);
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
