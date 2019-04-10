package file.controller;

import file.domain.Regular;
import file.service.RegularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:28
 */
@RestController
@RequestMapping("/regular")
public class RegularController {

    @Autowired
    private RegularService regularService;

    @GetMapping
    public List<Regular> findAll() {
        return regularService.findAll();
    }

}
