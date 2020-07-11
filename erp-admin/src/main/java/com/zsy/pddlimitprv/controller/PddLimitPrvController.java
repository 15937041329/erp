package com.zsy.pddlimitprv.controller;

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
import com.zsy.pddlimitprv.domain.PddLimitPrv;
import com.zsy.pddlimitprv.service.IPddLimitPrvService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

/**
 * 黑名单地区及年龄筛选Controller
 * 
 * @author wbq
 * @date 2020-07-11
 */
@Controller
@RequestMapping("/pddlimitprv/pddlimitprv")
public class PddLimitPrvController extends BaseController
{
    private String prefix = "pddlimitprv/pddlimitprv";

    @Autowired
    private IPddLimitPrvService pddLimitPrvService;

    @RequiresPermissions("pddlimitprv:pddlimitprv:view")
    @GetMapping()
    public String pddlimitprv()
    {
        return prefix + "/pddlimitprv";
    }

    /**
     * 查询黑名单地区及年龄筛选列表
     */
    @RequiresPermissions("pddlimitprv:pddlimitprv:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PddLimitPrv pddLimitPrv)
    {
        startPage();
        List<PddLimitPrv> list = pddLimitPrvService.selectPddLimitPrvList(pddLimitPrv);
        return getDataTable(list);
    }

    /**
     * 导出黑名单地区及年龄筛选列表
     */
    @RequiresPermissions("pddlimitprv:pddlimitprv:export")
    @Log(title = "黑名单地区及年龄筛选", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddLimitPrv pddLimitPrv)
    {
        List<PddLimitPrv> list = pddLimitPrvService.selectPddLimitPrvList(pddLimitPrv);
        ExcelUtil<PddLimitPrv> util = new ExcelUtil<PddLimitPrv>(PddLimitPrv.class);
        return util.exportExcel(list, "pddlimitprv");
    }

    /**
     * 新增黑名单地区及年龄筛选
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存黑名单地区及年龄筛选
     */
    @RequiresPermissions("pddlimitprv:pddlimitprv:add")
    @Log(title = "黑名单地区及年龄筛选", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PddLimitPrv pddLimitPrv)
    {
        return toAjax(pddLimitPrvService.insertPddLimitPrv(pddLimitPrv));
    }

    /**
     * 修改黑名单地区及年龄筛选
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PddLimitPrv pddLimitPrv = pddLimitPrvService.selectPddLimitPrvById(id);
        mmap.put("pddLimitPrv", pddLimitPrv);
        return prefix + "/edit";
    }

    /**
     * 修改保存黑名单地区及年龄筛选
     */
    @RequiresPermissions("pddlimitprv:pddlimitprv:edit")
    @Log(title = "黑名单地区及年龄筛选", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PddLimitPrv pddLimitPrv)
    {
        return toAjax(pddLimitPrvService.updatePddLimitPrv(pddLimitPrv));
    }

    /**
     * 删除黑名单地区及年龄筛选
     */
    @RequiresPermissions("pddlimitprv:pddlimitprv:remove")
    @Log(title = "黑名单地区及年龄筛选", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pddLimitPrvService.deletePddLimitPrvByIds(ids));
    }
}
