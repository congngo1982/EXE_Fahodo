package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.entity.Comment;
import exe.fahodo.fahodo.repository.AuthorRepository;
import exe.fahodo.fahodo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private IAuthorService authorService;
    @Autowired
    private ICommentService commentService;

    @Override
    public List<Book> GetAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> GetBookByAuthor(int id) {
        return bookRepository.findByAuthor_Id(id);
    }

    @Override
    public List<Comment> GetAllComment(int id) {
        return commentService.GetCommentByBook(id);
    }
}
