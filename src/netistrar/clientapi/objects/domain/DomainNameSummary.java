package netistrar.clientapi.objects.domain;

import java.util.Map;


public class DomainNameSummary  {

    /**
     */
    protected String ownerName;

    /**
     */
    protected String domainName;

    /**
     */
    protected String registeredDate;

    /**
     */
    protected String expiryDate;

    /**
     */
    protected Boolean locked;

    /**
     */
    protected String lockedUntil;

    /**
     */
    protected String authCode;

    /**
     */
    protected Boolean autoRenew;

    /**
     */
    protected Boolean privacyProxy;

    /**
     */
    protected String status;

    /**
     */
    protected String dnsProvider;

    /**
     */
    protected String emailProvider;




    /**
    * Blank Constructor
    *
    */
    public DomainNameSummary(){
    }



    /**
     * Get the ownerName
     *
     * @return String
     */
    public String getOwnerName(){
        return this.ownerName;
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
     * Get the registeredDate
     *
     * @return String
     */
    public String getRegisteredDate(){
        return this.registeredDate;
    }

    /**
     * Get the expiryDate
     *
     * @return String
     */
    public String getExpiryDate(){
        return this.expiryDate;
    }

    /**
     * Get the locked
     *
     * @return Boolean
     */
    public Boolean getLocked(){
        return this.locked;
    }

    /**
     * Get the lockedUntil
     *
     * @return String
     */
    public String getLockedUntil(){
        return this.lockedUntil;
    }

    /**
     * Get the authCode
     *
     * @return String
     */
    public String getAuthCode(){
        return this.authCode;
    }

    /**
     * Get the autoRenew
     *
     * @return Boolean
     */
    public Boolean getAutoRenew(){
        return this.autoRenew;
    }

    /**
     * Get the privacyProxy
     *
     * @return Boolean
     */
    public Boolean getPrivacyProxy(){
        return this.privacyProxy;
    }

    /**
     * Get the status
     *
     * @return String
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Get the dnsProvider
     *
     * @return String
     */
    public String getDnsProvider(){
        return this.dnsProvider;
    }

    /**
     * Get the emailProvider
     *
     * @return String
     */
    public String getEmailProvider(){
        return this.emailProvider;
    }


}