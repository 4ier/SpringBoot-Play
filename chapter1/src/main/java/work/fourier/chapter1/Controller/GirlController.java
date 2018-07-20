package work.fourier.chapter1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import work.fourier.chapter1.Bean.Girl;
import work.fourier.chapter1.Service.GirlService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlService girlService;

    @GetMapping(path = "/girls/{id}")
    public Girl find(@PathVariable Integer id) {
        return girlService.findById(id);
    }

    @PostMapping(path = "/girls/add")
    public Girl add(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        return girlService.save(girl);
    }

    @DeleteMapping(path = "/girls/del/{id}")
    public void del(@PathVariable Integer id) {
        girlService.del(id);
    }

    @PutMapping(path = "/girls/update/")
    public Girl update(Girl girl) {
        return girlService.save(girl);
    }

    @GetMapping(path = "/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable Integer age) {
        return girlService.findGirlByAge(age);
    }

    @PutMapping(path = "/girls/add/two")
    public void addTwo() {
        girlService.addTwoGirls();
    }
}
