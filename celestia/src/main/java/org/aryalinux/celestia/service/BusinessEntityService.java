package org.aryalinux.celestia.service;

import java.util.List;

import org.aryalinux.celestia.commons.dto.BusinessEntityDTO;
import org.aryalinux.celestia.commons.response.BaseResponse;

public interface BusinessEntityService {
	public BaseResponse createEntity(BusinessEntityDTO entityDTO);

	public List<BusinessEntityDTO> getAllEntities();

}
