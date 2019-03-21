package com.ssm.dao;

import com.ssm.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapperDao {
    Person findPersonById(long id);
}
