package com.zsy.beijing.controller;

import java.util.List;

import com.zsy.framework.util.ShiroUtils;
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
import com.zsy.beijing.domain.BeijingOrder;
import com.zsy.beijing.service.IBeijingOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 北京订单Controller
 * 
 * @author wangbingquan
 *
 * @date 2020-06-03
 */
@Controller
@RequestMapping("/beijing/order")
public class BeijingOrderController extends BaseController
{
    private String prefix = "beijing/order";

    @Autowired
    private IBeijingOrderService beijingOrderService;


    @RequiresPermissions("beijing:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询北京订单查询列表
     */
    @RequiresPermissions("beijing:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BeijingOrder beijingOrder)
    {
        if (ShiroUtils.getLoginName().equals("admin")) {
            startPage();
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);
        }
        if (ShiroUtils.getLoginName().equals("zhsuya")) {
            beijingOrder.setVdef1("zhsuya100");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyb")) {
            beijingOrder.setVdef1("zhsuyb111");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyc")) {
            beijingOrder.setVdef1("zhsuyc122");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }

        if (ShiroUtils.getLoginName().equals("zhsuye")) {
            beijingOrder.setVdef1("zhsuye144");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyf")) {
            beijingOrder.setVdef1("zhsuyf155");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyg")) {
            beijingOrder.setVdef1("zhsuyg166");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyh")) {
            beijingOrder.setVdef1("zhsuyh177");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyi")) {
            beijingOrder.setVdef1("zhsuyi188");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        }

        if (ShiroUtils.getLoginName().equals("zhsuyj")) {
            beijingOrder.setVdef1("zhsuyj199");
            beijingOrder.setCreateTime(beijingOrder.getCreateTime());
            beijingOrder.setReturnTime(beijingOrder.getReturnTime());
            startPage();
            beijingOrder.setCreateBy(ShiroUtils.getLoginName());
            List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
            return getDataTable(list);

        } else {

            return getDataTable(null);

        }

    }

    /**
     * 导出北京订单列表
     */
    @RequiresPermissions("beijing:order:export")
    @Log(title = "北京订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BeijingOrder beijingOrder)
    {
        List<BeijingOrder> list = beijingOrderService.selectBeijingOrderList(beijingOrder);
        ExcelUtil<BeijingOrder> util = new ExcelUtil<BeijingOrder>(BeijingOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增北京订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存北京订单
     */
    @RequiresPermissions("beijing:order:add")
    @Log(title = "北京订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BeijingOrder beijingOrder)
    {
        return toAjax(beijingOrderService.insertBeijingOrder(beijingOrder));
    }

    /**
     * 修改北京订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BeijingOrder beijingOrder = beijingOrderService.selectBeijingOrderById(id);
        mmap.put("beijingOrder", beijingOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存北京订单
     */
    @RequiresPermissions("beijing:order:edit")
    @Log(title = "北京订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BeijingOrder beijingOrder)
    {
        return toAjax(beijingOrderService.updateBeijingOrder(beijingOrder));
    }

    /**
     * 删除北京订单
     */
    @RequiresPermissions("beijing:order:remove")
    @Log(title = "北京订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(beijingOrderService.deleteBeijingOrderByIds(ids));
    }
}
