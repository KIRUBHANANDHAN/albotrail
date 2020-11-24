package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.model.dto.HospitalInfoLineEntity;
import com.albot.ventilator.manager.model.web.HospitalInfoline;
import com.albot.ventilator.manager.repos.postgres.HospitalInfoLineRepository;
import com.albot.ventilator.manager.service.HospitalInfoLineService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalInfoLineImpl implements HospitalInfoLineService {

    private static final Logger logger = LoggerFactory.getLogger(HospitalInfoLineImpl.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HospitalInfoLineRepository hospitalInfolineRepository;


    @Override
    public HospitalInfoline getByHospID(String hosp_id) {

        HospitalInfoLineEntity hospitalInfolineEntity = hospitalInfolineRepository.findByid(Integer.parseInt(hosp_id));
        return convertToUserDemoGraphics(hospitalInfolineEntity);
    }


    private HospitalInfoline convertToUserDemoGraphics(HospitalInfoLineEntity hospitalInfolineEntity) {
        return modelMapper
                .map(hospitalInfolineEntity, HospitalInfoline.class);
    }


}
