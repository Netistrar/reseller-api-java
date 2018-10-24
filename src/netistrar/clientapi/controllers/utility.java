package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import netistrar.clientapi.objects.utility.BulkOperationProgress;

/**
 * The Utility API provides utility services in support of the other APIs
 *
 * 
*/
public class utility extends WebServiceProxy {

    public utility(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Ping function for checking API service availability.  Returns OK if successful
     *
     * 
    */
    public String ping() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (String)super.callMethod("ping", "GET", params, null,String.class);
    }

    /**
     * Create a bulk operation progress key.  This can then be passed to a bulk operation method in e.g. the Domain API to allow progress tracking of the operation
     * using the getBulkOperationProgress method.
     *
     * 
    */
    public String createBulkOperation() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (String)super.callMethod("bulkoperation", "POST", params, null,String.class);
    }

    /**
     * Get the progress for a bulk operation as a BulkOperationProgress object using a progress key generated using the createBulkOperation method.  This will typically be attached to an operation in
     * e.g. the Domain API after which repeated calls can be made asynchronously to this method to check progress.
     *
     * 
    * @param String bulkOperationProgressKey
    */
    public BulkOperationProgress getBulkOperationProgress(String bulkOperationProgressKey) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (BulkOperationProgress)super.callMethod("bulkoperation/" + bulkOperationProgressKey + "", "GET", params, null,BulkOperationProgress.class);
    }


}
