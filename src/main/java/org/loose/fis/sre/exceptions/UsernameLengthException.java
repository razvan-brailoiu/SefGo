package org.loose.fis.sre.exceptions;

public class UsernameLengthException extends Exception{
    public UsernameLengthException(){
        super("Username Length Must be between 3 and 20 characters long");
    }
}
