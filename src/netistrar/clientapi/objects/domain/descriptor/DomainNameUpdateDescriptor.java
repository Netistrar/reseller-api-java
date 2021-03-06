package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;

/**
 * Descriptor for a domain name update operation.  This should be passed to the update operation on the Domains API.
*/
public class DomainNameUpdateDescriptor  {


    /**
     * the array of domain names to be updated.
     */
    private String[] domainNames;
    /**
     * A new owner contact to apply to all supplied domains.  If this is supplied as null, no owner contact update will be performed.<br><br><b>NB: </b> Key changes to owner details for GTLDs will trigger a verification email to the owner of the domain before these changes will be applied. Once approved by the owner a 60 day transfer lock will be placed on the domain.  If a verification has been triggered, it will be noted in the Transaction Element operation data for the update.  Please see extra documentation in the <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainNameContact">DomainNameContact</a> object definition.
     */
    private DomainNameContact ownerContact;
    /**
     * A new admin contact to apply to all supplied domains.  If this is supplied as null, no admin contact update will be performed.
     */
    private DomainNameContact adminContact;
    /**
     * A new admin contact to apply to all supplied domains.  If this is supplied as null, no billing contact update will be performed.
     */
    private DomainNameContact billingContact;
    /**
     * A new admin contact to apply to all supplied domains.  If this is supplied as null, no technical contact update will be performed.
     */
    private DomainNameContact technicalContact;
    /**
     * The array of nameservers to apply to the supplied domain names.  If this is supplied as null, no nameserver update will be performed.
     */
    private String[] nameservers;
    /**
     *  When set to 1 or 0 this will set / unset respectively the locked status for all passed domains.  If left unset no change will be made to the locked status for the domains.<br><br><b>NB:</b>It may not always be possible to unlock a domain if a mandatory lock has been applied such as after a create / transfer operation.
     */
    private Boolean locked;
    /**
     * This should be set to one of the following values: <br><br><b>0</b> If limited details are to be published via the WHOIS system for all supplied domains according to Registry policy.<br><b>1</b> if the free Netistrar Privacy Proxy service will be used for all supplied domains.
     */
    private Integer privacyProxy;
    /**
     * A boolean indicator as to whether the an attempt will be made to auto renew this domain using account payment methods (defaults to 0)
     */
    private Boolean autoRenew;
    /**
     * An array of tags to add to the supplied domain names for organisational purposes.
     */
    private String[] addTags;
    /**
     * An array of tags to remove from the supplied domain names for organisational purposes.
     */
    private String[] removeTags;



    /**
    * Blank Constructor
    *
    */
    public DomainNameUpdateDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param domainNames the domainNames
    * @param ownerContact the ownerContact
    * @param adminContact the adminContact
    * @param billingContact the billingContact
    * @param technicalContact the technicalContact
    * @param nameservers the nameservers
    * @param locked the locked
    * @param privacyProxy the privacyProxy
    * @param autoRenew the autoRenew
    * @param addTags the addTags
    * @param removeTags the removeTags
    */
    public DomainNameUpdateDescriptor(String[] domainNames, DomainNameContact ownerContact, DomainNameContact adminContact, DomainNameContact billingContact, DomainNameContact technicalContact, String[] nameservers, Boolean locked, Integer privacyProxy, Boolean autoRenew, String[] addTags, String[] removeTags){

        this.domainNames = domainNames;
        this.ownerContact = ownerContact;
        this.adminContact = adminContact;
        this.billingContact = billingContact;
        this.technicalContact = technicalContact;
        this.nameservers = nameservers;
        this.locked = locked;
        this.privacyProxy = privacyProxy;
        this.autoRenew = autoRenew;
        this.addTags = addTags;
        this.removeTags = removeTags;
        
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setOwnerContact(DomainNameContact ownerContact){
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setAdminContact(DomainNameContact adminContact){
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setBillingContact(DomainNameContact billingContact){
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setTechnicalContact(DomainNameContact technicalContact){
        this.technicalContact = technicalContact;
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setNameservers(String[] nameservers){
        this.nameservers = nameservers;
        return this;
    }

    /**
     * Get the locked
     *
     * @return locked
     */
    public Boolean getLocked(){
        return this.locked;
    }

    /**
     * Set the locked
     *
     * @param locked the locked
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setLocked(Boolean locked){
        this.locked = locked;
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setPrivacyProxy(Integer privacyProxy){
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
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setAutoRenew(Boolean autoRenew){
        this.autoRenew = autoRenew;
        return this;
    }

    /**
     * Get the addTags
     *
     * @return addTags
     */
    public String[] getAddTags(){
        return this.addTags;
    }

    /**
     * Set the addTags
     *
     * @param addTags the addTags
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setAddTags(String[] addTags){
        this.addTags = addTags;
        return this;
    }

    /**
     * Get the removeTags
     *
     * @return removeTags
     */
    public String[] getRemoveTags(){
        return this.removeTags;
    }

    /**
     * Set the removeTags
     *
     * @param removeTags the removeTags
     * @return DomainNameUpdateDescriptor
     */
    public DomainNameUpdateDescriptor setRemoveTags(String[] removeTags){
        this.removeTags = removeTags;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameUpdateDescriptor))
            return false;

        DomainNameUpdateDescriptor castObject = (DomainNameUpdateDescriptor)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainNames() == null && castObject.getDomainNames() == null) ||
            (this.getDomainNames() != null && this.getDomainNames().equals(castObject.getDomainNames())));
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
        equals = equals && ( (this.getLocked() == null && castObject.getLocked() == null) ||
            (this.getLocked() != null && this.getLocked().equals(castObject.getLocked())));
        equals = equals && ( (this.getPrivacyProxy() == null && castObject.getPrivacyProxy() == null) ||
            (this.getPrivacyProxy() != null && this.getPrivacyProxy().equals(castObject.getPrivacyProxy())));
        equals = equals && ( (this.getAutoRenew() == null && castObject.getAutoRenew() == null) ||
            (this.getAutoRenew() != null && this.getAutoRenew().equals(castObject.getAutoRenew())));
        equals = equals && ( (this.getAddTags() == null && castObject.getAddTags() == null) ||
            (this.getAddTags() != null && this.getAddTags().equals(castObject.getAddTags())));
        equals = equals && ( (this.getRemoveTags() == null && castObject.getRemoveTags() == null) ||
            (this.getRemoveTags() != null && this.getRemoveTags().equals(castObject.getRemoveTags())));

        return equals;
    }


}