package cn.com.kind.dzxxmoa.bean;

import java.io.Serializable;

public class Radio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	private String jsHide;
	private String checkOpinion;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getJsHide() {
		return jsHide;
	}
	public void setJsHide(String jsHide) {
		this.jsHide = jsHide;
	}
	public String getCheckOpinion() {
		return checkOpinion;
	}
	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}
	public Radio(String key, String value, String jsHide, String checkOpinion) {
		super();
		this.key = key;
		this.value = value;
		this.jsHide = jsHide;
		this.checkOpinion = checkOpinion;
	}
	public Radio() {
		super();
	}
	@Override
	public String toString() {
		return "Radio [key=" + key + ", value=" + value + ", jsHide=" + jsHide
				+ ", checkOpinion=" + checkOpinion + "]";
	}
	
}
