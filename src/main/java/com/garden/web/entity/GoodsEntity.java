package com.garden.web.entity;

import java.util.Date;

/**
 * 商品实体类
 * @author Garden
 * 2018年6月13日
 */
public class GoodsEntity {
	private String id;              /*商品id*/
	private String title;           /*商品标题*/
	private String description;     /*商品描述*/
	private Double price;           /*商品单价*/
	private Double discount;        /*商品折扣*/
	private String locality;        /*生成地*/
	private Date createDate;        /*生成日期*/
	private String supplier;        /*供应商*/
	private Date putAwayDate;       /*上架日期*/
	private int storage;            /*存货量*/
	private int isRemove;           /*是否下架*/
	private String image;           /*商品图片存放路径*/
	private String goods_type_code; /*商品类型代码*/
	public GoodsEntity() {
		super();
	}
	public GoodsEntity(String id, String title, String description, Double price, Double discount, String locality,
			Date createDate, String supplier, Date putAwayDate, int storage, int isRemove, String image,
			String goods_type_code) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.locality = locality;
		this.createDate = createDate;
		this.supplier = supplier;
		this.putAwayDate = putAwayDate;
		this.storage = storage;
		this.isRemove = isRemove;
		this.image = image;
		this.goods_type_code = goods_type_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Date getPutAwayDate() {
		return putAwayDate;
	}
	public void setPutAwayDate(Date putAwayDate) {
		this.putAwayDate = putAwayDate;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getIsRemove() {
		return isRemove;
	}
	public void setIsRemove(int isRemove) {
		this.isRemove = isRemove;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGoods_type_code() {
		return goods_type_code;
	}
	public void setGoods_type_code(String goods_type_code) {
		this.goods_type_code = goods_type_code;
	}
	@Override
	public String toString() {
		return "GoodsEntity [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", discount=" + discount + ", locality=" + locality + ", createDate=" + createDate + ", supplier="
				+ supplier + ", putAwayDate=" + putAwayDate + ", storage=" + storage + ", isRemove=" + isRemove
				+ ", image=" + image + ", goods_type_code=" + goods_type_code + "]";
	}
}
