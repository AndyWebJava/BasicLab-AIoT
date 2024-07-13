package com.basiclab.iot.device.controller.admin.product_properties;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import com.basiclab.iot.framework.common.pojo.PageParam;
import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.common.pojo.CommonResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;
import static com.basiclab.iot.framework.common.pojo.CommonResult.success;

import com.basiclab.iot.framework.excel.core.util.ExcelUtils;

import com.basiclab.iot.framework.apilog.core.annotation.ApiAccessLog;
import static com.basiclab.iot.framework.apilog.core.enums.OperateTypeEnum.*;

import com.basiclab.iot.device.controller.admin.product_properties.vo.*;
import com.basiclab.iot.device.dal.dataobject.product_properties.ProductPropertiesDO;
import com.basiclab.iot.device.service.product_properties.ProductPropertiesService;

@Tag(name = "管理后台 - 产品模型属性")
@RestController
@RequestMapping("/product/properties")
@Validated
public class ProductPropertiesController {

    @Resource
    private ProductPropertiesService propertiesService;

    @PostMapping("/create")
    @Operation(summary = "创建产品模型属性")
    @PreAuthorize("@ss.hasPermission('product:properties:create')")
    public CommonResult<Long> createProperties(@Valid @RequestBody ProductPropertiesSaveReqVO createReqVO) {
        return success(propertiesService.createProperties(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品模型属性")
    @PreAuthorize("@ss.hasPermission('product:properties:update')")
    public CommonResult<Boolean> updateProperties(@Valid @RequestBody ProductPropertiesSaveReqVO updateReqVO) {
        propertiesService.updateProperties(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品模型属性")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('product:properties:delete')")
    public CommonResult<Boolean> deleteProperties(@RequestParam("id") Long id) {
        propertiesService.deleteProperties(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品模型属性")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('product:properties:query')")
    public CommonResult<ProductPropertiesRespVO> getProperties(@RequestParam("id") Long id) {
        ProductPropertiesDO properties = propertiesService.getProperties(id);
        return success(BeanUtils.toBean(properties, ProductPropertiesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品模型属性分页")
    @PreAuthorize("@ss.hasPermission('product:properties:query')")
    public CommonResult<PageResult<ProductPropertiesRespVO>> getPropertiesPage(@Valid ProductPropertiesPageReqVO pageReqVO) {
        PageResult<ProductPropertiesDO> pageResult = propertiesService.getPropertiesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ProductPropertiesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品模型属性 Excel")
    @PreAuthorize("@ss.hasPermission('product:properties:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPropertiesExcel(@Valid ProductPropertiesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProductPropertiesDO> list = propertiesService.getPropertiesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "产品模型属性.xls", "数据", ProductPropertiesRespVO.class,
                        BeanUtils.toBean(list, ProductPropertiesRespVO.class));
    }

}