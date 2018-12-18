package netistrar.clientapi.objects.transaction;

import netistrar.clientapi.objects.transaction.TransactionElement;
import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;

/**
 * Domain Name Transaction object.  This is returned from the operations found in the Domain API.  It contains general status information about the transaction
 * along with an array of <b>DomainNameTransactionElement</b> objects for each Domain Name involved in the transaction.
*/
public class Transaction  {


    /**
     * The type of transaction represented by this object.  This will contain one of the following values:
     * <b>DOMAIN_CREATE:</b> For domain create operations initiated by a call to <i>createDomainName</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     * <b>DOMAIN_RENEW:</b> For domain renew operations initiated by a call to <i>renewDomains</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     * <b>DOMAIN_UPDATE:</b> For domain update operations initiated by a call to <i>updateDomainNames</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     * <b>DOMAIN_GLUE_RECORD_SET:</b> For domain glue record set operations initiated by a call to <i>setGlueRecords</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     * <b>DOMAIN_GLUE_RECORD_REMOVE:</b> For domain glue record remove operations initiated by a call to <i>removeGlueRecords</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     * <b>DOMAIN_TRANSFER_IN_CREATE</b> For domain transfer in operations initiated by a call to <i>createIncomingTransferDomains</i> on the <a href="netistrar-domain-transfer-api">Netistrar Domain Transfer API</a>.
     * <b>DOMAIN_TRANSFER_IN_CONFIRMATION</b> For domain transfer in confirmation resend operations initiated by  a call to <i>resendIncomingTransferConfirmations</i> on the <a href="netistrar-domain-transfer-api">Netistrar Domain Transfer API</a>.
     * <b>DOMAIN_TRANSFER_IN_CANCEL</b> For domain transfer cancellations initiated by a call to <i>cancelIncomingTransferDomains</i> on the <a href="netistrar-domain-transfer-api">Netistrar Domain Transfer API</a>.
     * <b>DOMAIN_TRANSFER_OUT_CREATE</b> For domain transfer out operations initiated by a call to <i>createOutgoingPushTransferDomains</i> on the <a href="netistrar-domain-transfer-api">Netistrar Domain Transfer API</a>.
     * <b>DOMAIN_TRANSFER_OUT_CONFIRMATION</b> For domain transfer out confirmation resend operations initiated by a call to <i>resendOutgoingPushTransferConfirmations</i> on the <a href="netistrar-domain-transfer-api">Netistrar Domain Transfer API</a>.
     * <b>DOMAIN_TRANSFER_OUT_CANCEL</b> For domain transfer out cancellations initiated by a call to <i>cancelOutgoingPushTransferDomains</i> on the <a href="netistrar-domain-transfer-api">Netistrar Domain Transfer API</a>.
     * <b>DOMAIN_CANCEL_PENDING_OWNER_CHANGES</b> For cancellation of pending owner changes for GTLDs initiated by a call to <i>cancelPendingOwnerContactChanges</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     */
    protected String transactionType;
    /**
     * The date and time at which this transaction was completed in dd/mm/YYYY HH:mi:ss format.
     */
    protected String transactionDateTime;
    /**
     * The status of this transaction.  This will contain one of the following values.
     * <b>SUCCEEDED:</b> When the operation succeeded for all involved domain names.
     * <b>PARTIALLY_SUCCEEDED:</b> When the operation succeeded only for some of the involved domain names.  In this case any failed transaction elements will contain errors detailing the reasons for the partial failure.
     * <b>ALL_ELEMENTS_FAILED:</b> When the operation failed for all involved domain names and the errors were downstream in the operation workflow.  In this case all elements will contain errors detailing the reasons for the failure.
     * <b>FAILED:</b> When the operation failed for a generic reason not specific to the operation.  This is most commonly a payment failure and will be recorded in the <a href="#transactionError">transactionError</a> member.
     */
    protected String transactionStatus;
    /**
     * A Netistrar Order ID if applicable for the given transaction.  This will be set when the transaction has resulted in a costed order and facilitates reconciliation with orders in the Netistrar Control Panel.
     * Currently, this will be set when the transaction type is <b>DOMAIN_CREATE</b> or <b>DOMAIN_RENEW</b>.
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected Integer orderId;
    /**
     * The currency for the Netistrar Order if applicable for the given transaction.  This will be set when the <a href="#netistrarOrderId">netistrarOrderId</a> element is set and will be a 3 digit currency code (e.g. GBP)
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected String orderCurrency;
    /**
     * The subtotal for the Netistrar Order if applicable for the given transaction.  This will be set when the <a href="#netistrarOrderId">netistrarOrderId</a> element is set and will be the net total (pre taxes) in the
     * currency set in the <a href="netistrarOrderCurrency">netistrarOrderCurrency</a> member.
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected Float orderSubtotal;
    /**
     * The taxes for the Netistrar Order if applicable for the given transaction.  This will be set when the <a href="#netistrarOrderId">netistrarOrderId</a> element is set and will be the taxes amount (VAT) in the
     * currency set in the <a href="netistrarOrderCurrency">netistrarOrderCurrency</a> member.
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected Float orderTaxes;
    /**
     * The subtotal for the Netistrar Order if applicable for the given transaction.  This will be set when the <a href="#netistrarOrderId">netistrarOrderId</a> element is set and will be the total including taxes in the
     * currency set in the <a href="netistrarOrderCurrency">netistrarOrderCurrency</a> member.
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected Float orderTotal;
    /**
     * An array of transaction elements (one for each domain name involved) which make up this transaction.  These are indexed by domain name for convenience of access.
     */
    protected Map<String,TransactionElement> transactionElements;
    /**
     * This member is populated when the <a href="#transactionStatus">transactionStatus</a> member is set to <b>FAILED</b>.  This will be a <a href="domain-operation-error">DomainOperationError</a> instance detailing the error.
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
     * @return transactionType
     */
    public String getTransactionType(){
        return this.transactionType;
    }

    /**
     * Get the transactionDateTime
     *
     * @return transactionDateTime
     */
    public String getTransactionDateTime(){
        return this.transactionDateTime;
    }

    /**
     * Get the transactionStatus
     *
     * @return transactionStatus
     */
    public String getTransactionStatus(){
        return this.transactionStatus;
    }

    /**
     * Get the orderId
     *
     * @return orderId
     */
    public Integer getOrderId(){
        return this.orderId;
    }

    /**
     * Get the orderCurrency
     *
     * @return orderCurrency
     */
    public String getOrderCurrency(){
        return this.orderCurrency;
    }

    /**
     * Get the orderSubtotal
     *
     * @return orderSubtotal
     */
    public Float getOrderSubtotal(){
        return this.orderSubtotal;
    }

    /**
     * Get the orderTaxes
     *
     * @return orderTaxes
     */
    public Float getOrderTaxes(){
        return this.orderTaxes;
    }

    /**
     * Get the orderTotal
     *
     * @return orderTotal
     */
    public Float getOrderTotal(){
        return this.orderTotal;
    }

    /**
     * Get the transactionElements
     *
     * @return transactionElements
     */
    public Map<String,TransactionElement> getTransactionElements(){
        return this.transactionElements;
    }

    /**
     * Get the transactionError
     *
     * @return transactionError
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