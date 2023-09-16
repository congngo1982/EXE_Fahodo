package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Author;
import exe.fahodo.fahodo.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
    @Autowired
    private IAuthorService authorService;
    @GetMapping("/allauthors")
    public List<Author> GetAllAuthor(){
        return authorService.GetAllAuthor();
    }
}
