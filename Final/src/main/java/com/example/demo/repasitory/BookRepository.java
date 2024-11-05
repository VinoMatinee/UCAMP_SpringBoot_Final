package com.example.demo.repasitory;



import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByIsbn(String isbn);
    List<BookEntity> findByPagesGreaterThan(Integer pages);
    List<BookEntity> findByTitleContaining(String title);
}
