package netistrar.clientapi.objects.test.domain;

import java.util.Map;


/**
 * Update descriptor for updating one or more domain names with attributes not normally updatable for testing
 * purposes.
 *
 */
public class TestDomainNameUpdateDescriptor  {

    /**
     */
    private String[] domainNames;

    /**
     */
    private String status;

    /**
     */
    private String registeredDate;

    /**
     */
    private String lockedUntil;

    /**
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
    * @param String[] $domainNames
    * @param String $status
    * @param String $registeredDate
    * @param String $lockedUntil
    * @param Boolean $locked
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
     * @return String[]
     */
    public String[] getDomainNames(){
        return this.domainNames;
    }

    /**
     * Set the domainNames
     *
     * @param String[] $domainNames
     */
    public void setDomainNames(String[] domainNames){
        this.domainNames = domainNames;
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
     * Set the status
     *
     * @param String $status
     */
    public void setStatus(String status){
        this.status = status;
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
     * Set the registeredDate
     *
     * @param String $registeredDate
     */
    public void setRegisteredDate(String registeredDate){
        this.registeredDate = registeredDate;
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
     * Set the lockedUntil
     *
     * @param String $lockedUntil
     */
    public void setLockedUntil(String lockedUntil){
        this.lockedUntil = lockedUntil;
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
     * Set the locked
     *
     * @param Boolean $locked
     */
    public void setLocked(Boolean locked){
        this.locked = locked;
    }


}