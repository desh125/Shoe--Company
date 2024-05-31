package lk.ijse.gdse.springboot.back_end.service.execption;

public class DublicateRecordException extends ServiceException{
    public DublicateRecordException(String message) {
        super(message);
    }
}
