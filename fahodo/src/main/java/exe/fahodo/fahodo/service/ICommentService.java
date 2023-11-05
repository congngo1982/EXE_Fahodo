package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> GetAllComment();
    public List<Comment> GetCommentByBook(int id);
    public String PostComment(Comment comment);
}
