package com.vitali.hib.mapper;

import com.vitali.hib.dto.PersonDto;
import com.vitali.hib.entity.Person;

public class PersonMapper implements Mapper<Person, PersonDto> {
    private static final PersonMapper INSTANCE = new PersonMapper();
    public static PersonMapper getInstance() {
        return INSTANCE;
    }
    @Override
    public PersonDto mapFrom(Person object) {
        return PersonDto.builder()
                .id(object.getId())
                .name(object.getName())
                .surname(object.getSurname())
                .build();
    }
}
