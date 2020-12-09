package netistrar.clientapi.objects.gsuite;

import netistrar.clientapi.objects.contact.Contact;
import java.util.Map;

/**
 * A read only object representing a GSuite subscription for an account holder.
*/
public class GSuite  {


    /**
     * If this GSuite has been activated the identifier will be the same as the primary domain name.  Otherwise it will be a numeric
     * identifier used temporarily until the domain name has been assigned.
     */
    protected String identifier;
    /**
     * The GSuite plan type - either <b>Monthly</b> or <b>Annual</b>.
     */
    protected String planType;
    /**
     * The number of licenced users at the point of renewal.  This will be different to numberOfLicencedUsers
     * if there has been a request to reduce licences.
     */
    protected Integer renewingNumberOfUsers;
    /**
     * The primary domain name for this GSuite if defined
     */
    protected String primaryDomainName;
    /**
     * The GSuite product - either <b>Basic</b>, <b>Business</b> or <b>Enterprise</b>.
     */
    protected String gsuiteProduct;
    /**
     * The date that this subscription is next due to renew.
     */
    protected String renewalDate;
    /**
     * Number of licenced users currently in play.
     */
    protected Integer numberOfLicencedUsers;
    /**
     * The plan type being activated at renewal time (either <b>Monthly</b> or <b>Annual</b>)
     * This will match the plan type unless another one has been scheduled.
     */
    protected String renewingPlanType;
    /**
     * The status of this GSuite subscription
     * should be either <b>PENDING_DOMAIN</b>, <b>PENDING_ACTIVATION</b>, <b>ACTIVE</b> or <b>SUSPENDED</b>.
     */
    protected String status;
    /**
     * The account contact as a nested object
     */
    protected Contact contact;
    /**
     * The google verification token used for DNS verification.
     */
    protected String verificationToken;
    /**
     * Flag determining whether this subscription will auto renew.  In the case of an <b>Annual</b>
     * subscription this determines whether or not the user needs to renew it manually.
     * In the case of a <b>Monthly</b> subscription if this is set to false the subscription will be cancelled
     * at the end of the current monthly period.
     */
    protected Boolean autoRenew;



    /**
    * Blank Constructor
    *
    */
    public GSuite(){
    }



    /**
     * Get the identifier
     *
     * @return identifier
     */
    public String getIdentifier(){
        return this.identifier;
    }

    /**
     * Get the planType
     *
     * @return planType
     */
    public String getPlanType(){
        return this.planType;
    }

    /**
     * Get the renewingNumberOfUsers
     *
     * @return renewingNumberOfUsers
     */
    public Integer getRenewingNumberOfUsers(){
        return this.renewingNumberOfUsers;
    }

    /**
     * Get the primaryDomainName
     *
     * @return primaryDomainName
     */
    public String getPrimaryDomainName(){
        return this.primaryDomainName;
    }

    /**
     * Get the gsuiteProduct
     *
     * @return gsuiteProduct
     */
    public String getGsuiteProduct(){
        return this.gsuiteProduct;
    }

    /**
     * Get the renewalDate
     *
     * @return renewalDate
     */
    public String getRenewalDate(){
        return this.renewalDate;
    }

    /**
     * Get the numberOfLicencedUsers
     *
     * @return numberOfLicencedUsers
     */
    public Integer getNumberOfLicencedUsers(){
        return this.numberOfLicencedUsers;
    }

    /**
     * Get the renewingPlanType
     *
     * @return renewingPlanType
     */
    public String getRenewingPlanType(){
        return this.renewingPlanType;
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
     * Get the contact
     *
     * @return contact
     */
    public Contact getContact(){
        return this.contact;
    }

    /**
     * Get the verificationToken
     *
     * @return verificationToken
     */
    public String getVerificationToken(){
        return this.verificationToken;
    }

    /**
     * Get the autoRenew
     *
     * @return autoRenew
     */
    public Boolean getAutoRenew(){
        return this.autoRenew;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof GSuite))
            return false;

        GSuite castObject = (GSuite)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getIdentifier() == null && castObject.getIdentifier() == null) ||
            (this.getIdentifier() != null && this.getIdentifier().equals(castObject.getIdentifier())));
        equals = equals && ( (this.getPlanType() == null && castObject.getPlanType() == null) ||
            (this.getPlanType() != null && this.getPlanType().equals(castObject.getPlanType())));
        equals = equals && ( (this.getRenewingNumberOfUsers() == null && castObject.getRenewingNumberOfUsers() == null) ||
            (this.getRenewingNumberOfUsers() != null && this.getRenewingNumberOfUsers().equals(castObject.getRenewingNumberOfUsers())));
        equals = equals && ( (this.getPrimaryDomainName() == null && castObject.getPrimaryDomainName() == null) ||
            (this.getPrimaryDomainName() != null && this.getPrimaryDomainName().equals(castObject.getPrimaryDomainName())));
        equals = equals && ( (this.getGsuiteProduct() == null && castObject.getGsuiteProduct() == null) ||
            (this.getGsuiteProduct() != null && this.getGsuiteProduct().equals(castObject.getGsuiteProduct())));
        equals = equals && ( (this.getRenewalDate() == null && castObject.getRenewalDate() == null) ||
            (this.getRenewalDate() != null && this.getRenewalDate().equals(castObject.getRenewalDate())));
        equals = equals && ( (this.getNumberOfLicencedUsers() == null && castObject.getNumberOfLicencedUsers() == null) ||
            (this.getNumberOfLicencedUsers() != null && this.getNumberOfLicencedUsers().equals(castObject.getNumberOfLicencedUsers())));
        equals = equals && ( (this.getRenewingPlanType() == null && castObject.getRenewingPlanType() == null) ||
            (this.getRenewingPlanType() != null && this.getRenewingPlanType().equals(castObject.getRenewingPlanType())));
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getContact() == null && castObject.getContact() == null) ||
            (this.getContact() != null && this.getContact().equals(castObject.getContact())));
        equals = equals && ( (this.getVerificationToken() == null && castObject.getVerificationToken() == null) ||
            (this.getVerificationToken() != null && this.getVerificationToken().equals(castObject.getVerificationToken())));
        equals = equals && ( (this.getAutoRenew() == null && castObject.getAutoRenew() == null) ||
            (this.getAutoRenew() != null && this.getAutoRenew().equals(castObject.getAutoRenew())));

        return equals;
    }


}