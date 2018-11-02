package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainAvailabilityPrice;
import java.util.Map;


/**
 * Domain availability class.
 *
 */
public class DomainAvailability  {

    /**
     */
    protected String domainName;

    /**
     */
    protected String availability;

    /**
     */
    protected String pricingType;

    /**
     */
    protected Map<String,Map<Integer,DomainAvailabilityPrice>> prices;

    /**
     */
    protected Map<String,Object> additionalData;




    /**
    * Blank Constructor
    *
    */
    public DomainAvailability(){
    }



    /**
     * Get the domainName
     *
     * @return String
     */
    public String getDomainName(){
        return this.domainName;
    }

    /**
     * Get the availability
     *
     * @return String
     */
    public String getAvailability(){
        return this.availability;
    }

    /**
     * Get the pricingType
     *
     * @return String
     */
    public String getPricingType(){
        return this.pricingType;
    }

    /**
     * Get the prices
     *
     * @return Map<String,Map<Integer,DomainAvailabilityPrice>>
     */
    public Map<String,Map<Integer,DomainAvailabilityPrice>> getPrices(){
        return this.prices;
    }

    /**
     * Get the additionalData
     *
     * @return Map<String,Object>
     */
    public Map<String,Object> getAdditionalData(){
        return this.additionalData;
    }


}