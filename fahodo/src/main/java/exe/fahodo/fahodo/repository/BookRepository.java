package exe.fahodo.fahodo.repository;

import exe.fahodo.fahodo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book>findByAuthor_Id(int id);
    public Book findBookById(int id);

    public List<Book>findAllByType(String type);

    public List<Book>findAllByRatingGreaterThanEqual(double rating);

    public List<Book>findAllByRatingGreaterThanEqualAndTypeEquals(double rating, String type);
}
