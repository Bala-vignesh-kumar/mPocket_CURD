package com.mpocket.crud.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContactDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private String phNumber;
}
