package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("http://127.0.0.1:5500")
public class BookRestController {
    @Autowired
    private IBookService bookService;
    @GetMapping("/allbooks")
    public List<Book> GetAllBook(){
        return bookService.GetAllBook();
    }

    @GetMapping("getbook/{category}")
    public List<Book> GetByCategory(@PathVariable("category") String category){
        return bookService.GetTop3(category);
    }

}
