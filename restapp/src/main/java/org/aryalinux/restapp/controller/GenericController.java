package org.aryalinux.restapp.controller;

import java.io.Serializable;
import java.util.Map;

import org.aryalinux.restapp.common.response.BaseResponse;
import org.aryalinux.restapp.service.EntityConverter;
import org.aryalinux.restapp.service.ServiceDiscoverer;
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
	private ServiceDiscoverer serviceDiscoverer;
	@Autowired
	private EntityConverter entityConverter;

	public ServiceDiscoverer getServiceDiscoverer() {
		return serviceDiscoverer;
	}

	public void setServiceDiscoverer(ServiceDiscoverer serviceDiscoverer) {
		this.serviceDiscoverer = serviceDiscoverer;
	}

	public EntityConverter getEntityConverter() {
		return entityConverter;
	}

	public void setEntityConverter(EntityConverter entityConverter) {
		this.entityConverter = entityConverter;
	}

	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public BaseResponse getById(@PathVariable String name, @RequestParam("id") Serializable id) {
		return serviceDiscoverer.getServiceByName(name).findById(id);
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/all", method = RequestMethod.GET)
	public BaseResponse getAll(@PathVariable String name) {
		return serviceDiscoverer.getServiceByName(name).fetchAll();
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/search", method = RequestMethod.POST)
	public BaseResponse getByParams(@PathVariable String name, @RequestBody Map<String, Object> params) {
		return serviceDiscoverer.getServiceByName(name).fetchByParams(params);
	}

	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.POST)
	public BaseResponse create(@PathVariable String name, @RequestBody Map<String, Object> entityMap) {
		String objectId = entityMap.get("__object_id").toString();
		entityMap.remove("__object_id");
		return serviceDiscoverer.getServiceByName(name)
				.newEntity(entityConverter.convert(entityMap, objectId));
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/execute", method = RequestMethod.POST)
	public BaseResponse execute(@PathVariable String name, @RequestBody Map<String, Object> entityMap) {
		return serviceDiscoverer.getServiceByName(name).execute(entityConverter.convert(entityMap));
	}

	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.PUT)
	public BaseResponse update(@PathVariable String name, @RequestBody Map<String, Object> entityMap) {
		return serviceDiscoverer.getServiceByName(name)
				.update(entityConverter.convert(entityMap, entityMap.get("__object_id").toString()));
	}

	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
	public BaseResponse delete(@PathVariable String name, @RequestParam("id") Serializable id) {
		return serviceDiscoverer.getServiceByName(name).delete(id);
	}
}
