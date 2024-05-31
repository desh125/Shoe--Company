package lk.ijse.gdse.springboot.back_end.service.execption;

public class NotFoundException extends ServiceException{
    public NotFoundException(String message) {
        super(message);
    }
}
