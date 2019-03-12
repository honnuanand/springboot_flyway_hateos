package com.lumiradx.iclient.common.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Smitha
 */
@Data
@Entity
@Table(name = "INTEGRATION_ADAPTER")
public class IntegrationAdapter extends IClientEntityBase implements Serializable
{
    private static final long serialVersionUID = 3374097801927236978L;

    @Id
    @Column(name = "INTEGRATION_ADAPTER_ID", nullable = false)
    @GeneratedValue
    private String primaryId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = true)
    private String type;

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
