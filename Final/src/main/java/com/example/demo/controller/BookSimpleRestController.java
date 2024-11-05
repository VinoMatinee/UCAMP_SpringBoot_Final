package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.repasitory.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookSimpleRestController {

    @Autowired
    private BookRepository bookRepository;

    //    등록 (4 점)
    //    POST
    //    http://localhost:8080/books
    @PostMapping
    public BookEntity create(@RequestBody BookEntity bookEntity){
        return bookRepository.save(bookEntity);
    }

    //    GET
    //    http://localhost:8080/books
    //    전체 목록 조회 (2 점)
    @GetMapping
    public List<BookEntity> getBooks(){
        return bookRepository.findAll();
    }

    //    Id 로 조회 (2 점)
    //    GET
    //    http://localhost:8080/books/{id}
    @GetMapping(value = "/{id}")
    public BookEntity getBookById(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow(()->new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
    }

    //    ISBN 으로 조회 (5점)
    //    GET
    //    http://localhost:8080/books/isbn/{isbn}
    @GetMapping(value = "/isbn/{isbn}")
    public BookEntity getBookById(@PathVariable String isbn){
        return bookRepository.findByIsbn(isbn).orElseThrow(()->new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
    }

    //    수정 (4 점)
    //    PUT
    //    http://localhost:8080/books/{id}
    @PutMapping("/{id}")
    public BookEntity updateCustomer(@PathVariable Long id, @RequestBody BookEntity detail){
        BookEntity existUser = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));

        existUser.setAuthor(detail.getAuthor());
        existUser.setGenre(detail.getGenre());
        existUser.setIsbn(detail.getIsbn());
        existUser.setPages(detail.getPages());
        existUser.setTitle(detail.getTitle());
        return bookRepository.save(existUser);
    }

    //    삭제 (3 점)
    //    DELETE
    //    http://localhost:8080/books/{id}
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
        bookRepository.delete(bookEntity);
        return ResponseEntity.ok("Book ID :: " + id + " Delete success");
    }

}
