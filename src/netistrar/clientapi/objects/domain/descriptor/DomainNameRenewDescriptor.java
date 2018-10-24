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


}