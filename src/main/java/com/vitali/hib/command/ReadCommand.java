package com.vitali.hib.command;

import com.vitali.hib.service.PersonService;
import com.vitali.hib.util.Constants;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.hib.util.Constants.*;

public class ReadCommand implements CrudCommand {
    private final PersonService personService = PersonService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(PERSON_LIST, personService.findAll());
        return LIST_JSP;
    }
}
