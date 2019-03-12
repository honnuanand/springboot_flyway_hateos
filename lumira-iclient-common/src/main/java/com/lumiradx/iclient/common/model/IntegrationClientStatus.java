package com.lumiradx.iclient.common.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Smitha
 */
@Data
@Entity
@Table(name = "INTEGRATION_CLIENT_STATUS")
public class IntegrationClientStatus extends IClientEntityBase implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "INTEGRATION_CLIENT_STATUS_ID", nullable = false)
    @GeneratedValue
    private String primaryId;

    @Column(name = "HEALTH_STATUS", nullable = false)
    private String healthStatus;

    @Column(name = "HEALTH_STATUS_DESCRIPTION", nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER) // eager loading
    @JoinColumn(name = "INTEGRATION_CLIENT_ID", referencedColumnName = "INTEGRATION_CLIENT_ID", nullable = false)
    private IntegrationClientInventory integrationClient;

    /**
     * Get the Primary key for this object.
     *
     * @return Primary key
     */
    @Override
    public String getPrimaryId()
    {
        return null;
    }

    @Override
    public void setPrimaryId(String primaryId)
    {

    }
}
