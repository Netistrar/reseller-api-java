package netistrar.clientapi.controllers;

import netistrar.clientapi.framework.WebServiceProxy;
import java.util.Map;
import java.util.HashMap;
import netistrar.clientapi.objects.test.domain.TestDomainNameUpdateDescriptor;
import netistrar.clientapi.exception.TransactionException;

/**
 * The Test API provides for OTE testing purposes allowing data to be updated or changed directly, circumventing the usual rules in place.  This facilitates in particular transfer testing.
 *
 * 
*/
public class test extends WebServiceProxy {

    public test(String webServiceURL, Map<String,String> globalParameters){
        super(webServiceURL, globalParameters);
    }

    /**
     * Update the account balance to a new value in UK Pounds.
     *
     * 
    * @param Integer newBalance
    */
    public void updateAccountBalance(Integer newBalance) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("updateBalance/" + newBalance + "", "GET", params, null,Object.class);
    }

    /**
     * Update attributes of domain name not usually accessible for testing purposes.
     *
     * 
    * @param TestDomainNameUpdateDescriptor testDomainNameUpdateDescriptor
    */
    public Boolean updateDomains(TestDomainNameUpdateDescriptor testDomainNameUpdateDescriptor) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (Boolean)super.callMethod("updateDomains", "PUT", params, testDomainNameUpdateDescriptor,Boolean.class);
    }

    /**
     * Remove a domain name from your account.  This doesn't remove the domain from the registry if it has been previously registered.
     * This is particularly useful when performing transfer testing etc.
     *
     * 
    * @param String domainName
    */
    public void removeDomainFromAccount(String domainName) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("removeDomainFromAccount/" + domainName + "", "GET", params, null,Object.class);
    }

    /**
     * Create one or more .RODEO domains in a different Registrar account, unlocked and ready for a pull transfer.
     *
     * You can create up to 10 domains using this method and it will return an array of entries where each entry is itself a simple array containing the domain name created
     * and the authorisation code required to start the transfer.
     *
     * 
    * @param Integer numberOfDomains
    */
    public String[][] createPullTransferRodeoDomains(Integer numberOfDomains) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (String[][])super.callMethod("createPullTransfer/" + numberOfDomains + "", "GET", params, null,String[][].class);
    }

    /**
     * Create one or more UK domains in the Netistrar Registrar account as if they had just been TAG changed to Netistrar.  This allows for testing of the push transfer in logic.<br /><br />
     * You can create up to 10 domains using this method and it will return an array of string domain names for the test domains created
     *
     * 
    * @param Integer numberOfDomains
    */
    public String[] createPushTransferUKDomains(Integer numberOfDomains) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        return (String[])super.callMethod("createPushTransfer/" + numberOfDomains + "", "GET", params, null,String[].class);
    }

    /**
     * Start a transfer out to a different Registrar account for one or more .RODEO domain names currently in your account.  This allows for testing of the Transfer out workflow for
     * Pull transfer domains.
     *
     * 
    * @param String[] domainNames
    */
    public void startTransferOutRodeo(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("startTransferOut", "POST", params, domainNames,Object.class);
    }

    /**
     * Accept Ownership confirmation for a transfer for a set of domain names (either .RODEO or .UK) which have been started for transfer in / out
     * using the <i>createIncomingTransferDomains</i> method on the <a href="netistrar-domain-transfer-api">Domain API</a> or
     * using the <b>startTransferOutRodeo</b> method above respectively.
     *
     * This is equivalent to clicking the links sent via email to the owner to confirm that the transfer can proceed.
     *
     * In the case of an incoming transfer this will start the transfer operation at the Registry.
     *
     * In the case of an outgoing transfer this will accept the transfer operation started by the <a href="#startTransferOutForPullTransferRodeoDomains">startTransferOutForPullTransferRodeoDomains</a> method.
     *
     * 
    * @param String[] domainNames
    */
    public void acceptOwnershipConfirmation(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("acceptOwnershipConfirmation", "POST", params, domainNames,Object.class);
    }

    /**
     * Decline Ownership confirmation for a transfer for a set of domain names (either .RODEO or .UK) which have been started for transfer in / out
     * using the <i>createIncomingTransferDomains</i> method on the <a href="netistrar-domain-transfer-api">Domain API</a> or
     * using the <b>startTransferOutRodeo</b> method above respectively.
     *
     * This is equivalent to clicking the links sent via email to the owner to decline  the transfer .
     *
     * In the case of an incoming transfer this will abandon the incoming transfer and restore the domain to active state.
     *
     * In the case of an outgoing transfer this will reject the operation started by the <b>startTransferOutForPullTransferRodeoDomains</b> method.
     *
     * 
    * @param String[] domainNames
    */
    public void declineOwnershipConfirmation(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("declineOwnershipConfirmation", "POST", params, domainNames,Object.class);
    }

    /**
     * Accepts incoming pull transfers at the other registrar for a set of pull transfer Rodeo domains.  This should be called after a call is made to the <b">createPullTransferRodeoDomains</b> to expedite the
     * transfer in operation at the other end for testing.
     *
     * 
    * @param String[] domainNames
    */
    public void approveIncomingTransferOtherRegistrar(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("approveIncomingTransfer", "POST", params, domainNames,Object.class);
    }

    /**
     * Rejects incoming pull transfers at the other registrar for a set of pull transfer Rodeo domains.  This should be called after a call is made to the <a href="#approveOwnershipConfirmationForTransfer">approveOwnershipConfirmationForTransfer</a> to reject the
     * transfer in operation at the other end for testing
     *
     * 
    * @param String[] domainNames
    */
    public void rejectIncomingTransferOtherRegistrar(String[] domainNames) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        

        super.callMethod("rejectIncomingTransfer", "POST", params, domainNames,Object.class);
    }


}
