package com.dan.green_energy.exceptions;

public class BaluException extends Exception {
    public BaluException() {super();}

    public BaluException(String message) { super(message);}

    public BaluException(Throwable cause ){ super(cause );}

    public BaluException(String message,Throwable cause ){ super(message,cause );}

}
