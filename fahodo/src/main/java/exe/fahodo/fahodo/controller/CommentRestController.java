package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.entity.Comment;
import exe.fahodo.fahodo.service.IAccountService;
import exe.fahodo.fahodo.service.IBookService;
import exe.fahodo.fahodo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
//@CrossOrigin("http://127.0.0.1:5500")
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
    public ResponseEntity<String> PostComment(Authentication authentication, @RequestBody Comment comment, @PathVariable("bookId") int bookId) throws Exception {
        if (authentication == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }
        comment.setAccount(accountService.GetAccountByUsername(authentication.getName()));
        Book book = bookService.GetBookById(bookId);
        comment.setBook(book);
        String status = commentService.PostComment(comment);
        return ResponseEntity.ok(status);
    }
}
