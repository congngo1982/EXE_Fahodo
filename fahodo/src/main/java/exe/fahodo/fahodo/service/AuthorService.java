package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Author;
import exe.fahodo.fahodo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> GetAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author GetAuthorByName(String name) {
//        return authorRepository.getAuthorByFullName(name);
        return null;
    }
}
