package com.basiclab.iot.system.controller.admin.logger;

import com.basiclab.iot.framework.apilog.core.annotation.ApiAccessLog;
import com.basiclab.iot.framework.common.pojo.CommonResult;
import com.basiclab.iot.framework.common.pojo.PageParam;
import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;
import com.basiclab.iot.framework.excel.core.util.ExcelUtils;
import com.basiclab.iot.framework.translate.core.TranslateUtils;
import com.basiclab.iot.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import com.basiclab.iot.system.controller.admin.logger.vo.operatelog.OperateLogRespVO;
import com.basiclab.iot.system.dal.dataobject.logger.OperateLogDO;
import com.basiclab.iot.system.service.logger.OperateLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.basiclab.iot.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static com.basiclab.iot.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 操作日志")
@RestController
@RequestMapping("/system/operate-log")
@Validated
public class OperateLogController {

    @Resource
    private OperateLogService operateLogService;

    @GetMapping("/page")
    @Operation(summary = "查看操作日志分页列表")
    @PreAuthorize("@ss.hasPermission('system:operate-log:query')")
    public CommonResult<PageResult<OperateLogRespVO>> pageOperateLog(@Valid OperateLogPageReqVO pageReqVO) {
        PageResult<OperateLogDO> pageResult = operateLogService.getOperateLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, OperateLogRespVO.class));
    }

    @Operation(summary = "导出操作日志")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('system:operate-log:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportOperateLog(HttpServletResponse response, @Valid OperateLogPageReqVO exportReqVO) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<OperateLogDO> list = operateLogService.getOperateLogPage(exportReqVO).getList();
        ExcelUtils.write(response, "操作日志.xls", "数据列表", OperateLogRespVO.class,
                TranslateUtils.translate(BeanUtils.toBean(list, OperateLogRespVO.class)));
    }

}
