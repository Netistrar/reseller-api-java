package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;


/**
 * Descriptor for a domain name create operation.  This should be passed to validate and create operations on the Domains API.
 *
 */
public class DomainNameCreateDescriptor  {

    /**
     */
    private String[] domainNames;

    /**
     */
    private Integer registrationYears;

    /**
     */
    private DomainNameContact ownerContact;

    /**
     */
    private String[] nameservers;

    /**
     */
    private DomainNameContact adminContact;

    /**
     */
    private DomainNameContact billingContact;

    /**
     */
    private DomainNameContact technicalContact;

    /**
     */
    private Integer privacyProxy;

    /**
     */
    private Boolean autoRenew;




    /**
    * Blank Constructor
    *
    */
    public DomainNameCreateDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param String[] $domainNames
    * @param Integer $registrationYears
    * @param DomainNameContact $ownerContact
    * @param String[] $nameservers
    * @param DomainNameContact $adminContact
    * @param DomainNameContact $billingContact
    * @param DomainNameContact $technicalContact
    * @param Integer $privacyProxy
    * @param Boolean $autoRenew
    */
    public DomainNameCreateDescriptor(String[] domainNames, Integer registrationYears, DomainNameContact ownerContact, String[] nameservers, DomainNameContact adminContact, DomainNameContact billingContact, DomainNameContact technicalContact, Integer privacyProxy, Boolean autoRenew){

        this.domainNames = domainNames;
        this.registrationYears = registrationYears;
        this.ownerContact = ownerContact;
        this.nameservers = nameservers;
        this.adminContact = adminContact;
        this.billingContact = billingContact;
        this.technicalContact = technicalContact;
        this.privacyProxy = privacyProxy;
        this.autoRenew = autoRenew;
        
    }


    /**
     * Get the domainNames
     *
     * @return String[]
     */
    public String[] getDomainNames(){
        return this.domainNames;
    }

    /**
     * Set the domainNames
     *
     * @param String[] $domainNames
     */
    public void setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
    }

    /**
     * Get the registrationYears
     *
     * @return Integer
     */
    public Integer getRegistrationYears(){
        return this.registrationYears;
    }

    /**
     * Set the registrationYears
     *
     * @param Integer $registrationYears
     */
    public void setRegistrationYears(Integer registrationYears){
        this.registrationYears = registrationYears;
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
     * Set the ownerContact
     *
     * @param DomainNameContact $ownerContact
     */
    public void setOwnerContact(DomainNameContact ownerContact){
        this.ownerContact = ownerContact;
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
     * Set the nameservers
     *
     * @param String[] $nameservers
     */
    public void setNameservers(String[] nameservers){
        this.nameservers = nameservers;
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
     * Set the adminContact
     *
     * @param DomainNameContact $adminContact
     */
    public void setAdminContact(DomainNameContact adminContact){
        this.adminContact = adminContact;
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
     * Set the billingContact
     *
     * @param DomainNameContact $billingContact
     */
    public void setBillingContact(DomainNameContact billingContact){
        this.billingContact = billingContact;
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
     * Set the technicalContact
     *
     * @param DomainNameContact $technicalContact
     */
    public void setTechnicalContact(DomainNameContact technicalContact){
        this.technicalContact = technicalContact;
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
     * Set the privacyProxy
     *
     * @param Integer $privacyProxy
     */
    public void setPrivacyProxy(Integer privacyProxy){
        this.privacyProxy = privacyProxy;
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
     * Set the autoRenew
     *
     * @param Boolean $autoRenew
     */
    public void setAutoRenew(Boolean autoRenew){
        this.autoRenew = autoRenew;
    }


}