package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;

/**
 * Descriptor for a domain name create operation.  This should be passed to validate and create operations on the Domains API.
*/
public class DomainNameCreateDescriptor  {


    /**
     * the array of domain names to be created.
     */
    private String[] domainNames;
    /**
     * The number of years for which these domain names will be created.
     */
    private Integer registrationYears;
    /**
     * The details for the owner contact (sometimes called the Registrant)
     */
    private DomainNameContact ownerContact;
    /**
     * An array of nameserver string to set for this domain name on creation.
     */
    private String[] nameservers;
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
     */
    private Map<String,bool> disclosedFields;
    /**
     * A boolean indicator as to whether the an attempt will be made to auto renew this domain using account payment methods (defaults to 0)
     */
    private Boolean autoRenew;
    /**
     * An array of string tags to assign to this domain for organisational purposes.
     */
    private String[] tags;
    /**
     * An associative array of registration codes indexed by domain name which must be supplied as a confirmation check for any domain names which are premium names.  These codes are obtained via a call to the <b>getLiveAvailability</b> function on the <a href="api:domains-api">Domain API</a> where it will be contained in the <b>premiumRegistrationCode</b> sub property of the <b>additionalData</b> member on the returned <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainAvailability">DomainAvailability</a> object.
     */
    private Map<String,String> premiumRegistrationCodes;



    /**
    * Blank Constructor
    *
    */
    public DomainNameCreateDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param domainNames the domainNames
    * @param registrationYears the registrationYears
    * @param ownerContact the ownerContact
    * @param nameservers the nameservers
    * @param adminContact the adminContact
    * @param billingContact the billingContact
    * @param technicalContact the technicalContact
    * @param privacyProxy the privacyProxy
    * @param disclosedFields the disclosedFields
    * @param autoRenew the autoRenew
    * @param tags the tags
    * @param premiumRegistrationCodes the premiumRegistrationCodes
    */
    public DomainNameCreateDescriptor(String[] domainNames, Integer registrationYears, DomainNameContact ownerContact, String[] nameservers, DomainNameContact adminContact, DomainNameContact billingContact, DomainNameContact technicalContact, Integer privacyProxy, Map<String,bool> disclosedFields, Boolean autoRenew, String[] tags, Map<String,String> premiumRegistrationCodes){

        this.domainNames = domainNames;
        this.registrationYears = registrationYears;
        this.ownerContact = ownerContact;
        this.nameservers = nameservers;
        this.adminContact = adminContact;
        this.billingContact = billingContact;
        this.technicalContact = technicalContact;
        this.privacyProxy = privacyProxy;
        this.disclosedFields = disclosedFields;
        this.autoRenew = autoRenew;
        this.tags = tags;
        this.premiumRegistrationCodes = premiumRegistrationCodes;
        
    }


    /**
     * Get the domainNames
     *
     * @return domainNames
     */
    public String[] getDomainNames(){
        return this.domainNames;
    }

    /**
     * Set the domainNames
     *
     * @param domainNames the domainNames
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
        return this;
    }

    /**
     * Get the registrationYears
     *
     * @return registrationYears
     */
    public Integer getRegistrationYears(){
        return this.registrationYears;
    }

    /**
     * Set the registrationYears
     *
     * @param registrationYears the registrationYears
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setRegistrationYears(Integer registrationYears){
        this.registrationYears = registrationYears;
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
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setOwnerContact(DomainNameContact ownerContact){
        this.ownerContact = ownerContact;
        return this;
    }

    /**
     * Get the nameservers
     *
     * @return nameservers
     */
    public String[] getNameservers(){
        return this.nameservers;
    }

    /**
     * Set the nameservers
     *
     * @param nameservers the nameservers
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setNameservers(String[] nameservers){
        this.nameservers = nameservers;
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
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setAdminContact(DomainNameContact adminContact){
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
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setBillingContact(DomainNameContact billingContact){
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
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setTechnicalContact(DomainNameContact technicalContact){
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
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setPrivacyProxy(Integer privacyProxy){
        this.privacyProxy = privacyProxy;
        return this;
    }

    /**
     * Get the disclosedFields
     *
     * @return disclosedFields
     */
    public Map<String,bool> getDisclosedFields(){
        return this.disclosedFields;
    }

    /**
     * Set the disclosedFields
     *
     * @param disclosedFields the disclosedFields
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setDisclosedFields(Map<String,bool> disclosedFields){
        this.disclosedFields = disclosedFields;
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
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setAutoRenew(Boolean autoRenew){
        this.autoRenew = autoRenew;
        return this;
    }

    /**
     * Get the tags
     *
     * @return tags
     */
    public String[] getTags(){
        return this.tags;
    }

    /**
     * Set the tags
     *
     * @param tags the tags
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setTags(String[] tags){
        this.tags = tags;
        return this;
    }

    /**
     * Get the premiumRegistrationCodes
     *
     * @return premiumRegistrationCodes
     */
    public Map<String,String> getPremiumRegistrationCodes(){
        return this.premiumRegistrationCodes;
    }

    /**
     * Set the premiumRegistrationCodes
     *
     * @param premiumRegistrationCodes the premiumRegistrationCodes
     * @return DomainNameCreateDescriptor
     */
    public DomainNameCreateDescriptor setPremiumRegistrationCodes(Map<String,String> premiumRegistrationCodes){
        this.premiumRegistrationCodes = premiumRegistrationCodes;
        return this;
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
        equals = equals && ( (this.getDisclosedFields() == null && castObject.getDisclosedFields() == null) ||
            (this.getDisclosedFields() != null && this.getDisclosedFields().equals(castObject.getDisclosedFields())));
        equals = equals && ( (this.getAutoRenew() == null && castObject.getAutoRenew() == null) ||
            (this.getAutoRenew() != null && this.getAutoRenew().equals(castObject.getAutoRenew())));
        equals = equals && ( (this.getTags() == null && castObject.getTags() == null) ||
            (this.getTags() != null && this.getTags().equals(castObject.getTags())));
        equals = equals && ( (this.getPremiumRegistrationCodes() == null && castObject.getPremiumRegistrationCodes() == null) ||
            (this.getPremiumRegistrationCodes() != null && this.getPremiumRegistrationCodes().equals(castObject.getPremiumRegistrationCodes())));

        return equals;
    }


}