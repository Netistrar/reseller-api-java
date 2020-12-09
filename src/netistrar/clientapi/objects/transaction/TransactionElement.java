package netistrar.clientapi.objects.transaction;

import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;

/**
 * Transaction element object.  Represents a single domain name result within a transaction returned from the operations found in the Domain API.
*/
public class TransactionElement  {


    /**
     * The type of element e.g. Domain Name
     */
    protected String type;
    /**
     * The description of the element
     */
    protected String description;
    /**
     * The status of this element.  This will contain one of the following values:<br />
     * <b>SUCCEEDED:</b> When this element succeeded.
     * <b>FAILED:</b> When this element failed.
     */
    protected String elementStatus;
    /**
     * An associative array of operation data relevant to the operation type returned in the case that the <b>elementStatus</b> member is set to <b>SUCCEEDED</b>.<br />
     * For <b>DOMAIN_CREATE</b> and <b>DOMAIN_RENEW</b> operations this will contain an array with the following keys<br />
     * <b>expiryDate:</b> The new expiry date for this domain name following the operation in dd/mm/YYYY format.
     * <b>registrationYears:</b> The number of years added to this domain following the operation.
     */
    protected Map<String,Object> operationData;
    /**
     * An error member which is populated in the case that the elementStatus member is set to <b>FAILED</b>. These will be indexed by the error code.
     */
    protected Map<String,TransactionError> elementErrors;
    /**
     * The subtotal for the Netistrar order line for this domain name if applicable for this transaction.  This will be set when the <b>orderId</b> element is defined for the wrapping <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object and will be the net total (pre taxes) for this domain operation in the currency defined in the transaction.<br />
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected Float orderLineSubtotal;
    /**
     * The taxes for the Netistrar order line for this domain name if applicable for this transaction.  This will be set when the <b>orderId</b> element is defined for the wrapping <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object
     * and will be the tax amount (VAT) for this domain operation in the currency defined in the transaction.<br />
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
     */
    protected Float orderLineTaxes;
    /**
     * The total for the Netistrar order line for this domain name if applicable for this transaction.  This will be set when the <b>orderId</b> element is defined for the wrapping <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object
     * and will be the total including taxes for this domain operation in the currency defined in the transaction.<br />
     * This property defaults to <b>N/A</b> if no order id is available for this transaction.
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
     * @return type
     */
    public String getType(){
        return this.type;
    }

    /**
     * Get the description
     *
     * @return description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Get the elementStatus
     *
     * @return elementStatus
     */
    public String getElementStatus(){
        return this.elementStatus;
    }

    /**
     * Get the operationData
     *
     * @return operationData
     */
    public Map<String,Object> getOperationData(){
        return this.operationData;
    }

    /**
     * Get the elementErrors
     *
     * @return elementErrors
     */
    public Map<String,TransactionError> getElementErrors(){
        return this.elementErrors;
    }

    /**
     * Get the orderLineSubtotal
     *
     * @return orderLineSubtotal
     */
    public Float getOrderLineSubtotal(){
        return this.orderLineSubtotal;
    }

    /**
     * Get the orderLineTaxes
     *
     * @return orderLineTaxes
     */
    public Float getOrderLineTaxes(){
        return this.orderLineTaxes;
    }

    /**
     * Get the orderLineTotal
     *
     * @return orderLineTotal
     */
    public Float getOrderLineTotal(){
        return this.orderLineTotal;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof TransactionElement))
            return false;

        TransactionElement castObject = (TransactionElement)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getType() == null && castObject.getType() == null) ||
            (this.getType() != null && this.getType().equals(castObject.getType())));
        equals = equals && ( (this.getDescription() == null && castObject.getDescription() == null) ||
            (this.getDescription() != null && this.getDescription().equals(castObject.getDescription())));
        equals = equals && ( (this.getElementStatus() == null && castObject.getElementStatus() == null) ||
            (this.getElementStatus() != null && this.getElementStatus().equals(castObject.getElementStatus())));
        equals = equals && ( (this.getOperationData() == null && castObject.getOperationData() == null) ||
            (this.getOperationData() != null && this.getOperationData().equals(castObject.getOperationData())));
        equals = equals && ( (this.getElementErrors() == null && castObject.getElementErrors() == null) ||
            (this.getElementErrors() != null && this.getElementErrors().equals(castObject.getElementErrors())));
        equals = equals && ( (this.getOrderLineSubtotal() == null && castObject.getOrderLineSubtotal() == null) ||
            (this.getOrderLineSubtotal() != null && this.getOrderLineSubtotal().equals(castObject.getOrderLineSubtotal())));
        equals = equals && ( (this.getOrderLineTaxes() == null && castObject.getOrderLineTaxes() == null) ||
            (this.getOrderLineTaxes() != null && this.getOrderLineTaxes().equals(castObject.getOrderLineTaxes())));
        equals = equals && ( (this.getOrderLineTotal() == null && castObject.getOrderLineTotal() == null) ||
            (this.getOrderLineTotal() != null && this.getOrderLineTotal().equals(castObject.getOrderLineTotal())));

        return equals;
    }


}