package com.market.vo;

public class ResponseEntity {
	private int code;
	private boolean success;
	private Object data;
	private String msg;
	
	public ResponseEntity(Object data, boolean flag) {
		this.data = data;
		this.success = flag;
	}
	
	public ResponseEntity(String msg) {
		this.msg = msg;
		this.success = false;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static ResponseEntity ok(Object obj) {
		return new ResponseEntity(obj, true);
	}
	
	public static ResponseEntity fail(String msg) {
		return new ResponseEntity(msg);
	}
}
