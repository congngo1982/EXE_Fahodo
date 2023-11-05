package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.entity.Comment;
import exe.fahodo.fahodo.service.IAccountService;
import exe.fahodo.fahodo.service.IBookService;
import exe.fahodo.fahodo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin("http://127.0.0.1:5500")
public class CommentRestController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IAccountService accountService;

    @GetMapping("/{bookId}")
    public List<Comment> GetCommnetByBook(@PathVariable("bookId") int bookId){
        return commentService.GetCommentByBook(bookId);
    }

    @PostMapping("/postcomment/{bookId}")
    public String PostComment(@RequestBody Comment comment, @PathVariable("bookId") int bookId){
        comment.setAccount(accountService.GetAllAccount().get(3));
        Book book = bookService.GetBookById(bookId);
        comment.setBook(book);
        String status = commentService.PostComment(comment);
        return status;
    }
}
