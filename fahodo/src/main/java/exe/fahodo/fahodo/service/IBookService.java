package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.entity.Comment;

import java.util.List;

public interface IBookService {
    public List<Book> GetAllBook();
    public List<Book> GetBookByAuthor(int id);
    public List<Comment> GetAllComment(int id);
}
