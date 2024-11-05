package com.example.demo.controller;

import com.example.demo.dto.req.BookReqDTO;
import com.example.demo.dto.req.BookReqFormDTO;
import com.example.demo.dto.res.BookResDTO;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookpage")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    // 목록조회 ( 3 점)
    // /bookpage/index

    @GetMapping("/")
    public String setIndex() {
        return "redirect:/bookpage/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<BookResDTO> bookList = bookService.getBooks();
        model.addAttribute("books",bookList);
        return "list-book";
    }

    // 등록 Form (3 점)
    // /bookpage/addForm

    @GetMapping("/addForm")
    public String showAddForm(Model model, @ModelAttribute("book") BookReqDTO reqDTO) {
        model.addAttribute("book", reqDTO);
        return "add-book";
    }

    // 등록 처리 (6 점) – Validation Message 출력되어야 합니다.
    // /bookpage/add
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("book") BookReqDTO reqDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "add-book";
        }
        // Service 등록 메서드 호출
        bookService.saveBook(reqDTO);
        return "redirect:/bookpage/index";
    }

    // 수정 Form (4 점)
    // /bookpage/editForm/{id}

    @GetMapping("/editForm/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        BookResDTO bookResDTO = bookService.getBookById(id);
        model.addAttribute("book", bookResDTO);
        return "update-book";
    }

    // 수정 처리 (6 점) – Validation Message 출력되어야 합니다.
    // /bookpage/edit/{id}

    @PostMapping("/edit/{id}")
    public String updateBookForm( @Valid @ModelAttribute("book") BookReqFormDTO reqFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "update-book";
        }
        // Service 수정 메서드 호출
        bookService.updateBookForm(reqFormDTO);
        return "redirect:/bookpage/index";
    }

    // 삭제 처리(3 점)
    // /bookpage/delete/{id}

    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable("id") long id) {
        bookService.removeBook(id);
        return "redirect:/bookpage/index";
    }


}
