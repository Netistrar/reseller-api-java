package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import netistrar.clientapi.objects.domain.descriptor.DomainNameAvailabilityDescriptor;
import netistrar.clientapi.objects.domain.DomainAvailabilityResults;
import netistrar.clientapi.exception.RateLimitExceededException;
import netistrar.clientapi.objects.domain.DomainAvailability;
import netistrar.clientapi.objects.domain.DomainNameListResults;
import netistrar.clientapi.objects.domain.DomainNameObject;
import netistrar.clientapi.exception.TransactionException;
import netistrar.clientapi.objects.domain.descriptor.DomainNameCreateDescriptor;
import netistrar.clientapi.objects.transaction.TransactionError;
import netistrar.clientapi.objects.transaction.Transaction;
import netistrar.clientapi.objects.domain.descriptor.DomainNameUpdateDescriptor;
import netistrar.clientapi.objects.domain.descriptor.DomainNameRenewDescriptor;
import netistrar.clientapi.objects.domain.DomainNameTransferStatus;
import netistrar.clientapi.objects.domain.descriptor.DomainNameTransferDescriptor;
import netistrar.clientapi.objects.domain.DomainNameGlueRecord;
import netistrar.clientapi.objects.domain.DomainNameDNSSECRecord;

/**
 * The Domains API provides the core services for managing Domains within the Netistrar Registrar system.
*/
public class domains extends WebServiceProxy {

