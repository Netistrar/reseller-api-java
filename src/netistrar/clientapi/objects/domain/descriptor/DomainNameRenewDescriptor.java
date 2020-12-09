package netistrar.clientapi.objects.domain.descriptor;

import java.util.Map;

/**
 * Descriptor for a domain name renew operation.  This should be passed to the renew operation on the Domains API.
*/
public class DomainNameRenewDescriptor  {


    /**
     * the array of domain names to be renewed.
     */
    private String[] domainNames;
    /**
     * The number of years to be added to the supplied domain names
     */
    private Integer additionalYears;
    /**
     * An associative array of renewal codes indexed by domain name which must be supplied as a confirmation check for any domain names which are premium names.  These codes are obtained via a call to the <b>getLiveAvailability</b> function on the <a href="api:domains-api">Domain API</a> where it will be contained in the <b>premiumRenewalCode</b> sub property of the <b>additionalData</b> member on the returned <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainAvailability">DomainAvailability</a> object.
     */
    private Map<String,String> premiumRenewalCodes;



    /**
    * Blank Constructor
    *
    */
    public DomainNameRenewDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param domainNames the domainNames
    * @param additionalYears the additionalYears
    * @param premiumRenewalCodes the premiumRenewalCodes
    */
    public DomainNameRenewDescriptor(String[] domainNames, Integer additionalYears, Map<String,String> premiumRenewalCodes){

        this.domainNames = domainNames;
        this.additionalYears = additionalYears;
        this.premiumRenewalCodes = premiumRenewalCodes;
        
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
     * @return DomainNameRenewDescriptor
     */
    public DomainNameRenewDescriptor setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
        return this;
    }

    /**
     * Get the additionalYears
     *
     * @return additionalYears
     */
    public Integer getAdditionalYears(){
        return this.additionalYears;
    }

    /**
     * Set the additionalYears
     *
     * @param additionalYears the additionalYears
     * @return DomainNameRenewDescriptor
     */
    public DomainNameRenewDescriptor setAdditionalYears(Integer additionalYears){
        this.additionalYears = additionalYears;
        return this;
    }

    /**
     * Get the premiumRenewalCodes
     *
     * @return premiumRenewalCodes
     */
    public Map<String,String> getPremiumRenewalCodes(){
        return this.premiumRenewalCodes;
    }

    /**
     * Set the premiumRenewalCodes
     *
     * @param premiumRenewalCodes the premiumRenewalCodes
     * @return DomainNameRenewDescriptor
     */
    public DomainNameRenewDescriptor setPremiumRenewalCodes(Map<String,String> premiumRenewalCodes){
        this.premiumRenewalCodes = premiumRenewalCodes;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameRenewDescriptor))
            return false;

        DomainNameRenewDescriptor castObject = (DomainNameRenewDescriptor)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainNames() == null && castObject.getDomainNames() == null) ||
            (this.getDomainNames() != null && this.getDomainNames().equals(castObject.getDomainNames())));
        equals = equals && ( (this.getAdditionalYears() == null && castObject.getAdditionalYears() == null) ||
            (this.getAdditionalYears() != null && this.getAdditionalYears().equals(castObject.getAdditionalYears())));
        equals = equals && ( (this.getPremiumRenewalCodes() == null && castObject.getPremiumRenewalCodes() == null) ||
            (this.getPremiumRenewalCodes() != null && this.getPremiumRenewalCodes().equals(castObject.getPremiumRenewalCodes())));

        return equals;
    }


}