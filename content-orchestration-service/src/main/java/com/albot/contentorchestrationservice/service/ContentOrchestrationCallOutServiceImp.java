package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.CallOutEntity;
import com.albot.contentorchestrationservice.cassandra.repository.CallOutRepository;
import com.albot.contentorchestrationservice.dto.CallOut;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.CallOutHadmIdNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ContentOrchestrationCallOutServiceImp implements ContentOrchestrationCallOutService {

    private CallOutRepository callOutRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContentOrchestrationCallOutServiceImp(CallOutRepository callOutRepository) {
        this.callOutRepository = callOutRepository;
    }

    @Override
    public List<CallOut> getAllCallOut() {
        return convertToListCallOut(callOutRepository.findAll());
    }

    @Override
    public CallOut getCallOutByhadmId(Integer hadmId) {
        CallOutEntity callOutEntity = callOutRepository.findByhadmId(hadmId);
        if (!Objects.isNull(callOutEntity)) {
            if (callOutEntity.getStatusFlag() == Boolean.TRUE) {
                throw new BadStatusRequestException(
                        String.format("Invalid  hadmId value as a %d, Please provide correct hadmId", hadmId));
            }
        } else {
            throw new CallOutHadmIdNotFoundException(
                    String.format("Given hadmId not found in callOut information with value  %d", hadmId));
        }
        return convertToCallOut(callOutEntity);
    }

    @Override
    public CallOut createCallOut(CallOut callOut) {
        CallOutEntity callOutEntity = convertToCallOutEntity(callOut);
        callOutEntity.setStatusFlag(Boolean.FALSE);
        return convertToCallOut(
                callOutRepository.insert(callOutEntity));
    }

    @Override
    public CallOut updateCallOut(CallOut callOut) {
        return convertToCallOut(
                callOutRepository.save(
                        convertToCallOutEntity(callOut)));
    }

    @Override
    public void deleteCallOutByhadmId(Integer hadmId) {
        CallOutEntity callOutEntity = callOutRepository.findByhadmId(hadmId);
        if(!Objects.isNull(callOutEntity) && hadmId.equals(callOutEntity.getHadmId())){
               callOutEntity.setStatusFlag(Boolean.TRUE);
               callOutRepository.save(callOutEntity);
        } else {
            throw new CallOutHadmIdNotFoundException(
                    String.format("Given hadmId with value %d not " +
                               "found in callOut information, Please provide correct hadmId", hadmId));
        }
    }

    private CallOutEntity convertToCallOutEntity(CallOut callOut) {
        return modelMapper
                .map(callOut, CallOutEntity.class);
    }

    private CallOut convertToCallOut(CallOutEntity callOutEntity) {
        return modelMapper
                .map(callOutEntity, CallOut.class);
    }

    private List<CallOut> convertToListCallOut(List<CallOutEntity> callOutEntities) {
        return modelMapper
                .map(callOutEntities, List.class);
    }
}
