package file.dao;

import file.domain.Regular;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lan
 * @date 2019-03-04 02:00
 */
public interface RegularDao extends JpaRepository<Regular, Integer> {


}
