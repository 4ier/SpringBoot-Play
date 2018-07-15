package work.fourier.chapter1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<GirlProperties, Integer> {
    public List<GirlProperties> findByAge(Integer age);
}
