package lk.ijse.gdse.springboot.back_end.service.execption;

public class ServiceException extends RuntimeException{
    public ServiceException(String message){
        super(message);
    }
}
