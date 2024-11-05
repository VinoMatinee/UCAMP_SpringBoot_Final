package myspring.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import myspring.book.service.BookService;
import myspring.book.vo.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	public BookController() {
		System.out.println(this.getClass().getName() + " :: 컨트롤러 기본 생성자 호출됨!!");
	}
	
	@RequestMapping(path= "/")
	public String index () {
		return "index";
	}
	
	@RequestMapping(path = "/bookList.do")
	public String bookList(Model model) {
		List<BookVO> bookList = bookService.getAllBookList();
		model.addAttribute("bookList", bookList);
		return "bookList";
	}
	
	@RequestMapping(path = "/bookInfo.do")
	public String bookInfo(@RequestParam int id, Model model) {
		BookVO bookInfo = bookService.getBookInfo(id);
		model.addAttribute("bookInfo", bookInfo);
		return "bookInfo";
	}
}
