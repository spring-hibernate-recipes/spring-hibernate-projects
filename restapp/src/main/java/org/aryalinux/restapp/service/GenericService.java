package org.aryalinux.restapp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.aryalinux.restapp.common.request.RestRequest;
import org.aryalinux.restapp.common.response.BaseResponse;
import org.aryalinux.restapp.dao.GenericDAO;

@SuppressWarnings("rawtypes")
public class GenericService {
	private GenericDAO dao;

	public GenericDAO getDao() {
		return dao;
	}

	public void setDao(GenericDAO dao) {
		this.dao = dao;
	}

	public BaseResponse newEntity(RestRequest request) {
		BaseResponse response = null;
		try {
			response = new BaseResponse(1, "Success.");
			response.setData(getDao().create(request.getData()));
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse fetchAll() {
		BaseResponse response = null;
		try {
			List data = getDao().getAll();
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
			List data = getDao().getByParams(params);
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

	public BaseResponse findById(Serializable id) {
		BaseResponse response = null;
		try {
			Object data = getDao().getById(id);
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

	public BaseResponse delete(Serializable id) {
		BaseResponse response = null;
		try {
			Object data = getDao().getById(id);
			if (data == null) {
				response = new BaseResponse(1, "Record not found.");
			} else {
				getDao().delete(data);
				response = new BaseResponse(1, "Success.");
			}
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

	public BaseResponse update(RestRequest ref) {
		BaseResponse response = null;
		try {
			getDao().update(ref.getData());
			response = new BaseResponse(1, "Success.");
		} catch (Exception ex) {
			response = new BaseResponse(0, ex.getMessage());
		}
		return response;
	}

}
