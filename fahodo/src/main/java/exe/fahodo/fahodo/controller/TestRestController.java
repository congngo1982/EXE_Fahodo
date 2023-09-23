package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/test")
@RestController
public class TestRestController {
    @Autowired
    private IBookService bookService;
    public List<Book> GetAllBook(){
        return bookService.GetAllBook();
    }

    @GetMapping("/getbyauthor/{id}")
    public List<Book> GetBookByAuthor(@PathVariable("id") int authorId){
        return bookService.GetBookByAuthor(authorId);
    }
    @GetMapping("/getall/{id}")
    public Book GetBookById(@PathVariable("id") int id){
        return bookService.GetBookById(id);
    }
    @GetMapping("getbytype/{type}")
    public List<Book> FilterBook(@PathVariable("type") String type){
        return bookService.FilterBook(type);
    }
    @GetMapping("/getrecommend/{type}")
    public List<Book> GetRecommendBook(@PathVariable("type") String type){
        return bookService.GetRecommendBook(type);
    }
    @GetMapping("/getallbyrating")
    public List<Book> GetBookByRating(){
        return bookService.GetBookByRating();
    }
}
