package org.aryalinux.restapp.controller;

import java.io.Serializable;
import java.util.List;
import java.util.HashMap;

import org.aryalinux.restapp.common.response.BaseResponse;
import org.aryalinux.restapp.model.Reflector;
import org.aryalinux.restapp.service.EntityMapper;
import org.aryalinux.restapp.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/services")
public class GenericController {
	@Autowired
	private GenericService service;
	@Autowired
	private EntityMapper entityMapper;

	public EntityMapper getEntityConverter() {
		return entityMapper;
	}

	public void setEntityConverter(EntityMapper entityMapper) {
		this.entityMapper = entityMapper;
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/structure", method = RequestMethod.GET)
	public List<Reflector.EntityField> structure(@PathVariable String name) {
		return Reflector.getStructure(entityMapper.getClassForName(name));
	}

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public BaseResponse getById(@PathVariable String name, @RequestParam("id") Serializable id) {
		Class pkClass = entityMapper.getPrimaryKeyTypeForName(name);
		if (pkClass == Integer.class) {
			return service.findById(entityMapper.getClassForName(name), new Integer(id.toString()));
		} else if (pkClass == String.class) {
			return service.findById(entityMapper.getClassForName(name), id.toString());
		} else {
			BaseResponse response = new BaseResponse(0, "Could not determine primary key type for class.");
			return response;
		}
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/all", method = RequestMethod.GET)
	public BaseResponse getAll(@PathVariable String name) {
		return service.fetchAll(entityMapper.getClassForName(name));
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/search", method = RequestMethod.POST)
	public BaseResponse getByParams(@PathVariable String name, @RequestBody HashMap<String, Object> params) {
		return service.fetchByParams(entityMapper.getClassForName(name), params);
	}

	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.POST)
	public BaseResponse create(@PathVariable String name, @RequestBody HashMap<String, Object> entityMap) {
		return service.newEntity(entityMapper.convert(entityMap, name));
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/execute", method = RequestMethod.POST)
	public BaseResponse execute(@PathVariable String name, @RequestBody HashMap<String, Object> entityMap) {
		return service.execute(entityMapper.convert(entityMap));
	}

	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.PUT)
	public BaseResponse update(@PathVariable String name, @RequestBody HashMap<String, Object> entityMap) {
		return service.update(entityMapper.convert(entityMap, name));
	}

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
	public BaseResponse delete(@PathVariable String name, @RequestParam("id") Serializable id) {
		Class pkClass = entityMapper.getPrimaryKeyTypeForName(name);
		if (pkClass == Integer.class) {
			return service.delete(entityMapper.getClassForName(name), new Integer(id.toString()));
		} else if (pkClass == String.class) {
			return service.delete(entityMapper.getClassForName(name), id.toString());
		} else {
			BaseResponse response = new BaseResponse(0, "Could not determine primary key type for class.");
			return response;
		}
	}
}
