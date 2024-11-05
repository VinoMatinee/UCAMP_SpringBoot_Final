package myspring.book.dao;

import myspring.book.dao.mapper.BookMapper;
import myspring.book.vo.BookVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	BookMapper bookMapper;
	
	
	@Override
	public List<BookVO> selectAllBook() {
		return bookMapper.selectAllBook();
	}

	@Override
	public BookVO selectBookById(int id) {
		return bookMapper.selectBookById(id);
	}

}
