package com.basiclab.iot.rule.service.impl;


import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.utils.bean.BeanUtils;
import com.basiclab.iot.common.security.service.TokenService;
import com.basiclab.iot.link.api.RemoteDeviceService;
import com.basiclab.iot.link.api.RemoteProductPropertiesService;
import com.basiclab.iot.link.api.RemoteProductService;
import com.basiclab.iot.link.api.RemoteProductServicesService;
import com.basiclab.iot.link.api.domain.device.entity.Device;
import com.basiclab.iot.link.api.domain.product.entity.Product;
import com.basiclab.iot.link.api.domain.product.entity.ProductProperties;
import com.basiclab.iot.link.api.domain.product.entity.ProductServices;
import com.basiclab.iot.rule.api.domain.RuleConditions;
import com.basiclab.iot.rule.api.domain.model.RuleConditionsModel;
import com.basiclab.iot.rule.mapper.RuleConditionsMapper;
import com.basiclab.iot.rule.service.RuleConditionsService;
import com.basiclab.iot.system.api.domain.SysUser;
import com.basiclab.iot.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: basiclabiot
 * @description: ${description}
 * @packagename: com.basiclab.basiclabiot.rule.service.impl
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-07-21 18:47
 **/
@Slf4j
@Service
public class RuleConditionsServiceImpl implements RuleConditionsService {

    @Resource
    private TokenService tokenService;
    @Resource
    private RuleConditionsMapper ruleConditionsMapper;

    @Resource
    private RemoteProductService remoteProductService;

    @Resource
    private RemoteProductServicesService remoteProductServicesService;

    @Resource
    private RemoteDeviceService remoteDeviceService;

    @Resource
    private RemoteProductPropertiesService remoteProductPropertiesService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return ruleConditionsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RuleConditions record) {
        return ruleConditionsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(RuleConditions record) {
        return ruleConditionsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(RuleConditions record) {
        return ruleConditionsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(RuleConditions record) {
        return ruleConditionsMapper.insertSelective(record);
    }

    @Override
    public RuleConditions selectByPrimaryKey(Long id) {
        return ruleConditionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RuleConditions> selectByRuleId(Long ruleId) {
        return ruleConditionsMapper.selectByRuleId(ruleId);
    }

    @Override
    public int updateByPrimaryKeySelective(RuleConditions record) {
        return ruleConditionsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RuleConditions record) {
        return ruleConditionsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<RuleConditions> list) {
        return ruleConditionsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<RuleConditions> list) {

        String sysUserName = getSysUserName();
        List<RuleConditions> updateRuleConditionsList = list.stream().map(s->{
            s.setCreateBy(sysUserName);
            return s;
        }).collect(Collectors.toList());

        return ruleConditionsMapper.updateBatchSelective(updateRuleConditionsList);
    }

    @Override
    public List<RuleConditions> batchInsert(List<RuleConditions> list) {

        String sysUserName = getSysUserName();
        List<RuleConditions> insertList = list.stream().map(s->{
            s.setCreateBy(sysUserName);
            return s;
        }).collect(Collectors.toList());
        ruleConditionsMapper.batchInsert(insertList);
        return  insertList;
    }

    public int deleteBatchByIds(Long[] ids) {
        return ruleConditionsMapper.deleteBatchByIds(ids);
    }

    public List<RuleConditionsModel> ruleConditionsListToRuleConditionsModelList(List<RuleConditions> ruleConditionsList){
        List<RuleConditionsModel> ruleConditionsModelList = new ArrayList<>();
        List<Long> productServicesIdList = new ArrayList<>();
        List<Long> productPropertiesIdList = new ArrayList<>();
        List<String> deviceIdentificationList = new ArrayList<>();
        List<String> productIdentificationList = new ArrayList<>();
        ruleConditionsList.stream().forEach(ruleConditions -> {
            productServicesIdList.add(ruleConditions.getServiceId());
            productPropertiesIdList.add(ruleConditions.getPropertiesId());
            deviceIdentificationList.add(ruleConditions.getDeviceIdentification());
            productIdentificationList.add(ruleConditions.getProductIdentification());
        });
        R<?> productListResponse = remoteProductService.selectProductByProductIdentificationList(productIdentificationList);
        Map<String,Product> productMap = BeanUtils.rDataToBeanList(productListResponse,Product.class).stream().collect(Collectors.toMap(Product::getProductIdentification, s->s));

        R<?> deviceListResponse = remoteDeviceService.selectDeviceByDeviceIdentificationList(deviceIdentificationList);
        Map<String,Device> deviceMap = BeanUtils.rDataToBeanList(deviceListResponse,Device.class).stream().collect(Collectors.toMap(Device::getDeviceIdentification, s->s));

        R<?> productServicesResponse = remoteProductServicesService.selectProductServicesByIdList(productServicesIdList);
        Map<Long, ProductServices> productServicesMap =  BeanUtils.rDataToBeanList(productServicesResponse,ProductServices.class).stream().collect(Collectors.toMap(ProductServices::getId,s->s));

        R<?> productPropertiesResponse = remoteProductPropertiesService.selectPropertiesByPropertiesIdList(productPropertiesIdList);
        Map<Long, ProductProperties> productPropertiesMap =  BeanUtils.rDataToBeanList(productPropertiesResponse,ProductProperties.class).stream().collect(Collectors.toMap(ProductProperties::getId,s->s));

        ruleConditionsList.stream().forEach(
                ruleConditions -> {
                    RuleConditionsModel ruleConditionsModel = new RuleConditionsModel();
                    BeanUtils.copyProperties(ruleConditions,ruleConditionsModel);
                    ruleConditionsModel.setProductName(BeanUtils.getMapBeanVal(productMap,ruleConditions.getProductIdentification().toString(), Product.class ,"getProductName"));
                    ruleConditionsModel.setDeviceName(BeanUtils.getMapBeanVal(deviceMap,ruleConditions.getDeviceIdentification().toString(),Device.class,"getDeviceName"));
                    ruleConditionsModel.setServiceName(BeanUtils.getMapBeanVal(productServicesMap,ruleConditions.getServiceId(),ProductServices.class,"getServiceName"));
                    ruleConditionsModel.setPropertiesName(BeanUtils.getMapBeanVal(productPropertiesMap,ruleConditions.getPropertiesId(),ProductProperties.class,"getName"));

                    ruleConditionsModelList.add(ruleConditionsModel);
                }
        );
        return ruleConditionsModelList;
    }
    private String getSysUserName(){
        LoginUser loginUser = tokenService.getLoginUser();
        SysUser sysUser = loginUser.getSysUser();
        return sysUser.getUserName();
    }
}

