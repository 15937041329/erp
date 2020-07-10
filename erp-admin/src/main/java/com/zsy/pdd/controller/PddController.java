package com.zsy.pdd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.zsy.framework.util.ShiroUtils;
import com.zsy.henan.domain.HenanOrder;
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
        if (ShiroUtils.getLoginName().equals("admin")) {
            startPage();
            List<Pdd> list = pddService.selectPddList(pdd);
            return getDataTable(list);
        }
        if (ShiroUtils.getLoginName().equals("xuyiming")) {
            pdd.setVdef5("xuyiming");
            startPage();
            pdd.setCreateBy(ShiroUtils.getLoginName());
            List<Pdd> list = pddService.selectPddList(pdd);
            return getDataTable(list);

        }
        if (ShiroUtils.getLoginName().equals("wangenhe")) {
            pdd.setVdef5("wangenhe");

            if (pdd.getCommodityName().equals("电信14元200G流量+100分钟") && pdd.getCommodityName().equals("电信19元200G流量+100分")) {
            }
            startPage();
            pdd.setCreateBy(ShiroUtils.getLoginName());
            List<Pdd> list = pddService.selectPddList(pdd);
            return getDataTable(list);

        } else {
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
            String limitPrvCityStr = "";
            if (pdd.getCommoditySpec().contains("电信19元200G流量+100分")) {
                limitPrvCityStr = "新疆~西藏~广西，宾阳~福建，龙岩~云南，普洱~广东，茂名，电白~广东，湛江，廉江~云南，德宏傣族景颇族自治州~云南，临沧~云南，西双版纳傣族自治州";
            } else if (pdd.getCommoditySpec().contains("电信14元200G流量+100分钟")) {
                limitPrvCityStr = "新疆~西藏~广西，宾阳~福建，龙岩~云南，普洱~广东，茂名~广东，电白~云南，德宏傣族景颇族自治州~云南，临沧~云南，西双版纳傣族自治州";
            }else if (pdd.getCommoditySpec().contains("顺意卡29元81G全国流量+100分")) {
                limitPrvCityStr = "广东,江门~广东,阳江~广东,东莞~广东,佛山~广东,肇庆~广东,茂名~广东,湛江";
            }
            else {
                continue;
            }
            boolean limitFlag = false;
            limitPrvCityStr = limitPrvCityStr.replace("，", ",");
            String[] rows = limitPrvCityStr.split("~");
            for (String item : rows) {
                String[] itemRows = item.split(",");
                if (itemRows.length == 1) {
                    String prvName = itemRows[0];
                    if (pdd.getProvince().contains(prvName)) {
                        limitFlag = true;
                        break;
                    }
                } else if (itemRows.length == 2) {
                    String prvName = itemRows[0];
                    String cityName = itemRows[1];
                    if (pdd.getProvince().contains(prvName) && pdd.getCity().contains(cityName)) {
                        limitFlag = true;
                        break;
                    }
                }
                else if (itemRows.length == 3) {
                    String prvName = itemRows[0];
                    String cityName = itemRows[1];
                    String countyName = itemRows[2];
                    if (pdd.getProvince().contains(prvName) && pdd.getCity().contains(cityName)&& pdd.getCounty().contains(countyName)) {
                        limitFlag = true;
                        break;
                    }
                }
            }
            if (!limitFlag) {
                continue;
            }

            String ip = pdd.getIp();
            pdd.setVdef4(intToString(getAgeByPsptNo(ip)));
            pdd.setVdef3("不发货地区");
            pddService.insertPdd(pdd);
        }
        return AjaxResult.success("SUCCESS");
    }

    public static String intToString(int value) {
        Integer integer = new Integer(value);
        return integer.toString();
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
        if (StringUtils.isEmpty(psptNo)) {
            return 0;
        }
        String birthDay = psptNo.substring(6, 14);
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String yearStr = time.split("-")[0];
        String monthStr = time.split("-")[1];
        String dayStr = time.split("-")[2];
        String yearBirthStr = birthDay.substring(0, 4);
        String monthBirthStr = birthDay.substring(4, 6);
        String dayBirthStr = birthDay.substring(6);
        int year = Integer.valueOf(yearStr);
        int yearBirth = Integer.valueOf(yearBirthStr);
        if (year - yearBirth <= 0) {
            return 0;
        }
        int age = year - yearBirth;
        int month = Integer.valueOf(monthStr);
        int monthBirth = Integer.valueOf(monthBirthStr);
        if (month - monthBirth > 0) {
            return age;
        }
        if (month - monthBirth < 0) {
            return --age;
        }
        int day = Integer.valueOf(dayStr);
        int dayBirth = Integer.valueOf(dayBirthStr);
        if (day - dayBirth >= 0) {
            return age;
        }
        return --age;
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
