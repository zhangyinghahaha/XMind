package com.example.demo.service;

import com.example.demo.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> findAll() {
        return this.contacts;
    }

    public void save(Contact contact) {
        this.contacts.add(contact);
    }
}
