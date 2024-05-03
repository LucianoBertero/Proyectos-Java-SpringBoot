package com.todotic.contacttilstapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private LocalDateTime createAt;



}
