package myspring.book.dao;

import java.util.List;

import myspring.book.vo.BookVO;

public interface  BookDAO {
	// 전체 목록 조회
	List<BookVO> selectAllBook();
	// ID 조회
	BookVO selectBookById(int id);
}
