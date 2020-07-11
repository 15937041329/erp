package com.zsy.wbqshop.controller;

import java.util.List;

import com.zsy.common.utils.IdUtils;
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
import com.zsy.wbqshop.domain.Shop;
import com.zsy.wbqshop.service.IShopService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * wbqshopController
 * 
 * @author wbq
 * @date 2020-07-10
 */
@Controller
@RequestMapping("/wbqshop/shop")
public class ShopController extends BaseController
{
    private String prefix = "wbqshop/shop";

    @Autowired
    private IShopService shopService;

    @RequiresPermissions("wbqshop:shop:view")
    @GetMapping()
    public String shop()
    {
        return prefix + "/shop";
    }

    /**
     * 查询wbqshop列表
     */
    @RequiresPermissions("wbqshop:shop:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Shop shop)
    {
        startPage();
        List<Shop> list = shopService.selectShopList(shop);
        return getDataTable(list);
    }

    /**
     * 导出wbqshop列表
     */
    @RequiresPermissions("wbqshop:shop:export")
    @Log(title = "wbqshop", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shop shop)
    {
        List<Shop> list = shopService.selectShopList(shop);
        ExcelUtil<Shop> util = new ExcelUtil<Shop>(Shop.class);
        return util.exportExcel(list, "shop");
    }

    /**
     * 新增wbqshop
     */
   /* @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }*/
    /**
     * 新增商品信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        return prefix + "/add";
    }

    /**
     * 新增保存wbqshop
     */
    @RequiresPermissions("wbqshop:shop:add")
    @Log(title = "wbqshop", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Shop shop)
    {
        return toAjax(shopService.insertShop(shop));
    }

    /**
     * 修改wbqshop
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Shop shop = shopService.selectShopById(id);
        mmap.put("shop", shop);
        return prefix + "/edit";
    }

    /**
     * 修改保存wbqshop
     */
    @RequiresPermissions("wbqshop:shop:edit")
    @Log(title = "wbqshop", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Shop shop)
    {
        return toAjax(shopService.updateShop(shop));
    }

    /**
     * 删除wbqshop
     */
    @RequiresPermissions("wbqshop:shop:remove")
    @Log(title = "wbqshop", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shopService.deleteShopByIds(ids));
    }
}
