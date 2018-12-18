package netistrar.clientapi.objects.transaction;

import java.util.Map;

/**
 * Domain name error object
*/
public class TransactionError  {


    /**
     * Either set to VALIDATION or OPERATION according to the type of error which this object represents.
     */
    protected String type;
    /**
     * The following error codes can occur when the type is set to <b>OPERATION</b>
     * <b>PAYMENT_ERROR:</b> If it has not been possible to collect payment for a costed transaction.  This will be qualified with a reason message.
     * <b>DOMAIN_UNAVAILABLE_FOR_REGISTRATION:</b> When an attempt is made to register a domain which is not available.
     * <b>DOMAIN_ALREADY_IN_ACCOUNT:</b> When an attempt is made to register a domain which is already in your account.
     * <b>DOMAIN_NOT_IN_ACCOUNT:</b> When an attempt is made to modify a domain which is not in your account.
     * <b>DOMAIN_INVALID_FOR_CANCELLATION:</b> When an attempt is made to cancel a domain which is not in a valid state for cancellation</br><br>
     * <b>DOMAIN_INVALID_FOR_RENEWAL:</b> An attempt has been made to renew a domain which is not valid for renewal.  Only domains with a status value of <b>ACTIVE</b> or <b>EXPIRED</b> can be renewed.
     * <b>DOMAIN_INVALID_FOR_GLUE_RECORD:</b> An attempt has been made to manage glue records for a domain which is not in <b>ACTIVE</b> status.
     * <b>DOMAIN_MISSING_GLUE_RECORD:</b> An attempt has been made to remove a glue record for a domain where the glue record has not been defined.
     * <b>DOMAIN_TRANSFER_NOT_PENDING_CONFIRMATION:</b> An attempt has been made to resend an owner confirmation for a domain which is not currently pending confirmation.
     * <b>DOMAIN_TRANSFER_INVALID_REGISTRAR_IDENTIFIER:</b> An attempt has been made to transfer a domain out using a push transfer using a registrar identifier which does not exist.
     * <b>DOMAIN_TRANSFER_NONE_PUSH_DOMAIN:</b> An attempt has been made to initiate a transfer out for a domain which does not support push transfers.
     * <b>DOMAIN_TRANSFER_NOT_CANCELLABLE:</b> An attempt has been made to cancel a domain transfer for a domain which is not currently either pending confirmation or awaiting response.
     * <b>DOMAIN_REGISTRATION_ERROR:</b> An unexpected error occurred when attempting to register this domain at the registry.  This will be qualified with a registry specific message giving further details.
     * <b>DOMAIN_TRANSFER_ERROR:</b> An unexpected error occurred when attempting a transfer operation.  This will be qualified with a registry specific message giving further details.
     * <b>DOMAIN_OWNER_NOT_PENDING_CHANGES:</b> An attempt was made to cancel owner verification changes for a domain name owner which has no pending changes.
     * <b>UNEXPECTED_TRANSACTION_ERROR:</b> When a general unexpected error occurs with a transaction.  This will be qualified with a reason message where possible.
     * The following error codes can occur when the type is set to <b>VALIDATION</b>
     * For Domain name Validation errors the following codes can occur.
     * <b>DOMAIN_MISSING_OWNER_CONTACT:</b> When a blank owner contact has been supplied to a domain operation
     * <b>DOMAIN_INVALID_OWNER_CONTACT:</b> When the owner contact supplied for an operation is invalid.  In this case the <a href="#relatedValidationErrors">relatedValidationErrors</a> member will be populated with an array of
     * contact specific errors from the list of contact validation errors below.
     * <b>DOMAIN_MISSING_ADMIN_CONTACT:</b> When a blank admin contact has been supplied to a domain operation for which the TLD for that domain requires an admin contact.
     * <b>DOMAIN_INVALID_ADMIN_CONTACT:</b> When the admin contact supplied for an operation is invalid.  In this case the <a href="#relatedValidationErrors">relatedValidationErrors</a> member will be populated with an array of
     * contact specific errors from the list of contact validation errors below.
     * <b>DOMAIN_MISSING_TECHNICAL_CONTACT:</b> When a blank technical contact has been supplied to a domain operation for which the TLD for that domain requires a technical contact.
     * <b>DOMAIN_INVALID_TECHNICAL_CONTACT:</b> When the technical contact supplied for an operation is invalid.  In this case the <a href="#relatedValidationErrors">relatedValidationErrors</a> member will be populated with an array of
     * contact specific errors from the list of contact validation errors below.
     * <b>DOMAIN_MISSING_BILLING_CONTACT:</b> When a blank billing contact has been supplied to a domain operation for which the TLD for that domain requires a billing contact.
     * <b>DOMAIN_INVALID_BILLING_CONTACT:</b> When the billing contact supplied for an operation is invalid.  In this case the <a href="#relatedValidationErrors">relatedValidationErrors</a> member will be populated with an array of
     * contact specific errors from the list of contact validation errors below.
     * <b>DOMAIN_TOO_FEW_NAMESERVERS:</b> When the set of nameservers supplied for a domain operation is fewer than is required for the TLD for the domain name in question.
     * <b>DOMAIN_INVALID_NAMESERVER_FORMAT:</b> When one or more of the array of nameservers supplied for a domain operation is not in valid nameserver format.  In this case the <a href="#extraData">extraData</a> member will be populated with an
     * array of integers representing the index(es) of the problematic nameserver(s) in the supplied nameserver array.
     * <b>DOMAIN_TOO_MANY_REGISTRATION_YEARS:</b> When the number of years supplied to a domain name operation exceeds the maximum allowed for that domain name.
     *  <br>
     * The following Contact Validation error codes can occur for Domain Transfer operations
     * <b>TRANSFER_DOMAIN_IN_ACCOUNT:</b> The domain name requested for transfer is already in your account
     * <b>TRANSFER_DOMAIN_NOT_REGISTERED:</b> If the domain name requested for transfer has not yet been registered
     * <b>TRANSFER_DOMAIN_MISSING_AUTHCODE:</b> If an authorisation code was not supplied for a domain name requested for transfer
     * <b>TRANSFER_DOMAIN_INVALID_AUTHCODE:</b> If an invalid authorisation code was supplied for a domain name requested for transfer
     * <b>TRANSFER_DOMAIN_LOCKED:</b> If a request is made for a domain which is currently locked for transfer.  In order to proceed with a transfer it is necessary to unlock the domain via the existing Registrar.
     * <b>TRANSFER_DOMAIN_60_DAY_REG_LOCK:</b> If a request is made for a domain which was registered less than 60 days ago.
     * <b>TRANSFER_ALREADY_STARTED:</b> If a request is made for a domain which is already in the middle of a transfer operation to another Registrar
     * <b>TRANSFER_DOMAIN_NOT_ASSIGNED:</b> If the transfer for a given domain requires a push operation and the domain has not yet been pushed (assigned) to Netistrar.
     * <br>
     * The following Contact Validation error codes can occur for Contact and Domain operations
     * <b>CONTACT_MISSING_NAME:</b> When a blank name is supplied for a domain contact.
     * <b>CONTACT_MISSING_EMAIL:</b> When a blank email address is supplied for a domain contact.
     * <b>CONTACT_INVALID_EMAIL_FORMAT:</b> When the contact email address is supplied in none email address format.
     * <b>CONTACT_MISSING_STREET_1:</b> When a blank street 1 value is supplied for a domain contact.
     * <b>CONTACT_MISSING_CITY:</b> When a blank city value is supplied for a domain contact.
     * <b>CONTACT_MISSING_COUNTY:</b> When a blank county value is supplied for a domain contact.
     * <b>CONTACT_MISSING_POSTCODE:</b> When a blank postcode value is supplied for a domain contact.
     * <b>CONTACT_INVALID_COUNTRY:</b> When an invalid country value (i.e. not in ISO 2 digit country code format) is supplied for a domain contact.
     * <b>CONTACT_UNSUPPORTED_COUNTRY:</b> When the TLD represented by a domain contact only allows contact within certain countries e.g. .EU and another country code is supplied</b>
     * <b>CONTACT_MISSING_TELEPHONE:</b> When the TLD represented by a domain contact requires a telephone number to be supplied and it is blank.
     * <b>CONTACT_INVALID_TELEPHONE:</b> When an invalid telephone number is supplied for a domain contact (i.e. should be a local number without spaces).
     * <b>CONTACT_MISSING_TELEPHONE_DIALLING_CODE:</b> When a blank telephone dialling code is supplied for a domain contact when a telephone number has also been supplied.
     * <b>CONTACT_INVALID_TELEPHONE_DIALLING_CODE:</b> When the telephone dialling code has been supplied in an invalid format (should start with a + e.g. +44 or +1)
     * <b>CONTACT_MISSING_FAX:</b> When the TLD represented by a domain contact requires a fax number to be supplied and it is blank.
     * <b>CONTACT_INVALID_FAX:</b> When an invalid fax number is supplied for a domain contact (i.e. should be a local number without spaces).
     * <b>CONTACT_MISSING_FAX_DIALLING_CODE:</b> When a blank fax dialling code is supplied for a domain contact when a fax number has also been supplied.
     * <b>CONTACT_INVALID_FAX_DIALLING_CODE:</b> When the fax dialling code has been supplied in an invalid format (should start with a + e.g. +44 or +1)
     * <br>
     * The following Validation error codes can occur for Contact operations on UK Nominet Domains.
     * <b>CONTACT_MISSING_NOMINETREGISTRANTTYPE:</b> When a blank value has been supplied for the additional Nominet Registrant Type field for a UK domain contact
     * <b>CONTACT_INVALID_NOMINETREGISTRANTTYPE:</b> When an invalid value has been supplied for the additional Nominet Registrant Type field for a UK domain contact (should be one of LTD,PLC,PTNR,STRA,LLP,IP,IND,SCH,RCHAR,GOV,CRC,STAT,OTHER).
     *<b>CONTACT_MISSING_NOMINETCOMPANYNUMBER:</b> When a blank value has been supplied for the additional Nominet Company Number field for a UK domain contact when it is required (in the cases that the Registrant Type is LTD, PLC, LLP, IP, SCH or RCHAR).
     * <br>
     * The following Validation error codes can occur for Domain Glue Record operations.
     * <b>GLUE_RECORD_MISSING_SUBDOMAIN:</b> When no subdomain (prefix) is supplied for a Domain Glue Record.
     * <b>GLUE_RECORD_INVALID_SUBDOMAIN:</b> When an invalid subdomain (prefix) has been supplied for a Domain Glue Record.
     * <b>GLUE_RECORD_MISSING_IP_ADDRESS:</b> When no IP address (either IPv4 or IPv6) has been supplied for a Domain Glue Record.
     * <b>GLUE_RECORD_INVALID_IPV4_ADDRESS:</b> When an invalid IPv4 address has been supplied for a Domain Glue Record.
     * <b>GLUE_RECORD_INVALID_IPV6_ADDRESS:</b> When an invalid IPv6 address has been supplied for a Domain Glue Record.
     */
    protected String code;
    /**
     * An accompanying message for display if required for this error.
     */
    protected String message;
    /**
     * An associative array of additional info if relevant for this error
     */
    protected Map<String,Object> additionalInfo;
    /**
     * Any associated errors mostly in the validation case.
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
     * @return type
     */
    public String getType(){
        return this.type;
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
     * Get the message
     *
     * @return message
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Get the additionalInfo
     *
     * @return additionalInfo
     */
    public Map<String,Object> getAdditionalInfo(){
        return this.additionalInfo;
    }

    /**
     * Get the relatedErrors
     *
     * @return relatedErrors
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