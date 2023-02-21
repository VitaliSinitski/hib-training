package com.vitali.hib.mapper;

import com.vitali.hib.dto.CreatePersonDto;
import com.vitali.hib.entity.Person;

public class CreatePersonMapper implements Mapper<CreatePersonDto, Person> {
    private final static CreatePersonMapper INSTANCE = new CreatePersonMapper();


    @Override
    public Person mapFrom(CreatePersonDto object) {
        return Person.builder()
                .name(object.getName())
                .surname(object.getSurname())
                .build();
    }


    public static CreatePersonMapper getInstance() {
        return INSTANCE;
    }
}
