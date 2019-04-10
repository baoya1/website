package file.service.impl;

import file.dao.RegularDao;
import file.domain.Regular;
import file.service.RegularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:29
 */
@Service
public class RegularServiceImpl implements RegularService {
    @Autowired
    private RegularDao regularDao;

    @Override
    public List<Regular> findAll() {
        return regularDao.findAll();
    }

    @Override
    public void add(Regular regular) {

    }
}
