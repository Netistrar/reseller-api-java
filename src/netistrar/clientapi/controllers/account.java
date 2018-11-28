package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import netistrar.clientapi.objects.account.AccountNotification;

/**
 * The Account API provides access to account functions including balances and notifications.
 *
 * 
*/
public class account extends WebServiceProxy {

    public account(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Get current account balance for your reseller account in current working currency as defined in the control panel.
     *
     * 
    */
    public Float balance() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (Float)super.callMethod("balance", "GET", params, null,Float.class);
    }

    /**
     * List account notifications ordered by the latest first.  This can be optionally limited to a number of notifications
     * and one or more notification types (supplied as an array) for filtering.
     *
     * 
    * @param Integer maxResults
    * @param String types
    * @param String subTypes
    */
    public AccountNotification[] listNotifications(Integer maxResults, String types, String subTypes) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("maxResults", maxResults);
        params.put("types", types);
        params.put("subTypes", subTypes);

        return (AccountNotification[])super.callMethod("notification", "GET", params, null,AccountNotification[].class);
    }

    /**
     * Get an account notification by id.
     *
     * 
    * @param Integer notificationId
    */
    public AccountNotification getNotification(Integer notificationId) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (AccountNotification)super.callMethod("notification/" + notificationId + "", "GET", params, null,AccountNotification.class);
    }


}
