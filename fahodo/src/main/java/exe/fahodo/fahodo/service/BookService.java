package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> GetAllBook() {
        return bookRepository.findAll();
    }
}
