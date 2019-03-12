package com.lumiradx.iclient.common.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Smitha
 */
@Data
@Entity
@Table(name = "INTEGRATION_CLIENT_INVENTORY")
public class IntegrationClientInventory extends IClientEntityBase implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "INTEGRATION_CLIENT_ID", nullable = false)
    @GeneratedValue
    private String primaryId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name = "CUSTOMER_CODE", nullable = false)
    private String customerCode;

    @Column(name = "ORG_ID", nullable = false)
    private String orgId;

    @OneToOne(fetch = FetchType.EAGER) // eager loading
    @JoinColumn(name = "INBOUND_ADAPTER_ID", referencedColumnName = "INTEGRATION_ADAPTER_ID")
    private IntegrationAdapter inboudAdapter;

    @OneToOne(fetch = FetchType.EAGER) // eager loading
    @JoinColumn(name = "OUTBOUND_ADAPTER_ID", referencedColumnName = "INTEGRATION_ADAPTER_ID")
    private IntegrationAdapter outboudAdapter;

    @Column(name = "STATUS", nullable = false)
    private String status;

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
