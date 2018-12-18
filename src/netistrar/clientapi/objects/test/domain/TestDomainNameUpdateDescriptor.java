package netistrar.clientapi.objects.test.domain;

import java.util.Map;

/**
 * Update descriptor for updating one or more domain names with attributes not normally updatable for testing
 * purposes.
*/
public class TestDomainNameUpdateDescriptor  {


    /**
     * An array of domain names to update
     */
    private String[] domainNames;
    /**
     * The new status for the supplied domain names.  This will be applied directly to the name
     * bypassing any workflow associated with the particular status.
     * Possible values are:
     * <b>ACTIVE</b> - The domain name is active and in use.
     * <b>EXPIRED</b> - The domain name has expired.
     * <b>SUSPENDED</b> - The domain name has been suspended (either for unlawful behaviour or invalid ownership details).
     * <b>RGP</b> - The domain has entered the Redemption Grace Period (usually around 45 days after expiry).  During this period additional costs are incurred to redeem the domain.
     * <b>DELETED</b> - The domain has dropped completely and has been deleted (usually around 75 days after expiry once the RGP has completed).
     * <b>TRANSFER_IN_PENDING_CONFIRMATION</b> - The domain is being transferred in and is awaiting confirmation from the legal owner.
     * <b>TRANSFER_IN_OWNER_DECLINED</b> - The domain is being transferred in but the legal owner declined the transfer.
     * <b>TRANSFER_IN_AWAITING_RESPONSE</b> - The domain transfer in operation has been started and is awaiting a response from the current Registrar.  If no response is received after 5 days the transfer would simply complete.
     * <b>TRANSFER_IN_REJECTED</b> - The domain transfer in operation has been rejected by the current Registrar.
     * <b>TRANSFER_OUT_PENDING_CONFIRMATION</b> - The domain has been requested to be transferred out and is awaiting confirmation from the legal owner.
     */
    private String status;
    /**
     * The date of registration in <b>dd/mm/YYYY</b> format.
     */
    private String registeredDate;
    /**
     * The locked until date in <b>dd/mm/YYYY</b> format.  This allows for testing unsetting of locks.
     */
    private String lockedUntil;
    /**
     * Forcibly update the lock status for testing regardless of whether or not this is permitted for a domain.
     */
    private Boolean locked;



    /**
    * Blank Constructor
    *
    */
    public TestDomainNameUpdateDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param domainNames the domainNames
    * @param status the status
    * @param registeredDate the registeredDate
    * @param lockedUntil the lockedUntil
    * @param locked the locked
    */
    public TestDomainNameUpdateDescriptor(String[] domainNames, String status, String registeredDate, String lockedUntil, Boolean locked){

        this.domainNames = domainNames;
        this.status = status;
        this.registeredDate = registeredDate;
        this.lockedUntil = lockedUntil;
        this.locked = locked;
        
    }


    /**
     * Get the domainNames
     *
     * @return domainNames
     */
    public String[] getDomainNames(){
        return this.domainNames;
    }

    /**
     * Set the domainNames
     *
     * @param domainNames the domainNames
     * @return TestDomainNameUpdateDescriptor
     */
    public TestDomainNameUpdateDescriptor setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
        return this;
    }

    /**
     * Get the status
     *
     * @return status
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Set the status
     *
     * @param status the status
     * @return TestDomainNameUpdateDescriptor
     */
    public TestDomainNameUpdateDescriptor setStatus(String status){
        this.status = status;
        return this;
    }

    /**
     * Get the registeredDate
     *
     * @return registeredDate
     */
    public String getRegisteredDate(){
        return this.registeredDate;
    }

    /**
     * Set the registeredDate
     *
     * @param registeredDate the registeredDate
     * @return TestDomainNameUpdateDescriptor
     */
    public TestDomainNameUpdateDescriptor setRegisteredDate(String registeredDate){
        this.registeredDate = registeredDate;
        return this;
    }

    /**
     * Get the lockedUntil
     *
     * @return lockedUntil
     */
    public String getLockedUntil(){
        return this.lockedUntil;
    }

    /**
     * Set the lockedUntil
     *
     * @param lockedUntil the lockedUntil
     * @return TestDomainNameUpdateDescriptor
     */
    public TestDomainNameUpdateDescriptor setLockedUntil(String lockedUntil){
        this.lockedUntil = lockedUntil;
        return this;
    }

    /**
     * Get the locked
     *
     * @return locked
     */
    public Boolean getLocked(){
        return this.locked;
    }

    /**
     * Set the locked
     *
     * @param locked the locked
     * @return TestDomainNameUpdateDescriptor
     */
    public TestDomainNameUpdateDescriptor setLocked(Boolean locked){
        this.locked = locked;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof TestDomainNameUpdateDescriptor))
            return false;

        TestDomainNameUpdateDescriptor castObject = (TestDomainNameUpdateDescriptor)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDomainNames() == null && castObject.getDomainNames() == null) ||
            (this.getDomainNames() != null && this.getDomainNames().equals(castObject.getDomainNames())));
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getRegisteredDate() == null && castObject.getRegisteredDate() == null) ||
            (this.getRegisteredDate() != null && this.getRegisteredDate().equals(castObject.getRegisteredDate())));
        equals = equals && ( (this.getLockedUntil() == null && castObject.getLockedUntil() == null) ||
            (this.getLockedUntil() != null && this.getLockedUntil().equals(castObject.getLockedUntil())));
        equals = equals && ( (this.getLocked() == null && castObject.getLocked() == null) ||
            (this.getLocked() != null && this.getLocked().equals(castObject.getLocked())));

        return equals;
    }


}