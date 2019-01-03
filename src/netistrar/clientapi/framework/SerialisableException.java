package netistrar.clientapi.framework;

public class SerialisableException extends Exception {

    protected String exceptionClass;

    /**
    * Get the exception class
    *
    * @return Exception Class
    */
    public String getExceptionClass() {
        return exceptionClass;
    }



}
