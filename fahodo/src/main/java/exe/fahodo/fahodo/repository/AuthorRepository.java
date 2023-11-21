package exe.fahodo.fahodo.repository;

import exe.fahodo.fahodo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public Author getAuthorById(int id);
}
