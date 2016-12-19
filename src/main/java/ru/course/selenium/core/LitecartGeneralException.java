package ru.course.selenium.core;

/**
 * Created by Aleksei.Klimenko on 19.12.2016.
 */
public class LitecartGeneralException extends RuntimeException{

    public LitecartGeneralException(){
        super();
    }

    public LitecartGeneralException(String message){
        super(message);
    }

    public LitecartGeneralException(String message, Throwable throwable){
        super(message, throwable);
    }
}
