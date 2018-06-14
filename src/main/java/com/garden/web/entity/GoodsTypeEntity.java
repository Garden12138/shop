package com.garden.web.entity;
/**
 * 商品类型实体类
 * @author Garden
 * 2018年6月12日
 */
public class GoodsTypeEntity {
	
	private String id;      /*商品类型id*/
	private String name;    /*商品类型名称*/
	private String code;    /*商品类型代码*/ 
	private String remark;  /*商品类型标签*/
	private int level;      /*商品类型级别*/
	public GoodsTypeEntity() {
		super();
	}
	public GoodsTypeEntity(String id, String name, String code, String remark, int level) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.remark = remark;
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "GoodsTypeEntity [id=" + id + ", name=" + name + ", code=" + code + ", remark=" + remark + ", level="
				+ level + "]";
	}
}
