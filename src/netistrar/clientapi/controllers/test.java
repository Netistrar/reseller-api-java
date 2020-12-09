package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import netistrar.clientapi.exception.RateLimitExceededException;
import netistrar.clientapi.objects.test.domain.TestDomainNameUpdateDescriptor;
import netistrar.clientapi.exception.TransactionException;

/**
 * The Test API provides for OTE testing purposes allowing data to be updated or changed directly, circumventing the usual rules in place.  This facilitates in particular transfer testing.
*/
public class test extends WebServiceProxy {

    /**
    * @param webServiceURL The URL to call for this webservice
    * @param globalParameters Any global parameters required for this webservice e.g. API Keys etc.
    */
    public test(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Update the account balance to a new value in UK Pounds.
     *
     * @param newBalance newBalance
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void updateAccountBalance(Integer newBalance) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("updateBalance/" + newBalance + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Update attributes of domain name not usually accessible for testing purposes.
     *
     * @param testDomainNameUpdateDescriptor testDomainNameUpdateDescriptor
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public Boolean updateDomains(TestDomainNameUpdateDescriptor testDomainNameUpdateDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Netistrar\\WebServices\\Common\\Exception\\TransactionException","netistrar.clientapi.exception.TransactionException");
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<Boolean>(){}.getType();

        return (Boolean)super.callMethod("updateDomains", "PUT", params, testDomainNameUpdateDescriptor, returnType,expectedExceptions);
    }

    /**
     * Remove a domain name from your account.  This doesn't remove the domain from the registry if it has been previously registered.
     * <br>This is particularly useful when performing transfer testing etc.
     *
     * @param domainName domainName
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void removeDomainFromAccount(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("removeDomainFromAccount/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Delete a domain - this both removes the domain from your account and issues a delete.  NB:  The delete will behave
     * differently at the Registry end according to the current status of the domain.  This is particularly useful for repeatable testing of
     * registrations of known domains (e.g. Premium Domain testing)
     *
     * @param domainName domainName
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void deleteDomain( domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("deleteDomain/" + domainName + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Create a domain in RGP
     *
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String createRGPDomain() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String>(){}.getType();

        return (String)super.callMethod("createRGPDomain", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Create a set of premium domains for transfer testing.  This will return an array of
     * arrays containing a domain name and auth code
     *
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String[][] createTransferPremiums() throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String[][]>(){}.getType();

        return (String[][])super.callMethod("createTransferPremium", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Create one or more .RODEO domains in a different Registrar account, unlocked and ready for a pull transfer.
     * You can create up to 10 domains using this method and it will return an array of entries where each entry is itself a simple array containing the domain name created
     * and the authorisation code required to start the transfer.
     *
     * @param numberOfDomains numberOfDomains
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String[][] createPullTransferRodeoDomains(Integer numberOfDomains) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String[][]>(){}.getType();

        return (String[][])super.callMethod("createPullTransfer/" + numberOfDomains + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Create one or more UK domains in the Netistrar Registrar account as if they had just been TAG changed to Netistrar.  This allows for testing of the push transfer in logic.<br><br>
     * You can create up to 10 domains using this method and it will return an array of string domain names for the test domains created
     *
     * @param numberOfDomains numberOfDomains
     * @param contactAdditionalData contactAdditionalData
     * @return Result from function
     * @throws Exception Throws server side exceptions of variable types.
     */
    public String[] createPushTransferUKDomains(Integer numberOfDomains, Map<String,Object> contactAdditionalData) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("contactAdditionalData", contactAdditionalData);

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = new TypeToken<String[]>(){}.getType();

        return (String[])super.callMethod("createPushTransfer/" + numberOfDomains + "", "GET", params, null, returnType,expectedExceptions);
    }

    /**
     * Start a transfer out to a different Registrar account for one or more .RODEO domain names currently in your account.  This allows for testing of the Transfer out workflow for
     * Pull transfer domains.
     *
     * @param domainNames domainNames
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void startTransferOutRodeo(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("startTransferOut", "POST", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Accept Ownership confirmation for a transfer for a set of domain names (either .RODEO or .UK) which have been started for transfer in / out
     * using the <i>createIncomingTransferDomains</i> method on the <a href="api:domains-api">Domain API</a> or
     * using the <b>startTransferOutRodeo</b> method above respectively.
     * <br>This is equivalent to clicking the links sent via email to the owner to confirm that the transfer can proceed.
     * <br>In the case of an incoming transfer this will start the transfer operation at the Registry.
     * <br>In the case of an outgoing transfer this will accept the transfer operation started by the <b>startTransferOutForPullTransferRodeoDomains</b> method.
     *
     * @param domainNames domainNames
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void acceptOwnershipConfirmation(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("acceptOwnershipConfirmation", "POST", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Decline Ownership confirmation for a transfer for a set of domain names (either .RODEO or .UK) which have been started for transfer in / out
     * using the <b>createIncomingTransferDomains</b> method on the <a href="api:domains-api">Domain API</a> or
     * using the <b>startTransferOutRodeo</b> method above respectively.
     * <br>This is equivalent to clicking the links sent via email to the owner to decline  the transfer .
     * <br>In the case of an incoming transfer this will abandon the incoming transfer and restore the domain to active state.
     * <br>In the case of an outgoing transfer this will reject the operation started by the <b>startTransferOutForPullTransferRodeoDomains</b> method.
     *
     * @param domainNames domainNames
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void declineOwnershipConfirmation(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("declineOwnershipConfirmation", "POST", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Accepts incoming pull transfers at the other registrar for a set of pull transfer Rodeo domains.  This should be called after a call is made to the <b>createPullTransferRodeoDomains</b> to expedite the
     * transfer in operation at the other end for testing.
     *
     * @param domainNames domainNames
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void approveIncomingTransferOtherRegistrar(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("approveIncomingTransfer", "POST", params, domainNames, returnType,expectedExceptions);
    }

    /**
     * Rejects incoming pull transfers at the other registrar for a set of pull transfer Rodeo domains.  This should be called after a call is made to the <a href="#approveOwnershipConfirmationForTransfer">approveOwnershipConfirmationForTransfer</a> to reject the
     * transfer in operation at the other end for testing
     *
     * @param domainNames domainNames
     * @throws Exception Throws server side exceptions of variable types.
     */
    public void rejectIncomingTransferOtherRegistrar(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        Map<String, String> expectedExceptions = new HashMap<String, String>();
        expectedExceptions.put("\\Kinikit\\MVC\\Exception\\RateLimitExceededException","netistrar.clientapi.exception.RateLimitExceededException");


        Type returnType;

        returnType = Object.class;

        super.callMethod("rejectIncomingTransfer", "POST", params, domainNames, returnType,expectedExceptions);
    }


}
