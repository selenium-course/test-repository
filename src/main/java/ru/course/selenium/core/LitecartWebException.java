package ru.course.selenium.core;

/**
 * Created by Aleksei.Klimenko on 04.12.2016.
 */
public class LitecartWebException extends RuntimeException{

    public LitecartWebException(){
        super();
    }

    public LitecartWebException(String message){
        super(message);
    }

    public LitecartWebException(String message, Throwable throwable){
        super(message, throwable);
    }
}
