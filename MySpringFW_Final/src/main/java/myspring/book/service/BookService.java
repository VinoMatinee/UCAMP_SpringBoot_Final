package myspring.book.service;

import java.util.List;

import myspring.book.vo.BookVO;

public interface  BookService {
	// 전체 목록 조회
	List<BookVO> getAllBookList();
	// ID 조회
	BookVO getBookInfo(int id);
}
