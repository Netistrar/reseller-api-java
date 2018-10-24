package netistrar.clientapi.framework;

public class SerialisableException extends Exception {

    protected String controllerName;
    protected String controllerMethod;
    protected String exceptionClass;
    protected int exceptionCode;
    protected String exceptionMessage;
    protected int exceptionLineNumber;
    protected String exceptionFile;
    protected String exceptionTrace;


    @Override
    public String getMessage() {
        return this.exceptionMessage;
    }


    /**
    * Get the controller name
    *
    * @return
    */
    public String getControllerName() {
        return controllerName;
    }

    /**
    * Get the controller method
    *
    * @return
    */
    public String getControllerMethod() {
        return controllerMethod;
    }

    /**
    * Get the exception class
    *
    * @return
    */
    public String getExceptionClass() {
        return exceptionClass;
    }

    /**
    * Get the exception code
    *
    * @return
    */
    public int getExceptionCode() {
        return exceptionCode;
    }

    /**
    * Get the exception message
    *
    * @return
    */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
    * Get the exception line number
    *
    *
    * @return
    */
    public int getExceptionLineNumber() {
        return exceptionLineNumber;
    }

    /**
    * Get the exception file
    *
    * @return
    */
    public String getExceptionFile() {
        return exceptionFile;
    }

    /**
    * Get the exception trace
    *
    * @return
    */
    public String getExceptionTrace() {
        return exceptionTrace;
    }



}
