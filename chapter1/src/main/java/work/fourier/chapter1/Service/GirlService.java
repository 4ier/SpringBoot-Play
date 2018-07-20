package work.fourier.chapter1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.fourier.chapter1.Bean.Girl;
import work.fourier.chapter1.Repository.GirlRepository;

import java.util.List;


@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addTwoGirls() {
        Girl g1 = new Girl();
        g1.setAge(30);
        g1.setCupSize("F");
        girlRepository.save(g1);

        Girl g2 = new Girl();
        g2.setAge(31);
        g2.setCupSize("FF");
        girlRepository.save(g2);
    }

    public Girl findById(Integer id) {
        return girlRepository.findById(id).get();
    }

    public Girl save(Girl girl) {
        return girlRepository.save(girl);
    }

    public void del(Integer id) {
        girlRepository.deleteById(id);
    }

    public List<Girl> findGirlByAge(Integer age) {
        return girlRepository.findByAge(age);
    }


}
