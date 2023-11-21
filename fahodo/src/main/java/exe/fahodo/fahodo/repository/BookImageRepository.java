package exe.fahodo.fahodo.repository;

import exe.fahodo.fahodo.entity.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookImageRepository extends JpaRepository<BookImage, Integer> {
}
