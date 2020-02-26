package com.yay.domain;

public class Movie {
	private Integer id;
	private String name;
	private String actor;
	private Double price;
	private String uptime;
	private Integer longtime;
	private String type;
	private Integer years;
	private String area;
	private Integer status;
	private String pig;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public Integer getLongtime() {
		return longtime;
	}
	public void setLongtime(Integer longtime) {
		this.longtime = longtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPig() {
		return pig;
	}
	public void setPig(String pig) {
		this.pig = pig;
	}
	public Movie(Integer id, String name, String actor, Double price, String uptime, Integer longtime, String type,
			Integer years, String area, Integer status, String pig) {
		super();
		this.id = id;
		this.name = name;
		this.actor = actor;
		this.price = price;
		this.uptime = uptime;
		this.longtime = longtime;
		this.type = type;
		this.years = years;
		this.area = area;
		this.status = status;
		this.pig = pig;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", actor=" + actor + ", price=" + price + ", uptime=" + uptime
				+ ", longtime=" + longtime + ", type=" + type + ", years=" + years + ", area=" + area + ", status="
				+ status + ", pig=" + pig + "]";
	}
	
	
}
