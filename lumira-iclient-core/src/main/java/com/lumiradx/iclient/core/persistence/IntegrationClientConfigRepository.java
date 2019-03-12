package com.lumiradx.iclient.core.persistence;

import com.lumiradx.iclient.common.model.IntegrationClientConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Smitha
 */
@RepositoryRestResource(collectionResourceRel = "configList", path = "integration-client-config")
public interface IntegrationClientConfigRepository  extends PagingAndSortingRepository<IntegrationClientConfig,String>
{

}
