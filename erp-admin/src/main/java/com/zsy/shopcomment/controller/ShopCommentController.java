package com.zsy.shopcomment.controller;

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
import com.zsy.shopcomment.domain.ShopComment;
import com.zsy.shopcomment.service.IShopCommentService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author wbq
 * @date 2020-07-18
 */
@Controller
@RequestMapping("/shopcomment/comment")
public class ShopCommentController extends BaseController
{
    private String prefix = "shopcomment/comment";

    @Autowired
    private IShopCommentService shopCommentService;

    @RequiresPermissions("shopcomment:comment:view")
    @GetMapping()
    public String comment()
    {
        return prefix + "/comment";
    }

    /**
     * 查询评论列表
     */
    @RequiresPermissions("shopcomment:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShopComment shopComment)
    {
        startPage();
        List<ShopComment> list = shopCommentService.selectShopCommentList(shopComment);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @RequiresPermissions("shopcomment:comment:export")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopComment shopComment)
    {
        List<ShopComment> list = shopCommentService.selectShopCommentList(shopComment);
        ExcelUtil<ShopComment> util = new ExcelUtil<ShopComment>(ShopComment.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 新增评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论
     */
    @RequiresPermissions("shopcomment:comment:add")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShopComment shopComment)
    {
        return toAjax(shopCommentService.insertShopComment(shopComment));
    }

    /**
     * 修改评论
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ShopComment shopComment = shopCommentService.selectShopCommentById(id);
        mmap.put("shopComment", shopComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论
     */
    @RequiresPermissions("shopcomment:comment:edit")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShopComment shopComment)
    {
        return toAjax(shopCommentService.updateShopComment(shopComment));
    }

    /**
     * 删除评论
     */
    @RequiresPermissions("shopcomment:comment:remove")
    @Log(title = "评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shopCommentService.deleteShopCommentByIds(ids));
    }
}
