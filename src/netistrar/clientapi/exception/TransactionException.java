package netistrar.clientapi.exception;

import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;


/**
 * Transaction Exception raised when an issue occurs usually in a call to
 * as single update function.
*/
public class TransactionException extends Exception {

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
     * Nested array of errors
     */
    protected Map<String,TransactionError> transactionErrors;




    /**
    * Blank Constructor
    *
    */
    public TransactionException(){
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

    /**
     * Get the transactionErrors
     *
     * @return transactionErrors
     */
    public Map<String,TransactionError> getTransactionErrors(){
        return this.transactionErrors;
    }


}