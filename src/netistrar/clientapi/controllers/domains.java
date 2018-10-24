package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import netistrar.clientapi.objects.domain.DomainNameListResults;
import netistrar.clientapi.objects.domain.DomainNameObject;
import netistrar.clientapi.objects.domain.descriptor.DomainNameCreateDescriptor;
import netistrar.clientapi.objects.domain.DomainNameTransaction;
import netistrar.clientapi.objects.domain.descriptor.DomainNameUpdateDescriptor;
import netistrar.clientapi.objects.domain.descriptor.DomainNameRenewDescriptor;
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

        return (DomainNameListResults)super.callMethod("", "GET", params, null,DomainNameListResults.class);
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
        

        return (DomainNameObject)super.callMethod("" + domainName + "", "GET", params, null,DomainNameObject.class);
    }

    /**
     * Get multiple domain names from within your account as full domain name objects.
     *
     * 
    * @param String[] domainNames
    */
    public DomainNameObject[] getMultiple(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (DomainNameObject[])super.callMethod("multiple", "POST", params, domainNames,DomainNameObject[].class);
    }

    /**
     * Validate one or more domain names for creation using a single set of contact and nameserver details.  This is designed to be called as a lightweight check before calling the create API.
     *
     * 
    * @param DomainNameCreateDescriptor createDescriptor
    */
    public Map<String,Object> validate(DomainNameCreateDescriptor createDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (Map<String,Object>)super.callMethod("validate", "POST", params, createDescriptor,Map.class);
    }

    /**
     * Create one or more domain names using a single set of contact and nameserver details.
     *
     * 
    * @param DomainNameCreateDescriptor createDescriptor
    * @param String bulkOperationProgressKey
    */
    public DomainNameTransaction create(DomainNameCreateDescriptor createDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        return (DomainNameTransaction)super.callMethod("", "POST", params, createDescriptor,DomainNameTransaction.class);
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
    public DomainNameTransaction update(DomainNameUpdateDescriptor updateDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        return (DomainNameTransaction)super.callMethod("", "PATCH", params, updateDescriptor,DomainNameTransaction.class);
    }

    /**
     *
     * 
    * @param DomainNameRenewDescriptor renewDescriptor
    * @param String bulkOperationProgressKey
    */
    public DomainNameTransaction renew(DomainNameRenewDescriptor renewDescriptor, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        return (DomainNameTransaction)super.callMethod("renew", "POST", params, renewDescriptor,DomainNameTransaction.class);
    }

    /**
     * Cancel any pending owner contact changes for the supplied domain names.  Pending changes arise when a call to the <b>updateDomainNames</b> method has resulted in a change to key fields for the owner contact of a GTLD.
     *
     * In this case the owner contact will be returned with a status of <b>PENDING_CHANGES</b>.  This method will remove the pending data awaiting verification and restore the Owner contact back a status of <b>LIVE</b> with the previous details intact.  This returns a DomainNameTransaction object with transaction elements which will be successful if the owner contact is pending changes or will contain an operation error if not successful.
     *
     * 
    * @param String[] domainNames
    */
    public DomainNameTransaction cancelPendingOwnerChanges(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (DomainNameTransaction)super.callMethod("cancelownerchanges", "DELETE", params, domainNames,DomainNameTransaction.class);
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
    public DomainNameGlueRecord[] listGlueRecords(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (DomainNameGlueRecord[])super.callMethod("gluerecords/" + domainName + "", "GET", params, null,DomainNameGlueRecord[].class);
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
    public DomainNameTransaction setGlueRecords(String domainName, DomainNameGlueRecord[] glueRecords, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        return (DomainNameTransaction)super.callMethod("gluerecords/" + domainName + "", "PATCH", params, glueRecords,DomainNameTransaction.class);
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
    public DomainNameTransaction removeGlueRecords(String domainName, String[] glueRecordSubdomains, String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("bulkOperationProgressKey", bulkOperationProgressKey);

        return (DomainNameTransaction)super.callMethod("gluerecords/" + domainName + "", "DELETE", params, glueRecordSubdomains,DomainNameTransaction.class);
    }


}
