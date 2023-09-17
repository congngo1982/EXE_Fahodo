package exe.fahodo.fahodo.repository;

import exe.fahodo.fahodo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select cmt from comment cmt join cmt.book book where book.id = :bookId")
    public List<Comment>GetCommentByBookId(@Param("bookId") int id);
}
