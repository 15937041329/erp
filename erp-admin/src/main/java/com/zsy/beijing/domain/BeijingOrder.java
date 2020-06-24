package com.zsy.beijing.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 北京订单对象 beijing_order
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
public class BeijingOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderid;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phonenum;

    /** 号码等级 */
    @Excel(name = "号码等级")
    private String numlevel;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String custname;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idcardnumber;

    /** 身份证证件地址 */
    @Excel(name = "身份证证件地址")
    private String idcardaddress;

    /** 邮编 */
    @Excel(name = "邮编")
    private String custpostalcode;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String linkphone;

    /** 收货人电话 */
    @Excel(name = "收货人电话")
    private String addresseephone;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String addresseeaddr;

    /** 基本策划编码 */
    @Excel(name = "基本策划编码")
    private String numpackageid;

    /** 基本策划名称 */
    @Excel(name = "基本策划名称")
    private String numpackagename;

    /** 操作工号 */
    @Excel(name = "操作工号")
    private String operatorid;

    /** 吉祥号营销案编码 */
    @Excel(name = "吉祥号营销案编码")
    private String offerid;

    /** 吉祥号营销案名称 */
    @Excel(name = "吉祥号营销案名称")
    private String offername;

    /** 促销案编码 */
    @Excel(name = "促销案编码")
    private String extrapackageid;

    /** 促销案名称 */
    @Excel(name = "促销案名称")
    private String extrapackagename;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materielcode;

    /** 店员积分编码 */
    @Excel(name = "店员积分编码")
    private String spreaderid;

    /** 店员积分类型 */
    @Excel(name = "店员积分类型")
    private String spreadertype;

    /** 退单时间 */
    @Excel(name = "退单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date returnTime;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long orderstate;

    /** 分销标识 */
    @Excel(name = "分销标识")
    private String vdef1;

    /** null */
    @Excel(name = "null")
    private String vdef2;

    /** null */
    @Excel(name = "null")
    private String vdef3;

    /** null */
    private String vdef4;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderid(String orderid) 
    {
        this.orderid = orderid;
    }

    public String getOrderid() 
    {
        return orderid;
    }
    public void setPhonenum(String phonenum) 
    {
        this.phonenum = phonenum;
    }

    public String getPhonenum() 
    {
        return phonenum;
    }
    public void setNumlevel(String numlevel) 
    {
        this.numlevel = numlevel;
    }

    public String getNumlevel() 
    {
        return numlevel;
    }
    public void setCustname(String custname) 
    {
        this.custname = custname;
    }

    public String getCustname() 
    {
        return custname;
    }
    public void setIdcardnumber(String idcardnumber) 
    {
        this.idcardnumber = idcardnumber;
    }

    public String getIdcardnumber() 
    {
        return idcardnumber;
    }
    public void setIdcardaddress(String idcardaddress) 
    {
        this.idcardaddress = idcardaddress;
    }

    public String getIdcardaddress() 
    {
        return idcardaddress;
    }
    public void setCustpostalcode(String custpostalcode) 
    {
        this.custpostalcode = custpostalcode;
    }

    public String getCustpostalcode() 
    {
        return custpostalcode;
    }
    public void setLinkphone(String linkphone) 
    {
        this.linkphone = linkphone;
    }

    public String getLinkphone() 
    {
        return linkphone;
    }
    public void setAddresseephone(String addresseephone) 
    {
        this.addresseephone = addresseephone;
    }

    public String getAddresseephone() 
    {
        return addresseephone;
    }
    public void setAddresseeaddr(String addresseeaddr) 
    {
        this.addresseeaddr = addresseeaddr;
    }

    public String getAddresseeaddr() 
    {
        return addresseeaddr;
    }
    public void setNumpackageid(String numpackageid) 
    {
        this.numpackageid = numpackageid;
    }

    public String getNumpackageid() 
    {
        return numpackageid;
    }
    public void setNumpackagename(String numpackagename) 
    {
        this.numpackagename = numpackagename;
    }

    public String getNumpackagename() 
    {
        return numpackagename;
    }
    public void setOperatorid(String operatorid) 
    {
        this.operatorid = operatorid;
    }

    public String getOperatorid() 
    {
        return operatorid;
    }
    public void setOfferid(String offerid) 
    {
        this.offerid = offerid;
    }

    public String getOfferid() 
    {
        return offerid;
    }
    public void setOffername(String offername) 
    {
        this.offername = offername;
    }

    public String getOffername() 
    {
        return offername;
    }
    public void setExtrapackageid(String extrapackageid) 
    {
        this.extrapackageid = extrapackageid;
    }

    public String getExtrapackageid() 
    {
        return extrapackageid;
    }
    public void setExtrapackagename(String extrapackagename) 
    {
        this.extrapackagename = extrapackagename;
    }

    public String getExtrapackagename() 
    {
        return extrapackagename;
    }
    public void setMaterielcode(String materielcode) 
    {
        this.materielcode = materielcode;
    }

    public String getMaterielcode() 
    {
        return materielcode;
    }
    public void setSpreaderid(String spreaderid) 
    {
        this.spreaderid = spreaderid;
    }

    public String getSpreaderid() 
    {
        return spreaderid;
    }
    public void setSpreadertype(String spreadertype) 
    {
        this.spreadertype = spreadertype;
    }

    public String getSpreadertype() 
    {
        return spreadertype;
    }
    public void setReturnTime(Date returnTime) 
    {
        this.returnTime = returnTime;
    }

    public Date getReturnTime() 
    {
        return returnTime;
    }
    public void setOrderstate(Long orderstate) 
    {
        this.orderstate = orderstate;
    }

    public Long getOrderstate() 
    {
        return orderstate;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderid", getOrderid())
            .append("phonenum", getPhonenum())
            .append("numlevel", getNumlevel())
            .append("custname", getCustname())
            .append("idcardnumber", getIdcardnumber())
            .append("idcardaddress", getIdcardaddress())
            .append("custpostalcode", getCustpostalcode())
            .append("linkphone", getLinkphone())
            .append("addresseephone", getAddresseephone())
            .append("addresseeaddr", getAddresseeaddr())
            .append("numpackageid", getNumpackageid())
            .append("numpackagename", getNumpackagename())
            .append("operatorid", getOperatorid())
            .append("offerid", getOfferid())
            .append("offername", getOffername())
            .append("extrapackageid", getExtrapackageid())
            .append("extrapackagename", getExtrapackagename())
            .append("materielcode", getMaterielcode())
            .append("spreaderid", getSpreaderid())
            .append("spreadertype", getSpreadertype())
            .append("createTime", getCreateTime())
            .append("returnTime", getReturnTime())
            .append("orderstate", getOrderstate())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .append("vdef4", getVdef4())
            .toString();
    }
}
