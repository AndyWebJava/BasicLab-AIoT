package com.basiclab.iot.system.api.logger;

import com.basiclab.iot.framework.common.pojo.CommonResult;
import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;
import com.basiclab.iot.system.api.logger.dto.OperateLogCreateReqDTO;
import com.basiclab.iot.system.api.logger.dto.OperateLogPageReqDTO;
import com.basiclab.iot.system.api.logger.dto.OperateLogRespDTO;
import com.basiclab.iot.system.dal.dataobject.logger.OperateLogDO;
import com.basiclab.iot.system.service.logger.OperateLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.basiclab.iot.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public CommonResult<Boolean> createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
        return success(true);
    }

    @Override
    public CommonResult<PageResult<OperateLogRespDTO>> getOperateLogPage(OperateLogPageReqDTO pageReqVO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqVO);
        return success(BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class));
    }

}
