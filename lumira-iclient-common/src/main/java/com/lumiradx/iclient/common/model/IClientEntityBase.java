package com.lumiradx.iclient.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * The base entity table to keep common methods/mappings for Integration Client Management service entities.
 *
 * @author Smitha.Rao
 */
@MappedSuperclass
public abstract class IClientEntityBase implements Serializable
{

    private static final long serialVersionUID = -4753188992809100024L;

    private static final String SRC_ID = "LumiraIntegrationClientMgmtService";

    private boolean deleted;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private Long version;
    private String createSourceId = SRC_ID;
    private String updateSourceId = SRC_ID;

    /**
     * Signifies whether the entity has been soft-deleted.
     */
    @Column(name = "DELETE_IND", nullable = false)
    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean isDeleted)
    {
        this.deleted = isDeleted;
    }

    /**
     * The ID of the user/principal that created this entity.
     */
    @Column(name = "CREATED_BY", nullable = false)
    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String userId)
    {
        this.createdBy = userId;
    }

    /**
     * The date/time when the entity was created (originally persisted).
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false)
    public Date getCreatedDate()
    {
        return createdDate == null ? null : (Date) createdDate.clone();
    }

    public void setCreatedDate(Date dateTime)
    {
        this.createdDate = dateTime == null ? null : new Date(dateTime.getTime());
    }

    /**
     * The ID of the user/principal that updated the entity last.
     */
    @Column(name = "UPDATED_BY", nullable = false)
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(String userId)
    {
        this.updatedBy = userId;
    }

    /**
     * The date/time when the entity was last updated in storage.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    public Date getUpdatedDate()
    {
        return updatedDate == null ? null : (Date) updatedDate.clone();
    }

    public void setUpdatedDate(Date dateTime)
    {
        this.updatedDate = dateTime == null ? null : new Date(dateTime.getTime());
    }

    /**
     * The entity version as the sequence number of the latest update; signifies the number the entity with this {@link
     * #id} has been persisted/updated in the database.
     */
    @Version
    @Column(name = "UPDT_SEQ_NUM", nullable = false)
    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long versionNum)
    {
        this.version = versionNum;
    }

    /**
     * The ID/name of the source user/application that created the entity.
     */
    @Column(name = "CRTE_SRC_ID", nullable = false)
    public String getCreateSourceId()
    {
        return createSourceId;
    }

    public void setCreateSourceId(String sourceId)
    {
        this.createSourceId = sourceId;
    }

    /**
     * The ID/name of the source user/application that updated the entity last.
     */
    @Column(name = "UPDT_SRC_ID", nullable = false)
    public String getUpdateSourceId()
    {
        return updateSourceId;
    }

    public void setUpdateSourceId(String sourceId)
    {
        this.updateSourceId = sourceId;
    }

    /**
     * Get the Primary key for this object.
     *
     * @return Primary key
     */
    @Transient
    public abstract String getPrimaryId();

    public abstract void setPrimaryId(String primaryId);

    @Transient
    public boolean isNew()
    {
        return (this.getPrimaryId() == null);
    }

    @PrePersist
    @PreUpdate
    protected void createAndUpdateAtCallback()
    {
        if (isNew())
        {
            setPrimaryId(UUID.randomUUID().toString());
            createdDate = new Date();
        }

        updatedDate = new Date();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((createSourceId == null) ? 0 : createSourceId.hashCode());
        result = (prime * result) + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = (prime * result) + ((createdDate == null) ? 0 : createdDate.hashCode());
        result = (prime * result) + (deleted ? 1231 : 1237);
        result = (prime * result) + ((updateSourceId == null) ? 0 : updateSourceId.hashCode());
        result = (prime * result) + ((updatedBy == null) ? 0 : updatedBy.hashCode());
        result = (prime * result) + ((updatedDate == null) ? 0 : updatedDate.hashCode());
        result = (prime * result) + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof IClientEntityBase))
            return false;

        IClientEntityBase that = (IClientEntityBase) o;

        if (isDeleted() != that.isDeleted())
            return false;
        if (!getCreatedBy().equals(that.getCreatedBy()))
            return false;
        if (!getCreatedDate().equals(that.getCreatedDate()))
            return false;
        if (!getUpdatedBy().equals(that.getUpdatedBy()))
            return false;
        if (!getUpdatedDate().equals(that.getUpdatedDate()))
            return false;
        if (!getVersion().equals(that.getVersion()))
            return false;
        if (!getCreateSourceId().equals(that.getCreateSourceId()))
            return false;
        return getUpdateSourceId().equals(that.getUpdateSourceId());

    }
}
