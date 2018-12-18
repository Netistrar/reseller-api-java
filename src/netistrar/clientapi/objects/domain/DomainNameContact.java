package netistrar.clientapi.objects.domain;

import java.util.Map;

/**
 * An updatable contact object used within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a> methods and as a related object to a <a href="domain-name-object">DomainNameObject</a>.
 * Changes to key data for the owner contact for GTLD domain names require verification via email to the current owner for the domain name before these changes can be applied.  If the change is accepted the
 * domain name will be locked for 60 days for transfer.
*/
public class DomainNameContact  {


    /**
     * The full name of this contact
     */
    private String name;
    /**
     * The email address for this contact.
     */
    private String emailAddress;
    /**
     * The organisation if applicable for this contact.
     */
    private String organisation;
    /**
     * The first line of the street address for this contact
     */
    private String street1;
    /**
     * The second line of the street address for this contact
     */
    private String street2;
    /**
     * The city of the street address for this contact
     */
    private String city;
    /**
     * The county of the street address for this contact
     */
    private String county;
    /**
     * The postcode for this contact
     */
    private String postcode;
    /**
     * The 2 digit country code for this contact (e.g. GB).  If not supplied, this will default to <b>GB</b>
     */
    private String country;
    /**
     * The telephone international dialling code with leading + if a telephone number is being supplied (e.g. +44, +1 etc)
     */
    private String telephoneDiallingCode;
    /**
     * The local telephone number bit after the dialling code with no spaces (e.g. 1235987878)
     */
    private String telephone;
    /**
     * An optional telephone extension (e.g. 201)
     */
    private String telephoneExt;
    /**
     * The fax international dialling code with leading + if a fax number is being supplied (e.g. +44, +1 etc)
     */
    private String faxDiallingCode;
    /**
     * The local number bit after the dialling code with no spaces (e.g. 1235987878)
     */
    private String fax;
    /**
     * An optional fax extension (e.g. 201)
     */
    private String faxExt;
    /**
     * An associative array of data where specific TLDs support / require additional properties
     * <b>Nominet UK domains:</b>
     * <br>
     * The following additional fields are supported for Nominet .UK domains
     * <b>nominetRegistrantType</b> String (required): One of the following code values
     * LTD: <i>UK Limited Company: </i><br>
     * PLC: <i>UK Public Limited Company: </i><br>
     * PTNR: <i>UK Partnership: </i><br>
     * STRA: <i>UK Sole Trader: </i><br>
     * LLP: <i>UK Limited Liability Partnership: </i><br>
     * IP: <i>UK Industrial/Provident Registered Company: </i><br>
     * IND: <i>UK Individual (representing self): </i><br>
     * SCH: <i>UK School: </i><br>
     * RCHAR: <i>UK Registered Charity: </i><br>
     * GOV: <i>UK Government Body: </i><br>
     * CRC: <i>UK Corporation by Royal Charter: </i><br>
     * STAT: <i>UK Statutory Body: </i><br>
     * OTHER: <i>UK Entity that does not fit into any of the above (e.g. clubs, associations, : </i><br>
     * <b>nominetTradingName</b> String (optional): An optional trading name which will display in WHOIS if set.
     * <b>nominetCompanyNumber</b> String (conditionally required):  The company number - required if the nominetRegistrantType field is set to any of the values
     * LTD, PLC, LLP, IP, SCH or RCHAR.
     */
    private Map<String,Object> additionalData;
    /**
     * The status of this contact (read only).  This will contain one of the following values.
     * <b>LIVE:</b> For all Admin, Billing, Technical and newly created Owner contacts
     * <b>PENDING_CHANGES:</b> For any GTLD Owner Contacts where key data has been changed and is awaiting verification by the owner.  This is usually following a call to <i>updateDomainNames</i> on the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.  For contacts with pending changes, the <a href="#pendingContact">pendingContact</a> member will contain the queued data awaiting approval.
     */
    protected String status;
    /**
     * Pending contact field.  This is only populated when the <a href="#status">status</a> member is set to <b>PENDING_CHANGES</b>.  This will contain a nested <a href="domain-name-contact">DomainNameContact</a> object containing the data awaiting verification by the owner of the domain.
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
    * @param name the name
    * @param emailAddress the emailAddress
    * @param organisation the organisation
    * @param street1 the street1
    * @param street2 the street2
    * @param city the city
    * @param county the county
    * @param postcode the postcode
    * @param country the country
    * @param telephoneDiallingCode the telephoneDiallingCode
    * @param telephone the telephone
    * @param telephoneExt the telephoneExt
    * @param faxDiallingCode the faxDiallingCode
    * @param fax the fax
    * @param faxExt the faxExt
    * @param additionalData the additionalData
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
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set the name
     *
     * @param name the name
     * @return DomainNameContact
     */
    public DomainNameContact setName(String name){
        this.name = name;
        return this;
    }

    /**
     * Get the emailAddress
     *
     * @return emailAddress
     */
    public String getEmailAddress(){
        return this.emailAddress;
    }

