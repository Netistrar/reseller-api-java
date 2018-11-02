package netistrar.clientapi.objects.domain;

import java.util.Map;


/**
 * Domain Availability Price objects are returned as part of the <a href="domain-availability-object">DomainAvailability</a> object structure.  They encode the price for an operation (registration, renewal, transfer) for a domain name
 * for a number of years.  The pricing fields returned will vary depending upon the price type (standard  / premium) and whether or not the pricing is a hint derived from the Netistrar pricing cache or confirmed pricing derived from a
 * call to the getLiveDomainAvailability within the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a>.
 *
 */
public class DomainAvailabilityPrice  {

    /**
     */
    protected String operation;

    /**
     */
    protected Integer numberOfYears;

    /**
     */
    protected String priceType;

    /**
     */
    protected Float standardBuyPrice;

    /**
     */
    protected Float hintedBuyPrice;

    /**
     */
    protected Float confirmedBuyPrice;




    /**
    * Blank Constructor
    *
    */
    public DomainAvailabilityPrice(){
    }



    /**
     * Get the operation
     *
     * @return String
     */
    public String getOperation(){
        return this.operation;
    }

    /**
     * Get the numberOfYears
     *
     * @return Integer
     */
    public Integer getNumberOfYears(){
        return this.numberOfYears;
    }

    /**
     * Get the priceType
     *
     * @return String
     */
    public String getPriceType(){
        return this.priceType;
    }

    /**
     * Get the standardBuyPrice
     *
     * @return Float
     */
    public Float getStandardBuyPrice(){
        return this.standardBuyPrice;
    }

    /**
     * Get the hintedBuyPrice
     *
     * @return Float
     */
    public Float getHintedBuyPrice(){
        return this.hintedBuyPrice;
    }

    /**
     * Get the confirmedBuyPrice
     *
     * @return Float
     */
    public Float getConfirmedBuyPrice(){
        return this.confirmedBuyPrice;
    }


}