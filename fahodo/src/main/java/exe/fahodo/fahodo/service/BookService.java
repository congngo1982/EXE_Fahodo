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
    public List<Book> GetBookByAuthor(int authorId) {
        return bookRepository.findByAuthor_Id(authorId);
    }


    @Override
    public Book GetBookById(int id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public List<Book> FilterBook(String type) {
        return bookRepository.findAllByType(type);
    }

    @Override
    public List<Book> GetRecommendBook(String type) {
        return bookRepository.findAllByRatingGreaterThanEqualAndTypeEquals(4.5, type);
    }

    @Override
    public List<Book> GetBookByRating() {
        return bookRepository.findAllByRatingGreaterThanEqual(4.5);
    }

    @Override
    public List<Book> GetTop3(String category) {
        return bookRepository.findTop3ByTypeIgnoreCase(category);
    }

    @Override
    public List<Book> GetBookByName(String name) {
        return bookRepository.findBookByTitleContainsIgnoreCase(name);
    }
}
