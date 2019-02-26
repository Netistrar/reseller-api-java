package netistrar.clientapi.exception;

import java.util.Map;


/**

*/
public class RateLimitExceededException extends Exception {

    /**
     */
    protected String message;

    /**
     */
    protected String code;

    /**
     */
    protected String file;

    /**
     */
    protected String line;

    /**
     * Indexed string array of exception data in the case that a non-serialisable
     * exception has been shunted into this class
     */
    protected Map<String,String> sourceException;




    /**
    * Blank Constructor
    *
    */
    public RateLimitExceededException(){
    }



    /**
     * Get the message
     *
     * @return message
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Get the code
     *
     * @return code
     */
    public String getCode(){
        return this.code;
    }

    /**
     * Get the file
     *
     * @return file
     */
    public String getFile(){
        return this.file;
    }

    /**
     * Get the line
     *
     * @return line
     */
    public String getLine(){
        return this.line;
    }

    /**
     * Get the sourceException
     *
     * @return sourceException
     */
    public Map<String,String> getSourceException(){
        return this.sourceException;
    }


}