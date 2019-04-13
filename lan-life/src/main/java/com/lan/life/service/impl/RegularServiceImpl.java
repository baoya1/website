package com.lan.life.service.impl;

import com.lan.life.dao.RegularDao;
import com.lan.life.domain.Regular;
import com.lan.life.service.RegularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
regularDao.save(regular);
    }

    @Override
    public Regular findById(Long id) {
        //com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: Regular$HibernateProxy$jIVrM0tZ["hibernateLazyInitializer"])
        //如果用getOne，查询记录有null字段，需要在实体类上加@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
//        return regularDao.getOne(id);
        return regularDao.findById(id).get();
    }


    @Override
    public void delete(Long id) {
regularDao.deleteById(id);
    }

    @Override
    public Page<Regular> findPage(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return regularDao.findAll(pageRequest);
    }
}
