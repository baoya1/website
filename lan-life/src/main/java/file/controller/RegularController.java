package file.controller;

import file.domain.Regular;
import file.service.RegularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Regular findOne(@PathVariable("id") Long id) {
        return regularService.findById(id);
    }

    @GetMapping("/{page}/{size}")
    public Page<Regular> findPage(@PathVariable("page") Integer page, @PathVariable("size")Integer size) {
        return regularService.findPage(page,size);
    }


    @PostMapping
    public String add(@RequestBody Regular regular){
        try {
            regularService.add(regular);
            return "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        try {
            regularService.delete(id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }

}
