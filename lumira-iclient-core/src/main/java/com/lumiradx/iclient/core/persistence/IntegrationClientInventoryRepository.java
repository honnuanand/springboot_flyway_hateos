package com.lumiradx.iclient.core.persistence;

import com.lumiradx.iclient.common.model.IntegrationClientInventory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Smitha
 */
@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface IntegrationClientInventoryRepository
    extends PagingAndSortingRepository<IntegrationClientInventory,String>
{

}
