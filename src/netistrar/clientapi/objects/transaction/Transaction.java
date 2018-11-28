package netistrar.clientapi.objects.transaction;

import netistrar.clientapi.objects.transaction.TransactionElement;
import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;


/**
 * Domain Name Transaction object.  This is returned from the operations found in the Domain API.  It contains general status information about the transaction
 * along with an array of <b>DomainNameTransactionElement</b> objects for each Domain Name involved in the transaction.
 *
 *
 */
public class Transaction  {

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
    protected Integer orderId;

    /**
     */
    protected String orderCurrency;

    /**
     */
    protected Float orderSubtotal;

    /**
     */
    protected Float orderTaxes;

    /**
     */
    protected Float orderTotal;

    /**
     */
    protected Map<String,TransactionElement> transactionElements;

    /**
     */
    protected TransactionError transactionError;




    /**
    * Blank Constructor
    *
    */
    public Transaction(){
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
     * Get the orderId
     *
     * @return Integer
     */
    public Integer getOrderId(){
        return this.orderId;
    }

    /**
     * Get the orderCurrency
     *
     * @return String
     */
    public String getOrderCurrency(){
        return this.orderCurrency;
    }

    /**
     * Get the orderSubtotal
     *
     * @return Float
     */
    public Float getOrderSubtotal(){
        return this.orderSubtotal;
    }

    /**
     * Get the orderTaxes
     *
     * @return Float
     */
    public Float getOrderTaxes(){
        return this.orderTaxes;
    }

    /**
     * Get the orderTotal
     *
     * @return Float
     */
    public Float getOrderTotal(){
        return this.orderTotal;
    }

    /**
     * Get the transactionElements
     *
     * @return Map<String,TransactionElement>
     */
    public Map<String,TransactionElement> getTransactionElements(){
        return this.transactionElements;
    }

    /**
     * Get the transactionError
     *
     * @return TransactionError
     */
    public TransactionError getTransactionError(){
        return this.transactionError;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof Transaction))
            return false;

        Transaction castObject = (Transaction)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getTransactionType() == null && castObject.getTransactionType() == null) ||
            (this.getTransactionType() != null && this.getTransactionType().equals(castObject.getTransactionType())));
        equals = equals && ( (this.getTransactionDateTime() == null && castObject.getTransactionDateTime() == null) ||
            (this.getTransactionDateTime() != null && this.getTransactionDateTime().equals(castObject.getTransactionDateTime())));
        equals = equals && ( (this.getTransactionStatus() == null && castObject.getTransactionStatus() == null) ||
            (this.getTransactionStatus() != null && this.getTransactionStatus().equals(castObject.getTransactionStatus())));
        equals = equals && ( (this.getOrderId() == null && castObject.getOrderId() == null) ||
            (this.getOrderId() != null && this.getOrderId().equals(castObject.getOrderId())));
        equals = equals && ( (this.getOrderCurrency() == null && castObject.getOrderCurrency() == null) ||
            (this.getOrderCurrency() != null && this.getOrderCurrency().equals(castObject.getOrderCurrency())));
        equals = equals && ( (this.getOrderSubtotal() == null && castObject.getOrderSubtotal() == null) ||
            (this.getOrderSubtotal() != null && this.getOrderSubtotal().equals(castObject.getOrderSubtotal())));
        equals = equals && ( (this.getOrderTaxes() == null && castObject.getOrderTaxes() == null) ||
            (this.getOrderTaxes() != null && this.getOrderTaxes().equals(castObject.getOrderTaxes())));
        equals = equals && ( (this.getOrderTotal() == null && castObject.getOrderTotal() == null) ||
            (this.getOrderTotal() != null && this.getOrderTotal().equals(castObject.getOrderTotal())));
        equals = equals && ( (this.getTransactionElements() == null && castObject.getTransactionElements() == null) ||
            (this.getTransactionElements() != null && this.getTransactionElements().equals(castObject.getTransactionElements())));
        equals = equals && ( (this.getTransactionError() == null && castObject.getTransactionError() == null) ||
            (this.getTransactionError() != null && this.getTransactionError().equals(castObject.getTransactionError())));

        return equals;
    }


}