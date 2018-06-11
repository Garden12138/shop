package com.garden.web.entity;
/**
 * 测试实体类
 * @author Garden
 * 2018年6月6日
 */
public class TestEntity {
	private int id;
	private String message;
	public TestEntity() {
		super();
	}
	public TestEntity(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
