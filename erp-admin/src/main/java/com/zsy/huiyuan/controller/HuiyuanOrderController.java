package com.zsy.huiyuan.controller;

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
import com.zsy.huiyuan.domain.HuiyuanOrder;
import com.zsy.huiyuan.service.IHuiyuanOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 未来会员Controller
 * 
 * @author wangbingquan
 * @date 2020-06-23
 */
@Controller
@RequestMapping("/huiyuan/order")
public class HuiyuanOrderController extends BaseController
{
    private String prefix = "huiyuan/order";

    @Autowired
    private IHuiyuanOrderService huiyuanOrderService;

    @RequiresPermissions("huiyuan:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询未来会员列表
     */
    @RequiresPermissions("huiyuan:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HuiyuanOrder huiyuanOrder)
    {
        startPage();
        List<HuiyuanOrder> list = huiyuanOrderService.selectHuiyuanOrderList(huiyuanOrder);
        return getDataTable(list);
    }

    /**
     * 导出未来会员列表
     */
    @RequiresPermissions("huiyuan:order:export")
    @Log(title = "未来会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HuiyuanOrder huiyuanOrder)
    {
        List<HuiyuanOrder> list = huiyuanOrderService.selectHuiyuanOrderList(huiyuanOrder);
        ExcelUtil<HuiyuanOrder> util = new ExcelUtil<HuiyuanOrder>(HuiyuanOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增未来会员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存未来会员
     */
    @RequiresPermissions("huiyuan:order:add")
    @Log(title = "未来会员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HuiyuanOrder huiyuanOrder)
    {
        return toAjax(huiyuanOrderService.insertHuiyuanOrder(huiyuanOrder));
    }

    /**
     * 修改未来会员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HuiyuanOrder huiyuanOrder = huiyuanOrderService.selectHuiyuanOrderById(id);
        mmap.put("huiyuanOrder", huiyuanOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存未来会员
     */
    @RequiresPermissions("huiyuan:order:edit")
    @Log(title = "未来会员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HuiyuanOrder huiyuanOrder)
    {
        return toAjax(huiyuanOrderService.updateHuiyuanOrder(huiyuanOrder));
    }

    /**
     * 删除未来会员
     */
    @RequiresPermissions("huiyuan:order:remove")
    @Log(title = "未来会员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(huiyuanOrderService.deleteHuiyuanOrderByIds(ids));
    }
}
