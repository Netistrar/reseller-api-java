package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;


/**
 * Descriptor for a domain name create operation.  This should be passed to validate and create transfer operations on the Domains API.
 *
 */
public class DomainNameTransferDescriptor  {

    /**
     */
    private String[] transferIdentifiers;

    /**
     */
    private DomainNameContact ownerContact;

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
    public DomainNameTransferDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param String[] $transferIdentifiers
    * @param DomainNameContact $ownerContact
    * @param DomainNameContact $adminContact
    * @param DomainNameContact $billingContact
    * @param DomainNameContact $technicalContact
    * @param Integer $privacyProxy
    * @param Boolean $autoRenew
    */
    public DomainNameTransferDescriptor(String[] transferIdentifiers, DomainNameContact ownerContact, DomainNameContact adminContact, DomainNameContact billingContact, DomainNameContact technicalContact, Integer privacyProxy, Boolean autoRenew){

        this.transferIdentifiers = transferIdentifiers;
        this.ownerContact = ownerContact;
        this.adminContact = adminContact;
        this.billingContact = billingContact;
        this.technicalContact = technicalContact;
        this.privacyProxy = privacyProxy;
        this.autoRenew = autoRenew;
        
    }


    /**
     * Get the transferIdentifiers
     *
     * @return String[]
     */
    public String[] getTransferIdentifiers(){
        return this.transferIdentifiers;
    }

    /**
     * Set the transferIdentifiers
     *
     * @param String[] $transferIdentifiers
     */
    public void setTransferIdentifiers(String[] transferIdentifiers){
        this.transferIdentifiers = transferIdentifiers;
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

        if (!(otherObject instanceof DomainNameTransferDescriptor))
            return false;

        DomainNameTransferDescriptor castObject = (DomainNameTransferDescriptor)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getTransferIdentifiers() == null && castObject.getTransferIdentifiers() == null) ||
            (this.getTransferIdentifiers() != null && this.getTransferIdentifiers().equals(castObject.getTransferIdentifiers())));
        equals = equals && ( (this.getOwnerContact() == null && castObject.getOwnerContact() == null) ||
            (this.getOwnerContact() != null && this.getOwnerContact().equals(castObject.getOwnerContact())));
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