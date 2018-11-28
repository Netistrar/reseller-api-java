package netistrar.clientapi.objects.domain.descriptor;

import java.util.Map;


/**
 * Descriptor for a domain name renew operation.  This should be passed to the renew operation on the Domains API.
 *
 */
public class DomainNameRenewDescriptor  {

    /**
     */
    private String[] domainNames;

    /**
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
    * @param String[] $domainNames
    * @param Integer $additionalYears
    */
    public DomainNameRenewDescriptor(String[] domainNames, Integer additionalYears){

        this.domainNames = domainNames;
        this.additionalYears = additionalYears;
        
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
     * Get the additionalYears
     *
     * @return Integer
     */
    public Integer getAdditionalYears(){
        return this.additionalYears;
    }

    /**
     * Set the additionalYears
     *
     * @param Integer $additionalYears
     */
    public void setAdditionalYears(Integer additionalYears){
        this.additionalYears = additionalYears;
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