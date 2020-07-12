package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.AdmissionsEntity;
import com.albot.contentorchestrationservice.dto.Admissions;
import com.albot.contentorchestrationservice.cassandra.repository.AdmissionsRepository;
import com.albot.contentorchestrationservice.exception.AdmissionsHadmIdNotFoundException;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
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

        return convertToListAdmissions(admissionsRepository.findAll());
    }

    @Override
    public Admissions getAdmissionsByhadmId(Integer hadmId) {
        AdmissionsEntity admissionsEntity = admissionsRepository.findByhadmId(hadmId);
        if (!Objects.isNull(admissionsEntity)) {
            if (admissionsEntity.getStatusFlag() == Boolean.TRUE) {
                throw new BadStatusRequestException(
                        String.format("Invalid  hadmId value as a %d, Please provide correct hadmId", hadmId));
            }
        } else {
            throw new AdmissionsHadmIdNotFoundException(
                    String.format("Given hadmId not found in admissions information with value  %d", hadmId));
        }
        return convertToAdmissions(admissionsEntity);
    }

    @Override
    public Admissions createAdmissions(Admissions admissions) {
        AdmissionsEntity admissionsEntity = convertToAdmissionsEntity(admissions);
        admissionsEntity.setStatusFlag(Boolean.FALSE);
        return convertToAdmissions(
                admissionsRepository
                        .insert(admissionsEntity));
    }

    @Override
    public Admissions updateAdmissions(Admissions admissions) {
        return convertToAdmissions(
                admissionsRepository
                        .save(convertToAdmissionsEntity(admissions)));
    }

    @Override
    public void deleteAdmissionsByhadmId(Integer hadmId) {
        AdmissionsEntity admissionsEntity = admissionsRepository.findByhadmId(hadmId);
        if (!Objects.isNull(admissionsEntity) && hadmId.equals(admissionsEntity.getHadmId())) {
            admissionsEntity.setStatusFlag(Boolean.TRUE);
            admissionsRepository.save(admissionsEntity);
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
