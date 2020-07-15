package com.zsy.pddstorage.controller;

import java.util.List;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import com.zsy.framework.util.ShiroUtils;
import com.zsy.pdd.domain.Pdd;
import com.zsy.pddlimitprv.domain.PddLimitPrv;
import com.zsy.pddlimitprv.mapper.PddLimitPrvMapper;
import com.zsy.pddstorage.mapper.PddStorageMapper;
import io.swagger.annotations.ApiOperation;
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
import com.zsy.pddstorage.domain.PddStorage;
import com.zsy.pddstorage.service.IPddStorageService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 数据存储Controller
 * 
 * @author wbq
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/pddstorage/storage")
public class PddStorageController extends BaseController
{
    private String prefix = "pddstorage/storage";

    @Autowired
    private IPddStorageService pddStorageService;

    @Resource
    private PddStorageMapper pddStorageMapper;
    @RequiresPermissions("pddstorage:storage:view")
    @GetMapping()
    public String storage()
    {
        return prefix + "/storage";
    }

    /**
     * 查询数据存储列表
     */
    @RequiresPermissions("pddstorage:storage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PddStorage pddStorage)
    {
        startPage();
        List<PddStorage> list = pddStorageService.selectPddStorageList(pddStorage);
        return getDataTable(list);
    }

    /**
     * 导出数据存储列表
     */
    @RequiresPermissions("pddstorage:storage:export")
    @Log(title = "数据存储", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddStorage pddStorage)
    {
        List<PddStorage> list = pddStorageService.selectPddStorageList(pddStorage);
        ExcelUtil<PddStorage> util = new ExcelUtil<PddStorage>(PddStorage.class);
        return util.exportExcel(list, "storage");
    }

    /**
     * 新增数据存储
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据存储
     */
    @RequiresPermissions("pddstorage:storage:add")
    @Log(title = "数据存储", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PddStorage pddStorage)
    {
        return toAjax(pddStorageService.insertPddStorage(pddStorage));
    }

    /**
     * 修改数据存储
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PddStorage pddStorage = pddStorageService.selectPddStorageById(id);
        mmap.put("pddStorage", pddStorage);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据存储
     */
    @RequiresPermissions("pddstorage:storage:edit")
    @Log(title = "数据存储", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PddStorage pddStorage)
    {
        return toAjax(pddStorageService.updatePddStorage(pddStorage));
    }

    /**
     * 删除数据存储
     */
    @RequiresPermissions("pddstorage:storage:remove")
    @Log(title = "数据存储", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pddStorageService.deletePddStorageByIds(ids));
    }


    /**
     * 导入拼多多表格导入列表
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PddStorage> util = new ExcelUtil<PddStorage>(PddStorage.class);
        List<PddStorage> pddList = util.importExcel(file.getInputStream());
        PddStorage pdd=new PddStorage();
        for (PddStorage pddStorage : pddList) {
            pddStorage.setVdef4(Convert.toStr(IdcardUtil.getAgeByIdCard(pddStorage.getIp())));
            pddStorageService.insertPddStorage(pddStorage);
        }
        return AjaxResult.success("SUCCESS");

    }

    /**
     * 根据身份证号码计算年龄
     *
     * @param psptNo
     * @return
     */
    @ApiOperation("计算年龄")
    @PostMapping("/getAgeByPsptNo")
    public int getAgeByPsptNo(String psptNo) {
        try {
            return IdcardUtil.getAgeByIdCard(psptNo);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



}
