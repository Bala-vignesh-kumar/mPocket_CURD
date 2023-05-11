package com.mpocket.crud.mapper;

import com.mpocket.crud.dto.ContactDTO;
import com.mpocket.crud.entity.Contacts;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactMapper {

    public ContactDTO getDTO(Contacts contact){
        return ContactDTO.builder().id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .phNumber(contact.getPhNumber()).build();
    }
    public Contacts getEntity(ContactDTO contactDTO){
        return  Contacts.builder().firstName(contactDTO.getFirstName())
                .lastName(contactDTO.getLastName())
                .phNumber(contactDTO.getPhNumber())
                .status(true).build();
    }

    public List<ContactDTO> getDTOs(List<Contacts> contacts){
        return contacts.stream().map(this::getDTO).collect(Collectors.toList());
    }
}
