package com.basiclab.iot.rule.controller;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.web.controller.BaseController;
import com.basiclab.iot.rule.service.RuleDeviceLinkageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: basiclabiot
 * @description: 设备联动Controller
 * @packagename: com.basiclab.basiclabiot.rule.controller
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-08-07 20:31
 **/
@RestController
@RequestMapping("/ruleDeviceLinkage")
@Slf4j
public class RuleDeviceLinkageController extends BaseController {


    @Autowired
    private RuleDeviceLinkageService ruleDeviceLinkageService;

    /**
     * 触发设备联动规则条件
     * @param ruleIdentification 规则标识
     * @return
     */
    @GetMapping(value = "/triggerDeviceLinkage/{ruleIdentification}")
    public R<?> triggerDeviceLinkage(@PathVariable("ruleIdentification") String ruleIdentification) {
        ruleDeviceLinkageService.triggerDeviceLinkageByRuleIdentification(ruleIdentification);
        return R.ok();
    }

    /**
     * 获取所有的产品
     * @return
     */
    @GetMapping("/selectAllProduct")
    public R<?> selectAllProduct(){
        return ruleDeviceLinkageService.selectAllProduct("0");
    }


    /**
     * 根据产品标识获取产品关联设备
     * @param productIdentification
     * @return
     */
    @GetMapping("/selectDeviceByProductIdentification/{productIdentification}")
    public R<?> selectDeviceByProductIdentification(@PathVariable("productIdentification") String productIdentification){
        return ruleDeviceLinkageService.selectDeviceByProductIdentification(productIdentification);
    }


    /**
     * 根据产品标识获取产品关联服务
     * @param productIdentification
     * @return
     */
    @GetMapping("/selectProductServicesByProductIdentification/{productIdentification}")
    public R<?> selectProductServicesByProductIdentification(@PathVariable("productIdentification") String productIdentification){
        return ruleDeviceLinkageService.selectProductServicesByProductIdentification(productIdentification);
    }

    @GetMapping("/selectProductPropertiesByServiceId/{serviceId}")
    public R<?> selectProductPropertiesByServiceId(@PathVariable("serviceId") Long serviceId){
        return ruleDeviceLinkageService.selectProductPropertiesByServiceId(serviceId);
    }

    @GetMapping("/selectProductCommandsByServiceId/{serviceId}")
    public R<?> selectProductCommandsByServiceId(@PathVariable("serviceId") Long serviceId){
        return ruleDeviceLinkageService.selectProductCommandsByServiceId(serviceId);
    }





}
