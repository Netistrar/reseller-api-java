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



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameCreateDescriptor))
            return false;

        DomainNameCreateDescriptor castObject = (DomainNameCreateDescriptor)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainNames() == null && castObject.getDomainNames() == null) ||
            (this.getDomainNames() != null && this.getDomainNames().equals(castObject.getDomainNames())));
        equals = equals && ( (this.getRegistrationYears() == null && castObject.getRegistrationYears() == null) ||
            (this.getRegistrationYears() != null && this.getRegistrationYears().equals(castObject.getRegistrationYears())));
        equals = equals && ( (this.getOwnerContact() == null && castObject.getOwnerContact() == null) ||
            (this.getOwnerContact() != null && this.getOwnerContact().equals(castObject.getOwnerContact())));
        equals = equals && ( (this.getNameservers() == null && castObject.getNameservers() == null) ||
            (this.getNameservers() != null && this.getNameservers().equals(castObject.getNameservers())));
        equals = equals && ( (this.getAdminContact() == null && castObject.getAdminContact() == null) ||
            (this.getAdminContact() != null && this.getAdminContact().equals(castObject.getAdminContact())));
        equals = equals && ( (this.getBillingContact() == null && castObject.getBillingContact() == null) ||
            (this.getBillingContact() != null && this.getBillingContact().equals(castObject.getBillingContact())));
        equals = equals && ( (this.getTechnicalContact() == null && castObject.getTechnicalContact() == null) ||
            (this.getTechnicalContact() != null && this.getTechnicalContact().equals(castObject.getTechnicalContact())));
        equals = equals && ( (this.getPrivacyProxy() == null && castObject.getPrivacyProxy() == null) ||
            (this.getPrivacyProxy() != null && this.getPrivacyProxy().equals(castObject.getPrivacyProxy())));
        equals = equals && ( (this.getAutoRenew() == null && castObject.getAutoRenew() == null) ||
            (this.getAutoRenew() != null && this.getAutoRenew().equals(castObject.getAutoRenew())));

        return equals;
    }


}