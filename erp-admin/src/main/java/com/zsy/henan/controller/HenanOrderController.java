package com.zsy.henan.controller;

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
import com.zsy.henan.domain.HenanOrder;
import com.zsy.henan.service.IHenanOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 河南订单Controller
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
@Controller
@RequestMapping("/henan/order")
public class HenanOrderController extends BaseController
{
    private String prefix = "henan/order";

    @Autowired
    private IHenanOrderService henanOrderService;

    @RequiresPermissions("henan:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询河南订单信息列表
     */
    @RequiresPermissions("henan:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HenanOrder henanOrder)
    {

        if (ShiroUtils.getLoginName().equals("admin")) {
            startPage();
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);
        }
        if (ShiroUtils.getLoginName().equals("zhsuya")) {
            henanOrder.setVdef2("zhsuya100");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyb")) {
            henanOrder.setVdef2("zhsuyb111");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyc")) {
            henanOrder.setVdef2("zhsuyc122");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyd")) {
            henanOrder.setVdef2("zhsuyd133");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuye")) {
            henanOrder.setVdef2("zhsuye144");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyf")) {
            henanOrder.setVdef2("zhsuyf155");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyg")) {
            henanOrder.setVdef2("zhsuyg166");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyh")) {
            henanOrder.setVdef2("zhsuyh177");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("zhsuyi")) {
            henanOrder.setVdef2("zhsuyi188");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        }

        if (ShiroUtils.getLoginName().equals("zhsuyj")) {
            henanOrder.setVdef2("zhsuyj199");
            startPage();
            henanOrder.setCreateBy(ShiroUtils.getLoginName());
            List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
            return getDataTable(list);

        } else {

            return getDataTable(null);

        }
    }

    /**
     * 导出河南订单列表
     */
    @RequiresPermissions("henan:order:export")
    @Log(title = "河南订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HenanOrder henanOrder)
    {
        List<HenanOrder> list = henanOrderService.selectHenanOrderList(henanOrder);
        ExcelUtil<HenanOrder> util = new ExcelUtil<HenanOrder>(HenanOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增河南订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存河南订单
     */
    @RequiresPermissions("henan:order:add")
    @Log(title = "河南订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HenanOrder henanOrder)
    {
        return toAjax(henanOrderService.insertHenanOrder(henanOrder));
    }

    /**
     * 修改河南订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HenanOrder henanOrder = henanOrderService.selectHenanOrderById(id);
        mmap.put("henanOrder", henanOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存河南订单
     */
    @RequiresPermissions("henan:order:edit")
    @Log(title = "河南订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HenanOrder henanOrder)
    {
        return toAjax(henanOrderService.updateHenanOrder(henanOrder));
    }

    /**
     * 删除河南订单
     */
    @RequiresPermissions("henan:order:remove")
    @Log(title = "河南订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(henanOrderService.deleteHenanOrderByIds(ids));
    }








}
