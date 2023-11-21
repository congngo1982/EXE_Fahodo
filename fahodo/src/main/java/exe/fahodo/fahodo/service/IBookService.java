package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.entity.Comment;

import java.util.List;

public interface IBookService {
    public List<Book> GetAllBook();
    public List<Book> GetBookByAuthor(int authorId);
    public Book GetBookById(int id);
    public List<Book> FilterBook(String type);
    public List<Book> GetRecommendBook(String type);
    public List<Book> GetBookByRating();

    public List<Book> GetTop3(String category);
    public List<Book> GetBookByName(String name);
    public Book CreateBook(Book book);
}
