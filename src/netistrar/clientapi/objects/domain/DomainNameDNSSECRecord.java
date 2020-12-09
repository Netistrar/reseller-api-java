package netistrar.clientapi.objects.domain;

import java.util.Map;

/**

*/
public class DomainNameDNSSECRecord  {


    /**
     * The domain name for which this glue record applies.  This field is only populated for results returned from the <b>listDNSSECRecords</b> method on the
     * <b>Domains API</b> and is not supplied when setting DNSSEC records.
     */
    protected String domainName;
    /**
     * The key tag for this DNSSEC record.  This is obtained from the DNS provider
     */
    private Integer keyTag;
    /**
     * The digest for this DNSSEC record.  This is obtained from the DNS provider and should be in Hexadecimal format.
     */
    private String digest;
    /**
     * The algorithm in use for this DNSSEC record.  This is obtained from the DNS provider and
     * will be usually be a number between 1 and 5.  NB: support of algorithms varies amongst Registry
     * operators with algorithm number 5 (RSA/SHA-1) being the only mandatory value under the DNSSEC specification.
     * This is the default value if none is supplied
     */
    private Integer algorithm;
    /**
     * The digest type in use for this DNSSEC record.  This is obtained from the DNS provider and
     * is usually set to a value of 1 (SHA-1) which is the default value if none is supplied.
     */
    private Integer digestType;



    /**
    * Blank Constructor
    *
    */
    public DomainNameDNSSECRecord(){
    }

    /**
     * Updatable Constructor
     *
    * @param keyTag the keyTag
    * @param digest the digest
    * @param algorithm the algorithm
    * @param digestType the digestType
    */
    public DomainNameDNSSECRecord(Integer keyTag, String digest, Integer algorithm, Integer digestType){

        this.keyTag = keyTag;
        this.digest = digest;
        this.algorithm = algorithm;
        this.digestType = digestType;
        
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
     * Get the keyTag
     *
     * @return keyTag
     */
    public Integer getKeyTag(){
        return this.keyTag;
    }

    /**
     * Set the keyTag
     *
     * @param keyTag the keyTag
     * @return DomainNameDNSSECRecord
     */
    public DomainNameDNSSECRecord setKeyTag(Integer keyTag){
        this.keyTag = keyTag;
        return this;
    }

    /**
     * Get the digest
     *
     * @return digest
     */
    public String getDigest(){
        return this.digest;
    }

    /**
     * Set the digest
     *
     * @param digest the digest
     * @return DomainNameDNSSECRecord
     */
    public DomainNameDNSSECRecord setDigest(String digest){
        this.digest = digest;
        return this;
    }

    /**
     * Get the algorithm
     *
     * @return algorithm
     */
    public Integer getAlgorithm(){
        return this.algorithm;
    }

    /**
     * Set the algorithm
     *
     * @param algorithm the algorithm
     * @return DomainNameDNSSECRecord
     */
    public DomainNameDNSSECRecord setAlgorithm(Integer algorithm){
        this.algorithm = algorithm;
        return this;
    }

    /**
     * Get the digestType
     *
     * @return digestType
     */
    public Integer getDigestType(){
        return this.digestType;
    }

    /**
     * Set the digestType
     *
     * @param digestType the digestType
     * @return DomainNameDNSSECRecord
     */
    public DomainNameDNSSECRecord setDigestType(Integer digestType){
        this.digestType = digestType;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameDNSSECRecord))
            return false;

        DomainNameDNSSECRecord castObject = (DomainNameDNSSECRecord)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainName() == null && castObject.getDomainName() == null) ||
            (this.getDomainName() != null && this.getDomainName().equals(castObject.getDomainName())));
        equals = equals && ( (this.getKeyTag() == null && castObject.getKeyTag() == null) ||
            (this.getKeyTag() != null && this.getKeyTag().equals(castObject.getKeyTag())));
        equals = equals && ( (this.getDigest() == null && castObject.getDigest() == null) ||
            (this.getDigest() != null && this.getDigest().equals(castObject.getDigest())));
        equals = equals && ( (this.getAlgorithm() == null && castObject.getAlgorithm() == null) ||
            (this.getAlgorithm() != null && this.getAlgorithm().equals(castObject.getAlgorithm())));
        equals = equals && ( (this.getDigestType() == null && castObject.getDigestType() == null) ||
            (this.getDigestType() != null && this.getDigestType().equals(castObject.getDigestType())));

        return equals;
    }


}