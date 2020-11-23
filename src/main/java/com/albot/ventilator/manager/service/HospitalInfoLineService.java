package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.HospitalInfoline;


public interface HospitalInfoLineService {

    HospitalInfoline getByHospID(String hosp_id);

}
