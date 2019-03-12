package com.lumiradx.iclient.core.persistence;

import com.lumiradx.iclient.common.model.IntegrationAdapter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Smitha
 */
@RepositoryRestResource(collectionResourceRel = "adapters", path = "integration-adapters")
public interface IntegrationAdapterRepository
    extends PagingAndSortingRepository<IntegrationAdapter,String>
{

}