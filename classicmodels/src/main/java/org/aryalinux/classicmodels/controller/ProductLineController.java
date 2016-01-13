package org.aryalinux.classicmodels.controller;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.NewProductLineRequest;
import org.aryalinux.classicmodels.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductLineController {
	@Autowired
	private ProductLineService productLineService;

	@ResponseBody
	@RequestMapping(path = "/rest/productline", method = RequestMethod.POST)
	public BaseResponse newProductLine(@RequestBody NewProductLineRequest newProductLineRequest) {
		return productLineService.getAllProductLines();
	}

	@ResponseBody
	@RequestMapping(path = "/rest/productline", method = RequestMethod.GET)
	public BaseResponse getAllProductLines() {
		return productLineService.getAllProductLines();
	}

	@ResponseBody
	@RequestMapping(path = "/rest/productline/{productLine}", method = RequestMethod.GET)
	public BaseResponse getAllProductLineByName(@PathVariable("productLine") String productLine) {
		return productLineService.getProductLineByName(productLine);
	}

	@ResponseBody
	@RequestMapping(path = "/rest/productline", method = RequestMethod.DELETE)
	public BaseResponse deleteProductLine(@RequestParam(name = "name") String productLine) {
		return productLineService.deleteProductLine(productLine);
	}

	@ResponseBody
	@RequestMapping(path = "/rest/productline", method = RequestMethod.PUT)
	public BaseResponse updateProductLine(@RequestBody NewProductLineRequest newProductLineRequest) {
		return productLineService.updateProductLine(newProductLineRequest);
	}
}
