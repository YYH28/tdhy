package com.yyh.tdhy.until;

import java.util.ArrayList;
import java.util.List;

public class ResultMsg<Object> {

	private int code = 0;
	private String msg;
	// 总条数
	private Long count;
	// 装前台当前页的数据
	private List<Object> data = new ArrayList<>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

}
