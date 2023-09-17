package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Comment;
import exe.fahodo.fahodo.service.IBookService;
import exe.fahodo.fahodo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IBookService bookService;

    @GetMapping("/{bookId}")
    public List<Comment> GetCommnetByBook(@PathVariable("bookId") int bookId){
        return commentService.GetCommentByBook(bookId);
    }
}
