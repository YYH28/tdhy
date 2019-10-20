package com.example.tdhy.po;

import java.io.Serializable;

public class ResultMsg implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5553964331969125438L;

	public Integer code;
	
	public String msg;
	
	public Object obj;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	

}
