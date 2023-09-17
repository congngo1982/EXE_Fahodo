package exe.fahodo.fahodo.repository;

import exe.fahodo.fahodo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book>findByAuthor_Id(int id);
}
