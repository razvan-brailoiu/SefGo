package org.loose.fis.sre.exceptions;

public class UserNotInDatabaseException extends Exception{
    public UserNotInDatabaseException(){
        super("This username was not found in the database. Try inputting something else");
    }
}
