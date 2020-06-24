package com.zsy.web.controller.product;

import java.util.List;
import com.zsy.common.utils.IdUtils;
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
import com.zsy.product.domain.Product;
import com.zsy.product.service.IProductService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;
/**
 * 商品信息Controller
 *
 * @author cloud
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/product/product")
public class ProductController extends BaseController {
    private String prefix = "product/product";

    @Autowired
    private IProductService productService;

    @RequiresPermissions("product:product:view")
    @GetMapping()
    public String product() {
        return prefix + "/product";
    }

    /**
     * 查询商品信息列表
     */
    @RequiresPermissions("product:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product product) {
       if (("admin").equals(ShiroUtils.getLoginName())){
            startPage();
            List<Product> list = productService.selectProductList(product);
            return getDataTable(list);
        }else {

           startPage();
           product.setCreateBy(ShiroUtils.getLoginName());
           List<Product> list = productService.selectProductList(product);
           return getDataTable(list);
       }
    }
    /**
     * 新增商品信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("itemSku", IdUtils.getShortUuid());
        return prefix + "/add";
    }

    /**
     * 新增保存商品信息
     */
    @RequiresPermissions("product:product:add")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Product product) {
        product.setCurrency("CYN");
        product.setStandardPrice(10.00);
        product.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改商品信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品信息
     */
    @RequiresPermissions("product:product:edit")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Product product) {
        product.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(productService.updateProduct(product));
    }

    @RequiresPermissions("product:product:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("product", productService.selectProductById(id));
        return prefix + "/detail";
    }

    /**
     * 删除商品信息
     */
    @RequiresPermissions("product:product:remove")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(productService.deleteProductByIds(ids));
    }



    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product)
    {
        if(("admin").equals(ShiroUtils.getLoginName())){

            List<Product> list = productService.selectProductList(product);
            ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
            return util.exportExcel(list, "用户数据");

        }else {
            product.setCreateBy(ShiroUtils.getLoginName());
            List<Product> list = productService.selectProductList(product);
            ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
            return util.exportExcel(list, "用户数据");


        }



    }
}
