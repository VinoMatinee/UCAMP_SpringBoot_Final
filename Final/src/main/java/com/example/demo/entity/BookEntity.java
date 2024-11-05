package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(nullable = false)
    private String genre;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private String title;
}
