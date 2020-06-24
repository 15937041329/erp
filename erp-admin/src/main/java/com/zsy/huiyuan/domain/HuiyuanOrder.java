package com.zsy.huiyuan.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 未来会员对象 huiyuan_order
 * 
 * @author wangbingquan
 * @date 2020-06-23
 */
public class HuiyuanOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 办理名称 */
    @Excel(name = "办理名称")
    private String name;

    /** QQ号 */
    @Excel(name = "QQ号")
    private String phonenum;

    /** 状态 */
    @Excel(name = "状态")
    private String vdef1;

    /** 手机号 */
    @Excel(name = "手机号")
    private String vdef2;

    /** 记录 */
    @Excel(name = "记录")
    private String vdef3;

    /** 办理时间 */
    @Excel(name = "办理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date banliTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhonenum(String phonenum) 
    {
        this.phonenum = phonenum;
    }

    public String getPhonenum() 
    {
        return phonenum;
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
    public void setBanliTime(Date banliTime) 
    {
        this.banliTime = banliTime;
    }

    public Date getBanliTime() 
    {
        return banliTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phonenum", getPhonenum())
            .append("createTime", getCreateTime())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .append("banliTime", getBanliTime())
            .toString();
    }
}
