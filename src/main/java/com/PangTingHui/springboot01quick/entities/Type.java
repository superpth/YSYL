package com.PangTingHui.springboot01quick.entities;

public class Type {

	private Integer id;
	private String Type;

	@Override
	public String toString() {
		return "Type{" +
				"id=" + id +
				", Type='" + Type + '\'' +
				'}';
	}

	public Type() {
	}

	public Type(Integer id, String type) {
		this.id = id;
		Type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
