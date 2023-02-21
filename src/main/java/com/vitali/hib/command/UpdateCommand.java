package com.vitali.hib.command;

import com.sun.xml.bind.v2.model.core.ID;
import com.vitali.hib.converter.Converter;
import com.vitali.hib.dto.CreatePersonDto;
import com.vitali.hib.dto.PersonDto;
import com.vitali.hib.service.PersonService;
import com.vitali.hib.util.Constants;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.hib.util.Constants.*;

public class UpdateCommand implements CrudCommand {
    private final PersonService personService = PersonService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (request.getMethod().equals(GET)) {
            PersonDto personDto = personService.findById(id);
            request.setAttribute(ID, id);
            request.setAttribute(PERSON_DTO, personDto);
            return UPDATE_JSP;
        } else {
            CreatePersonDto createPersonDto = Converter.converter(request);
            personService.update(createPersonDto, id);
            request.setAttribute(PERSON_LIST, personService.findAll());
            return LIST_JSP;
        }
    }
}
