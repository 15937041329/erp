package com.zsy.shoporder.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 七品馆订单信息表对象 shop_order
 * 
 * @author wbq
 * @date 2020-07-17
 */
public class ShopOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderId;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String county;

    /** 镇 */
    @Excel(name = "镇")
    private String town;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 付款金额 */
    @Excel(name = "付款金额")
    private String payamount;

    /** 是否为退款订单 */
    @Excel(name = "是否为退款订单")
    private Long isrefund;

    /** 客户备注 */
    @Excel(name = "客户备注")
    private String remarks;

    /** vdef1 */
    @Excel(name = "vdef1")
    private String vdef1;

    /** vdef2 */
    @Excel(name = "vdef2")
    private String vdef2;

    /** vdef3 */
    @Excel(name = "vdef3")
    private String vdef3;

    /** vdef4 */
    @Excel(name = "vdef4")
    private String vdef4;

    /** vdef5 */
    @Excel(name = "vdef5")
    private String vdef5;

    /** vdef6 */
    @Excel(name = "vdef6")
    private String vdef6;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
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
    public void setPayamount(String payamount) 
    {
        this.payamount = payamount;
    }

    public String getPayamount() 
    {
        return payamount;
    }
    public void setIsrefund(Long isrefund) 
    {
        this.isrefund = isrefund;
    }

    public Long getIsrefund() 
    {
        return isrefund;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
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
    public void setVdef4(String vdef4) 
    {
        this.vdef4 = vdef4;
    }

    public String getVdef4() 
    {
        return vdef4;
    }
    public void setVdef5(String vdef5) 
    {
        this.vdef5 = vdef5;
    }

    public String getVdef5() 
    {
        return vdef5;
    }
    public void setVdef6(String vdef6) 
    {
        this.vdef6 = vdef6;
    }

    public String getVdef6() 
    {
        return vdef6;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("phone", getPhone())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("town", getTown())
            .append("address", getAddress())
            .append("payamount", getPayamount())
            .append("createTime", getCreateTime())
            .append("isrefund", getIsrefund())
            .append("remarks", getRemarks())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .append("vdef4", getVdef4())
            .append("vdef5", getVdef5())
            .append("vdef6", getVdef6())
            .toString();
    }
}
