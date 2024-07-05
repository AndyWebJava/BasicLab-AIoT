package com.basiclab.iot.link.controller.product;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.utils.SecurityUtils;
import com.basiclab.iot.common.core.utils.poi.ExcelUtil;
import com.basiclab.iot.common.core.web.controller.BaseController;
import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.common.core.web.page.TableDataInfo;
import com.basiclab.iot.common.log.annotation.Log;
import com.basiclab.iot.common.log.enums.BusinessType;
import com.basiclab.iot.common.security.annotation.PreAuthorize;
import com.basiclab.iot.link.api.domain.product.entity.ProductProperties;
import com.basiclab.iot.link.api.domain.product.entity.ProductServices;
import com.basiclab.iot.link.service.product.ProductServicesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * (productServices)表控制层
 *
 * @author BasicLab基础架构实验室
 */
@RestController
@RequestMapping("/productServices")
public class ProductServicesController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private ProductServicesService productServicesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProductServices selectOne(Long id) {
        return productServicesService.selectByPrimaryKey(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "/selectProductServicesById/{id}")
    public R<?> selectProductServicesById(@PathVariable("id") Long id)
    {
        return R.ok(productServicesService.selectProductServicesById(id));
    }

    /**
     * 查询产品模型服务列表
     */
    @PreAuthorize(hasPermi = "link:productServices:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductServices productServices) {
        startPage();
        List<ProductServices> list = productServicesService.selectProductServicesList(productServices);
        return getDataTable(list);
    }

    /**
     * 查询产品模型服务列表
     */
    @PreAuthorize(hasPermi = "link:productServices:list")
    @GetMapping("/query")
    public AjaxResult query(ProductServices productServices) {
        List<ProductServices> list = productServicesService.selectProductServicesList(productServices);
        return AjaxResult.success(list);
    }

    /**
     * 导出产品模型服务列表
     */
    @PreAuthorize(hasPermi = "link:productServices:export")
    @Log(title = "产品模型服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductServices productServices) throws IOException {
        List<ProductServices> list = productServicesService.selectProductServicesList(productServices);
        ExcelUtil<ProductServices> util = new ExcelUtil<ProductServices>(ProductServices.class);
        util.exportExcel(response, list, "产品模型服务数据");
    }

    /**
     * 获取产品模型服务详细信息
     */
    @PreAuthorize(hasPermi = "link:productServices:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(productServicesService.selectProductServicesById(id));
    }

    /**
     * 新增产品模型服务
     */
    @PreAuthorize(hasPermi = "link:productServices:add")
    @Log(title = "产品模型服务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductServices productServices) {
        productServices.setCreateBy(SecurityUtils.getUsername());
        return toAjax(productServicesService.insertProductServices(productServices));
    }

    /**
     * 修改产品模型服务
     */
    @PreAuthorize(hasPermi = "link:productServices:edit")
    @Log(title = "产品模型服务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductServices productServices) {
        productServices.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(productServicesService.updateProductServices(productServices));
    }

    /**
     * 删除产品模型服务
     */
    @PreAuthorize(hasPermi = "link:productServices:remove")
    @Log(title = "产品模型服务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(productServicesService.deleteProductServicesByIds(ids));
    }


    /**
     * 根据产品标识和状态获取产品关联服务
     * @param productIdentification
     * @param status
     * @return
     */
    @GetMapping("/selectAllByProductIdentificationAndStatus")
    public R<?> selectAllByProductIdentificationAndStatus(@RequestParam("productIdentification") String productIdentification, @RequestParam("status") String status){
        return R.ok(productServicesService.selectAllByProductIdentificationAndStatus(productIdentification,status));
    }

    @PostMapping("/selectProductServicesByIdList")
    public R<?> selectProductServicesByIdList(@RequestBody List<Long> serviceIdList) {
        return R.ok(productServicesService.selectProductServicesByIdList(serviceIdList));
    }
}
