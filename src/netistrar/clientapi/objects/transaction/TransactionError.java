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



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof TransactionError))
            return false;

        TransactionError castObject = (TransactionError)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getType() == null && castObject.getType() == null) ||
            (this.getType() != null && this.getType().equals(castObject.getType())));
        equals = equals && ( (this.getCode() == null && castObject.getCode() == null) ||
            (this.getCode() != null && this.getCode().equals(castObject.getCode())));
        equals = equals && ( (this.getMessage() == null && castObject.getMessage() == null) ||
            (this.getMessage() != null && this.getMessage().equals(castObject.getMessage())));
        equals = equals && ( (this.getAdditionalInfo() == null && castObject.getAdditionalInfo() == null) ||
            (this.getAdditionalInfo() != null && this.getAdditionalInfo().equals(castObject.getAdditionalInfo())));
        equals = equals && ( (this.getRelatedErrors() == null && castObject.getRelatedErrors() == null) ||
            (this.getRelatedErrors() != null && this.getRelatedErrors().equals(castObject.getRelatedErrors())));

        return equals;
    }


}