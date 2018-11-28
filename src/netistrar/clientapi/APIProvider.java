package netistrar.clientapi;

import java.util.Map;
import java.util.HashMap;
import netistrar.clientapi.framework.WebServiceProxy;
import netistrar.clientapi.controllers.domains;
import netistrar.clientapi.controllers.utility;
import netistrar.clientapi.controllers.account;
import netistrar.clientapi.controllers.test;

public class APIProvider  {

    private String apiURL;
    private String apiKey;
    private Map<String, String> globalParameters = new HashMap<String, String>();
    private Map<String, WebServiceProxy> instances = new HashMap<String, WebServiceProxy>();

    /**
    * Construct with the api url and the api key for access.
    *
    * @param String apiURL
    * @param String apiKey
    * @param String apiSecret
    */
    public APIProvider(String apiURL, String apiKey, String apiSecret){
        this.apiURL = apiURL;
        this.globalParameters.put("apiKey", apiKey);
        this.globalParameters.put("apiSecret", apiSecret);
    }

    /**
    * Get an instance of the domains API
    *
    * @return 
    */
    public domains domains(){
        if (this.instances.get("domains") == null){
            this.instances.put("domains", new domains(this.apiURL + "/domains", this.globalParameters));
        }
        return (domains)this.instances.get("domains");
    }

    /**
    * Get an instance of the utility API
    *
    * @return 
    */
    public utility utility(){
        if (this.instances.get("utility") == null){
            this.instances.put("utility", new utility(this.apiURL + "/utility", this.globalParameters));
        }
        return (utility)this.instances.get("utility");
    }

    /**
    * Get an instance of the account API
    *
    * @return 
    */
    public account account(){
        if (this.instances.get("account") == null){
            this.instances.put("account", new account(this.apiURL + "/account", this.globalParameters));
        }
        return (account)this.instances.get("account");
    }

    /**
    * Get an instance of the test API
    *
    * @return 
    */
    public test test(){
        if (this.instances.get("test") == null){
            this.instances.put("test", new test(this.apiURL + "/test", this.globalParameters));
        }
        return (test)this.instances.get("test");
    }




}