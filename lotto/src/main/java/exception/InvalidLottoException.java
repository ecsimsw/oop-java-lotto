package exception;

public class InvalidLottoException extends RuntimeException {
    public InvalidLottoException(String msg){
        super(msg);
    }
}
