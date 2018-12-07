package netistrar.clientapi.exception;

import java.util.Map;


/**

*/
public class RateLimitExceededException extends Exception {

    /**
     * Indexed string array of exception data in the case that a non-serialisable
     * exception has been shunted into this class
     */
    protected Map<String,String> sourceException;

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
    * Blank Constructor
    *
    */
    public RateLimitExceededException(){
    }



    /**
     * Get the sourceException
     *
     * @return Map<String,String>
     */
    public Map<String,String> getSourceException(){
        return this.sourceException;
    }

    /**
     * Get the message
     *
     * @return String
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Get the code
     *
     * @return String
     */
    public String getCode(){
        return this.code;
    }

    /**
     * Get the file
     *
     * @return String
     */
    public String getFile(){
        return this.file;
    }

    /**
     * Get the line
     *
     * @return String
     */
    public String getLine(){
        return this.line;
    }


}