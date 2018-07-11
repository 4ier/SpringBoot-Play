package work.fourier.chapter1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApplication {
    @RequestMapping("/hello/{userID}")
    public String hello(@PathVariable String userID) {
        return "hello " + userID;
    }
}
