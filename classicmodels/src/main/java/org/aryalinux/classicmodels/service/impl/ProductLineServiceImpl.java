package org.aryalinux.classicmodels.service.impl;

import java.util.List;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.NewProductLineRequest;
import org.aryalinux.classicmodels.dao.ProductLineDAO;
import org.aryalinux.classicmodels.model.ProductLine;
import org.aryalinux.classicmodels.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductLineServiceImpl implements ProductLineService {
	@Autowired
	private ProductLineDAO productLineDAO;

	public BaseResponse newProductLine(NewProductLineRequest productLineRequest) {
		BaseResponse baseResponse = null;
		try {
			ProductLine productLine = new ProductLine();
			productLine.setProductLine(productLineRequest.getProductLine());
			productLine.setHtmlDescription(productLineRequest.getHtmlDescription());
			productLine.setImage(productLineRequest.getImage());
			productLine.setTextDescription(productLineRequest.getTextDescription());
			String id = productLineDAO.save(productLine);
			baseResponse = new BaseResponse(1, "Product Line Created Successfully.");
			baseResponse.setData(id);
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, ex.getMessage());
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

	public BaseResponse getAllProductLines() {
		BaseResponse baseResponse = null;
		try {
			List<ProductLine> productLines = productLineDAO.getAll();
			baseResponse = new BaseResponse(1, "Product Lines found.");
			baseResponse.setData(productLines);
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, ex.getMessage());
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

	public BaseResponse deleteProductLine(String name) {
		BaseResponse baseResponse = null;
		try {
			ProductLine line = productLineDAO.getById(name);
			productLineDAO.delete(line);
			baseResponse = new BaseResponse(1, "Product Line deleted successfully.");
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, ex.getMessage());
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

	public BaseResponse updateProductLine(NewProductLineRequest productLineRequest) {
		BaseResponse baseResponse = null;
		try {
			ProductLine productLine = new ProductLine();
			productLine.setProductLine(productLineRequest.getProductLine());
			productLine.setHtmlDescription(productLineRequest.getHtmlDescription());
			productLine.setImage(productLineRequest.getImage());
			productLine.setTextDescription(productLineRequest.getTextDescription());
			productLineDAO.update(productLine);
			baseResponse = new BaseResponse(1, "Product Line updated successfully.");
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, ex.getMessage());
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

	public BaseResponse getProductLineByName(String productLine) {
		BaseResponse baseResponse = null;
		try {
			ProductLine productLine2 = productLineDAO.getById(productLine);
			baseResponse = new BaseResponse(1, "Product Line Found.");
			baseResponse.setData(productLine2);
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, ex.getMessage());
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

}
