package com.basiclab.iot.protocol.factory;

import java.util.Map;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.basiclab.iot.protocol.model.EncryptionDetailsDTO;
import com.basiclab.iot.protocol.model.ProtocolDataMessageDTO;
import com.basiclab.iot.protocol.utils.ProtocolMessageSignatureVerifierUtils;
import com.basiclab.iot.protocol.utils.ProtocolRegexTopicVariableExtractorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: basiclabiot
 * @description: 协议信息适配器
 * @packagename: com.basiclab.iot.mqtt.handler
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-05-30 15:08
 **/
@Slf4j
@Component
public class ProtocolMessageAdapter {

    public boolean validateProtocolData(String body) {
        return ProtocolMessageSignatureVerifierUtils.validateProtocolData(body);
    }

    public Map<String, String> extractVariables(String topic) {
        return ProtocolRegexTopicVariableExtractorUtils.extractVariables(topic);
    }

    public ProtocolDataMessageDTO parseProtocolDataMessage(String body) {
        return BeanUtil.toBean(JSON.parseObject(body), ProtocolDataMessageDTO.class);
    }

    public String decryptMessage(String body, EncryptionDetailsDTO encryptionDetailsDTO) throws Exception {
        String signKey = encryptionDetailsDTO.getSignKey();
        String encryptKey = encryptionDetailsDTO.getEncryptKey();
        String encryptVector = encryptionDetailsDTO.getEncryptVector();
        return ProtocolMessageSignatureVerifierUtils.decryptMessage(body, signKey, encryptKey, encryptVector);
    }

    public <T> ProtocolDataMessageDTO<T> buildResponse(ProtocolDataMessageDTO<T> protocolDataMessageDTO,
                                                       String resultDataBody, EncryptionDetailsDTO encryptionDetailsDTO) throws Exception {
        String signKey = encryptionDetailsDTO.getSignKey();
        String encryptKey = encryptionDetailsDTO.getEncryptKey();
        String encryptVector = encryptionDetailsDTO.getEncryptVector();
        //数据加密签名处理
        String dataBody = ProtocolMessageSignatureVerifierUtils.encryptMessage(resultDataBody, protocolDataMessageDTO.getHead().getCipherFlag(), signKey, encryptKey,
                encryptVector);
        //JSON字符串转换为对象
        protocolDataMessageDTO = JSON.parseObject(dataBody, new TypeReference<ProtocolDataMessageDTO>() {
        });


        return protocolDataMessageDTO;
    }

    public <T> ProtocolDataMessageDTO buildResponse(String resultDataBody, EncryptionDetailsDTO encryptionDetailsDTO) throws Exception {
        String signKey = encryptionDetailsDTO.getSignKey();
        String encryptKey = encryptionDetailsDTO.getEncryptKey();
        String encryptVector = encryptionDetailsDTO.getEncryptVector();
        //数据加密签名处理
        String dataBody = ProtocolMessageSignatureVerifierUtils.encryptMessage(resultDataBody, encryptionDetailsDTO.getCipherFlag(), signKey, encryptKey,
                encryptVector);
        //JSON字符串转换为对象
        ProtocolDataMessageDTO protocolDataMessageDTO = JSON.parseObject(dataBody, new TypeReference<ProtocolDataMessageDTO>() {
        });


        return protocolDataMessageDTO;
    }
}
