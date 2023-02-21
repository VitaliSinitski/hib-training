package com.vitali.hib.converter;

import com.vitali.hib.dto.CreatePersonDto;
import com.vitali.hib.util.Constants;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.hib.util.Constants.*;

public class Converter {
    public static CreatePersonDto converter(HttpServletRequest request) {
        return CreatePersonDto.builder()
                .name(request.getParameter(NAME))
                .surname(request.getParameter(SURNAME))
                .build();
    }
}
