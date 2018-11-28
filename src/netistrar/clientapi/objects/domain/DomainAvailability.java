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



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainAvailability))
            return false;

        DomainAvailability castObject = (DomainAvailability)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainName() == null && castObject.getDomainName() == null) ||
            (this.getDomainName() != null && this.getDomainName().equals(castObject.getDomainName())));
        equals = equals && ( (this.getAvailability() == null && castObject.getAvailability() == null) ||
            (this.getAvailability() != null && this.getAvailability().equals(castObject.getAvailability())));
        equals = equals && ( (this.getPricingType() == null && castObject.getPricingType() == null) ||
            (this.getPricingType() != null && this.getPricingType().equals(castObject.getPricingType())));
        equals = equals && ( (this.getPrices() == null && castObject.getPrices() == null) ||
            (this.getPrices() != null && this.getPrices().equals(castObject.getPrices())));
        equals = equals && ( (this.getAdditionalData() == null && castObject.getAdditionalData() == null) ||
            (this.getAdditionalData() != null && this.getAdditionalData().equals(castObject.getAdditionalData())));

        return equals;
    }


}