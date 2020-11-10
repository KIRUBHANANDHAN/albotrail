package com.albot.ventilator.manager.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

    public static String toObjectToJson(Object object)
            throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

    // TODO IndexType is used for elastic search to inserting data
    public enum IndexType {
        ADMISSIONS,
        CAREGIVERS,  //Care Givers used for fetching care givers information by using cgid, which is a research nurse (RN), medical doctor (MD)
        CALLOUT,   // CallOut information used to discharge patient information from the ICU.
        CPTEVENT,  // Current procedural terminology Event
        CPT,      // Current Procedural Terminology (CPT)
        PATIENT
    }

    public enum Status {
        SUCCESS,
        FAILED
    }
}
