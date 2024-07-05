package com.basiclab.iot.rule.controller;

import com.basiclab.iot.common.core.annotation.NoRepeatSubmit;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.utils.bean.BeanUtils;
import com.basiclab.iot.common.core.web.controller.BaseController;
import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.common.core.web.page.TableDataInfo;
import com.basiclab.iot.common.log.annotation.Log;
import com.basiclab.iot.common.log.enums.BusinessType;
import com.basiclab.iot.common.security.annotation.PreAuthorize;
import com.basiclab.iot.rule.api.domain.ActionCommands;
import com.basiclab.iot.rule.api.domain.model.ActionCommandsModel;
import com.basiclab.iot.rule.service.ActionCommandsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/actionCommands")
@RestController
public class ActionCommandsController extends BaseController {


    @Resource
    private ActionCommandsService actionCommandsService;

    /**
     * 通过主产品标识查询产品
     *
     * @param ruleIdentification 规则标识
     * @return 单条数据
     */
    @GetMapping("/actionCommandsByRuleIdentification/{ruleIdentification}")
    public R<?> actionCommandsByRuleIdentification(@PathVariable(value = "ruleIdentification") String ruleIdentification) {
        return R.ok(actionCommandsService.actionCommandsByRuleIdentification(ruleIdentification));
    }


    @PreAuthorize(hasPermi = "rule:rule:list")
    @GetMapping("/list")
    public TableDataInfo list(ActionCommands actionCommands) {
        List<ActionCommands> list = actionCommandsService.selectByActionCommandsSelective(actionCommands );
        return getDataTable(list);
    }

    /**
     * 批量新增执行动作命令
     */
    @NoRepeatSubmit
    @PreAuthorize(hasPermi = "rule:actionCommands:add")
    @Log(title = "执行动作命令", businessType = BusinessType.INSERT)
    @PostMapping("/batchInsert")
    public AjaxResult batchInsert(@RequestBody List<ActionCommands> actionCommandsList) {
        return AjaxResult.success(actionCommandsService.batchInsert(actionCommandsList));
    }

    /**
     * 批量编辑执行动作命令
     */
    @NoRepeatSubmit
    @PreAuthorize(hasPermi = "rule:actionCommands:edit")
    @Log(title = "执行动作命令", businessType = BusinessType.UPDATE)
    @PutMapping("/batchEdit")
    public AjaxResult updateBatch(@RequestBody List<ActionCommands> actionCommandsList) {
        return toAjax(actionCommandsService.updateBatchSelective(actionCommandsList));
    }

    /**
     * 批量删除执行动作命令
     * @param ids
     * @return
     */
    @PreAuthorize(hasPermi = "link:actionCommands:remove")
    @Log(title = "执行动作命令", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(actionCommandsService.deleteBatchByIds(ids));
    }
}
