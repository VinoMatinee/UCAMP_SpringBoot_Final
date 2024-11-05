package com.example.demo.dto.res;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResDTO {
    private Long id;
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm E a",
            timezone = "Asia/Seoul")
    private LocalDateTime created_at = LocalDateTime.now();

    private String genre;
    private String isbn;
    private Integer pages;
    private String title;
}
