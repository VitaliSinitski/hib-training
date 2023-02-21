package com.vitali.hib.command;

import com.vitali.hib.util.Constants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static com.vitali.hib.util.Constants.*;

public class CrudFactory {
    private static final CrudFactory INSTANCE = new CrudFactory();


    public CrudCommand defineCommand(HttpServletRequest request) {
        String command = request.getParameter(COMMAND);
        if (command == null || command.isEmpty()) {
            return null;
        }
        CrudEnum crudEnum = CrudEnum.valueOf(command.toUpperCase());
        return crudEnum.getCrudCommand();
    }

    public static CrudFactory getInstance() {
        return INSTANCE;
    }
}
