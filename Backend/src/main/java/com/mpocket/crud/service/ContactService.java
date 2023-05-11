package com.mpocket.crud.service;

import com.mpocket.crud.dto.ContactDTO;

import java.util.List;

public interface ContactService {


    List<ContactDTO> getRecentContacts();

    List<ContactDTO> searchContacts(String lastName);

    Integer addContact(ContactDTO contactDTO);

    Integer deleteContact(Integer id);
}
