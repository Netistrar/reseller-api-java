package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainNameError;
import java.util.Map;


/**
 * Transaction element object.  Represents a single domain name result within a transaction returned from the operations found in the Domain API.
 *
 */
public class DomainNameTransactionElement  {

    /**
     */
    protected String domainName;

    /**
     */
    protected String elementStatus;

    /**
     */
    protected Map<String,Object> operationData;

    /**
     */
    protected Map<String,DomainNameError> elementErrors;

    /**
     */
    protected Object netistrarOrderLineSubtotal;

    /**
     */
    protected Object netistrarOrderLineTaxes;

    /**
     */
    protected Object netistrarOrderLineTotal;




    /**
    * Blank Constructor
    *
    */
    public DomainNameTransactionElement(){
    }



    /**
     * Get the domainName
     *
     * @return String
     */
    public String getDomainName(){
        return this.domainName;
    }

    /**
     * Get the elementStatus
     *
     * @return String
     */
    public String getElementStatus(){
        return this.elementStatus;
    }

    /**
     * Get the operationData
     *
     * @return Map<String,Object>
     */
    public Map<String,Object> getOperationData(){
        return this.operationData;
    }

    /**
     * Get the elementErrors
     *
     * @return Map<String,DomainNameError>
     */
    public Map<String,DomainNameError> getElementErrors(){
        return this.elementErrors;
    }

    /**
     * Get the netistrarOrderLineSubtotal
     *
     * @return Object
     */
    public Object getNetistrarOrderLineSubtotal(){
        return this.netistrarOrderLineSubtotal;
    }

    /**
     * Get the netistrarOrderLineTaxes
     *
     * @return Object
     */
    public Object getNetistrarOrderLineTaxes(){
        return this.netistrarOrderLineTaxes;
    }

    /**
     * Get the netistrarOrderLineTotal
     *
     * @return Object
     */
    public Object getNetistrarOrderLineTotal(){
        return this.netistrarOrderLineTotal;
    }


}