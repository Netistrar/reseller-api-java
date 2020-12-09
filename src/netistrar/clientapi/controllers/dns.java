package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


/**
 * The DNS API allows management of DNS records for domains which have been activated with the
 * Netistrar Free DNS service.
*/
public class dns extends WebServiceProxy {

    /**
    * @param webServiceURL The URL to call for this webservice
    * @param globalParameters Any global parameters required for this webservice e.g. API Keys etc.
    */
    public dns(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }


}
