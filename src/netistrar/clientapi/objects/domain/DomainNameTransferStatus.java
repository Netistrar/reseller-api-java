package netistrar.clientapi.objects.domain;

import java.util.Map;

/**
 * This encodes details about a domain transfer.  When a domain name is in the <i>TRANSFER_IN_AWAITING_RESPONSE</i> status this will be fully populated with details about the
 * transfer window as obtained from the Registry.
 * <br /><br />
 * Otherwise if the domain name is in a pending confirmation status this will only have the <a href="#domainName">domainName</a> and <a href="#status">status</a> members set.
*/
public class DomainNameTransferStatus  {


    /**
     * The domain name for which the transfer status applies.
     */
    protected String domainName;
    /**
     * The status for this domain.  This will be either <i>TRANSFER_IN_PENDING_CONFIRMATION</i>, <i>TRANSFER_IN_AWAITING_RESPONSE</i>, <i>TRANSFER_IN_REJECTED</i> for transfer in operations
     * or <i>TRANSFER_OUT_PENDING_CONFIRMATION</i> for transfer out operations.
     */
    protected String status;
    /**
     * The transfer status as returned from the Registry.  This is usually "Pending"
     * <br /><br />
     * This is only set when the <a href="#status">status</a> is set to <i>TRANSFER_IN_AWAITING_RESPONSE</i> otherwise <b>N/A</b> will be returned.
     */
    protected String transferStatus;
    /**
     * The date and time that the transfer was started in <b>dd/mm/YYYY HH:mm:ss</b> format
     * <br /><br />
     * This is only set when the <a href="#status">status</a> is set to <i>TRANSFER_IN_AWAITING_RESPONSE</i> otherwise <b>N/A</b> will be returned.
     */
    protected String transferStartedDate;
    /**
     * The date and time that the transfer expires - usually 5 days after the transfer started date in <b>dd/mm/YYYY HH:mm:ss</b> format
     * <br /><br />
     * This is only set when the <a href="#status">status</a> is set to <i>TRANSFER_IN_AWAITING_RESPONSE</i> otherwise <b>N/A</b> will be returned.
     */
    protected String transferExpiryDate;
    /**
     * The date and time for the new expiry date for the domain after the transfer completes (usually 1yr more than current expiry) in <b>dd/mm/YYYY HH:mm:ss</b> format
     * <br /><br />
     * This is only set when the <a href="#status">status</a> is set to <i>TRANSFER_IN_AWAITING_RESPONSE</i> otherwise <b>N/A</b> will be returned.
     */
    protected String domainExpiryDate;



    /**
    * Blank Constructor
    *
    */
    public DomainNameTransferStatus(){
    }



    /**
     * Get the domainName
     *
     * @return String
     */
    public String getDomainName(){
        return this.domainName;
    }

    /**
     * Get the status
     *
     * @return String
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Get the transferStatus
     *
     * @return String
     */
    public String getTransferStatus(){
        return this.transferStatus;
    }

    /**
     * Get the transferStartedDate
     *
     * @return String
     */
    public String getTransferStartedDate(){
        return this.transferStartedDate;
    }

    /**
     * Get the transferExpiryDate
     *
     * @return String
     */
    public String getTransferExpiryDate(){
        return this.transferExpiryDate;
    }

    /**
     * Get the domainExpiryDate
     *
     * @return String
     */
    public String getDomainExpiryDate(){
        return this.domainExpiryDate;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameTransferStatus))
            return false;

        DomainNameTransferStatus castObject = (DomainNameTransferStatus)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainName() == null && castObject.getDomainName() == null) ||
            (this.getDomainName() != null && this.getDomainName().equals(castObject.getDomainName())));
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getTransferStatus() == null && castObject.getTransferStatus() == null) ||
            (this.getTransferStatus() != null && this.getTransferStatus().equals(castObject.getTransferStatus())));
        equals = equals && ( (this.getTransferStartedDate() == null && castObject.getTransferStartedDate() == null) ||
            (this.getTransferStartedDate() != null && this.getTransferStartedDate().equals(castObject.getTransferStartedDate())));
        equals = equals && ( (this.getTransferExpiryDate() == null && castObject.getTransferExpiryDate() == null) ||
            (this.getTransferExpiryDate() != null && this.getTransferExpiryDate().equals(castObject.getTransferExpiryDate())));
        equals = equals && ( (this.getDomainExpiryDate() == null && castObject.getDomainExpiryDate() == null) ||
            (this.getDomainExpiryDate() != null && this.getDomainExpiryDate().equals(castObject.getDomainExpiryDate())));

        return equals;
    }


}