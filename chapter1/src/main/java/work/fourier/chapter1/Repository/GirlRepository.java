package work.fourier.chapter1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.fourier.chapter1.Bean.Girl;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findByAge(Integer age);
}
