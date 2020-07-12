package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.AdmissionsEntity;
import com.albot.contentorchestrationservice.dto.Admissions;
import com.albot.contentorchestrationservice.cassandra.repository.AdmissionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContentOrchestrationAdmissionsServiceImp implements ContentOrchestrationAdmissionsService {

    private AdmissionsRepository admissionsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContentOrchestrationAdmissionsServiceImp(AdmissionsRepository admissionsRepository) {
        this.admissionsRepository = admissionsRepository;
    }

    @Override
    public List<Admissions> getAllAdmissions() {

        return null;
    }

    @Override
    public Admissions getAdmissions(Integer handId) {
        return convertToAdmissionsEntity(
                          admissionsRepository.findByhadmId(handId));
    }

    @Override
    public Admissions createAdmissions(Admissions admissions) {

        return convertToAdmissionsEntity(
                       admissionsRepository
                                .insert(convertToAdmissions(admissions)));
    }

    @Override
    public Admissions updateAdmissions(Admissions admissions) {
        return convertToAdmissionsEntity(
                admissionsRepository
                        .save(convertToAdmissions(admissions)));
    }

    private AdmissionsEntity convertToAdmissions(Admissions admissions) {
        return modelMapper
                .map(admissions, AdmissionsEntity.class);
    }

    private Admissions convertToAdmissionsEntity(AdmissionsEntity admissionsEntity) {
         if(Objects.isNull(admissionsEntity)){
             return new Admissions();
         }
        return modelMapper
                .map(admissionsEntity, Admissions.class);
    }
}
