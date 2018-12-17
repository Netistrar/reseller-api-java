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
    * Blank Constructor
    *
    */
    public DomainNameRenewDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param domainNames
    * @param additionalYears
    */
    public DomainNameRenewDescriptor(String[] domainNames, Integer additionalYears){

        this.domainNames = domainNames;
        this.additionalYears = additionalYears;
        
    }


    /**
     * Get the domainNames
     *
     * @return
     */
    public String[] getDomainNames(){
        return this.domainNames;
    }

    /**
     * Set the domainNames
     *
     * @param domainNames
     * @return
     */
    public DomainNameRenewDescriptor setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
        return this;
    }

    /**
     * Get the additionalYears
     *
     * @return
     */
    public Integer getAdditionalYears(){
        return this.additionalYears;
    }

    /**
     * Set the additionalYears
     *
     * @param additionalYears
     * @return
     */
    public DomainNameRenewDescriptor setAdditionalYears(Integer additionalYears){
        this.additionalYears = additionalYears;
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

        return equals;
    }


}