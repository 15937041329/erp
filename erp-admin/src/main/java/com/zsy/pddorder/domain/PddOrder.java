package com.zsy.pddorder.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 拼多多对象 pdd_order
 * 
 * @author wangbingquan
 * @date 2020-06-12
 */
public class PddOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 拼多多付款订单号 */
    @Excel(name = "拼多多付款订单号")
    private String pddpayorder;

    /** 套餐类型 */
    @Excel(name = "套餐类型")
    private Long taocantype;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String username;

    /** 客户身份证号 */
    @Excel(name = "客户身份证号")
    private String useridnum;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String usertel;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String county;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /** 身份证正面 */
    @Excel(name = "身份证正面")
    private String zmImageUrl;

    /** 身份证反面 */
    @Excel(name = "身份证反面")
    private String fmImageUrl;

    /** 身份证正脸照 */
    @Excel(name = "身份证正脸照")
    private String rlImageUrl;

    /** 预留字段1 */
    @Excel(name = "预留字段1")
    private String vdef1;

    /** 预留字段3 */
    @Excel(name = "预留字段3")
    private String vdef2;

    /** 预留字段3 */
    @Excel(name = "预留字段3")
    private String vdef3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPddpayorder(String pddpayorder) 
    {
        this.pddpayorder = pddpayorder;
    }

    public String getPddpayorder() 
    {
        return pddpayorder;
    }
    public void setTaocantype(Long taocantype) 
    {
        this.taocantype = taocantype;
    }

    public Long getTaocantype() 
    {
        return taocantype;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setUseridnum(String useridnum) 
    {
        this.useridnum = useridnum;
    }

    public String getUseridnum() 
    {
        return useridnum;
    }
    public void setUsertel(String usertel) 
    {
        this.usertel = usertel;
    }

    public String getUsertel() 
    {
        return usertel;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCounty(String county) 
    {
        this.county = county;
    }

    public String getCounty() 
    {
        return county;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }
    public void setZmImageUrl(String zmImageUrl) 
    {
        this.zmImageUrl = zmImageUrl;
    }

    public String getZmImageUrl() 
    {
        return zmImageUrl;
    }
    public void setFmImageUrl(String fmImageUrl) 
    {
        this.fmImageUrl = fmImageUrl;
    }

    public String getFmImageUrl() 
    {
        return fmImageUrl;
    }
    public void setRlImageUrl(String rlImageUrl) 
    {
        this.rlImageUrl = rlImageUrl;
    }

    public String getRlImageUrl() 
    {
        return rlImageUrl;
    }
    public void setVdef1(String vdef1) 
    {
        this.vdef1 = vdef1;
    }

    public String getVdef1() 
    {
        return vdef1;
    }
    public void setVdef2(String vdef2) 
    {
        this.vdef2 = vdef2;
    }

    public String getVdef2() 
    {
        return vdef2;
    }
    public void setVdef3(String vdef3) 
    {
        this.vdef3 = vdef3;
    }

    public String getVdef3() 
    {
        return vdef3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pddpayorder", getPddpayorder())
            .append("taocantype", getTaocantype())
            .append("username", getUsername())
            .append("useridnum", getUseridnum())
            .append("usertel", getUsertel())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("address", getAddress())
            .append("creatTime", getCreatTime())
            .append("zmImageUrl", getZmImageUrl())
            .append("fmImageUrl", getFmImageUrl())
            .append("rlImageUrl", getRlImageUrl())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .toString();
    }
}
