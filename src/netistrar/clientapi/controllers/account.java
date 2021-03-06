package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import netistrar.clientapi.exception.RateLimitExceededException;
import netistrar.clientapi.objects.account.AccountNotification;

/**
 * The Account API provides access to account functions including balances and notifications.
*/
public class account extends WebServiceProxy {

    /**
    * @param webServiceURL The URL to call for this webservice
    * @param globalParameters Any global parameters required for this webservice e.g. API Keys etc.
    */
    public account(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Get current account balance for your reseller account in current working currency as defined in the control panel.
     *
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Float balance() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Float>(){}.getType();

        return (Float)super.callMethod("balance", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * List account notifications ordered by the latest first.  This can be optionally limited to a number of notifications
     * and one or more notification types (supplied as an array) for filtering.
     *
     * @param maxResults maxResults
     * @param types types
     * @param subTypes subTypes
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public AccountNotification[] listNotifications(Integer maxResults, String types, String subTypes) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("maxResults", maxResults);
        params.put("types", types);
        params.put("subTypes", subTypes);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<AccountNotification[]>(){}.getType();

        return (AccountNotification[])super.callMethod("notification", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Get an account notification by id.
     *
     * @param notificationId notificationId
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public AccountNotification getNotification(Integer notificationId) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<AccountNotification>(){}.getType();

        return (AccountNotification)super.callMethod("notification/" + notificationId + "", "GET", params, null, returnType,expectedExceptions);
    }


}
