package netistrar.clientapi.exception;

import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;


/**
 * Transaction Exception raised when an issue occurs usually in a call to
 * as single update function.
*/
public class TransactionException extends Exception {

    /**
     * Nested array of errors
     */
    protected Map<String,TransactionError> transactionErrors;

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
    public TransactionException(){
    }



    /**
     * Get the transactionErrors
     *
     * @return
     */
    public Map<String,TransactionError> getTransactionErrors(){
        return this.transactionErrors;
    }

    /**
     * Get the sourceException
     *
     * @return
     */
    public Map<String,String> getSourceException(){
        return this.sourceException;
    }

    /**
     * Get the message
     *
     * @return
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Get the code
     *
     * @return
     */
    public String getCode(){
        return this.code;
    }

    /**
     * Get the file
     *
     * @return
     */
    public String getFile(){
        return this.file;
    }

    /**
     * Get the line
     *
     * @return
     */
    public String getLine(){
        return this.line;
    }


}