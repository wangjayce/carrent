package com.sxt.bus.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Outport {
    private Integer id;

    private String paytype;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date outporttime;

    private String operateperson;

    private Integer number;

    private String remark;

    private Double outportprice;

    private Integer providerid;

    private Integer goodsid;
    
    
    private String goodsname;
    
    private String providername;
    
    

    public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getProvidername() {
		return providername;
	}

	public void setProvidername(String providername) {
		this.providername = providername;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Date getOutporttime() {
        return outporttime;
    }

    public void setOutporttime(Date outporttime) {
        this.outporttime = outporttime;
    }

    public String getOperateperson() {
        return operateperson;
    }

    public void setOperateperson(String operateperson) {
        this.operateperson = operateperson == null ? null : operateperson.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getOutportprice() {
        return outportprice;
    }

    public void setOutportprice(Double outportprice) {
        this.outportprice = outportprice;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }
}