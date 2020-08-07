package com.sivasankr.dbservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "URL_REPO")
@Data
@NoArgsConstructor
public class URLModel {
    @Id
    @Column(name = "original_url")
    private String originalURL;

    @Column(name = "short_url")
    private String shortURL;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;
}
