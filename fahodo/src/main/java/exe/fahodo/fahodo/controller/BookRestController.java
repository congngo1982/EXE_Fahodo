package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Book;
import exe.fahodo.fahodo.entity.BookImage;
import exe.fahodo.fahodo.service.IAuthorService;
import exe.fahodo.fahodo.service.IBookImageService;
import exe.fahodo.fahodo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("http://127.0.0.1:5500")
public class BookRestController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IAuthorService authorService;
    @Autowired
    IBookImageService bookImageService;

    @GetMapping("/allbooks")
    public List<Book> GetAllBook() {
        return bookService.GetAllBook();
    }

    @GetMapping("getbook/{category}")
    public List<Book> GetByCategory(@PathVariable("category") String category) {
        return bookService.GetTop3(category);
    }

    @GetMapping("getbookbyId/{bookId}")
    public Book GetBookById(@PathVariable("bookId") String bookId) {
        int id = 0;
        try {
            id = Integer.parseInt(bookId);
        } catch (Exception e) {
            return null;
        }
        return bookService.GetBookById(id);
    }

    @GetMapping("getbookbyname")
    public List<Book> GetBookByName(@RequestParam String name) {
        return bookService.GetBookByName(name);
    }

    @PostMapping("create/{authorId}")
    public ResponseEntity<String> CreateBook(@RequestBody Book book, @PathVariable int authorId, Authentication authentication) throws Exception {
        String isSuccess = "Failed";
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorize");
        }
        if (bookService.GetBookById(book.getId()) != null) {
            throw new Exception("Book Id is existed");
        }
        book.setStoreOwner(authentication.getName());
        book.setAuthor(authorService.GetAuthorById(authorId));
        try {
            isSuccess = bookService.CreateBook(book).getId() + "";
        } catch (Exception e) {
            isSuccess = "Failed";
        }
        System.out.println(isSuccess);
        return ResponseEntity.ok(isSuccess);
    }


    @PostMapping("/upload/{bookId}")
    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file, @PathVariable int bookId) {
        System.out.println(file.getOriginalFilename());
        // Check if the file is not empty
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file!", HttpStatus.BAD_REQUEST);
        }
        try {
            // Get the file and save it to a location (in this example, it's saved to the project root)
            String serverPath = Paths.get("").toAbsolutePath().toString();
            String filePath = serverPath + "\\src\\main\\resources\\static\\BookImages\\" + file.getOriginalFilename();
            Book book = bookService.GetBookById(bookId);
            BookImage bookImage = new BookImage(0, filePath, book, "poster");
            bookImageService.CreateBookImage(bookImage);
            System.out.println(filePath);
            File savedFile = new File(filePath);
            file.transferTo(savedFile);
            return new ResponseEntity<>("File uploaded successfully!", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/uploadmulti/{bookId}")
    public ResponseEntity<String> uploadMultipleFile(@RequestBody MultipartFile[] subPoster, @PathVariable int bookId) {
        // Check if the file is not empty
        if (subPoster.length == 0) {
            return new ResponseEntity<>("Please select a file!", HttpStatus.BAD_REQUEST);
        }
        ResponseEntity<String> isSuccess = new ResponseEntity<>("File uploaded successfully!", HttpStatus.OK);
        int l = subPoster.length;
        for (int i = 0; i < l; i++) {
            MultipartFile file = subPoster[i];
            try {
                System.out.println(file.getOriginalFilename());
                // Get the file and save it to a location (in this example, it's saved to the project root)
                String serverPath = Paths.get("").toAbsolutePath().toString();
                String filePath = serverPath + "\\src\\main\\resources\\static\\BookImages\\" + file.getOriginalFilename();
                Book book = bookService.GetBookById(bookId);
                BookImage bookImage = new BookImage(0, filePath, book, "image");
                bookImageService.CreateBookImage(bookImage);
                System.out.println(filePath);
                File savedFile = new File(filePath);
                file.transferTo(savedFile);
            } catch (IOException e) {
                isSuccess = new ResponseEntity<>("Failed to upload file!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return isSuccess;
    }
}
