package com.mpocket.crud.service.impl;

import com.mpocket.crud.dto.ContactDTO;
import com.mpocket.crud.entity.Contacts;
import com.mpocket.crud.mapper.ContactMapper;
import com.mpocket.crud.repository.ContactsRepo;
import com.mpocket.crud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactsRepo contactsRepo;
    @Autowired
    private ContactMapper mapper;

    @Override
    public List<ContactDTO> getRecentContacts() {
        return mapper.getDTOs(contactsRepo.findLast10ByStatus(true));
    }

    @Override
    public List<ContactDTO> searchContacts(String lastName) {
        return mapper.getDTOs(contactsRepo.findByLastNameContainingIgnoreCase(lastName));
    }

    @Override
    public Integer addContact(ContactDTO contactDTO) {
        Contacts contacts = mapper.getEntity(contactDTO);
        contacts = contactsRepo.save(contacts);
        return contacts.getId();
    }

    @Override
    public Integer deleteContact(Integer id) {
        Contacts contact = contactsRepo.findById(id).get();
        contact.setStatus(false);
        contact =  contactsRepo.save(contact);
        return contact.getId();
    }
}
