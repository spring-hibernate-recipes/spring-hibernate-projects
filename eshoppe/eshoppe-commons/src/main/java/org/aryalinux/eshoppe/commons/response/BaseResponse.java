package org.aryalinux.eshoppe.commons.response;

public class BaseResponse {
	private Integer code;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return "Code: " + code + ", Message : " + message;
	}
}
