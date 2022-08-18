package exception;

/**
 * @author yqb
 * @Date 2022/8/18 12:44
 */
public class NotEnoughException extends RuntimeException{
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
