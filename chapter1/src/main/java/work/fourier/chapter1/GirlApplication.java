package work.fourier.chapter1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlsApplication {
    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(path = "/girls/{id}")
    public GirlProperties find(@PathVariable Integer id) {
        return girlRepository.findById(id).get();
    }

    @PutMapping(path = "/girls/add")
    public GirlProperties add(@RequestParam String cupSize,
                              @RequestParam Integer age) {
        GirlProperties girl = new GirlProperties();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(path = "/girls/del/{id}")
    public void del(@PathVariable Integer id) {
        girlRepository.deleteById(id);
    }

    @PutMapping(path = "/girls/update/{id}")
    public GirlProperties update(@PathVariable Integer id,
                                 @RequestParam String cupSize,
                                 @RequestParam Integer age) {
        GirlProperties girl = new GirlProperties();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping(path = "/girls/age/{age}")
    public List<GirlProperties> findGirlByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }
}
