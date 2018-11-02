package netistrar.clientapi.objects.transaction;

import java.util.Map;


/**
 * Domain name error object
 */
public class TransactionError  {

    /**
     */
    protected String type;

    /**
     */
    protected String code;

    /**
     */
    protected String message;

    /**
     */
    protected Map<String,Object> additionalInfo;

    /**
     */
    protected Map<String,TransactionError> relatedErrors;




    /**
    * Blank Constructor
    *
    */
    public TransactionError(){
    }



    /**
     * Get the type
     *
     * @return String
     */
    public String getType(){
        return this.type;
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
     * Get the message
     *
     * @return String
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Get the additionalInfo
     *
     * @return Map<String,Object>
     */
    public Map<String,Object> getAdditionalInfo(){
        return this.additionalInfo;
    }

    /**
     * Get the relatedErrors
     *
     * @return Map<String,TransactionError>
     */
    public Map<String,TransactionError> getRelatedErrors(){
        return this.relatedErrors;
    }


}