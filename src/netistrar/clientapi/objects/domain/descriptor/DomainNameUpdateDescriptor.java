package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.DomainNameContact;
import java.util.Map;


/**
 * Descriptor for a domain name update operation.  This should be passed to the update operation on the Domains API.
 *
 */
public class DomainNameUpdateDescriptor  {

    /**
     */
    private String[] domainNames;

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
    private String[] nameservers;

    /**
     */
    private Boolean locked;

    /**
     */
    private Integer privacyProxy;

    /**
     */
    private Boolean autoRenew;

    /**
     */
    private String[] addTags;

    /**
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
    * @param String[] $domainNames
    * @param DomainNameContact $ownerContact
    * @param DomainNameContact $adminContact
    * @param DomainNameContact $billingContact
    * @param DomainNameContact $technicalContact
    * @param String[] $nameservers
    * @param Boolean $locked
    * @param Integer $privacyProxy
    * @param Boolean $autoRenew
    * @param String[] $addTags
    * @param String[] $removeTags
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
     * Get the locked
     *
     * @return Boolean
     */
    public Boolean getLocked(){
        return this.locked;
    }

    /**
     * Set the locked
     *
     * @param Boolean $locked
     */
    public void setLocked(Boolean locked){
        this.locked = locked;
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
     * Get the addTags
     *
     * @return String[]
     */
    public String[] getAddTags(){
        return this.addTags;
    }

    /**
     * Set the addTags
     *
     * @param String[] $addTags
     */
    public void setAddTags(String[] addTags){
        this.addTags = addTags;
    }

    /**
     * Get the removeTags
     *
     * @return String[]
     */
    public String[] getRemoveTags(){
        return this.removeTags;
    }

    /**
     * Set the removeTags
     *
     * @param String[] $removeTags
     */
    public void setRemoveTags(String[] removeTags){
        this.removeTags = removeTags;
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