package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.CareGiversEntity;
import com.albot.contentorchestrationservice.cassandra.repository.CareGiversRepository;
import com.albot.contentorchestrationservice.dto.CareGivers;
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
                //TODO:- Here We have to throw User friendly exception
                return new CareGivers();
            }
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
    public String deleteCareGiversByCgId(Integer cgid) {
        CareGiversEntity careGiversEntity =
                careGiversRepository.findBycgId(cgid);
        if (!Objects.isNull(careGiversEntity) && cgid.equals(careGiversEntity.getCgId())) {
            careGiversEntity.setStatusFlag(true);
            careGiversRepository.save(careGiversEntity);
        } else {
            return String.format("Given cgid with value %d not found in CareGivers information, Please provide correct cgId", cgid);
        }
        return "Successfully deleted CareGivers information given by cgId";
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
