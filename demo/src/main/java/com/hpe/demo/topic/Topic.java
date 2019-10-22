package com.hpe.demo.topic;

public class Topic {
	
	String topic;
	String id;
	String des;
	
	public Topic() {
		
	}	
	public Topic(String topic, String id, String des) {
		super();
		this.topic = topic;
		this.id = id;
		this.des = des;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	
	
}
