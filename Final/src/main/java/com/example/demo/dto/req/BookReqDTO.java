package com.example.demo.dto.req;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReqDTO {
    @NotBlank(message="author는 필수 입력 항목 입니다.")
    private String author;

    @NotBlank(message="genre는 필수 입력 항목 입니다.")
    private String genre;

    @NotBlank(message="isbn은 필수 입력 항목 입니다.")
    private String isbn;

    @NotNull(message="쪽수를 입력해 주세요.")
    @Min(value=50, message="쪽수는 최소한 50이상으로 입력하세요.")
    private Integer pages;

    @NotBlank(message="title은 필수 입력 항목 입니다.")
    private String title;
}
