package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import netistrar.clientapi.exception.RateLimitExceededException;
import netistrar.clientapi.objects.utility.BulkOperationProgress;

/**
 * The Utility API provides utility services in support of the other APIs
*/
public class utility extends WebServiceProxy {

    /**
    * @param webServiceURL The URL to call for this webservice
    * @param globalParameters Any global parameters required for this webservice e.g. API Keys etc.
    */
    public utility(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Ping function for checking API service availability.  Returns OK if successful
     *
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String ping() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String>(){}.getType();

        return (String)super.callMethod("ping", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Create a bulk operation progress key.  This can then be passed to a bulk operation method in e.g. the Domain API to allow progress tracking of the operation
     * using the getBulkOperationProgress method.
     *
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String createBulkOperation() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String>(){}.getType();

        return (String)super.callMethod("bulkoperation", "POST", params, null, returnType,expectedExceptions);
    }

    /**
     * Get the progress for a bulk operation as a BulkOperationProgress object using a progress key generated using the <b>createBulkOperation</b> method.  This will typically be attached to an operation in e.g. the Domain API after which repeated calls can be made asynchronously to this method to check progress.
     *
     * @param bulkOperationProgressKey bulkOperationProgressKey
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public BulkOperationProgress getBulkOperationProgress(String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<BulkOperationProgress>(){}.getType();

        return (BulkOperationProgress)super.callMethod("bulkoperation/" + bulkOperationProgressKey + "", "GET", params, null, returnType,expectedExceptions);
    }


}
