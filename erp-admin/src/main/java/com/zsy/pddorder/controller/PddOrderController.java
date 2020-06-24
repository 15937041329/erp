package com.zsy.pddorder.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zsy.common.annotation.Log;
import com.zsy.common.enums.BusinessType;
import com.zsy.pddorder.domain.PddOrder;
import com.zsy.pddorder.service.IPddOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 拼多多Controller
 * 
 * @author wangbingquan
 * @date 2020-06-12
 */
@Controller
@RequestMapping("/pddorder/order")
public class PddOrderController extends BaseController
{
    private String prefix = "pddorder/order";

    @Autowired
    private IPddOrderService pddOrderService;

    @RequiresPermissions("pddorder:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询拼多多列表
     */
    @RequiresPermissions("pddorder:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PddOrder pddOrder)
    {
        startPage();
        List<PddOrder> list = pddOrderService.selectPddOrderList(pddOrder);
        return getDataTable(list);
    }

    /**
     * 导出拼多多列表
     */
    @RequiresPermissions("pddorder:order:export")
    @Log(title = "拼多多", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddOrder pddOrder)
    {
        List<PddOrder> list = pddOrderService.selectPddOrderList(pddOrder);
        ExcelUtil<PddOrder> util = new ExcelUtil<PddOrder>(PddOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增拼多多
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存拼多多
     */
    @RequiresPermissions("pddorder:order:add")
    @Log(title = "拼多多", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PddOrder pddOrder)
    {
        return toAjax(pddOrderService.insertPddOrder(pddOrder));
    }

    /**
     * 修改拼多多
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PddOrder pddOrder = pddOrderService.selectPddOrderById(id);
        mmap.put("pddOrder", pddOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存拼多多
     */
    @RequiresPermissions("pddorder:order:edit")
    @Log(title = "拼多多", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PddOrder pddOrder)
    {
        return toAjax(pddOrderService.updatePddOrder(pddOrder));
    }

    /**
     * 删除拼多多
     */
    @RequiresPermissions("pddorder:order:remove")
    @Log(title = "拼多多", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pddOrderService.deletePddOrderByIds(ids));
    }
}
