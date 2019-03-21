package com.ssm.service;

import com.ssm.entity.Person;

public interface PersonService {
    Person findPersonById(long id);
}