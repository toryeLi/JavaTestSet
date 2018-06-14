package cMyORM.dJdbcUtilSelect.exception;

public class MyOrmException extends RuntimeException{
    static final long serialVersionUID = 1L;

    public MyOrmException() {
    }

    public MyOrmException(String message) {
        super(message);
    }

    public MyOrmException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyOrmException(Throwable cause) {
        super(cause);
    }
}
