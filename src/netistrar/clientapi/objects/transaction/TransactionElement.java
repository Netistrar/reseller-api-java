package netistrar.clientapi.objects.transaction;

import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;


/**
 * Transaction element object.  Represents a single domain name result within a transaction returned from the operations found in the Domain API.
 *
 */
public class TransactionElement  {

    /**
     */
    protected String type;

    /**
     */
    protected String description;

    /**
     */
    protected String elementStatus;

    /**
     */
    protected Map<String,Object> operationData;

    /**
     */
    protected Map<String,TransactionError> elementErrors;

    /**
     */
    protected Float orderLineSubtotal;

    /**
     */
    protected Float orderLineTaxes;

    /**
     */
    protected Float orderLineTotal;




    /**
    * Blank Constructor
    *
    */
    public TransactionElement(){
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
     * Get the description
     *
     * @return String
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Get the elementStatus
     *
     * @return String
     */
    public String getElementStatus(){
        return this.elementStatus;
    }

    /**
     * Get the operationData
     *
     * @return Map<String,Object>
     */
    public Map<String,Object> getOperationData(){
        return this.operationData;
    }

    /**
     * Get the elementErrors
     *
     * @return Map<String,TransactionError>
     */
    public Map<String,TransactionError> getElementErrors(){
        return this.elementErrors;
    }

    /**
     * Get the orderLineSubtotal
     *
     * @return Float
     */
    public Float getOrderLineSubtotal(){
        return this.orderLineSubtotal;
    }

    /**
     * Get the orderLineTaxes
     *
     * @return Float
     */
    public Float getOrderLineTaxes(){
        return this.orderLineTaxes;
    }

    /**
     * Get the orderLineTotal
     *
     * @return Float
     */
    public Float getOrderLineTotal(){
        return this.orderLineTotal;
    }


}