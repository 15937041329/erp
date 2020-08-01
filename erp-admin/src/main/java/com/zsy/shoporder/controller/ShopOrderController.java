package com.zsy.shoporder.controller;

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
import com.zsy.shoporder.domain.ShopOrder;
import com.zsy.shoporder.service.IShopOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 七品馆订单信息表Controller
 * 
 * @author wbq
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/shoporder/order")
public class ShopOrderController extends BaseController
{
    private String prefix = "shoporder/order";

    @Autowired
    private IShopOrderService shopOrderService;

    @RequiresPermissions("shoporder:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询七品馆订单信息表列表
     */
    @RequiresPermissions("shoporder:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShopOrder shopOrder)
    {
        startPage();
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        return getDataTable(list);
    }

    /**
     * 导出七品馆订单信息表列表
     */
    @RequiresPermissions("shoporder:order:export")
    @Log(title = "七品馆订单信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopOrder shopOrder)
    {
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        ExcelUtil<ShopOrder> util = new ExcelUtil<ShopOrder>(ShopOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增七品馆订单信息表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存七品馆订单信息表
     */
    @RequiresPermissions("shoporder:order:add")
    @Log(title = "七品馆订单信息表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShopOrder shopOrder)
    {
        return toAjax(shopOrderService.insertShopOrder(shopOrder));
    }

    /**
     * 修改七品馆订单信息表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ShopOrder shopOrder = shopOrderService.selectShopOrderById(id);
        mmap.put("shopOrder", shopOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存七品馆订单信息表
     */
    @RequiresPermissions("shoporder:order:edit")
    @Log(title = "七品馆订单信息表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShopOrder shopOrder)
    {
        return toAjax(shopOrderService.updateShopOrder(shopOrder));
    }

    /**
     * 删除七品馆订单信息表
     */
    @RequiresPermissions("shoporder:order:remove")
    @Log(title = "七品馆订单信息表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shopOrderService.deleteShopOrderByIds(ids));
    }
}
