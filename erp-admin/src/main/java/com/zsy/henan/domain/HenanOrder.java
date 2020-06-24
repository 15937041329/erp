package com.zsy.henan.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 河南订单对象 henan_order
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
public class HenanOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 预占号码 */
    @Excel(name = "预占号码")
    private String cardsvcnum;

    /** 预占号码所属地市 */
    @Excel(name = "预占号码所属地市")
    private String cardregion;

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

    /** 镇/村 */
    @Excel(name = "镇/村")
    private String town;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 套餐id */
    @Excel(name = "套餐id")
    private String outprodid;

    /** 集团统一产品编码 */
    @Excel(name = "集团统一产品编码")
    private String ouprodprcid;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private Double payamount;

    /** 取卡方式 */
    @Excel(name = "取卡方式")
    private String havecardtype;

    /** 外部订单id */
    @Excel(name = "外部订单id")
    private String outorderid;

    /** 收货人 */
    @Excel(name = "收货人")
    private String contactsname;

    /** 用户拍摄人图像名称 */
    @Excel(name = "用户拍摄人图像名称")
    private String picnamerpath;

    /** 客户身份证号 */
    @Excel(name = "客户身份证号")
    private String useridnum;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String username;

    /** 调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号 */
    @Excel(name = "调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号调用证件文字识别人像比对认证时的流水号和接口返回的在线流水号")
    private String busiseq;

    /** 状态通知唯一标识 */
    @Excel(name = "状态通知唯一标识")
    private String changeid;

    /** 状态变更 */
    @Excel(name = "状态变更")
    private String channgestate;

    /** 状态变更时间 */
    @Excel(name = "状态变更时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date changetime;

    /** 物流公司 */
    @Excel(name = "物流公司")
    private String wlcompany;

    /** 物流单号 */
    @Excel(name = "物流单号")
    private String wlorderid;

    /** 接口编码 */
    @Excel(name = "接口编码")
    private String busicode;

    /** 请求系统标识 */
    @Excel(name = "请求系统标识")
    private String sourceid;

    /** 业务流水 */
    @Excel(name = "业务流水")
    private String busiserial;

    /** 业务参数格式 */
    @Excel(name = "业务参数格式")
    private String format;

    /** 签名 */
    @Excel(name = "签名")
    private String sign;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cd;

    /** 分销标识 */
    @Excel(name = "分销标识")
    private String vdef2;

    /** 预留字段3 */
    private String vdef3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCardsvcnum(String cardsvcnum) 
    {
        this.cardsvcnum = cardsvcnum;
    }

    public String getCardsvcnum() 
    {
        return cardsvcnum;
    }
    public void setCardregion(String cardregion) 
    {
        this.cardregion = cardregion;
    }

    public String getCardregion() 
    {
        return cardregion;
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
    public void setTown(String town) 
    {
        this.town = town;
    }

    public String getTown() 
    {
        return town;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setOutprodid(String outprodid) 
    {
        this.outprodid = outprodid;
    }

    public String getOutprodid() 
    {
        return outprodid;
    }
    public void setOuprodprcid(String ouprodprcid) 
    {
        this.ouprodprcid = ouprodprcid;
    }

    public String getOuprodprcid() 
    {
        return ouprodprcid;
    }
    public void setPayamount(Double payamount) 
    {
        this.payamount = payamount;
    }

    public Double getPayamount() 
    {
        return payamount;
    }
    public void setHavecardtype(String havecardtype) 
    {
        this.havecardtype = havecardtype;
    }

    public String getHavecardtype() 
    {
        return havecardtype;
    }
    public void setOutorderid(String outorderid) 
    {
        this.outorderid = outorderid;
    }

    public String getOutorderid() 
    {
        return outorderid;
    }
    public void setContactsname(String contactsname) 
    {
        this.contactsname = contactsname;
    }

    public String getContactsname() 
    {
        return contactsname;
    }
    public void setPicnamerpath(String picnamerpath) 
    {
        this.picnamerpath = picnamerpath;
    }

    public String getPicnamerpath() 
    {
        return picnamerpath;
    }
    public void setUseridnum(String useridnum) 
    {
        this.useridnum = useridnum;
    }

    public String getUseridnum() 
    {
        return useridnum;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setBusiseq(String busiseq) 
    {
        this.busiseq = busiseq;
    }

    public String getBusiseq() 
    {
        return busiseq;
    }
    public void setChangeid(String changeid) 
    {
        this.changeid = changeid;
    }

    public String getChangeid() 
    {
        return changeid;
    }
    public void setChanngestate(String channgestate) 
    {
        this.channgestate = channgestate;
    }

    public String getChanngestate() 
    {
        return channgestate;
    }
    public void setChangetime(Date changetime) 
    {
        this.changetime = changetime;
    }

    public Date getChangetime() 
    {
        return changetime;
    }
    public void setWlcompany(String wlcompany) 
    {
        this.wlcompany = wlcompany;
    }

    public String getWlcompany() 
    {
        return wlcompany;
    }
    public void setWlorderid(String wlorderid) 
    {
        this.wlorderid = wlorderid;
    }

    public String getWlorderid() 
    {
        return wlorderid;
    }
    public void setBusicode(String busicode) 
    {
        this.busicode = busicode;
    }

    public String getBusicode() 
    {
        return busicode;
    }
    public void setSourceid(String sourceid) 
    {
        this.sourceid = sourceid;
    }

    public String getSourceid() 
    {
        return sourceid;
    }
    public void setBusiserial(String busiserial) 
    {
        this.busiserial = busiserial;
    }

    public String getBusiserial() 
    {
        return busiserial;
    }
    public void setFormat(String format) 
    {
        this.format = format;
    }

    public String getFormat() 
    {
        return format;
    }
    public void setSign(String sign) 
    {
        this.sign = sign;
    }

    public String getSign() 
    {
        return sign;
    }
    public void setCd(Date cd) 
    {
        this.cd = cd;
    }

    public Date getCd() 
    {
        return cd;
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
            .append("cardsvcnum", getCardsvcnum())
            .append("cardregion", getCardregion())
            .append("usertel", getUsertel())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("town", getTown())
            .append("address", getAddress())
            .append("outprodid", getOutprodid())
            .append("ouprodprcid", getOuprodprcid())
            .append("payamount", getPayamount())
            .append("havecardtype", getHavecardtype())
            .append("outorderid", getOutorderid())
            .append("contactsname", getContactsname())
            .append("picnamerpath", getPicnamerpath())
            .append("useridnum", getUseridnum())
            .append("username", getUsername())
            .append("busiseq", getBusiseq())
            .append("changeid", getChangeid())
            .append("channgestate", getChanngestate())
            .append("changetime", getChangetime())
            .append("wlcompany", getWlcompany())
            .append("wlorderid", getWlorderid())
            .append("busicode", getBusicode())
            .append("sourceid", getSourceid())
            .append("busiserial", getBusiserial())
            .append("format", getFormat())
            .append("sign", getSign())
            .append("cd", getCd())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .toString();
    }
}
