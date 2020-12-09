package netistrar.clientapi.objects.domain;

import java.util.Map;

/**
 * Domain Availability Price objects are returned as part of the <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainAvailability">DomainAvailability</a> object structure.  They encode the price for an operation (registration, renewal, transfer) for a domain name
 * for a number of years.
 * <br> The pricing fields returned will vary depending upon the price type (standard  / premium) and whether or not the pricing is a hint derived from the Netistrar pricing cache or confirmed pricing derived from a call to the <b>liveAvailability</b> method within the <a href="api:domains-api">Domain API</a>.
*/
public class DomainAvailabilityPrice  {


    /**
     * The operation for which this price applies as a string either <b>registration</b>, <b>renewal</b> or <b>transfer</b>
     */
    protected String operation;
    /**
     * The number of registration years which this price represents for the current operation (usually between 1 and 10)
     */
    protected Integer numberOfYears;
    /**
     * The pricing type for the current operation for the domain represented by this price.  This is a string value with one of the following values:<br />
     * <b>STANDARD:</b> When the pricing for this domain operation is known to be standard i.e. when the TLD doesn't support premium domains or this pricing object has been returned as part of the results from a call to <b>liveAvailability</b> on the <a href="api:domains-api">Domains API</a>
     * <b>PREMIUM:</b> When the pricing for this domain operation is known to be premium i.e. this object was returned from a call to <b>liveAvailability</b> on the <a href="api:domains-api">Domains API</a>.
     * <b>HINTED_PREMIUM:</b> When this pricing object has been returned as part of the results from a call to <b>hintedAvailability</b> on the <a href="api:domains-api">Domains API</a> and the pricing for this domain operation is believed to be premium based upon the presence of an entry in the Netistrar cache of Premium Domains.
     * <b>HINTED_STANDARD:</b> When this pricing object has been returned as part of the results from a call to to <b>hintedAvailability</b> on the <a href="api:domains-api">Domains API</a> and  the pricing for this domain operation is believed to be standard based upon the absence of an entry in the Netistrar cache of Premium Domains.
     * <b>UNKNOWN:</b> When this pricing object has been returned as part of the results from a call to <b>hintedAvailability</b> on the <a href="api:domains-api">Domains API</a> and the tld for this domain supports premium pricing but there is no cached information for this tld.
     */
    protected String priceType;
    /**
     * The price you pay for the current operation for the number of years for any domain of the same TLD which is standard priced.  This is populated in all cases and provides an indicator of the minimum price for
     * the given domain if premium status is unknown.  This is converted to the current currency.
     */
    protected Float standardBuyPrice;
    /**
     * This is only populated when the <b>priceType</b> property is set to <b>HINTED_PREMIUM</b> or <b>HINTED_STANDARD</b>.  This occurs when the pricing object is returned as part of results from a call to <b>hintedAvailability</b> on the <a href="api:domains-api">Domains API</a>.<br />
     * The value is either the same as the <b>standardBuyPrice</b> property in the case that the <b>priceType</b> property is set to <b>HINTED_STANDARD</b> or to the value contained within the Netistrar pricing cache when set to <b>HINTED_PREMIUM</b>.<br />
     * The value is converted to the current currency when available or set to <b>N/A</b> when unavailable.
     */
    protected Float hintedBuyPrice;
    /**
     * This is only populated when the <b>priceType</b> property is set to <b>STANDARD</b> or <b>PREMIUM</b>.  This occurs when the pricing object is returned as part of results from a call to <b>liveAvailability</b> on the <a href="api:domains-api">Domains API</a> or when the
     * TLD in question does not support premium pricing (e.g. UK, COM) where the pricing is guaranteed to be standard.<br />
     * The value is converted to the current currency when available or set to <b>N/A</b> when unavailable.
     */
    protected Float confirmedBuyPrice;
    /**
     * This is only populated when the standard buy price has been discounted via an offer.  This is populated with the original standard price for display e.g. crossed out in search results
     * This value is converted to the current currency.
     */
    protected Float originalBuyPrice;



    /**
    * Blank Constructor
    *
    */
    public DomainAvailabilityPrice(){
    }



    /**
     * Get the operation
     *
     * @return operation
     */
    public String getOperation(){
        return this.operation;
    }

    /**
     * Get the numberOfYears
     *
     * @return numberOfYears
     */
    public Integer getNumberOfYears(){
        return this.numberOfYears;
    }

    /**
     * Get the priceType
     *
     * @return priceType
     */
    public String getPriceType(){
        return this.priceType;
    }

    /**
     * Get the standardBuyPrice
     *
     * @return standardBuyPrice
     */
    public Float getStandardBuyPrice(){
        return this.standardBuyPrice;
    }

    /**
     * Get the hintedBuyPrice
     *
     * @return hintedBuyPrice
     */
    public Float getHintedBuyPrice(){
        return this.hintedBuyPrice;
    }

    /**
     * Get the confirmedBuyPrice
     *
     * @return confirmedBuyPrice
     */
    public Float getConfirmedBuyPrice(){
        return this.confirmedBuyPrice;
    }

    /**
     * Get the originalBuyPrice
     *
     * @return originalBuyPrice
     */
    public Float getOriginalBuyPrice(){
        return this.originalBuyPrice;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainAvailabilityPrice))
            return false;

        DomainAvailabilityPrice castObject = (DomainAvailabilityPrice)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getOperation() == null && castObject.getOperation() == null) ||
            (this.getOperation() != null && this.getOperation().equals(castObject.getOperation())));
        equals = equals && ( (this.getNumberOfYears() == null && castObject.getNumberOfYears() == null) ||
            (this.getNumberOfYears() != null && this.getNumberOfYears().equals(castObject.getNumberOfYears())));
        equals = equals && ( (this.getPriceType() == null && castObject.getPriceType() == null) ||
            (this.getPriceType() != null && this.getPriceType().equals(castObject.getPriceType())));
        equals = equals && ( (this.getStandardBuyPrice() == null && castObject.getStandardBuyPrice() == null) ||
            (this.getStandardBuyPrice() != null && this.getStandardBuyPrice().equals(castObject.getStandardBuyPrice())));
        equals = equals && ( (this.getHintedBuyPrice() == null && castObject.getHintedBuyPrice() == null) ||
            (this.getHintedBuyPrice() != null && this.getHintedBuyPrice().equals(castObject.getHintedBuyPrice())));
        equals = equals && ( (this.getConfirmedBuyPrice() == null && castObject.getConfirmedBuyPrice() == null) ||
            (this.getConfirmedBuyPrice() != null && this.getConfirmedBuyPrice().equals(castObject.getConfirmedBuyPrice())));
        equals = equals && ( (this.getOriginalBuyPrice() == null && castObject.getOriginalBuyPrice() == null) ||
            (this.getOriginalBuyPrice() != null && this.getOriginalBuyPrice().equals(castObject.getOriginalBuyPrice())));

        return equals;
    }


}