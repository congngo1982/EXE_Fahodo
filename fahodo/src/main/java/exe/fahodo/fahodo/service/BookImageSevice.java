package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.BookImage;
import exe.fahodo.fahodo.repository.BookImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImageSevice implements IBookImageService{
    @Autowired
    private BookImageRepository bookImageRepository;
    @Override
    public BookImage CreateBookImage(BookImage bookImage) {
        return bookImageRepository.save(bookImage);
    }
}
