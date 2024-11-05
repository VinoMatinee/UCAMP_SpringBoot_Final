package com.example.demo.runner;

import com.example.demo.entity.BookEntity;
import com.example.demo.repasitory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookInsertRunner implements ApplicationRunner {
    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BookEntity book1 = new BookEntity();
        book1.setTitle("소년이 온다");
        book1.setAuthor("한강");
        book1.setIsbn("8936434128"); //
        book1.setGenre("소설");
        book1.setPages(216);

        BookEntity book2 = new BookEntity();
        book2.setTitle("바람이 분다, 가라");
        book2.setAuthor("한강");
        book2.setIsbn("9788932026");
        book2.setGenre("소설");
        book2.setPages(390);

        BookEntity book3 = new BookEntity();
        book3.setTitle("흔한 남매");
        book3.setAuthor("유난희");
        book3.setIsbn("9791168416");
        book3.setGenre("만화");
        book3.setPages(150);

        BookEntity book4 = new BookEntity();
        book4.setTitle("ETS 토익");
        book4.setAuthor("YBM ");
        book4.setIsbn("9788917238");
        book4.setGenre("학습");
        book4.setPages(170);

        BookEntity book5 = new BookEntity();
        book5.setTitle("작별하지 않는다");
        book5.setAuthor("한강");
        book5.setIsbn("9788954682152"); //
        book5.setGenre("소설");
        book5.setPages(332);


        bookRepository.saveAll(List.of(book1, book2, book3, book4, book5));
    }
}