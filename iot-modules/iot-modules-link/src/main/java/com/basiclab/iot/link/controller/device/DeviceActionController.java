package com.basiclab.iot.link.controller.device;

import com.basiclab.iot.common.core.utils.poi.ExcelUtil;
import com.basiclab.iot.common.core.web.controller.BaseController;
import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.common.core.web.page.TableDataInfo;
import com.basiclab.iot.common.log.annotation.Log;
import com.basiclab.iot.common.log.enums.BusinessType;
import com.basiclab.iot.common.security.annotation.PreAuthorize;
import com.basiclab.iot.link.api.domain.device.entity.DeviceAction;
import com.basiclab.iot.link.service.device.DeviceActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 设备动作数据Controller
 *
 * @author BasicLab基础架构实验室
 * @date 2022-06-17
 */
@RestController
@RequestMapping("/action")
public class DeviceActionController extends BaseController
{
    @Autowired
    private DeviceActionService deviceActionService;

    /**
     * 查询设备动作数据列表
     */
    @PreAuthorize(hasPermi = "link:action:list")
    @GetMapping("/list")
    public TableDataInfo list(DeviceAction deviceAction)
    {
        startPage();
        List<DeviceAction> list = deviceActionService.selectDeviceActionList(deviceAction);
        return getDataTable(list);
    }

    /**
     * 导出设备动作数据列表
     */
    @PreAuthorize(hasPermi = "link:action:export")
    @Log(title = "设备动作数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceAction deviceAction) throws IOException
    {
        List<DeviceAction> list = deviceActionService.selectDeviceActionList(deviceAction);
        ExcelUtil<DeviceAction> util = new ExcelUtil<DeviceAction>(DeviceAction.class);
        util.exportExcel(response, list, "设备动作数据数据");
    }

    /**
     * 获取设备动作数据详细信息
     */
    @PreAuthorize(hasPermi = "link:action:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(deviceActionService.selectDeviceActionById(id));
    }

    /**
     * 新增设备动作数据
     */
    @PostMapping
    public AjaxResult add(@RequestBody DeviceAction deviceAction)
    {
        return toAjax(deviceActionService.insertDeviceAction(deviceAction));
    }

    /**
     * 修改设备动作数据
     */
    @PreAuthorize(hasPermi = "link:action:edit")
    @Log(title = "设备动作数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceAction deviceAction)
    {
        return toAjax(deviceActionService.updateDeviceAction(deviceAction));
    }

    /**
     * 删除设备动作数据
     */
    @PreAuthorize(hasPermi = "link:action:remove")
    @Log(title = "设备动作数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceActionService.deleteDeviceActionByIds(ids));
    }
}