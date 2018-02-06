package com.mr.goods.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

public class Goods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5986147639974522739L;

	/**
	 * 
	 */

	private Integer goodsId;

    private String goodsName;

    private Integer goodsPrice;

    @Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsCount="
				+ goodsCount + ", goodsTime=" + goodsTime + ", typeId=" + typeId + "]";
	}

	private Integer goodsCount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date goodsTime;
	
	public String getGoodsTimeStr(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return goodsTime==null?"":sdf.format(goodsTime);
	}

    private Integer typeId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Date getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(Date goodsTime) {
        this.goodsTime = goodsTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}