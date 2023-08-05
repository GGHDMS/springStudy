package hello.springtx.order;

public class NotEnoughMeneyException extends Exception{

    public NotEnoughMeneyException(String message) {
        super(message);
    }
}
