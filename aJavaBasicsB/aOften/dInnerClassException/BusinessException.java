package aOften.dInnerClassException;

/**
 * 业务异常：继承RuntimeException
 */
public class BusinessException extends  RuntimeException {

    private static final long serialVersionUID = 9140279009357013389L;
    public BusinessException(){};
    public BusinessException(String message){
        super(message);
    }
}
