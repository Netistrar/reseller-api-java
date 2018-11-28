package netistrar.clientapi.objects.domain;

import java.util.Map;


/**
 * An updatable contact object used within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a> methods and as a related object to a <a href="domain-name-object">DomainNameObject</a>.
 * 
 * Changes to key data for the owner contact for GTLD domain names require verification via email to the current owner for the domain name before these changes can be applied.  If the change is accepted the
 * domain name will be locked for 60 days for transfer.
 *
  */
public class DomainNameContact  {

    /**
     */
    private String name;

    /**
     */
    private String emailAddress;

    /**
     */
    private String organisation;

    /**
     */
    private String street1;

    /**
     */
    private String street2;

    /**
     */
    private String city;

    /**
     */
    private String county;

    /**
     */
    private String postcode;

    /**
     */
    private String country;

    /**
     */
    private String telephoneDiallingCode;

    /**
     */
    private String telephone;

    /**
     */
    private String telephoneExt;

    /**
     */
    private String faxDiallingCode;

    /**
     */
    private String fax;

    /**
     */
    private String faxExt;

    /**
     */
    private Map<String,Object> additionalData;

    /**
     */
    protected String status;

    /**
     */
    protected DomainNameContact pendingContact;




    /**
    * Blank Constructor
    *
    */
    public DomainNameContact(){
    }

    /**
     * Updatable Constructor
     *
    * @param String $name
    * @param String $emailAddress
    * @param String $organisation
    * @param String $street1
    * @param String $street2
    * @param String $city
    * @param String $county
    * @param String $postcode
    * @param String $country
    * @param String $telephoneDiallingCode
    * @param String $telephone
    * @param String $telephoneExt
    * @param String $faxDiallingCode
    * @param String $fax
    * @param String $faxExt
    * @param Map<String,Object> $additionalData
    */
    public DomainNameContact(String name, String emailAddress, String organisation, String street1, String street2, String city, String county, String postcode, String country, String telephoneDiallingCode, String telephone, String telephoneExt, String faxDiallingCode, String fax, String faxExt, Map<String,Object> additionalData){

        this.name = name;
        this.emailAddress = emailAddress;
        this.organisation = organisation;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
        this.country = country;
        this.telephoneDiallingCode = telephoneDiallingCode;
        this.telephone = telephone;
        this.telephoneExt = telephoneExt;
        this.faxDiallingCode = faxDiallingCode;
        this.fax = fax;
        this.faxExt = faxExt;
        this.additionalData = additionalData;
        
    }


    /**
     * Get the name
     *
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set the name
     *
     * @param String $name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get the emailAddress
     *
     * @return String
     */
    public String getEmailAddress(){
        return this.emailAddress;
    }

    /**
     * Set the emailAddress
     *
     * @param String $emailAddress
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     * Get the organisation
     *
     * @return String
     */
    public String getOrganisation(){
        return this.organisation;
    }

    /**
     * Set the organisation
     *
     * @param String $organisation
     */
    public void setOrganisation(String organisation){
        this.organisation = organisation;
    }

    /**
     * Get the street1
     *
     * @return String
     */
    public String getStreet1(){
        return this.street1;
    }

    /**
     * Set the street1
     *
     * @param String $street1
     */
    public void setStreet1(String street1){
        this.street1 = street1;
    }

    /**
     * Get the street2
     *
     * @return String
     */
    public String getStreet2(){
        return this.street2;
    }

    /**
     * Set the street2
     *
     * @param String $street2
     */
    public void setStreet2(String street2){
        this.street2 = street2;
    }

    /**
     * Get the city
     *
     * @return String
     */
    public String getCity(){
        return this.city;
    }

    /**
     * Set the city
     *
     * @param String $city
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * Get the county
     *
     * @return String
     */
    public String getCounty(){
        return this.county;
    }

    /**
     * Set the county
     *
     * @param String $county
     */
    public void setCounty(String county){
        this.county = county;
    }

    /**
     * Get the postcode
     *
     * @return String
     */
    public String getPostcode(){
        return this.postcode;
    }

