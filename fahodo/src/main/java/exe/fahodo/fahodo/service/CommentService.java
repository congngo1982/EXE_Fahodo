package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Comment;
import exe.fahodo.fahodo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> GetAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> GetCommentByBook(int id) {
        return commentRepository.GetCommentByBookId(id);
    }
}
