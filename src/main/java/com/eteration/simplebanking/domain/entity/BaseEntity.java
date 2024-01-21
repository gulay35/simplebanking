package com.eteration.simplebanking.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity<T> implements Serializable {
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "created_at"
    )
    private Date createdAt;

    @CreatedBy
    @Column(
            name = "created_by"
    )
    private String createdBy;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "modified_at"
    )
    private Date modifiedAt;
    @LastModifiedBy
    @Column(
            name = "modified_by"
    )
    private String modifiedBy;
    @Version
    @Column(
            name = "version"
    )
    private Integer version;
}
