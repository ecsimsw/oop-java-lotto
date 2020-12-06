package exception;

public class InvalidBonusNumberException extends RuntimeException{
    public InvalidBonusNumberException(String msg){
        super(msg);
    }
}
