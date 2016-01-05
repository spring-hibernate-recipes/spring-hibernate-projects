package org.aryalinux.ezshoppe.commons.response;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse {
	private int code;
	private String message;
	private Map<String, Object> data;

	public BaseResponse() {
		data = new HashMap<String, Object>();
	}

	public BaseResponse(int code, String message) {
		this();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public BaseResponse addData(String key, Object value) {
		data.put(key, value);
		return this;
	}
}
