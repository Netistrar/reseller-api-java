package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainNameTransactionElement;
import netistrar.clientapi.objects.domain.DomainNameError;
import java.util.Map;


/**
 * Domain Name Transaction object.  This is returned from the operations found in the Domain API.  It contains general status information about the transaction
 * along with an array of <b>DomainNameTransactionElement</b> objects for each Domain Name involved in the transaction.
 *
 *
 */
public class DomainNameTransaction  {

    /**
     */
    protected String transactionType;

    /**
     */
    protected String transactionDateTime;

    /**
     */
    protected String transactionStatus;

    /**
     */
    protected Object netistrarOrderId;

    /**
     */
    protected Object netistrarOrderCurrency;

    /**
     */
    protected Object netistrarOrderSubtotal;

    /**
     */
    protected Object netistrarOrderTaxes;

    /**
     */
    protected Object netistrarOrderTotal;

    /**
     */
    protected Map<String,DomainNameTransactionElement> transactionElements;

    /**
     */
    protected DomainNameError transactionError;




    /**
    * Blank Constructor
    *
    */
    public DomainNameTransaction(){
    }



    /**
     * Get the transactionType
     *
     * @return String
     */
    public String getTransactionType(){
        return this.transactionType;
    }

    /**
     * Get the transactionDateTime
     *
     * @return String
     */
    public String getTransactionDateTime(){
        return this.transactionDateTime;
    }

    /**
     * Get the transactionStatus
     *
     * @return String
     */
    public String getTransactionStatus(){
        return this.transactionStatus;
    }

    /**
     * Get the netistrarOrderId
     *
     * @return Object
     */
    public Object getNetistrarOrderId(){
        return this.netistrarOrderId;
    }

    /**
     * Get the netistrarOrderCurrency
     *
     * @return Object
     */
    public Object getNetistrarOrderCurrency(){
        return this.netistrarOrderCurrency;
    }

    /**
     * Get the netistrarOrderSubtotal
     *
     * @return Object
     */
    public Object getNetistrarOrderSubtotal(){
        return this.netistrarOrderSubtotal;
    }

    /**
     * Get the netistrarOrderTaxes
     *
     * @return Object
     */
    public Object getNetistrarOrderTaxes(){
        return this.netistrarOrderTaxes;
    }

    /**
     * Get the netistrarOrderTotal
     *
     * @return Object
     */
    public Object getNetistrarOrderTotal(){
        return this.netistrarOrderTotal;
    }

    /**
     * Get the transactionElements
     *
     * @return Map<String,DomainNameTransactionElement>
     */
    public Map<String,DomainNameTransactionElement> getTransactionElements(){
        return this.transactionElements;
    }

    /**
     * Get the transactionError
     *
     * @return DomainNameError
     */
    public DomainNameError getTransactionError(){
        return this.transactionError;
    }


}