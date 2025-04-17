package com.user.service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class User {

    @Id
    private String user_id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private Character gender;

    @CurrentTimestamp
    private LocalDateTime created_time;

    @UpdateTimestamp
    private LocalDateTime updated_time;
}
