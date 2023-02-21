package com.vitali.hib.command;

public enum CrudEnum {
    CREAT(new CreateCommand()),
    READ(new ReadCommand()),
    UPDATE(new UpdateCommand()),
    DELETE(new DeleteCommand());
    private final CrudCommand crudCommand;
    public CrudCommand getCrudCommand() {
        return crudCommand;
    }
    CrudEnum (CrudCommand newCrudCommand) {
        crudCommand = newCrudCommand;
    }
}
