package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;


/**
 * A value object used within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a> methods to capture all of the properties of a domain name including related
 * Contacts and Nameservers objects.
 *
 */
public class DomainNameObject  {

    /**
     */
    protected DomainNameContact ownerContact;

    /**
     */
    protected DomainNameContact adminContact;

    /**
     */
    protected DomainNameContact billingContact;

    /**
     */
    protected DomainNameContact technicalContact;

    /**
     */
    protected String[] nameservers;

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
    public DomainNameObject(){
    }



    /**
     * Get the ownerContact
     *
     * @return DomainNameContact
     */
    public DomainNameContact getOwnerContact(){
        return this.ownerContact;
    }

    /**
     * Get the adminContact
     *
     * @return DomainNameContact
     */
    public DomainNameContact getAdminContact(){
        return this.adminContact;
    }

    /**
     * Get the billingContact
     *
     * @return DomainNameContact
     */
    public DomainNameContact getBillingContact(){
        return this.billingContact;
    }

    /**
     * Get the technicalContact
     *
     * @return DomainNameContact
     */
    public DomainNameContact getTechnicalContact(){
        return this.technicalContact;
    }

    /**
     * Get the nameservers
     *
     * @return String[]
     */
    public String[] getNameservers(){
        return this.nameservers;
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

        if (!(otherObject instanceof DomainNameObject))
            return false;

        DomainNameObject castObject = (DomainNameObject)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getOwnerContact() == null && castObject.getOwnerContact() == null) ||
            (this.getOwnerContact() != null && this.getOwnerContact().equals(castObject.getOwnerContact())));
        equals = equals && ( (this.getAdminContact() == null && castObject.getAdminContact() == null) ||
            (this.getAdminContact() != null && this.getAdminContact().equals(castObject.getAdminContact())));
        equals = equals && ( (this.getBillingContact() == null && castObject.getBillingContact() == null) ||
            (this.getBillingContact() != null && this.getBillingContact().equals(castObject.getBillingContact())));
        equals = equals && ( (this.getTechnicalContact() == null && castObject.getTechnicalContact() == null) ||
            (this.getTechnicalContact() != null && this.getTechnicalContact().equals(castObject.getTechnicalContact())));
        equals = equals && ( (this.getNameservers() == null && castObject.getNameservers() == null) ||
            (this.getNameservers() != null && this.getNameservers().equals(castObject.getNameservers())));
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