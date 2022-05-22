package org.loose.fis.sre.exceptions;

public class OneOrMoreEmptyFieldsException extends Exception{
    public OneOrMoreEmptyFieldsException(){
        super("Hey! One or more fields are empty!");
    }
}
