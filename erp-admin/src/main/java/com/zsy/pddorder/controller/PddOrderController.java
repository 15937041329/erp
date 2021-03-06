package com.zsy.pddorder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.zsy.util.httputil.HttpUtil;
import com.zsy.util.httputil.RequestParamsToMap;
import io.swagger.annotations.Api;
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
import com.zsy.pddorder.domain.PddOrder;
import com.zsy.pddorder.service.IPddOrderService;
import com.zsy.common.core.controller.BaseController;
import com.zsy.common.core.domain.AjaxResult;
import com.zsy.common.utils.poi.ExcelUtil;
import com.zsy.common.core.page.TableDataInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拼多多Controller
 * 
 * @author wangbingquan
 * @date 2020-06-12
 */
@Api(tags = "拼多多订单接口")
@Controller
@RequestMapping("/pddorder/order")
public class PddOrderController extends BaseController
{
    private String prefix = "pddorder/order";

    @Autowired
    private IPddOrderService pddOrderService;

    @RequiresPermissions("pddorder:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询拼多多列表
     */
    @RequiresPermissions("pddorder:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PddOrder pddOrder)
    {
        startPage();
        List<PddOrder> list = pddOrderService.selectPddOrderList(pddOrder);
        return getDataTable(list);
    }

    /**
     * 导出拼多多列表
     */
    @RequiresPermissions("pddorder:order:export")
    @Log(title = "拼多多", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddOrder pddOrder)
    {
        List<PddOrder> list = pddOrderService.selectPddOrderList(pddOrder);
        ExcelUtil<PddOrder> util = new ExcelUtil<PddOrder>(PddOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增拼多多
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存拼多多
     */
    @RequiresPermissions("pddorder:order:add")
    @Log(title = "拼多多", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PddOrder pddOrder)
    {
        return toAjax(pddOrderService.insertPddOrder(pddOrder));
    }

    /**
     * 修改拼多多
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PddOrder pddOrder = pddOrderService.selectPddOrderById(id);
        mmap.put("pddOrder", pddOrder);
        return prefix + "/edit";
    }


    /**
     * 获取拼多多手机号和身份证号后六位
     */
    @GetMapping("/editipnum/{id}")
    public String editeditipnum(@PathVariable("id") Long id, ModelMap mmap)
    {
        JSONObject params = new JSONObject();
        PddOrder pddOrder = pddOrderService.selectPddOrderById(id);
        params.put("pddOrder", pddOrder);
        String useridnum = null;
        String usertel = null;
        useridnum = params.getJSONObject("pddOrder").getString("useridnum");
        String useridnumSix = useridnum.substring(useridnum.length() - 6);
        usertel = params.get("usertel").toString();
        mmap.put("pddOrder", pddOrder);
        mmap.put("useridnumSix", useridnumSix);
        mmap.put("usertel", usertel);
        return prefix + "/edit";
    }
    @ApiOperation("拼多多接口")
    @RequestMapping("queryPhoneNumber")
    @GetMapping
    public void queryPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        HttpUtil httpUtil = new HttpUtil();
        Map<String, Object> postList = RequestParamsToMap.getParameterMap(request);

        String httpRet1 = httpUtil.getHtml("http://tel.whaleda.com/order/query", postList, "");

        String phone=postList.get("phone").toString();
        String idCard=postList.get("id_card").toString();
        idCard=idCard.substring(idCard.length()-6);
        httpRet1= httpRet1.replace(" name=\"phone\""," name=\"phone\" value=\""+phone+"\"");
        httpRet1= httpRet1.replace(" name=\"id_card\""," name=\"id_card\" value=\""+idCard+"\"");
        httpRet1=  httpRet1.replace("<head>" ,"<head><base href=\"http://tel.whaleda.com/order/\" />");
        httpRet1=  httpRet1.replace("<form class=\"content\" method=\"post\">" ,"<form class=\"content\" method=\"post\" action=\"http://tel.whaleda.com/order/query\">");

        for (HttpCookie item : httpUtil.getCookieJar().cookieStore) {
            Cookie userCookie=new Cookie(item.getName(),item.getValue());
            userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
            userCookie.setPath(item.getPath());
            response.addCookie(userCookie);
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(httpRet1);

    }

    /**
     * 修改保存拼多多
     */
    @RequiresPermissions("pddorder:order:edit")
    @Log(title = "拼多多", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PddOrder pddOrder)
    {
        return toAjax(pddOrderService.updatePddOrder(pddOrder));
    }

    /**
     * 删除拼多多
     */
    @RequiresPermissions("pddorder:order:remove")
    @Log(title = "拼多多", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pddOrderService.deletePddOrderByIds(ids));
    }
}
