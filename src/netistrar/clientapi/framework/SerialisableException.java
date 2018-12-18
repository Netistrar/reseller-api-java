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
    * @return Controller Name
    */
    public String getControllerName() {
        return controllerName;
    }

    /**
    * Get the controller method
    *
    * @return Controller Method
    */
    public String getControllerMethod() {
        return controllerMethod;
    }

    /**
    * Get the exception class
    *
    * @return Exception Class
    */
    public String getExceptionClass() {
        return exceptionClass;
    }

    /**
    * Get the exception code
    *
    * @return Exception Code
    */
    public int getExceptionCode() {
        return exceptionCode;
    }

    /**
    * Get the exception message
    *
    * @return Exception Message
    */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
    * Get the exception line number
    *
    *
    * @return Exception Line Number
    */
    public int getExceptionLineNumber() {
        return exceptionLineNumber;
    }

    /**
    * Get the exception file
    *
    * @return Exception File
    */
    public String getExceptionFile() {
        return exceptionFile;
    }

    /**
    * Get the exception trace
    *
    * @return Exception Trace
    */
    public String getExceptionTrace() {
        return exceptionTrace;
    }



}
