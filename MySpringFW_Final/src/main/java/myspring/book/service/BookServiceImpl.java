package myspring.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.book.vo.BookVO;
import myspring.book.dao.BookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<BookVO> getAllBookList() {
		return bookDAO.selectAllBook();
	}

	@Override
	public BookVO getBookInfo(int id) {
		return bookDAO.selectBookById(id);
	}
}
