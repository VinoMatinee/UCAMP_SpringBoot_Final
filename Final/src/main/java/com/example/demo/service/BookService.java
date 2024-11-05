package com.example.demo.service;

import com.example.demo.dto.req.BookReqDTO;
import com.example.demo.dto.req.BookReqFormDTO;
import com.example.demo.dto.res.BookResDTO;
import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.repasitory.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    // 생성 (Create)
    @Transactional
    public BookResDTO saveBook(BookReqDTO bookReqDto) {
        // reqDto -> Entity
        BookEntity book = modelMapper.map(bookReqDto, BookEntity.class);
        BookEntity savedBook = bookRepository.save(book);
        return modelMapper.map(savedBook, BookResDTO.class);
    }

    // 전체 목록 조회
    public List<BookResDTO> getBooks() {
        List<BookEntity> bookList = bookRepository.findAll();
        return bookList.stream()
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .toList();
    }

    // Id 로 조회
    public BookResDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
    }

    // Pages 로 조회
    public List<BookResDTO> getBookByPages(Integer pages) {
        List<BookEntity> bookList = bookRepository.findByPagesGreaterThan(pages);
        return bookList.stream()
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .toList();

    }

    // Title 로 조회
    public List<BookResDTO> getBookByTitle(String title) {
        List<BookEntity> bookList = bookRepository.findByTitleContaining(title);
        return bookList.stream()
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .toList();
    }

    // 수정 PUT
    @Transactional
    public BookResDTO updateBook(Long id, BookReqDTO bookReqDto ) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException( id + "Book Not Found", HttpStatus.NOT_FOUND));
        bookEntity.setAuthor(bookReqDto.getAuthor());
        bookEntity.setGenre(bookReqDto.getGenre());
        bookEntity.setIsbn(bookReqDto.getIsbn());
        bookEntity.setPages(bookReqDto.getPages());
        bookEntity.setTitle(bookReqDto.getTitle());
        return modelMapper.map(bookEntity, BookResDTO.class);
    }


    // 삭제 DELETE
    @Transactional
    public void removeBook(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id).orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
        bookRepository.delete(bookEntity);
    }

    // 4번 BookReqFromDTO 수정
    @Transactional
    public void updateBookForm(BookReqFormDTO reqFormDTO) {
        BookEntity bookEntity  = bookRepository
                .findById(reqFormDTO.getId())
                .orElseThrow(()-> new BusinessException(reqFormDTO.getId() +" Customer Not Found", HttpStatus.NOT_FOUND));
        bookEntity.setAuthor(reqFormDTO.getAuthor());
        bookEntity.setGenre(reqFormDTO.getGenre());
        bookEntity.setIsbn(reqFormDTO.getIsbn());
        bookEntity.setPages(reqFormDTO.getPages());
        bookEntity.setTitle(reqFormDTO.getTitle());
    }
}
