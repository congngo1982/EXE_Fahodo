package exe.fahodo.fahodo.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessStatisResourceRestController {

//    @GetMapping("/BookImages/{fileName}")
//    public ResponseEntity<Resource> serveFile(@PathVariable String fileName) {
//        Resource file = new FileSystemResource("BookImages/" + fileName);
//
//        if (file.exists() && file.isReadable()) {
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//                    .body(file);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}