package org.aryalinux.restapptemplate.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.aryalinux.restapptemplate.common.request.RestRequest;
import org.aryalinux.restapptemplate.common.response.BaseResponse;
import org.aryalinux.restapptemplate.dao.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GenericServiceImpl<E, F extends Serializable> {
	@Autowired
	private GenericDAO<E, Serializable> dao;

	public BaseResponse newEntity(RestRequest<E> request) {
		BaseResponse response = null;
		try {
			response = new BaseResponse(1, "Success.");
			response.setData(dao.create(request.getData()));
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse fetchAll() {
		BaseResponse response = null;
		try {
			List<E> data = dao.getAll();
			if (data == null || data.isEmpty()) {
				response = new BaseResponse(1, "No records found.");
				return response;
			} else {
				response = new BaseResponse(1, data.size() + " records found.");
				response.setData(data);
			}
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse fetchByParams(Map<String, Object> params) {
		BaseResponse response = null;
		try {
			List<E> data = dao.getByParams(params);
			if (data == null || data.isEmpty()) {
				response = new BaseResponse(1, "No records found.");
				return response;
			} else {
				response = new BaseResponse(1, data.size() + " records found.");
				response.setData(data);
			}
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse findById(F id) {
		BaseResponse response = null;
		try {
			E data = dao.getById(id);
			if (data == null) {
				response = new BaseResponse(1, "No records found.");
			} else {
				response = new BaseResponse(1, "1 record found.");
				response.setData(data);
			}
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse delete(F id) {
		BaseResponse response = null;
		try {
			E data = dao.getById(id);
			if (data == null) {
				response = new BaseResponse(1, "Record not found.");
			} else {
				dao.delete(data);
				response = new BaseResponse(1, "Success.");
			}
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse update(RestRequest<E> ref) {
		BaseResponse response = null;
		try {
			dao.update(ref.getData());
			response = new BaseResponse(1, "Success.");
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}
}
