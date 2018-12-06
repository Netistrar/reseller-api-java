package netistrar.clientapi.objects.domain;

import java.util.Map;


/**
 *
 * Domain name summary object
 */
public class DomainNameSummary  {

    /**
     */
    protected String ownerName;

    /**
     */
    protected String domainName;

    /**
     */
    protected String registeredDate;

    /**
     */
    protected String expiryDate;

    /**
     */
    protected Boolean locked;

    /**
     */
    protected String lockedUntil;

    /**
     */
    protected String authCode;

    /**
     */
    protected Boolean autoRenew;

    /**
     */
    protected Integer privacyProxy;

    /**
     */
    protected String status;

    /**
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