    /**
    * @param webServiceURL The URL to call for this webservice
    * @param globalParameters Any global parameters required for this webservice e.g. API Keys etc.
    */
    public domains(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Provides fast hinted search results for one or more TLDs or predefined TLD Categories for a supplied domain prefix string.  This allows for rapid indicative search results without the overhead of real time checking via each registry.
     * <br>It is strongly recommended that a call is made to the <b>getLiveAvailability</b> function for individual domains before confirming a sale or adding to an application cart.
     * Hinted availability is provided via the use of cached zone file data.  Pricing data is returned according to the availability detected and where premium pricing may apply for a given TLD, a hint of the premium status and pricing is returned via cached premium data where available.
     * <br>The returned object contains DomainAvailability objects structured according to the parameters passed.
     *
     * @param descriptor descriptor
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainAvailabilityResults hintedAvailability(DomainNameAvailabilityDescriptor descriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainAvailabilityResults>(){}.getType();

        return (DomainAvailabilityResults)super.callMethod("hinted", "POST", params, descriptor, returnType,expectedExceptions);
    }

    /**
     * Get live domain availability for a single domain name.  This actually checks the real time availability with the Registry and returns a single <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainAvailability">DomainAvailability</a> object with actual availability and confirmed pricing.  This method
     * should be called before committing to a sale (usually at the point of adding to a cart).
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainAvailability liveAvailability(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainAvailability>(){}.getType();

        return (DomainAvailability)super.callMethod("available/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * List domains currently contained within your account as <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainNameSummary">DomainNameSummary</a> items.
     * This method supports paging operations using the <i>pageSize</i> and <i>page</i> parameters and allows for sorting of results using the <i>orderBy</i> and <i>orderDirection</i> parameters.
     *
     * @param searchTerm searchTerm
     * @param pageSize pageSize
     * @param page page
     * @param orderBy orderBy
     * @param orderDirection orderDirection
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainNameListResults list(String searchTerm, Integer pageSize, Integer page, String orderBy, String orderDirection) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("searchTerm", searchTerm);
        params.put("pageSize", pageSize);
        params.put("page", page);
        params.put("orderBy", orderBy);
        params.put("orderDirection", orderDirection);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainNameListResults>(){}.getType();

        return (DomainNameListResults)super.callMethod("", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Return a single domain name from within your account as a full domain name object.
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainNameObject get(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainNameObject>(){}.getType();

        return (DomainNameObject)super.callMethod("" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Get multiple domain names from within your account as full domain name objects.
     *
     * @param domainNames domainNames
     * @param ignoreMissingItems ignoreMissingItems
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Map<String,DomainNameObject> getMultiple(String[] domainNames, Boolean ignoreMissingItems) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("ignoreMissingItems", ignoreMissingItems);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Map<String,DomainNameObject>>(){}.getType();

        return (Map<String,DomainNameObject>)super.callMethod("multiple", "POST", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Validate one or more domain names for creation using a single set of contact and nameserver details.  This is designed to be called as a lightweight check before calling the create API.
     *
     * @param createDescriptor createDescriptor
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Map<String,Map<String,TransactionError>> validate(DomainNameCreateDescriptor createDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Map<String,Map<String,TransactionError>>>(){}.getType();

        return (Map<String,Map<String,TransactionError>>)super.callMethod("validate", "POST", params, createDescriptor, returnType,expectedExceptions);
    }

    /**
     * Create one or more domain names using a single set of contact and nameserver details.
     *
     * @param createDescriptor createDescriptor
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction create(DomainNameCreateDescriptor createDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("", "POST", params, createDescriptor, returnType,expectedExceptions);
    }

    /**
     * Update one or more domain names within your account.  This allows for contact, nameserver and domain name attributes to be updated in bulk.
     * <b>NB: </b> Please note the special additional verification workflow documented below when changing owner contacts for GTLDs.
     *
     * @param updateDescriptor updateDescriptor
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction update(DomainNameUpdateDescriptor updateDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("", "PATCH", params, updateDescriptor, returnType,expectedExceptions);
    }

    /**
     * Renew a single domain for the number of years supplied.
     *
     * @param domainName domainName
     * @param numberOfYears numberOfYears
     * @param premiumRenewalCode premiumRenewalCode
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction renew(String domainName, Integer numberOfYears, String premiumRenewalCode) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("premiumRenewalCode", premiumRenewalCode);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("renew/" + domainName + "/" + numberOfYears + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Renew multiple domains
     *
     * @param renewDescriptor renewDescriptor
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction renewMultiple(DomainNameRenewDescriptor renewDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("renew", "POST", params, renewDescriptor, returnType,expectedExceptions);
    }

    /**
     * Restore a single domain name from RGP using the supplied <b>restoreCode</b> and then renew the domain using the number of renewal years supplied.  This is modelled as a GET
     * method for convenience of use in e.g. a browser etc.
     * The Restore Code is obtained via a call to the <b>getLiveAvailability</b> function where it will be contained in the <b>restoreCode</b>
     * sub property of the <b>additionalData</b> member on the returned <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainAvailability">DomainAvailability</a> object
     *
     * @param domainName domainName
     * @param restoreCode restoreCode
     * @param numberOfRenewalYears numberOfRenewalYears
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction restore( domainName,  restoreCode,  numberOfRenewalYears) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("restoreCode", restoreCode);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("restore/" + domainName + "/" + redemptionCode + "/" + numberOfRenewalYears + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Check the transfer status for a domain name.  This will return a <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainNameTransferStatus">DomainNameTransferStatus</a> object detailing the timings for the transfer window in progress where the domain is currently in a transfer cycle or N/A if this is not the case
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainNameTransferStatus transferCheck(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainNameTransferStatus>(){}.getType();

        return (DomainNameTransferStatus)super.callMethod("transfer/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Validate multiple domains for transfer in.  This accepts a transfer descriptor which encodes one or more domain names for transfer in along with proposed contact details.
     * <br><b>NB: </b>Since the introduction of the 2018 Temporary Specification for GTLD registration data, post transfer contact details need to be supplied upfront when creating / validating incoming transfers
     * as these are no longer readable via WHOIS due to privacy redaction.
     *
     * @param transferDescriptor transferDescriptor
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Map<String,Map<String,TransactionError>> transferValidate(DomainNameTransferDescriptor transferDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Map<String,Map<String,TransactionError>>>(){}.getType();

        return (Map<String,Map<String,TransactionError>>)super.callMethod("transfer/validate", "POST", params, transferDescriptor, returnType,expectedExceptions);
    }

    /**
     * Create multiple domains for transfer in. This accepts a transfer descriptor which encodes one or more domain names for transfer in along with proposed contact details.  This call should usually be preceded by a call to <b>validateIncomingTransferDomains</b> to confirm auth codes etc.
     * <br><b>NB: </b>Since the introduction of the 2018 Temporary Specification for GTLD registration data, post transfer contact details need to be supplied upfront when creating / validating incoming transfers
     * as these are no longer readable via WHOIS due to privacy redaction.
     * <br>
     * If successful, this method starts the transfer process for the supplied domains by taking payment for the transfer (for Pull Transfer operations) and starting the transfer operation with the Registry.
     * It returns a <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object detailing the result of the operation.
     * <b>For Pull Transfers:</b> Once a transfer is created it will be added to your account with a status of <i>TRANSFER_IN_AWAITING_RESPONSE</i> until it is either cancelled, accepted,
     * rejected or automatically accepted after 5 days.
     * <b>For Push Transfers</b>: the domain name will be imported and activated within your account.
     *
     * @param transferDescriptor transferDescriptor
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction transferCreate(DomainNameTransferDescriptor transferDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("transfer", "POST", params, transferDescriptor, returnType,expectedExceptions);
    }

    /**
     * Cancel incoming transfer operations for one or more domain names.  Domain transfers can be cancelled while domains have <i>TRANSFER_IN_PENDING_CONFIRMATION</i> or <i>TRANSFER_IN_AWAITING_RESPONSE</i>
     * status (applicable for Pull Transfers only).
     * <br>This operation if successful will cancel the transfer operation and remove the domain name from your account.
     * <br>A a <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object is returned detailing the success or failure for each attempted domain name.
     *
     * @param domainNames domainNames
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction transferCancel(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("transfer", "DELETE", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Cancel any pending owner contact changes for the supplied domain names.  Pending changes arise when a call to the <b>updateDomainNames</b> method has resulted in a change to key fields for the owner contact of a GTLD.
     * <br>In this case the owner contact will be returned with a status of <b>PENDING_CHANGES</b>.  This method will remove the pending data awaiting verification and restore the Owner contact back a status of <b>LIVE</b> with the previous details intact.  This returns a DomainNameTransaction object with transaction elements which will be successful if the owner contact is pending changes or will contain an operation error if not successful.
     *
     * @param domainNames domainNames
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction ownerChangeCancel(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("cancelownerchanges", "DELETE", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * List all previously set glue records for a domain name.   Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated
     * nameserver for other domains or indeed the domain name itself.
     * <br>PLEASE NOTE:  This method will only list glue records which have been explicitly set using the <b>setGlueRecords</b> method or via the Netistrar Control Panel.  There is no guarantee that this list is the complete list of records defined at the registry if this name has been transferred into Netistrar with existing additional glue records intact.
     * <br>This method returns an array of <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainNameGlueRecord">DomainNameGlueRecord</a> objects currently defined for the domain name
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainNameGlueRecord[] glueRecordsList(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainNameGlueRecord[]>(){}.getType();

        return (DomainNameGlueRecord[])super.callMethod("gluerecords/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Set one or more glue records for a domain name.  Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated
     * nameserver for other domains or indeed the domain name itself.
     * <br>This method accepts a domain name and an array of <a href="object:Netistrar/WebServices/Common/Objects/Domain/DomainNameGlueRecord">DomainNameGlueRecord</a> objects which comprise a subdomain prefix and either an ipv4 or ipv6 address or both.
     * <br>It returns a <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object which encodes the result of the set operation with a transaction element for each glue record passed.  If the glue records are
     * in an invalid format or have missing data, a validation error will be returned as part of the element.
     *
     * @param domainName domainName
     * @param glueRecords glueRecords
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction glueRecordsSet(String domainName, DomainNameGlueRecord[] glueRecords, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("gluerecords/" + domainName + "", "PATCH", params, glueRecords, returnType,expectedExceptions);
    }

    /**
     * Remove one or more glue records for a domain name.  Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated nameserver for other domains or indeed the domain name itself.
     * <br>This method accepts a domain name and an array of String objects which represent the subdomains to remove as glue records.
     * <br>It returns a <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object which encodes the result of the remove operation with a transaction element for each glue record passed.  Operation errors will be raised
     * if the glue record does not exist or cannot be removed
     *
     * @param domainName domainName
     * @param glueRecordSubdomains glueRecordSubdomains
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction glueRecordsRemove(String domainName, String[] glueRecordSubdomains, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("gluerecords/" + domainName + "", "DELETE", params, glueRecordSubdomains, returnType,expectedExceptions);
    }

    /**
     * List DNSSEC Records for a supplied domain name.  DNSSEC records are obtained from the DNS provider for the domain name and represent a secure DNS
     * chain of trust up to the internet root nameservers.
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public DomainNameDNSSECRecord[] dnssecRecordsList(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<DomainNameDNSSECRecord[]>(){}.getType();

        return (DomainNameDNSSECRecord[])super.callMethod("dnssec/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Add DNSSEC Records for a supplied domain name  DNSSEC records are obtained from the DNS provider for the domain name and represent a secure DNS
     * chain of trust up to the internet root nameservers.
     * <br>It returns a <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object which encodes the result of the set operation with a transaction element for each DNSSEC record passed.  If the DNSSEC records are
     * in an invalid format or have missing data, a validation error will be returned as part of the element.
     *
     * @param domainName domainName
     * @param dnsSecRecords dnsSecRecords
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction dnssecRecordsAdd(String domainName, DomainNameDNSSECRecord[] dnsSecRecords) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("dnssec/" + domainName + "", "POST", params, dnsSecRecords, returnType,expectedExceptions);
    }

    /**
     * Remove one or more DNSSEC Records for a supplied domain name and array of key tag strings
     * <br>It returns a <a href="object:Netistrar/WebServices/Common/Objects/Transaction/Transaction">Transaction</a> object which encodes the result of the remove operation with a transaction element for each DNSSEC record passed.  Operation errors will be raised
     * if the DNSSEC record does not exist or cannot be removed
     *
     * @param domainName domainName
     * @param keyTags keyTags
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction dnssecRecordsRemove(String domainName, String[] keyTags) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("dnssec/" + domainName + "", "DELETE", params, keyTags, returnType,expectedExceptions);
    }

    /**
     * Remove all DNSSEC Records for a supplied domain name.  This will effectively remove all DNSSEC records and mark the domain as not enabled for DNSSEC.
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction dnssecDisable(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("dnssec/disable/" + domainName + "", "DELETE", params, null, returnType,expectedExceptions);
    }

    /**
     * Get all available TLDs enabled within the system.  This can optionally be limited by one of the categories obtained from the method <b>getAllTLDCategories</b> below.
     *
     * @param categoryName categoryName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String[] tldList(String categoryName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("categoryName", categoryName);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String[]>(){}.getType();

        return (String[])super.callMethod("tld", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Get all defined TLD categories as a string array.
     *
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String[] tldCategoryList() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String[]>(){}.getType();

        return (String[])super.callMethod("tldcategory", "GET", params, null, returnType,expectedExceptions);
    }


}
