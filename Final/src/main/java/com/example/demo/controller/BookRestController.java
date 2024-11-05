package com.example.demo.controller;

import com.example.demo.dto.req.BookReqDTO;
import com.example.demo.dto.res.BookResDTO;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    @Autowired
    private BookService bookService;

//    REST API URL
//    등록 (4 점)
//    POST
//    http://localhost:8080/api/books
    @PostMapping()
    public ResponseEntity<?> getBooks(@RequestBody BookReqDTO reqDto) {
        return ResponseEntity.ok(bookService.saveBook(reqDto));
    }

//    전체 목록 조회 (3 점)
//    GET
//    http://localhost:8080/api/books
    @GetMapping()
    public ResponseEntity<?> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

//    Id 로 조회 (3 점)
//    GET
//    http://localhost:8080/api/books/{id}
    @GetMapping("/{id}")
    public BookResDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

//    Pages 로 조회 (9 점)
//    GET
//    http://localhost:8080/api/books/pages/{pages}
    @GetMapping("/pages/{pages}")
    public ResponseEntity<?> getBookByPages(@PathVariable Integer pages) {
        return ResponseEntity.ok(bookService.getBookByPages(pages));
    }

//    Title 로 조회 ( 끝에 / 가 있음 ) (9 점)
//    GET
//    http://localhost:8080/api/books/title/{title}/
    @GetMapping("/title/{title}/")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

//    수정 PUT (4 점)
//    http://localhost:8080/api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,
                                            @RequestBody BookReqDTO reqDto) {
        return ResponseEntity.ok(bookService.updateBook(id, reqDto));
    }

//    삭제 DELETE (3 점)
//    http://localhost:8080/api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return ResponseEntity.ok("Book ID :: " + id + " 삭제처리 되었습니다.");
    }

}
