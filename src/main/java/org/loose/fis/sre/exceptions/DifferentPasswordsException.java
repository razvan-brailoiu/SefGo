package org.loose.fis.sre.exceptions;

public class DifferentPasswordsException extends Exception{
    public DifferentPasswordsException(){
        super("Hey, the two passwords must be the same!");
    }
}
