package com.zsy.pddstorage.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 数据存储对象 pdd_storage
 * 
 * @author wbq
 * @date 2020-07-15
 */
public class PddStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品 */
    @Excel(name = "商品")
    private String commodityName;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderId;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStates;

    /** 商家实收金额(元) */
    @Excel(name = "商家实收金额(元)")
    private String payMoney;

    /** 拼单成功时间 */
    @Excel(name = "拼单成功时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date successTime;

    /** 商品规格 */
    @Excel(name = "商品规格")
    private String commoditySpec;

    /** 商家备注 */
    @Excel(name = "商家备注")
    private String businessNotes;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 手机 */
    @Excel(name = "手机")
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

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 身份证姓名 */
    @Excel(name = "身份证姓名")
    private String name;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String ip;

    /** 是否直播间订单 */
    @Excel(name = "是否直播间订单")
    private String roomId;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommodityName(String commodityName) 
    {
        this.commodityName = commodityName;
    }

    public String getCommodityName() 
    {
        return commodityName;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setOrderStates(String orderStates) 
    {
        this.orderStates = orderStates;
    }

    public String getOrderStates() 
    {
        return orderStates;
    }
    public void setPayMoney(String payMoney) 
    {
        this.payMoney = payMoney;
    }

    public String getPayMoney() 
    {
        return payMoney;
    }
    public void setSuccessTime(Date successTime) 
    {
        this.successTime = successTime;
    }

    public Date getSuccessTime() 
    {
        return successTime;
    }
    public void setCommoditySpec(String commoditySpec) 
    {
        this.commoditySpec = commoditySpec;
    }

    public String getCommoditySpec() 
    {
        return commoditySpec;
    }
    public void setBusinessNotes(String businessNotes) 
    {
        this.businessNotes = businessNotes;
    }

    public String getBusinessNotes() 
    {
        return businessNotes;
    }
    public void setConsignee(String consignee) 
    {
        this.consignee = consignee;
    }

    public String getConsignee() 
    {
        return consignee;
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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setRoomId(String roomId) 
    {
        this.roomId = roomId;
    }

    public String getRoomId() 
    {
        return roomId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("commodityName", getCommodityName())
            .append("orderId", getOrderId())
            .append("orderStates", getOrderStates())
            .append("payMoney", getPayMoney())
            .append("successTime", getSuccessTime())
            .append("commoditySpec", getCommoditySpec())
            .append("businessNotes", getBusinessNotes())
            .append("consignee", getConsignee())
            .append("phone", getPhone())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("address", getAddress())
            .append("name", getName())
            .append("ip", getIp())
            .append("roomId", getRoomId())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .append("vdef4", getVdef4())
            .append("vdef5", getVdef5())
            .toString();
    }
}
