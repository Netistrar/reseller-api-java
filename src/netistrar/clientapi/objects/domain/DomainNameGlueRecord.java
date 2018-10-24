package netistrar.clientapi.objects.domain;

import java.util.Map;


/**
 * A value object used within the <b>Domains API</b> when listing or setting glue records for a domain name.
 *
 * Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated
 * nameserver for other domains or indeed the domain name itself.
 *
 */
public class DomainNameGlueRecord  {

    /**
     */
    protected String domainName;

    /**
     */
    private String subDomainPrefix;

    /**
     */
    private String ipv4Address;

    /**
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
    * @param String $subDomainPrefix
    * @param String $ipv4Address
    * @param String $ipv6Address
    */
    public DomainNameGlueRecord(String subDomainPrefix, String ipv4Address, String ipv6Address){

        this.subDomainPrefix = subDomainPrefix;
        this.ipv4Address = ipv4Address;
        this.ipv6Address = ipv6Address;
        
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
     * Get the subDomainPrefix
     *
     * @return String
     */
    public String getSubDomainPrefix(){
        return this.subDomainPrefix;
    }

    /**
     * Set the subDomainPrefix
     *
     * @param String $subDomainPrefix
     */
    public void setSubDomainPrefix(String subDomainPrefix){
        this.subDomainPrefix = subDomainPrefix;
    }

    /**
     * Get the ipv4Address
     *
     * @return String
     */
    public String getIpv4Address(){
        return this.ipv4Address;
    }

    /**
     * Set the ipv4Address
     *
     * @param String $ipv4Address
     */
    public void setIpv4Address(String ipv4Address){
        this.ipv4Address = ipv4Address;
    }

    /**
     * Get the ipv6Address
     *
     * @return String
     */
    public String getIpv6Address(){
        return this.ipv6Address;
    }

    /**
     * Set the ipv6Address
     *
     * @param String $ipv6Address
     */
    public void setIpv6Address(String ipv6Address){
        this.ipv6Address = ipv6Address;
    }


}