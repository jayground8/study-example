package com.example.exampleappevent.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="cat_event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String payload;
    private boolean published;
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;

    @CreationTimestamp
    private Date createdAt;

    public Event() {
    }

    public Event(String type, String payload) {
        this.type = type;
        this.payload = payload;
        this.published = false;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    public boolean isPublished() {
        return published;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
