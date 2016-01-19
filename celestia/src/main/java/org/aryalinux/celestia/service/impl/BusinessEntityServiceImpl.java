package org.aryalinux.celestia.service.impl;

import java.util.Date;
import java.util.List;

import org.aryalinux.celestia.commons.dto.BusinessEntityDTO;
import org.aryalinux.celestia.commons.response.BaseResponse;
import org.aryalinux.celestia.dao.BusinessEntityDAO;
import org.aryalinux.celestia.model.BusinessEntity;
import org.aryalinux.celestia.service.BusinessEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessEntityServiceImpl implements BusinessEntityService {
	@Autowired
	private BusinessEntityDAO entityDAO;

	public BaseResponse createEntity(BusinessEntityDTO entityDTO) {
		BaseResponse baseResponse = new BaseResponse();
		BusinessEntity ref = new BusinessEntity();
		ref.setCreatedDate(new Date());
		ref.setCreatedBy("chandrakant");
		ref.setDescription(entityDTO.getDescription());
		ref.setName(entityDTO.getName());
		Integer id = entityDAO.save(ref);
		baseResponse.setData(id);
		baseResponse.setCode(1);
		baseResponse.setMessage("Entity Created Successfully");
		return baseResponse;
	}

	public List<BusinessEntityDTO> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

}
