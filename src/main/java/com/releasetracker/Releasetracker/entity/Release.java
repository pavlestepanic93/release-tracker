package com.releasetracker.Releasetracker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please Add Release Name")
    private String name;
    @NotBlank(message = "Please Add Release Description")
    private String description;
    @NotBlank(message = "Please Add Release Status")
    private String status;
    @NotNull(message = "Please Add Release Date")
    private Date releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdateAt;

}
