package netistrar.clientapi.objects.contact;

import java.util.Map;

/**
 * Base contact class used for general API use.
 * Class Contact
*/
public class Contact  {


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
    * Blank Constructor
    *
    */
    public Contact(){
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
    */
    public Contact(String name, String emailAddress, String organisation, String street1, String street2, String city, String county, String postcode, String country, String telephoneDiallingCode, String telephone, String telephoneExt, String faxDiallingCode, String fax, String faxExt){

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
     * @return Contact
     */
    public Contact setName(String name){
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
     * @return Contact
     */
    public Contact setEmailAddress(String emailAddress){
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
     * @return Contact
     */
    public Contact setOrganisation(String organisation){
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
     * @return Contact
     */
    public Contact setStreet1(String street1){
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
     * @return Contact
     */
    public Contact setStreet2(String street2){
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
     * @return Contact
     */
    public Contact setCity(String city){
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
     * @return Contact
     */
    public Contact setCounty(String county){
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
     * @return Contact
     */
    public Contact setPostcode(String postcode){
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
     * @return Contact
     */
    public Contact setCountry(String country){
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
     * @return Contact
     */
    public Contact setTelephoneDiallingCode(String telephoneDiallingCode){
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
     * @return Contact
     */
    public Contact setTelephone(String telephone){
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
     * @return Contact
     */
    public Contact setTelephoneExt(String telephoneExt){
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
     * @return Contact
     */
    public Contact setFaxDiallingCode(String faxDiallingCode){
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
     * @return Contact
     */
    public Contact setFax(String fax){
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
     * @return Contact
     */
    public Contact setFaxExt(String faxExt){
        this.faxExt = faxExt;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof Contact))
            return false;

        Contact castObject = (Contact)otherObject;

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

        return equals;
    }


}