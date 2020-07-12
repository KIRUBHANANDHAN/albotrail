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
        return null;
    }

    @Override
    public CareGivers getCareGivers(Integer cgId) {
        return convertToAdmissionsEntity(careGiversRepository.findBycgId(cgId));
    }

    @Override
    public CareGivers createCareGivers(CareGivers careGivers) {
        return convertToAdmissionsEntity(
                careGiversRepository.insert(convertToAdmissions(careGivers)));
    }

    @Override
    public CareGivers updateCareGivers(CareGivers careGivers) {
        return convertToAdmissionsEntity(
                careGiversRepository.save(convertToAdmissions(careGivers)));
    }

    private CareGiversEntity convertToAdmissions(CareGivers careGivers) {
        return modelMapper
                .map(careGivers, CareGiversEntity.class);
    }

    private CareGivers convertToAdmissionsEntity(CareGiversEntity careGiversEntityvers) {
        if (Objects.isNull(careGiversEntityvers)) {
            return new CareGivers();
        }
        return modelMapper
                .map(careGiversEntityvers, CareGivers.class);
    }
}