    /**
     * Set the postcode
     *
     * @param String $postcode
     */
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }

    /**
     * Get the country
     *
     * @return String
     */
    public String getCountry(){
        return this.country;
    }

    /**
     * Set the country
     *
     * @param String $country
     */
    public void setCountry(String country){
        this.country = country;
    }

    /**
     * Get the telephoneDiallingCode
     *
     * @return String
     */
    public String getTelephoneDiallingCode(){
        return this.telephoneDiallingCode;
    }

    /**
     * Set the telephoneDiallingCode
     *
     * @param String $telephoneDiallingCode
     */
    public void setTelephoneDiallingCode(String telephoneDiallingCode){
        this.telephoneDiallingCode = telephoneDiallingCode;
    }

    /**
     * Get the telephone
     *
     * @return String
     */
    public String getTelephone(){
        return this.telephone;
    }

    /**
     * Set the telephone
     *
     * @param String $telephone
     */
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    /**
     * Get the telephoneExt
     *
     * @return String
     */
    public String getTelephoneExt(){
        return this.telephoneExt;
    }

    /**
     * Set the telephoneExt
     *
     * @param String $telephoneExt
     */
    public void setTelephoneExt(String telephoneExt){
        this.telephoneExt = telephoneExt;
    }

    /**
     * Get the faxDiallingCode
     *
     * @return String
     */
    public String getFaxDiallingCode(){
        return this.faxDiallingCode;
    }

    /**
     * Set the faxDiallingCode
     *
     * @param String $faxDiallingCode
     */
    public void setFaxDiallingCode(String faxDiallingCode){
        this.faxDiallingCode = faxDiallingCode;
    }

    /**
     * Get the fax
     *
     * @return String
     */
    public String getFax(){
        return this.fax;
    }

    /**
     * Set the fax
     *
     * @param String $fax
     */
    public void setFax(String fax){
        this.fax = fax;
    }

    /**
     * Get the faxExt
     *
     * @return String
     */
    public String getFaxExt(){
        return this.faxExt;
    }

    /**
     * Set the faxExt
     *
     * @param String $faxExt
     */
    public void setFaxExt(String faxExt){
        this.faxExt = faxExt;
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
     * Set the additionalData
     *
     * @param Map<String,Object> $additionalData
     */
    public void setAdditionalData(Map<String,Object> additionalData){
        this.additionalData = additionalData;
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
     * Get the pendingContact
     *
     * @return DomainNameContact
     */
    public DomainNameContact getPendingContact(){
        return this.pendingContact;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameContact))
            return false;

        DomainNameContact castObject = (DomainNameContact)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getName() == null && castObject.getName() == null) ||
            (this.getName() != null && this.getName().equals(castObject.getName())));
        equals = equals && ( (this.getEmailAddress() == null && castObject.getEmailAddress() == null) ||
            (this.getEmailAddress() != null && this.getEmailAddress().equals(castObject.getEmailAddress())));
        equals = equals && ( (this.getOrganisation() == null && castObject.getOrganisation() == null) ||
            (this.getOrganisation() != null && this.getOrganisation().equals(castObject.getOrganisation())));
        equals = equals && ( (this.getStreet1() == null && castObject.getStreet1() == null) ||
            (this.getStreet1() != null && this.getStreet1().equals(castObject.getStreet1())));
        equals = equals && ( (this.getStreet2() == null && castObject.getStreet2() == null) ||
            (this.getStreet2() != null && this.getStreet2().equals(castObject.getStreet2())));
        equals = equals && ( (this.getCity() == null && castObject.getCity() == null) ||
            (this.getCity() != null && this.getCity().equals(castObject.getCity())));
        equals = equals && ( (this.getCounty() == null && castObject.getCounty() == null) ||
            (this.getCounty() != null && this.getCounty().equals(castObject.getCounty())));
        equals = equals && ( (this.getPostcode() == null && castObject.getPostcode() == null) ||
            (this.getPostcode() != null && this.getPostcode().equals(castObject.getPostcode())));
        equals = equals && ( (this.getCountry() == null && castObject.getCountry() == null) ||
            (this.getCountry() != null && this.getCountry().equals(castObject.getCountry())));
        equals = equals && ( (this.getTelephoneDiallingCode() == null && castObject.getTelephoneDiallingCode() == null) ||
            (this.getTelephoneDiallingCode() != null && this.getTelephoneDiallingCode().equals(castObject.getTelephoneDiallingCode())));
        equals = equals && ( (this.getTelephone() == null && castObject.getTelephone() == null) ||
            (this.getTelephone() != null && this.getTelephone().equals(castObject.getTelephone())));
        equals = equals && ( (this.getTelephoneExt() == null && castObject.getTelephoneExt() == null) ||
            (this.getTelephoneExt() != null && this.getTelephoneExt().equals(castObject.getTelephoneExt())));
        equals = equals && ( (this.getFaxDiallingCode() == null && castObject.getFaxDiallingCode() == null) ||
            (this.getFaxDiallingCode() != null && this.getFaxDiallingCode().equals(castObject.getFaxDiallingCode())));
        equals = equals && ( (this.getFax() == null && castObject.getFax() == null) ||
            (this.getFax() != null && this.getFax().equals(castObject.getFax())));
        equals = equals && ( (this.getFaxExt() == null && castObject.getFaxExt() == null) ||
            (this.getFaxExt() != null && this.getFaxExt().equals(castObject.getFaxExt())));
        equals = equals && ( (this.getAdditionalData() == null && castObject.getAdditionalData() == null) ||
            (this.getAdditionalData() != null && this.getAdditionalData().equals(castObject.getAdditionalData())));
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getPendingContact() == null && castObject.getPendingContact() == null) ||
            (this.getPendingContact() != null && this.getPendingContact().equals(castObject.getPendingContact())));

        return equals;
    }


}