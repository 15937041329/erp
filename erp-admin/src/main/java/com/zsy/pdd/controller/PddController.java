package com.zsy.pdd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.druid.util.StringUtils;
import com.zsy.framework.util.ShiroUtils;
import com.zsy.henan.domain.HenanOrder;
import com.zsy.pddlimitprv.domain.PddLimitPrv;
import com.zsy.pddlimitprv.mapper.PddLimitPrvMapper;
import com.zsy.system.domain.SysUser;
import com.zsy.util.httputil.TrustAllManager;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
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
import com.zsy.pdd.domain.Pdd;
import com.zsy.pdd.service.IPddService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 拼多多表格导入Controller
 *
 * @author wbq
 * @date 2020-07-09
 */
@Controller
@RequestMapping("/pdd/pddorder")
public class PddController extends BaseController {
    private String prefix = "pdd/pddorder";

    @Autowired
    private IPddService pddService;
    @Resource
    private PddLimitPrvMapper pddLimitPrvMapper;

    @Autowired


    @RequiresPermissions("pdd:pddorder:view")
    @GetMapping()
    public String pddorder() {
        return prefix + "/pddorder";
    }

    /**
     * 查询拼多多表格导入列表
     */
    @RequiresPermissions("pdd:pddorder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pdd pdd) {
        if (ShiroUtils.getLoginName().equals("adminpdd")) {
            startPage();
            pdd.setCreateBy(ShiroUtils.getLoginName());
            List<Pdd> list = pddService.selectPddList(pdd);
            return getDataTable(list);
        }
        if (ShiroUtils.getLoginName().equals("admin")) {
            startPage();
            pdd.setCreateBy(ShiroUtils.getLoginName());
            List<Pdd> list = pddService.selectPddList(pdd);
            return getDataTable(list);
        }
       else {
            return getDataTable(null);
        }
    }

    /**
     * 导出拼多多表格导入列表
     */
    @RequiresPermissions("pdd:pddorder:export")
    @Log(title = "拼多多表格导入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Pdd pdd) {
        List<Pdd> list = pddService.selectPddList(pdd);
        ExcelUtil<Pdd> util = new ExcelUtil<Pdd>(Pdd.class);
        return util.exportExcel(list, "pddorder");
    }

    /**
     * 新增拼多多表格导入
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存拼多多表格导入
     */
    @RequiresPermissions("pdd:pddorder:add")
    @Log(title = "拼多多表格导入", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Pdd pdd) {
        return toAjax(pddService.insertPdd(pdd));
    }

    /**
     * 修改拼多多表格导入
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Pdd pdd = pddService.selectPddById(id);
        mmap.put("pdd", pdd);
        return prefix + "/edit";
    }

    /**
     * 修改保存拼多多表格导入
     */
    @RequiresPermissions("pdd:pddorder:edit")
    @Log(title = "拼多多表格导入", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Pdd pdd) {
        return toAjax(pddService.updatePdd(pdd));
    }

    /**
     * 删除拼多多表格导入
     */
    @RequiresPermissions("pdd:pddorder:remove")
    @Log(title = "拼多多表格导入", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(pddService.deletePddByIds(ids));
    }


    /**
     * 导入拼多多表格导入列表
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Pdd> util = new ExcelUtil<Pdd>(Pdd.class);
        String operName = ShiroUtils.getSysUser().getLoginName();
        List<Pdd> pddList = util.importExcel(file.getInputStream());
        for (Pdd pdd : pddList) {
            if (StrUtil.isEmpty(pdd.getVdef1())) {
                return AjaxResult.error("Vdef1为空，请检查！");
            }
            PddLimitPrv pddLimitPrvQuery = new PddLimitPrv();
            pddLimitPrvQuery.setSkuName(pdd.getVdef1());
            List<PddLimitPrv> pddLimitPrvList = pddLimitPrvMapper.selectPddLimitPrvList(pddLimitPrvQuery);
            if (pddLimitPrvList.size() == 0) {
                return AjaxResult.error("过滤规则检测失败，请检查！");
            }
            IdcardUtil.getAgeByIdCard(pdd.getIp());
        }
        for (Pdd pdd : pddList) {

            PddLimitPrv pddLimitPrvQuery = new PddLimitPrv();
            pddLimitPrvQuery.setSkuName(pdd.getVdef1());
            List<PddLimitPrv> pddLimitPrvList = pddLimitPrvMapper.selectPddLimitPrvList(pddLimitPrvQuery);
            if (pddLimitPrvList.size() == 0) {
                return AjaxResult.error("过滤规则检测失败，请检查！");
            }
            boolean limitPrvFlag = false;
            boolean limitAgeFlag = false;
            int age = IdcardUtil.getAgeByIdCard(pdd.getIp());
            for (PddLimitPrv pddLimitPrv : pddLimitPrvList) {
                if (age < pddLimitPrv.getMinAge() || age > pddLimitPrv.getMaxAge()) {
                    limitAgeFlag = true;
                    break;
                }

                if (!StrUtil.isEmpty(pddLimitPrv.getPrv()) &&
                        !StrUtil.isEmpty(pddLimitPrv.getCity()) &&
                        !StrUtil.isEmpty(pddLimitPrv.getCounty())) {
                    if (pdd.getProvince().contains(pddLimitPrv.getPrv()) &&
                            pdd.getCity().contains(pddLimitPrv.getCity()) &&
                            pdd.getCounty().contains(pddLimitPrv.getCounty())) {
                        limitPrvFlag = true;
                        break;
                    }
                }
                if (!StrUtil.isEmpty(pddLimitPrv.getPrv()) &&
                        !StrUtil.isEmpty(pddLimitPrv.getCity()) &&
                        StrUtil.isEmpty(pddLimitPrv.getCounty())) {
                    if (pdd.getProvince().contains(pddLimitPrv.getPrv()) &&
                            pdd.getCity().contains(pddLimitPrv.getCity())) {
                        limitPrvFlag = true;
                        break;
                    }
                }
                if (!StrUtil.isEmpty(pddLimitPrv.getPrv()) &&
                        StrUtil.isEmpty(pddLimitPrv.getCity()) &&
                        StrUtil.isEmpty(pddLimitPrv.getCounty())) {
                    if (pdd.getProvince().contains(pddLimitPrv.getPrv())) {
                        limitPrvFlag = true;
                        break;
                    }
                }
            }
            if (!limitPrvFlag && !limitAgeFlag) {
                continue;
            }
            if (limitPrvFlag) {
                pdd.setVdef3("不发货地区");
            }
            if (limitAgeFlag) {
                pdd.setVdef2("超龄");
            }
            String ip = pdd.getIp();
            pdd.setVdef4(Convert.toStr(IdcardUtil.getAgeByIdCard(pdd.getIp())));
            pddService.insertPdd(pdd);
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


    /**
     * 导出微客项目模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        List<Pdd> list = new ArrayList<>();
        ExcelUtil<Pdd> util = new ExcelUtil<Pdd>(Pdd.class);
        return util.exportExcel(list, "导入项目模板");
    }

    @Data
    public static class PrvCityModel {
        String prvName;
        String cityName;
    }
}
