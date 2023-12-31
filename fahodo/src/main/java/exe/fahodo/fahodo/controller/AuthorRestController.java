package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Author;
import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.service.IAuthorService;
import exe.fahodo.fahodo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private IBookService bookService;
    @GetMapping("/allauthors")
    public List<Author> GetAllAuthor(){
        return authorService.GetAllAuthor();
    }

    @GetMapping("/books/{id}")
    public List<Book> GetAllBook(@PathVariable("id") int id){
        return bookService.GetBookByAuthor(id);
    }
}
