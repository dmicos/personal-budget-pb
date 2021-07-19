package com.myfinance.personalbudget.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EqualsAndHashCode
@Getter
public abstract class AbstractEntity implements Serializable {
    @CreationTimestamp
    @Column(name = "created", updatable = false)
    LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "updated", insertable = false)
    LocalDateTime updatedOn;
}
