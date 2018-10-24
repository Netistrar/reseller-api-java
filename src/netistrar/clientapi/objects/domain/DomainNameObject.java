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
    protected Boolean privacyProxy;

    /**
     */
    protected String status;

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
     * @return Boolean
     */
    public Boolean getPrivacyProxy(){
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


}