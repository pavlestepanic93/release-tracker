package com.releasetracker.Releasetracker.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotBlank(message = "Please Add Release Name")
    private String Name;
    @NotBlank(message = "Please Add Release Description")
    private String Description;
    @NotBlank(message = "Please Add Release Status")
    private String Status;
    @NotNull(message = "Please Add Release Date")
    private Date releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdateAt;

    public Release() {
    }

    public Release(Long id, String name, String description, String status, Date releaseDate, LocalDateTime createdAt, LocalDateTime lastUpdateAt) {
        Id = id;
        Name = name;
        Description = description;
        Status = status;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
        this.lastUpdateAt = lastUpdateAt;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(LocalDateTime lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    @Override
    public String toString() {
        return "Release{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Status='" + Status + '\'' +
                ", releaseDate=" + releaseDate +
                ", createdAt=" + createdAt +
                ", lastUpdateAt=" + lastUpdateAt +
                '}';
    }

}
