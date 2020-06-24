package com.zsy.liuliangbao.controller;

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
import com.zsy.liuliangbao.domain.HenanliuliangbaoOrder;
import com.zsy.liuliangbao.service.IHenanliuliangbaoOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 头条抖音流量包Controller
 * 
 * @author wangbingquan
 * @date 2020-06-09
 */
@Controller
@RequestMapping("/liuliangbao/order")
public class HenanliuliangbaoOrderController extends BaseController
{
    private String prefix = "liuliangbao/order";

    @Autowired
    private IHenanliuliangbaoOrderService henanliuliangbaoOrderService;

    @RequiresPermissions("liuliangbao:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询头条抖音流量包列表
     */
    @RequiresPermissions("liuliangbao:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        startPage();
        List<HenanliuliangbaoOrder> list = henanliuliangbaoOrderService.selectHenanliuliangbaoOrderList(henanliuliangbaoOrder);
        return getDataTable(list);
    }

    /**
     * 导出头条抖音流量包列表
     */
    @RequiresPermissions("liuliangbao:order:export")
    @Log(title = "头条抖音流量包", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        List<HenanliuliangbaoOrder> list = henanliuliangbaoOrderService.selectHenanliuliangbaoOrderList(henanliuliangbaoOrder);
        ExcelUtil<HenanliuliangbaoOrder> util = new ExcelUtil<HenanliuliangbaoOrder>(HenanliuliangbaoOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增头条抖音流量包
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存头条抖音流量包
     */
    @RequiresPermissions("liuliangbao:order:add")
    @Log(title = "头条抖音流量包", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        return toAjax(henanliuliangbaoOrderService.insertHenanliuliangbaoOrder(henanliuliangbaoOrder));
    }

    /**
     * 修改头条抖音流量包
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HenanliuliangbaoOrder henanliuliangbaoOrder = henanliuliangbaoOrderService.selectHenanliuliangbaoOrderById(id);
        mmap.put("henanliuliangbaoOrder", henanliuliangbaoOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存头条抖音流量包
     */
    @RequiresPermissions("liuliangbao:order:edit")
    @Log(title = "头条抖音流量包", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        return toAjax(henanliuliangbaoOrderService.updateHenanliuliangbaoOrder(henanliuliangbaoOrder));
    }

    /**
     * 删除头条抖音流量包
     */
    @RequiresPermissions("liuliangbao:order:remove")
    @Log(title = "头条抖音流量包", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(henanliuliangbaoOrderService.deleteHenanliuliangbaoOrderByIds(ids));
    }
}
