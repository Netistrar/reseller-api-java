package netistrar.clientapi.objects.domain;

import java.util.Map;

/**
 * A value object used within the <b>Domains API</b> when listing or setting glue records for a domain name.
 * Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated
 * nameserver for other domains or indeed the domain name itself.
*/
public class DomainNameGlueRecord  {


    /**
     * The domain name for which this glue record applies.  This field is only populated for results returned from the <b>listGlueRecords</b> method on the
     * <b>Domains API</b> and is not supplied when adding glue records.
     */
    protected String domainName;
    /**
     * The non fully qualified sub domain prefix for the glue record e.g. ns1
     */
    private String subDomainPrefix;
    /**
     * An IPv4 address string matching the sub domain in xxx.xxx.xxx.xxx format
     */
    private String ipv4Address;
    /**
     * An IPv6 address string matching the sub domain in xxxx:xxxx:xxxx:xxxx:xxxx:xxxx:xxxx:xxxx format.
     */
    private String ipv6Address;



    /**
    * Blank Constructor
    *
    */
    public DomainNameGlueRecord(){
    }

    /**
     * Updatable Constructor
     *
    * @param subDomainPrefix
    * @param ipv4Address
    * @param ipv6Address
    */
    public DomainNameGlueRecord(String subDomainPrefix, String ipv4Address, String ipv6Address){

        this.subDomainPrefix = subDomainPrefix;
        this.ipv4Address = ipv4Address;
        this.ipv6Address = ipv6Address;
        
    }


    /**
     * Get the domainName
     *
     * @return
     */
    public String getDomainName(){
        return this.domainName;
    }

    /**
     * Get the subDomainPrefix
     *
     * @return
     */
    public String getSubDomainPrefix(){
        return this.subDomainPrefix;
    }

    /**
     * Set the subDomainPrefix
     *
     * @param subDomainPrefix
     * @return
     */
    public DomainNameGlueRecord setSubDomainPrefix(String subDomainPrefix){
        this.subDomainPrefix = subDomainPrefix;
        return this;
    }

    /**
     * Get the ipv4Address
     *
     * @return
     */
    public String getIpv4Address(){
        return this.ipv4Address;
    }

    /**
     * Set the ipv4Address
     *
     * @param ipv4Address
     * @return
     */
    public DomainNameGlueRecord setIpv4Address(String ipv4Address){
        this.ipv4Address = ipv4Address;
        return this;
    }

    /**
     * Get the ipv6Address
     *
     * @return
     */
    public String getIpv6Address(){
        return this.ipv6Address;
    }

    /**
     * Set the ipv6Address
     *
     * @param ipv6Address
     * @return
     */
    public DomainNameGlueRecord setIpv6Address(String ipv6Address){
        this.ipv6Address = ipv6Address;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameGlueRecord))
            return false;

        DomainNameGlueRecord castObject = (DomainNameGlueRecord)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainName() == null && castObject.getDomainName() == null) ||
            (this.getDomainName() != null && this.getDomainName().equals(castObject.getDomainName())));
        equals = equals && ( (this.getSubDomainPrefix() == null && castObject.getSubDomainPrefix() == null) ||
            (this.getSubDomainPrefix() != null && this.getSubDomainPrefix().equals(castObject.getSubDomainPrefix())));
        equals = equals && ( (this.getIpv4Address() == null && castObject.getIpv4Address() == null) ||
            (this.getIpv4Address() != null && this.getIpv4Address().equals(castObject.getIpv4Address())));
        equals = equals && ( (this.getIpv6Address() == null && castObject.getIpv6Address() == null) ||
            (this.getIpv6Address() != null && this.getIpv6Address().equals(castObject.getIpv6Address())));

        return equals;
    }


}