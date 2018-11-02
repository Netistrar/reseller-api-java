package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainAvailability;
import java.util.Map;


/**
 * Encodes the results from a call to <b>getHintedAvailability</b>
 *
 */
public class DomainAvailabilityResults  {

    /**
     */
    protected DomainAvailability directResult;

    /**
     */
    protected Map<String,DomainAvailability> categoryResults;

    /**
     */
    protected Map<String,DomainAvailability> tldResults;




    /**
    * Blank Constructor
    *
    */
    public DomainAvailabilityResults(){
    }



    /**
     * Get the directResult
     *
     * @return DomainAvailability
     */
    public DomainAvailability getDirectResult(){
        return this.directResult;
    }

    /**
     * Get the categoryResults
     *
     * @return Map<String,DomainAvailability>
     */
    public Map<String,DomainAvailability> getCategoryResults(){
        return this.categoryResults;
    }

    /**
     * Get the tldResults
     *
     * @return Map<String,DomainAvailability>
     */
    public Map<String,DomainAvailability> getTldResults(){
        return this.tldResults;
    }


}