package work.fourier.chapter1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public void addTwoGirls() {
        GirlProperties g1 = new GirlProperties();
        g1.setAge(30);
        g1.setCupSize("F");
        girlRepository.save(g1);

        GirlProperties g2 = new GirlProperties();
        g2.setAge(31);
        g2.setCupSize("FF");
        girlRepository.save(g2);
    }
}
