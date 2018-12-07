package netistrar.clientapi.objects.domain;

import java.util.Map;

/**
 * Domain name summary object
*/
public class DomainNameSummary  {


    /**
     * The owner of this domain name
     */
    protected String ownerName;
    /**
     * The full domain name as a string
     */
    protected String domainName;
    /**
     * The date of registration for this domain name if known.  NB:  This may not always be populated when domains have been transferred from elsewhere.
     */
    protected String registeredDate;
    /**
     * The expiry date for this domain name.
     */
    protected String expiryDate;
    /**
     * An indicator as to whether or not this domain name is currently locked.  Locking a domain provides an extra level of security as it prevents it from being either deleted or transferred until the lock is removed.
     * <br><br>
     * When unlocked the <a href="#authCode">authCode</a> field will be populated with the authorisation code required to move this domain to another provider.
     * <br><br>
     * Some operations (e.g. new registration, transfer) result in a mandatory lock of a domain for a period of time.  In this case the <a href="#lockedUntil">lockedUntil</a> field will be populated with a date after which the domain will be available for unlocking.
     */
    protected Boolean locked;
    /**
     * A date after which the mandatory lock period for this domain name will cease.  This is used in conjunction with the <a href="#locked">locked</a> field in the case that a mandatory lock has been applied to this domain following an operation (e.g. new registration, transfer).
     */
    protected String lockedUntil;
    /**
     * The authorisation code required for most domain transfers (notable exceptions are .UK domains and some other country TLDs).  This is only available when this domain is unlocked (i.e. the <a href="#locked">locked</a> member is true).
     * If the domain is locked this will be set to <b>N/A</b>.
     */
    protected String authCode;
    /**
     * An indicator as to whether or not an attempt will be made to auto renew this domain.  If this is set to true an attempt will be made around 30 days prior to the expiry date to renew the domain using any available payment
     * methods defined within your account in the Netistrar Control Panel.
     */
    protected Boolean autoRenew;
    /**
     * An indicator as to whether or not the free Netistrar Privacy Proxy service is being used for this domain.  If set to true, standard Netistrar privacy contacts will be transmitted to the domain registry for display in Public WHOIS
     * in lieu of the true contact details which will still be held on the Netistrar side.
     */
    protected Integer privacyProxy;
    /**
     * One of the following status values representing the current Netistrar Domain Name status for this domain name.
     * <b>ACTIVE</b> - The domain name is active and in use.
     * <b>EXPIRED</b> - The domain name has expired.
     * <b>SUSPENDED</b> - The domain name has been suspended (either for unlawful behaviour or invalid ownership details).
     * <b>RGP</b> - The domain has entered the Redemption Grace Period (usually around 45 days after expiry).  During this period additional costs are incurred to redeem the domain.
     * <b>DELETED</b> - The domain has dropped completely and has been deleted (usually around 75 days after expiry once the RGP has completed).
     * <b>TRANSFER_IN_PENDING_CONFIRMATION</b> - The domain is being transferred in and is awaiting confirmation from the legal owner.
     * <b>TRANSFER_IN_OWNER_DECLINED</b> - The domain is being transferred in but the legal owner declined the transfer.
     * <b>TRANSFER_IN_AWAITING_RESPONSE</b> - The domain transfer in operation has been started and is awaiting a response from the current Registrar.  If no response is received after 5 days the transfer would simply complete.
     * <b>TRANSFER_IN_REJECTED</b> - The domain transfer in operation has been rejected by the current Registrar.
     * <b>TRANSFER_OUT_PENDING_CONFIRMATION</b> - The domain has been requested to be transferred out and is awaiting confirmation from the legal owner.
     */
    protected String status;
    /**
     * An array of tags which have been added to this domain for organisational purposes.
     */
    protected String[] tags;
    /**
     */
    protected String dnsProvider;
    /**
     */
    protected String emailProvider;



    /**
    * Blank Constructor
    *
    */
    public DomainNameSummary(){
    }



