package file.service;

import file.domain.Regular;

import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:29
 */
public interface RegularService {
    List<Regular> findAll();

    void add(Regular regular);
}
