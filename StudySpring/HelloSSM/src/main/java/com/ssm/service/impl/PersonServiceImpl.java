package com.ssm.service.impl;

import com.ssm.dao.PersonMapperDao;
import com.ssm.entity.Person;
import com.ssm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapperDao personMapperDao;

    public Person findPersonById(long id) {
        return personMapperDao.findPersonById(id);
    }
}