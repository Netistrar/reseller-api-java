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
    private Integer privacyProxy;




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
    * @param Integer $privacyProxy
    */
    public DomainNameUpdateDescriptor(String[] domainNames, DomainNameContact ownerContact, DomainNameContact adminContact, DomainNameContact billingContact, DomainNameContact technicalContact, String[] nameservers, Integer privacyProxy){

        this.domainNames = domainNames;
        this.ownerContact = ownerContact;
        this.adminContact = adminContact;
        this.billingContact = billingContact;
        this.technicalContact = technicalContact;
        this.nameservers = nameservers;
        this.privacyProxy = privacyProxy;
        
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


}