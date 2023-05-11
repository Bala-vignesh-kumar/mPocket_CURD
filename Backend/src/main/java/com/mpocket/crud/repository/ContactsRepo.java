package com.mpocket.crud.repository;

import com.mpocket.crud.dto.ContactDTO;
import com.mpocket.crud.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactsRepo extends JpaRepository<Contacts, Integer> {
    List<Contacts> findLast10ByStatus(boolean status);

    List<Contacts> findByLastNameContainingIgnoreCase(String lastName);
}