    /**
     * Set the emailAddress
     *
     * @param emailAddress the emailAddress
     * @return DomainNameContact
     */
    public DomainNameContact setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get the organisation
     *
     * @return organisation
     */
    public String getOrganisation(){
        return this.organisation;
    }

    /**
     * Set the organisation
     *
     * @param organisation the organisation
     * @return DomainNameContact
     */
    public DomainNameContact setOrganisation(String organisation){
        this.organisation = organisation;
        return this;
    }

    /**
     * Get the street1
     *
     * @return street1
     */
    public String getStreet1(){
        return this.street1;
    }

    /**
     * Set the street1
     *
     * @param street1 the street1
     * @return DomainNameContact
     */
    public DomainNameContact setStreet1(String street1){
        this.street1 = street1;
        return this;
    }

    /**
     * Get the street2
     *
     * @return street2
     */
    public String getStreet2(){
        return this.street2;
    }

    /**
     * Set the street2
     *
     * @param street2 the street2
     * @return DomainNameContact
     */
    public DomainNameContact setStreet2(String street2){
        this.street2 = street2;
        return this;
    }

    /**
     * Get the city
     *
     * @return city
     */
    public String getCity(){
        return this.city;
    }

    /**
     * Set the city
     *
     * @param city the city
     * @return DomainNameContact
     */
    public DomainNameContact setCity(String city){
        this.city = city;
        return this;
    }

    /**
     * Get the county
     *
     * @return county
     */
    public String getCounty(){
        return this.county;
    }

    /**
     * Set the county
     *
     * @param county the county
     * @return DomainNameContact
     */
    public DomainNameContact setCounty(String county){
        this.county = county;
        return this;
    }

    /**
     * Get the postcode
     *
     * @return postcode
     */
    public String getPostcode(){
        return this.postcode;
    }

    /**
     * Set the postcode
     *
     * @param postcode the postcode
     * @return DomainNameContact
     */
    public DomainNameContact setPostcode(String postcode){
        this.postcode = postcode;
        return this;
    }

    /**
     * Get the country
     *
     * @return country
     */
    public String getCountry(){
        return this.country;
    }

    /**
     * Set the country
     *
     * @param country the country
     * @return DomainNameContact
     */
    public DomainNameContact setCountry(String country){
        this.country = country;
        return this;
    }

    /**
     * Get the telephoneDiallingCode
     *
     * @return telephoneDiallingCode
     */
    public String getTelephoneDiallingCode(){
        return this.telephoneDiallingCode;
    }

    /**
     * Set the telephoneDiallingCode
     *
     * @param telephoneDiallingCode the telephoneDiallingCode
     * @return DomainNameContact
     */
    public DomainNameContact setTelephoneDiallingCode(String telephoneDiallingCode){
        this.telephoneDiallingCode = telephoneDiallingCode;
        return this;
    }

    /**
     * Get the telephone
     *
     * @return telephone
     */
    public String getTelephone(){
        return this.telephone;
    }

    /**
     * Set the telephone
     *
     * @param telephone the telephone
     * @return DomainNameContact
     */
    public DomainNameContact setTelephone(String telephone){
        this.telephone = telephone;
        return this;
    }

    /**
     * Get the telephoneExt
     *
     * @return telephoneExt
     */
    public String getTelephoneExt(){
        return this.telephoneExt;
    }

    /**
     * Set the telephoneExt
     *
     * @param telephoneExt the telephoneExt
     * @return DomainNameContact
     */
    public DomainNameContact setTelephoneExt(String telephoneExt){
        this.telephoneExt = telephoneExt;
        return this;
    }

    /**
     * Get the faxDiallingCode
     *
     * @return faxDiallingCode
     */
    public String getFaxDiallingCode(){
        return this.faxDiallingCode;
    }

    /**
     * Set the faxDiallingCode
     *
     * @param faxDiallingCode the faxDiallingCode
     * @return DomainNameContact
     */
    public DomainNameContact setFaxDiallingCode(String faxDiallingCode){
        this.faxDiallingCode = faxDiallingCode;
        return this;
    }

    /**
     * Get the fax
     *
     * @return fax
     */
    public String getFax(){
        return this.fax;
    }

    /**
     * Set the fax
     *
     * @param fax the fax
     * @return DomainNameContact
     */
    public DomainNameContact setFax(String fax){
        this.fax = fax;
        return this;
    }

    /**
     * Get the faxExt
     *
     * @return faxExt
     */
    public String getFaxExt(){
        return this.faxExt;
    }

    /**
     * Set the faxExt
     *
     * @param faxExt the faxExt
     * @return DomainNameContact
     */
    public DomainNameContact setFaxExt(String faxExt){
        this.faxExt = faxExt;
        return this;
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
     * Set the additionalData
     *
     * @param additionalData the additionalData
     * @return DomainNameContact
     */
    public DomainNameContact setAdditionalData(Map<String,Object> additionalData){
        this.additionalData = additionalData;
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
     * Get the pendingContact
     *
     * @return pendingContact
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