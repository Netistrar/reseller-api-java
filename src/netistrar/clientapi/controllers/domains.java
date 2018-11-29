package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import netistrar.clientapi.objects.domain.descriptor.DomainNameAvailabilityDescriptor;
import netistrar.clientapi.objects.domain.DomainAvailabilityResults;
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

/**
 * The Domains API provides the core services for managing Domains within the Netistrar Registrar system.
 *
 * 
*/
public class domains extends WebServiceProxy {

    public domains(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Provides fast hinted search results for one or more TLDs or predefined TLD Categories for a supplied domain prefix string.  This allows for rapid indicative search results without the overhead of real time checking via each registry.
     *
     * It is strongly recommended that a call is made to the <b>getLiveAvailability</b> function for individual domains before confirming a sale or adding to an application cart.
     *
     * Hinted availability is provided via the use of cached zone file data and an indicator of the cache age is returned
     * as part of the results.  Pricing data is returned according to the availability detected and where premium pricing may apply for a given TLD, a hint of the premium status and pricing is returned via cached premium data where available.
     * The returned object contains DomainAvailability objects structured according to the parameters passed.
     *
     * 
    * @param DomainNameAvailabilityDescriptor descriptor
    */
    public DomainAvailabilityResults hintedAvailability(DomainNameAvailabilityDescriptor descriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<DomainAvailabilityResults>(){}.getType();

        return (DomainAvailabilityResults)super.callMethod("hinted", "POST", params, descriptor, returnType,expectedExceptions);
    }

    /**
     * Get live domain availability for a single domain name.  This actually checks the real time availability with the Registry and returns a single <a href="domain-availability-object">DomainAvailability</a> object with actual availability and confirmed pricing.  This method
     * should be called before committing to a sale (usually at the point of adding to a cart).
     *
     * 
    * @param String domainName
    */
    public DomainAvailability liveAvailability(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<DomainAvailability>(){}.getType();

        return (DomainAvailability)super.callMethod("available/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * List domains currently contained within your account as <a href="../../object/DomainNameSummaryObject">DomainNameSummaryObject</a> items.
     *
     * This method supports paging operations using the <i>pageSize</i> and <i>page</i> parameters and allows for sorting of results using the <i>orderBy</i> and <i>orderDirection</i> parameters.
     *
     * 
    * @param String searchTerm
    * @param Integer pageSize
    * @param Integer page
    * @param String orderBy
    * @param String orderDirection
    */
    public DomainNameListResults list(String searchTerm, Integer pageSize, Integer page, String orderBy, String orderDirection) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("searchTerm", searchTerm);
        params.put("pageSize", pageSize);
        params.put("page", page);
        params.put("orderBy", orderBy);
        params.put("orderDirection", orderDirection);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<DomainNameListResults>(){}.getType();

        return (DomainNameListResults)super.callMethod("", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Return a single domain name from within your account as a full domain name object.
     *
     *
     * 
    * @param String domainName
    */
    public DomainNameObject get(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");


        Type returnType;

        returnType = new TypeToken<DomainNameObject>(){}.getType();

        return (DomainNameObject)super.callMethod("" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Get multiple domain names from within your account as full domain name objects.
     *
     * 
    * @param String[] domainNames
    * @param Boolean ignoreMissingItems
    */
    public Map<String,DomainNameObject> getMultiple(String[] domainNames, Boolean ignoreMissingItems) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("ignoreMissingItems", ignoreMissingItems);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");


        Type returnType;

        returnType = new TypeToken<Map<String,DomainNameObject>>(){}.getType();

        return (Map<String,DomainNameObject>)super.callMethod("multiple", "POST", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Validate one or more domain names for creation using a single set of contact and nameserver details.  This is designed to be called as a lightweight check before calling the create API.
     *
     * 
    * @param DomainNameCreateDescriptor createDescriptor
    */
    public Map<String,Map<String,TransactionError>> validate(DomainNameCreateDescriptor createDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Map<String,Map<String,TransactionError>>>(){}.getType();

        return (Map<String,Map<String,TransactionError>>)super.callMethod("validate", "POST", params, createDescriptor, returnType,expectedExceptions);
    }

    /**
     * Create one or more domain names using a single set of contact and nameserver details.
     *
     * 
    * @param DomainNameCreateDescriptor createDescriptor
    * @param String bulkOperationProgressKey
    */
    public Transaction create(DomainNameCreateDescriptor createDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("", "POST", params, createDescriptor, returnType,expectedExceptions);
    }

    /**
     * Update one or more domain names within your account.  This allows for contact, nameserver and domain name attributes to be updated in bulk.
     *
     * <b>NB: </b> Please note the special additional verification workflow documented below when changing owner contacts for GTLDs.
     *
     * 
    * @param DomainNameUpdateDescriptor updateDescriptor
    * @param String bulkOperationProgressKey
    */
    public Transaction update(DomainNameUpdateDescriptor updateDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("", "PATCH", params, updateDescriptor, returnType,expectedExceptions);
    }

    /**
     * Renew multiple domains
     *
     * 
    * @param DomainNameRenewDescriptor renewDescriptor
    * @param String bulkOperationProgressKey
    */
    public Transaction renew(DomainNameRenewDescriptor renewDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("renew", "POST", params, renewDescriptor, returnType,expectedExceptions);
    }

    /**
     * Check the transfer status for a domain name.  This will return a <b>DomainNameTransferStatus</b> object detailing the timings for the transfer window in progress where the
     * domain is currently in a transfer cycle or N/A if this is not the case
     *
     * 
    * @param String domainName
    */
    public DomainNameTransferStatus transferCheck(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");


        Type returnType;

        returnType = new TypeToken<DomainNameTransferStatus>(){}.getType();

        return (DomainNameTransferStatus)super.callMethod("transfer/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Validate multiple domains for transfer in.  This accepts a transfer descriptor which encodes one or more domain names for transfer in along with proposed contact details.
     *
     * <b>NB: </b>Since the introduction of the 2018 Temporary Specification for GTLD registration data, post transfer contact details need to be supplied upfront when creating / validating incoming transfers
     * as these are no longer readable via WHOIS due to privacy redaction.
     *
     * 
    * @param DomainNameTransferDescriptor transferDescriptor
    */
    public Map<String,Map<String,TransactionError>> transferValidate(DomainNameTransferDescriptor transferDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Map<String,Map<String,TransactionError>>>(){}.getType();

        return (Map<String,Map<String,TransactionError>>)super.callMethod("transfer/validate", "POST", params, transferDescriptor, returnType,expectedExceptions);
    }

    /**
     * Create multiple domains for transfer in. This accepts a transfer descriptor which encodes one or more domain names for transfer in along with proposed contact details.  This call should usually be preceded by a call to <b>validateIncomingTransferDomains</b> to confirm auth codes etc.
     *
     * <b>NB: </b>Since the introduction of the 2018 Temporary Specification for GTLD registration data, post transfer contact details need to be supplied upfront when creating / validating incoming transfers
     * as these are no longer readable via WHOIS due to privacy redaction.
     * <br /><br />
     * If successful, this method starts the transfer process for the supplied domains by taking payment for the transfer (for Pull Transfer operations) and starting the transfer operation with the Registry.
     * It returns a <b>DomainNameTransaction</b> object detailing the result of the operation.
     *
     * <b>For Pull Transfers:</b> Once a transfer is created it will be added to your account with a status of <i>TRANSFER_IN_AWAITING_RESPONSE</i> until it is either cancelled, accepted,
     * rejected or automatically accepted after 5 days.
     *
     * <b>For Push Transfers</b>: the domain name will be imported and activated within your account.
     *
     * 
    * @param DomainNameTransferDescriptor transferDescriptor
    * @param String bulkOperationProgressKey
    */
    public Transaction transferCreate(DomainNameTransferDescriptor transferDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("transfer", "POST", params, transferDescriptor, returnType,expectedExceptions);
    }

    /**
     * Cancel incoming transfer operations for one or more domain names.  Domain transfers can be cancelled while domains have <i>TRANSFER_IN_PENDING_CONFIRMATION</i> or <i>TRANSFER_IN_AWAITING_RESPONSE</i>
     * status (applicable for Pull Transfers only).
     * This operation if successful will cancel the transfer operation and remove the domain name from your account.
     *
     * A <b>DomainNameTransaction</b> object is returned detailing the success or failure for each attempted domain name.
     *
     * 
    * @param String[] domainNames
    */
    public Transaction transferCancel(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("transfer", "DELETE", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Cancel any pending owner contact changes for the supplied domain names.  Pending changes arise when a call to the <b>updateDomainNames</b> method has resulted in a change to key fields for the owner contact of a GTLD.
     *
     * In this case the owner contact will be returned with a status of <b>PENDING_CHANGES</b>.  This method will remove the pending data awaiting verification and restore the Owner contact back a status of <b>LIVE</b> with the previous details intact.  This returns a DomainNameTransaction object with transaction elements which will be successful if the owner contact is pending changes or will contain an operation error if not successful.
     *
     * 
    * @param String[] domainNames
    */
    public Transaction ownerChangeCancel(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("cancelownerchanges", "DELETE", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * List all previously set glue records for a domain name.   Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated
     * nameserver for other domains or indeed the domain name itself.
     *
     * PLEASE NOTE:  This method will only list glue records which have been explicitly set using the <b>setGlueRecords</b> method or via the Netistrar Control Panel.  There is no guarantee that this list is the complete list of records defined at the registry if this name has been transferred into Netistrar with existing additional glue records intact.
     *
     * This method returns an array of <b>DomainNameGlueRecord</b> objects currently defined for the domain name
     *
     * 
    * @param String domainName
    */
    public DomainNameGlueRecord[] glueRecordsList(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");


        Type returnType;

        returnType = new TypeToken<DomainNameGlueRecord[]>(){}.getType();

        return (DomainNameGlueRecord[])super.callMethod("gluerecords/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Set one or more glue records for a domain name.  Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated
     * nameserver for other domains or indeed the domain name itself.
     *
     * This method accepts a domain name and an array of <b>DomainNameGlueRecord</b> objects which comprise a subdomain prefix and either an ipv4 or ipv6 address or both.
     *
     * It returns a <b>DomainNameTransaction</b> object which encodes the result of the set operation with a transaction element for each glue record passed.  If the glue records are
     * in an invalid format or have missing data, a validation error will be returned as part of the element.
     *
     * 
    * @param String domainName
    * @param DomainNameGlueRecord[] glueRecords
    * @param String bulkOperationProgressKey
    */
    public Transaction glueRecordsSet(String domainName, DomainNameGlueRecord[] glueRecords, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("gluerecords/" + domainName + "", "PATCH", params, glueRecords, returnType,expectedExceptions);
    }

    /**
     * Remove one or more glue records for a domain name.  Glue records (sometimes called child nameservers) define explicit mappings of subdomains to IP addresses such that the subdomain may be used as a delegated nameserver for other domains or indeed the domain name itself.
     *
     * This method accepts a domain name and an array of String objects which represent the subdomains to remove as glue records.
     *
     * It returns a <b>DomainNameTransaction</b> object which encodes the result of the remove operation with a transaction element for each glue record passed.  Operation errors will be raised
     * if the glue record does not exist or cannot be removed
     *
     * 
    * @param String domainName
    * @param String[] glueRecordSubdomains
    * @param String bulkOperationProgressKey
    */
    public Transaction glueRecordsRemove(String domainName, String[] glueRecordSubdomains, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("gluerecords/" + domainName + "", "DELETE", params, glueRecordSubdomains, returnType,expectedExceptions);
    }

    /**
     * Get all available TLDs enabled within the system.  This can optionally be limited by one of the categories obtained from the method <b>getAllTLDCategories</b> below.
     *
     * 
    * @param String categoryName
    */
    public String[] tldList(String categoryName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("categoryName", categoryName);

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<String[]>(){}.getType();

        return (String[])super.callMethod("tld", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Get all defined TLD categories as a string array.
     *
     * 
    */
    public String[] tldCategoryList() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();


        Type returnType;

        returnType = new TypeToken<String[]>(){}.getType();

        return (String[])super.callMethod("tldcategory", "GET", params, null, returnType,expectedExceptions);
    }


}
