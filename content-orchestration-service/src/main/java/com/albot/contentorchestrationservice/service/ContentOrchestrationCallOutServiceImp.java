package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.CallOutEntity;
import com.albot.contentorchestrationservice.cassandra.repository.CallOutRepository;
import com.albot.contentorchestrationservice.dto.CallOut;
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
        return null;
    }

    @Override
    public CallOut getCallOut(Integer handId) {
        return convertToCallOutEntity(
                   callOutRepository.findByhadmId(handId));
    }

    @Override
    public CallOut createCallOut(CallOut callOut) {

        return convertToCallOutEntity(
                callOutRepository.insert(
                        convertToCallOut(callOut)));
    }

    @Override
    public CallOut updateCallOut(CallOut callOut) {
        return convertToCallOutEntity(
                callOutRepository.save(
                        convertToCallOut(callOut)));
    }

    @Override
    public CallOut deleteCallOut(Integer handId) {
        return null;
    }

    private CallOutEntity convertToCallOut(CallOut callOut) {
        return modelMapper
                .map(callOut, CallOutEntity.class);
    }

    private CallOut convertToCallOutEntity(CallOutEntity callOutEntity) {
        if (Objects.isNull(callOutEntity)) {
            return new CallOut();
        }
        return modelMapper
                .map(callOutEntity, CallOut.class);
    }
}
