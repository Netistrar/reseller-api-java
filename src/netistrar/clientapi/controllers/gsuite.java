package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import netistrar.clientapi.objects.gsuite.GSuite;
import netistrar.clientapi.exception.RateLimitExceededException;
import netistrar.clientapi.objects.gsuite.descriptor.GSuiteCreateDescriptor;
import netistrar.clientapi.objects.transaction.Transaction;
import netistrar.clientapi.objects.gsuite.descriptor.GSuiteUpdateDescriptor;
import netistrar.clientapi.objects.transaction.Transaction;

/**
 * The GSuite API provides functionality to create and manage GSuite Plans
*/
public class gsuite extends WebServiceProxy {

    /**
    * @param webServiceURL The URL to call for this webservice
    * @param globalParameters Any global parameters required for this webservice e.g. API Keys etc.
    */
    public gsuite(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * List all G Suite subscriptions within your account.
     *
     * @param pageSize pageSize
     * @param page page
     * @param orderBy orderBy
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public GSuite[] list(Integer pageSize, Integer page, Integer orderBy) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("pageSize", pageSize);
        params.put("page", page);
        params.put("orderBy", orderBy);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<GSuite[]>(){}.getType();

        return (GSuite[])super.callMethod("", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Get a single G Suite subscription within your account by domain name.
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public GSuite get(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<GSuite>(){}.getType();

        return (GSuite)super.callMethod("" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Check whether the supplied domain name is available for creating a G Suite subscription.
     * This will return one of the following values
     * <br><b>AVAILABLE</b> if the domain is available for attachment of a new G Suite subscription
     * <b>UNAVAILABLE</b> if another G Suite subscription is attached to this domain already externally.
     * <b>ALREADY_ATTACHED</b> if another G Suite subscription is attached to this domain from within your account.
     *
     * @param domainName domainName
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String available(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String>(){}.getType();

        return (String)super.callMethod("available/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Create a G Suite subscription for an existing domain within your account.
     *
     * @param domainName domainName
     * @param createDescriptor createDescriptor
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction create(String domainName, GSuiteCreateDescriptor createDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("" + domainName + "", "POST", params, createDescriptor, returnType,expectedExceptions);
    }

    /**
     * Update a G Suite subscription for an existing subscription within your account.
     *
     * @param domainName domainName
     * @param updateDescriptor updateDescriptor
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Transaction update(String domainName, GSuiteUpdateDescriptor updateDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Transaction>(){}.getType();

        return (Transaction)super.callMethod("" + domainName + "", "PUT", params, updateDescriptor, returnType,expectedExceptions);
    }

    /**
     * Cancel a G Suite subscription - This will not cancel the subscription immediately
     * but instead schedule it to not be renewed at the next renewal date.
     *
     * @param domainName domainName
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void cancel( domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("" + domainName + "", "DELETE", params, null, returnType,expectedExceptions);
    }

    /**
     * Restore a G Suite subscription which may have been cancelled in error.  Please note that this
     * can only be done before the renewal date after which a new subscription will need to be created.
     *
     * @param domainName domainName
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void restore( domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("" + domainName + "", "PATCH", params, null, returnType,expectedExceptions);
    }

    /**
     * Suspend a G Suite subscription.  This would usually be in the scenario that a customer
     * hasn't paid.
     *
     * @param domainName domainName
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void suspend(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("suspend/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Unsuspend a G Suite subscription which you have previously suspended.
     *
     * @param domainName domainName
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void unsuspend(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("unsuspend/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }


}
