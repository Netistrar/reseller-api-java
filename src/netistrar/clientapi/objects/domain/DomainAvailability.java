package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainAvailabilityPrice;
import java.util.Map;

/**
 * Domain availability class.
*/
public class DomainAvailability  {


    /**
     * The full domain name for this availability object as a string
     */
    protected String domainName;
    /**
     * The availability status.  This matches one of the following values.
     *  <b>AVAILABLE:</b> When this domain is known to be available e.g. this object has been returned from a call to getLiveDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a>.
     *  <b>UNAVAILABLE:</b> When this domain is known to be unavailable e.g. this object has been returned from a call to getLiveDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a>.
     *  <b>MY_DOMAIN:</b> When this domain has already been registered to your account and is effectively one of your domains within Netistrar
     *  <b>HINTED_AVAILABLE:</b> When this object has been returned from a call to getHintedDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a> and the caching system does not have an entry for this domain.
     *  <b>HINTED_UNAVAILABLE:</b> When this object has been returned from a call to getHintedDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a> and the caching system does have an entry for this domain.
     *  <b>NO_HINTED_AVAILABILITY:</b> When this object has been returned from a call to getHintedDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a> and the caching system does have any information for the TLD of this domain.
     */
    protected String availability;
    /**
     * The pricing type for the domain name which matches one of the following values.
     * <b>STANDARD:</b> When the pricing for this domain is known to be standard i.e. when the TLD doesn't support premium domains or this object was returned from a call to getLiveDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a>
     * <b>PREMIUM:</b> When the pricing for this domain is known to be premium i.e. this object was returned from a call to getLiveDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a>.
     * <b>FIXED:</b> When the pricing for this domain has been fixed for a specific offer or deal.
     * <b>HINTED_PREMIUM:</b> When this object has been returned from a call to getHintedDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a> and the pricing for this domain is believed to be premium based upon the presence of an entry in the Netistrar cache of Premium Domains.
     * <b>HINTED_STANDARD:</b> When this object has been returned from a call to getHintedDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a> and  the pricing for this domain is believed to be standard based upon the absence of an entry in the Netistrar cache of Premium Domains.
     * <b>UNKNOWN:</b> When this object has been returned from a call to getHintedDomainAvailability on the <a href="netistrar-domain-availability-api">Netistrar Domain Availability API</a> and the tld for this domain supports premium pricing but there is no cached information for this tld.
     */
    protected String pricingType;
    /**
     * An indicator as to whether or not the tld for this domain name
     * supports premium domains.  This is particularly useful when searching for hinted availability as it
     * allows marking up of prices as "from" etc.
     */
    protected String premiumSupported;
    /**
     * An associative array containing sets of domain prices for Registration, Renewal and Transfer for this domain name.  These pricing sets are indexed using the keys <b>registration</b>, <b>renewal</b> and <b>transfer</b> and are included according
     * to the following rules depending upon the availability property.
     * Registration prices are included when the availability property is set to <b>AVAILABLE</b> or <b>HINTED_AVAILABLE</b> or <b>NO_HINTED_AVAILABILITY</b>,  these comprise an array of <a href="domain-availability-price-object">DomainAvailabilityPrice</a> items for all possible registration years (usually 10).
     * Renewal prices are included for all availabilities.  In the <b>AVAILABLE</b>, <b>HINTED_AVAILABLE</b> and <b>NO_HINTED_AVAILABILITY</b> cases this will comprise an array of <a href="domain-availability-price-object">DomainAvailabilityPrice</a> items for all possible renewal years (i.e. registration years -1).  In the
     * <b>MY_DOMAIN</b> case this will comprise an array of <a href="domain-availability-price-object">DomainAvailabilityPrice</a> items for all possible renewal years according to the current registration state.  In the remaining <b>UNAVAILABLE</b>
     * and <b>HINTED_UNAVAILABLE</b> cases this will comprise an array containing a single <a href="domain-availability-price-object">DomainAvailabilityPrice</a> item for one year renewal price.
     * Transfer prices are included only when the availability property is set to <b>UNAVAILABLE</b> or <b>HINTED_UNAVAILABLE</b>.  This will comprise an array containing a single <a href="domain-availability-price-object">DomainAvailabilityPrice</a> item for one year transfer price.
     */
    protected Map<String,DomainAvailabilityPrice[]> prices;
    /**
     * An arbitrary array of additional data included to qualify given availability and pricing states when required.
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
     * @return domainName
     */
    public String getDomainName(){
        return this.domainName;
    }

    /**
     * Get the availability
     *
     * @return availability
     */
    public String getAvailability(){
        return this.availability;
    }

    /**
     * Get the pricingType
     *
     * @return pricingType
     */
    public String getPricingType(){
        return this.pricingType;
    }

    /**
     * Get the premiumSupported
     *
     * @return premiumSupported
     */
    public String getPremiumSupported(){
        return this.premiumSupported;
    }

    /**
     * Get the prices
     *
     * @return prices
     */
    public Map<String,DomainAvailabilityPrice[]> getPrices(){
        return this.prices;
    }

    /**
     * Get the additionalData
     *
     * @return additionalData
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
        equals = equals && ( (this.getPremiumSupported() == null && castObject.getPremiumSupported() == null) ||
            (this.getPremiumSupported() != null && this.getPremiumSupported().equals(castObject.getPremiumSupported())));
        equals = equals && ( (this.getPrices() == null && castObject.getPrices() == null) ||
            (this.getPrices() != null && this.getPrices().equals(castObject.getPrices())));
        equals = equals && ( (this.getAdditionalData() == null && castObject.getAdditionalData() == null) ||
            (this.getAdditionalData() != null && this.getAdditionalData().equals(castObject.getAdditionalData())));

        return equals;
    }


}