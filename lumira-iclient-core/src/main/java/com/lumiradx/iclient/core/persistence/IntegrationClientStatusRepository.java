package com.lumiradx.iclient.core.persistence;

import com.lumiradx.iclient.common.model.IntegrationClientStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Smitha
 */
@RepositoryRestResource(collectionResourceRel = "ic-status", path = "integration-client-status")
public interface IntegrationClientStatusRepository
    extends PagingAndSortingRepository<IntegrationClientStatus,String>
{

}
