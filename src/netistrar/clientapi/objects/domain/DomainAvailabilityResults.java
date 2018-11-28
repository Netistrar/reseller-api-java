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
    protected Map<String,Map<String,DomainAvailability>> categoryResults;

    /**
     */
    protected Map<String,DomainAvailability> tldResults;

    /**
     */
    protected Map<String,DomainAvailability[]> tldSuggestions;

    /**
     */
    protected DomainAvailability[] suggestions;




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
     * @return Map<String,Map<String,DomainAvailability>>
     */
    public Map<String,Map<String,DomainAvailability>> getCategoryResults(){
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

    /**
     * Get the tldSuggestions
     *
     * @return Map<String,DomainAvailability[]>
     */
    public Map<String,DomainAvailability[]> getTldSuggestions(){
        return this.tldSuggestions;
    }

    /**
     * Get the suggestions
     *
     * @return DomainAvailability[]
     */
    public DomainAvailability[] getSuggestions(){
        return this.suggestions;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainAvailabilityResults))
            return false;

        DomainAvailabilityResults castObject = (DomainAvailabilityResults)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getDirectResult() == null && castObject.getDirectResult() == null) ||
            (this.getDirectResult() != null && this.getDirectResult().equals(castObject.getDirectResult())));
        equals = equals && ( (this.getCategoryResults() == null && castObject.getCategoryResults() == null) ||
            (this.getCategoryResults() != null && this.getCategoryResults().equals(castObject.getCategoryResults())));
        equals = equals && ( (this.getTldResults() == null && castObject.getTldResults() == null) ||
            (this.getTldResults() != null && this.getTldResults().equals(castObject.getTldResults())));
        equals = equals && ( (this.getTldSuggestions() == null && castObject.getTldSuggestions() == null) ||
            (this.getTldSuggestions() != null && this.getTldSuggestions().equals(castObject.getTldSuggestions())));
        equals = equals && ( (this.getSuggestions() == null && castObject.getSuggestions() == null) ||
            (this.getSuggestions() != null && this.getSuggestions().equals(castObject.getSuggestions())));

        return equals;
    }


}