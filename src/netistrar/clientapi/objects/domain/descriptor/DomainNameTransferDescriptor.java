package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;

/**
 * Descriptor for a domain name create operation.  This should be passed to validate and create transfer operations on the Domains API.
*/
public class DomainNameTransferDescriptor  {


    /**
     * An array of identifier entries for transfer in.
     * In the case of GTLDs the entry should be in the format <b>domain name,auth code</b>
     * For .UK and other non-auth code TLDs this should simply be the domain name.
     */
    private String[] transferIdentifiers;
    /**
     * The details for the owner contact (sometimes called the Registrant)
     */
    private DomainNameContact ownerContact;
    /**
     * The details for the admin contact for these domains (required for some TLDs).  If this is required but not supplied it will use the Default Admin contact details specified in the Netistrar control panel under My Account -> API settings or will generate a Validation Error if these are not defined.
     */
    private DomainNameContact adminContact;
    /**
     * The details for the billing contact for these domains (required for some TLDs).  If this is required but not supplied it will use the Default Billing contact details specified in the Netistrar control panel under My Account -> API settings or will generate a Validation Error if these are not defined.
     */
    private DomainNameContact billingContact;
    /**
     * The details for the technical contact for these domains (required for some TLDs).  If this is required but not supplied it will use the Default Billing contact details specified in the Netistrar control panel under My Account -> API settings or will generate a Validation Error if these are not defined.
     */
    private DomainNameContact technicalContact;
    /**
     * This should be set to one of the following values: <br><br><b>0</b> If limited details are to be published via the WHOIS system for all supplied domains according to Registry policy.<br><b>1</b> if the free Netistrar Privacy Proxy service will be used for all supplied domains.
     */
    private Integer privacyProxy;
    /**
     * A boolean indicator as to whether the an attempt will be made to auto renew this domain using account payment methods (defaults to 0)
     */
    private Boolean autoRenew;
    /**
     * An associative array of transfer codes indexed by domain name which must be supplied as a confirmation check for any domain names which are premium names.  These codes are obtained via a call to the <b>getLiveAvailability</b> function on the <a href="api:domains-api">Domain API</a> where it will be contained in the <b>premiumTransferCode</b> sub property of the <b>additionalData</b> member on the returned <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainAvailability">DomainAvailability</a> object.
     */
    private Map<String,String> premiumTransferCodes;



    /**
    * Blank Constructor
    *
    */
    public DomainNameTransferDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param transferIdentifiers the transferIdentifiers
    * @param ownerContact the ownerContact
    * @param adminContact the adminContact
    * @param billingContact the billingContact
    * @param technicalContact the technicalContact
    * @param privacyProxy the privacyProxy
    * @param autoRenew the autoRenew
    * @param premiumTransferCodes the premiumTransferCodes
    */
    public DomainNameTransferDescriptor(String[] transferIdentifiers, DomainNameContact ownerContact, DomainNameContact adminContact, DomainNameContact billingContact, DomainNameContact technicalContact, Integer privacyProxy, Boolean autoRenew, Map<String,String> premiumTransferCodes){

        this.transferIdentifiers = transferIdentifiers;
        this.ownerContact = ownerContact;
        this.adminContact = adminContact;
        this.billingContact = billingContact;
        this.technicalContact = technicalContact;
        this.privacyProxy = privacyProxy;
        this.autoRenew = autoRenew;
        this.premiumTransferCodes = premiumTransferCodes;
        
    }


    /**
     * Get the transferIdentifiers
     *
     * @return transferIdentifiers
     */
    public String[] getTransferIdentifiers(){
        return this.transferIdentifiers;
    }

    /**
     * Set the transferIdentifiers
     *
     * @param transferIdentifiers the transferIdentifiers
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setTransferIdentifiers(String[] transferIdentifiers){
        this.transferIdentifiers = transferIdentifiers;
        return this;
    }

    /**
     * Get the ownerContact
     *
     * @return ownerContact
     */
    public DomainNameContact getOwnerContact(){
        return this.ownerContact;
    }

    /**
     * Set the ownerContact
     *
     * @param ownerContact the ownerContact
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setOwnerContact(DomainNameContact ownerContact){
        this.ownerContact = ownerContact;
        return this;
    }

    /**
     * Get the adminContact
     *
     * @return adminContact
     */
    public DomainNameContact getAdminContact(){
        return this.adminContact;
    }

    /**
     * Set the adminContact
     *
     * @param adminContact the adminContact
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setAdminContact(DomainNameContact adminContact){
        this.adminContact = adminContact;
        return this;
    }

    /**
     * Get the billingContact
     *
     * @return billingContact
     */
    public DomainNameContact getBillingContact(){
        return this.billingContact;
    }

    /**
     * Set the billingContact
     *
     * @param billingContact the billingContact
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setBillingContact(DomainNameContact billingContact){
        this.billingContact = billingContact;
        return this;
    }

    /**
     * Get the technicalContact
     *
     * @return technicalContact
     */
    public DomainNameContact getTechnicalContact(){
        return this.technicalContact;
    }

    /**
     * Set the technicalContact
     *
     * @param technicalContact the technicalContact
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setTechnicalContact(DomainNameContact technicalContact){
        this.technicalContact = technicalContact;
        return this;
    }

    /**
     * Get the privacyProxy
     *
     * @return privacyProxy
     */
    public Integer getPrivacyProxy(){
        return this.privacyProxy;
    }

    /**
     * Set the privacyProxy
     *
     * @param privacyProxy the privacyProxy
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setPrivacyProxy(Integer privacyProxy){
        this.privacyProxy = privacyProxy;
        return this;
    }

    /**
     * Get the autoRenew
     *
     * @return autoRenew
     */
    public Boolean getAutoRenew(){
        return this.autoRenew;
    }

    /**
     * Set the autoRenew
     *
     * @param autoRenew the autoRenew
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setAutoRenew(Boolean autoRenew){
        this.autoRenew = autoRenew;
        return this;
    }

    /**
     * Get the premiumTransferCodes
     *
     * @return premiumTransferCodes
     */
    public Map<String,String> getPremiumTransferCodes(){
        return this.premiumTransferCodes;
    }

    /**
     * Set the premiumTransferCodes
     *
     * @param premiumTransferCodes the premiumTransferCodes
     * @return DomainNameTransferDescriptor
     */
    public DomainNameTransferDescriptor setPremiumTransferCodes(Map<String,String> premiumTransferCodes){
        this.premiumTransferCodes = premiumTransferCodes;
        return this;
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
        equals = equals && ( (this.getPremiumTransferCodes() == null && castObject.getPremiumTransferCodes() == null) ||
            (this.getPremiumTransferCodes() != null && this.getPremiumTransferCodes().equals(castObject.getPremiumTransferCodes())));

        return equals;
    }


}