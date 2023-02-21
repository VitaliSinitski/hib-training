package com.vitali.hib.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreatePersonDto {
    String name;
    String surname;
}
