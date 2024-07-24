package utils;

public class CustomException extends Exception{
    CustomException(String message){
        super(message);
    }
    CustomException(int message){
        super(Integer.toString(message));
    }
}
