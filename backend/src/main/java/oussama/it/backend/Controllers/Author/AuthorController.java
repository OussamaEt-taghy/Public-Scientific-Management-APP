package oussama.it.backend.Controllers.Author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Author")
@RequiredArgsConstructor
public class AuthorController {

    @GetMapping
    public ResponseEntity<String> sayhello() {
        return ResponseEntity.ok("Hello World1");
    }
}
