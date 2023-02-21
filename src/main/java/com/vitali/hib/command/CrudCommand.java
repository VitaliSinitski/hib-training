package com.vitali.hib.command;

import javax.servlet.http.HttpServletRequest;

public interface CrudCommand {
    String execute(HttpServletRequest request);
}
