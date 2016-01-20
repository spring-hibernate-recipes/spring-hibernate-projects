package org.aryalinux.restapptemplate.controller;

import java.io.Serializable;
import java.util.Map;

import org.aryalinux.restapptemplate.common.request.RestRequest;
import org.aryalinux.restapptemplate.common.response.BaseResponse;
import org.aryalinux.restapptemplate.service.ServiceDiscovery;
import org.aryalinux.restapptemplate.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chandrakant.Singh
 *
 * @param <E>
 *            E is the DTO type for creating new elements. This class must
 *            extend RestRequest.
 * @param <F>
 *            F is the DTO type for updating existing elements. This class must
 *            extend RestRequest.
 * 
 *            GenericController does most of the heavy-lifting done by
 *            controllers. Since it is generic there are only few methods
 *            defined in the class. To make it more functional, more methods
 *            need to be added to individual controllers that can extend this
 *            class. Methods can also be overridden as deemed fit.
 */
@Controller
@RequestMapping("/services")
public class GenericController<E, X extends RestRequest<E>, Y extends RestRequest<E>> {
	@Autowired
	private ServiceDiscovery serviceDiscovery;

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public BaseResponse getById(@PathVariable("name") String name, @RequestParam("id") Serializable id) {
		return getServiceByName(name).findById(id);
	}

	@ResponseBody
	@RequestMapping(path = "/{name}/all", method = RequestMethod.GET)
	public BaseResponse getAll(@PathVariable("name") String name) {
		return getServiceByName(name).fetchAll();
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(path = "/{name}/search", method = RequestMethod.POST)
	public BaseResponse getByParams(@PathVariable("name") String name, @RequestBody X ref) {
		Map<String, Object> params = (Map<String, Object>) ref.getData();
		return getServiceByName(name).fetchByParams(params);
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.POST)
	public BaseResponse create(@PathVariable("name") String name, @RequestBody X ref) {
		return getServiceByName(name).newEntity(ref);
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.PUT)
	public BaseResponse update(@PathVariable("name") String name, @RequestBody X ref) {
		return getServiceByName(name).update(ref);
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(path = "/{name}", method = RequestMethod.POST)
	public BaseResponse delete(@PathVariable("name") String name, @RequestParam("id") Serializable id) {
		return getServiceByName(name).delete(id);
	}

	public GenericServiceImpl getServiceByName(String name) {
		return serviceDiscovery.getServiceByName(name);
	}
}