    /**
     * Get the ownerName
     *
     * @return String
     */
    public String getOwnerName(){
        return this.ownerName;
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
     * Get the registeredDate
     *
     * @return String
     */
    public String getRegisteredDate(){
        return this.registeredDate;
    }

    /**
     * Get the expiryDate
     *
     * @return String
     */
    public String getExpiryDate(){
        return this.expiryDate;
    }

    /**
     * Get the locked
     *
     * @return Boolean
     */
    public Boolean getLocked(){
        return this.locked;
    }

    /**
     * Get the lockedUntil
     *
     * @return String
     */
    public String getLockedUntil(){
        return this.lockedUntil;
    }

    /**
     * Get the authCode
     *
     * @return String
     */
    public String getAuthCode(){
        return this.authCode;
    }

    /**
     * Get the autoRenew
     *
     * @return Boolean
     */
    public Boolean getAutoRenew(){
        return this.autoRenew;
    }

    /**
     * Get the privacyProxy
     *
     * @return Integer
     */
    public Integer getPrivacyProxy(){
        return this.privacyProxy;
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
     * Get the tags
     *
     * @return String[]
     */
    public String[] getTags(){
        return this.tags;
    }

    /**
     * Get the dnsProvider
     *
     * @return String
     */
    public String getDnsProvider(){
        return this.dnsProvider;
    }

    /**
     * Get the emailProvider
     *
     * @return String
     */
    public String getEmailProvider(){
        return this.emailProvider;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameSummary))
            return false;

        DomainNameSummary castObject = (DomainNameSummary)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getOwnerName() == null && castObject.getOwnerName() == null) ||
            (this.getOwnerName() != null && this.getOwnerName().equals(castObject.getOwnerName())));
        equals = equals && ( (this.getDomainName() == null && castObject.getDomainName() == null) ||
            (this.getDomainName() != null && this.getDomainName().equals(castObject.getDomainName())));
        equals = equals && ( (this.getRegisteredDate() == null && castObject.getRegisteredDate() == null) ||
            (this.getRegisteredDate() != null && this.getRegisteredDate().equals(castObject.getRegisteredDate())));
        equals = equals && ( (this.getExpiryDate() == null && castObject.getExpiryDate() == null) ||
            (this.getExpiryDate() != null && this.getExpiryDate().equals(castObject.getExpiryDate())));
        equals = equals && ( (this.getLocked() == null && castObject.getLocked() == null) ||
            (this.getLocked() != null && this.getLocked().equals(castObject.getLocked())));
        equals = equals && ( (this.getLockedUntil() == null && castObject.getLockedUntil() == null) ||
            (this.getLockedUntil() != null && this.getLockedUntil().equals(castObject.getLockedUntil())));
        equals = equals && ( (this.getAuthCode() == null && castObject.getAuthCode() == null) ||
            (this.getAuthCode() != null && this.getAuthCode().equals(castObject.getAuthCode())));
        equals = equals && ( (this.getAutoRenew() == null && castObject.getAutoRenew() == null) ||
            (this.getAutoRenew() != null && this.getAutoRenew().equals(castObject.getAutoRenew())));
        equals = equals && ( (this.getPrivacyProxy() == null && castObject.getPrivacyProxy() == null) ||
            (this.getPrivacyProxy() != null && this.getPrivacyProxy().equals(castObject.getPrivacyProxy())));
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getTags() == null && castObject.getTags() == null) ||
            (this.getTags() != null && this.getTags().equals(castObject.getTags())));
        equals = equals && ( (this.getDnsProvider() == null && castObject.getDnsProvider() == null) ||
            (this.getDnsProvider() != null && this.getDnsProvider().equals(castObject.getDnsProvider())));
        equals = equals && ( (this.getEmailProvider() == null && castObject.getEmailProvider() == null) ||
            (this.getEmailProvider() != null && this.getEmailProvider().equals(castObject.getEmailProvider())));

        return equals;
    }


}