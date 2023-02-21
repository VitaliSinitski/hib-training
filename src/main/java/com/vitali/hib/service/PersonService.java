package com.vitali.hib.service;

import com.vitali.hib.dao.PersonDao;
import com.vitali.hib.dto.CreatePersonDto;
import com.vitali.hib.dto.PersonDto;
import com.vitali.hib.entity.Person;
import com.vitali.hib.mapper.CreatePersonMapper;
import com.vitali.hib.mapper.PersonMapper;
import org.apache.bcel.generic.INEG;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private static final PersonService INSTANCE = new PersonService();
    private final PersonDao personDao = PersonDao.getInstance();
    private final PersonMapper personMapper = PersonMapper.getInstance();
    private final CreatePersonMapper createPersonMapper = CreatePersonMapper.getInstance();

    public List<PersonDto> findAll() {
        return personDao.findAll()
                .stream()
                .map(personMapper::mapFrom)
                .collect(Collectors.toList());
    }

    public PersonDto findById(Integer id) {
        return personMapper.mapFrom(personDao.findById(id));
    }

    public void delete(Integer id) {
        personDao.delete(id);
    }

    public void update(CreatePersonDto createPersonDto, Integer id) {
        Person person = createPersonMapper.mapFrom(createPersonDto);
        personDao.update(person, id);
    }

    public PersonDto save(CreatePersonDto createPersonDto) {
        Person person = createPersonMapper.mapFrom(createPersonDto);
        Person personEntity = personDao.save(person);
        return personMapper.mapFrom(personEntity);

    }






    public static PersonService getInstance() {
        return INSTANCE;
    }

}
