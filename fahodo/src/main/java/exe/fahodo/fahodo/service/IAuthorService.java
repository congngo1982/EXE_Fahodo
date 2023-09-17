package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Author;
import exe.fahodo.fahodo.repository.AuthorRepository;

import java.util.List;

public interface IAuthorService {
    public List<Author> GetAllAuthor();
    public Author GetAuthorByName(String name);
}
