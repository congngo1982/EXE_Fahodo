package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    private IBookService bookService;
    @GetMapping("/allbooks")
    public List<Book> GetAllBook(){
        return bookService.GetAllBook();
    }

}
