package netistrar.clientapi.objects.domain.descriptor;

import netistrar.clientapi.objects.domain.descriptor.DomainNameSuggestionOptions;
import java.util.Map;

/**
 * Descriptor for a domain name hinted availability operation.  This is passed to the getHintedAvailability function on the Domains API.
*/
public class DomainNameAvailabilityDescriptor  {


    /**
     * The search string to seed the availability search
     */
    private String searchString;
    /**
     * An optional array of categories to limit the availability search to specific TLD categories as obtained by a call to <b>getTLDCategories</b>.
     */
    private String[] tldCategories;
    /**
     * An optional array of tlds to limit the availability search to specific TLDs as obtained by a call to <b>getTLDs</b>.
     */
    private String[] tlds;
    /**
     * A flag to indicate whether or not to include suggestions in the result set.
     */
    private Boolean suggestions;
    /**
     * If suggestions is set to true an options object may be passed to configure the suggestions
     */
    private DomainNameSuggestionOptions suggestionOptions;



    /**
    * Blank Constructor
    *
    */
    public DomainNameAvailabilityDescriptor(){
    }

    /**
     * Updatable Constructor
     *
    * @param String $searchString
    * @param String[] $tldCategories
    * @param String[] $tlds
    * @param Boolean $suggestions
    * @param DomainNameSuggestionOptions $suggestionOptions
    */
    public DomainNameAvailabilityDescriptor(String searchString, String[] tldCategories, String[] tlds, Boolean suggestions, DomainNameSuggestionOptions suggestionOptions){

        this.searchString = searchString;
        this.tldCategories = tldCategories;
        this.tlds = tlds;
        this.suggestions = suggestions;
        this.suggestionOptions = suggestionOptions;
        
    }


    /**
     * Get the searchString
     *
     * @return String
     */
    public String getSearchString(){
        return this.searchString;
    }

    /**
     * Set the searchString
     *
     * @param String $searchString
     * @return DomainNameAvailabilityDescriptor
     */
    public DomainNameAvailabilityDescriptor setSearchString(String searchString){
        this.searchString = searchString;
        return this;
    }

    /**
     * Get the tldCategories
     *
     * @return String[]
     */
    public String[] getTldCategories(){
        return this.tldCategories;
    }

    /**
     * Set the tldCategories
     *
     * @param String[] $tldCategories
     * @return DomainNameAvailabilityDescriptor
     */
    public DomainNameAvailabilityDescriptor setTldCategories(String[] tldCategories){
        this.tldCategories = tldCategories;
        return this;
    }

    /**
     * Get the tlds
     *
     * @return String[]
     */
    public String[] getTlds(){
        return this.tlds;
    }

    /**
     * Set the tlds
     *
     * @param String[] $tlds
     * @return DomainNameAvailabilityDescriptor
     */
    public DomainNameAvailabilityDescriptor setTlds(String[] tlds){
        this.tlds = tlds;
        return this;
    }

    /**
     * Get the suggestions
     *
     * @return Boolean
     */
    public Boolean getSuggestions(){
        return this.suggestions;
    }

    /**
     * Set the suggestions
     *
     * @param Boolean $suggestions
     * @return DomainNameAvailabilityDescriptor
     */
    public DomainNameAvailabilityDescriptor setSuggestions(Boolean suggestions){
        this.suggestions = suggestions;
        return this;
    }

    /**
     * Get the suggestionOptions
     *
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions getSuggestionOptions(){
        return this.suggestionOptions;
    }

    /**
     * Set the suggestionOptions
     *
     * @param DomainNameSuggestionOptions $suggestionOptions
     * @return DomainNameAvailabilityDescriptor
     */
    public DomainNameAvailabilityDescriptor setSuggestionOptions(DomainNameSuggestionOptions suggestionOptions){
        this.suggestionOptions = suggestionOptions;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameAvailabilityDescriptor))
            return false;

        DomainNameAvailabilityDescriptor castObject = (DomainNameAvailabilityDescriptor)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getSearchString() == null && castObject.getSearchString() == null) ||
            (this.getSearchString() != null && this.getSearchString().equals(castObject.getSearchString())));
        equals = equals && ( (this.getTldCategories() == null && castObject.getTldCategories() == null) ||
            (this.getTldCategories() != null && this.getTldCategories().equals(castObject.getTldCategories())));
        equals = equals && ( (this.getTlds() == null && castObject.getTlds() == null) ||
            (this.getTlds() != null && this.getTlds().equals(castObject.getTlds())));
        equals = equals && ( (this.getSuggestions() == null && castObject.getSuggestions() == null) ||
            (this.getSuggestions() != null && this.getSuggestions().equals(castObject.getSuggestions())));
        equals = equals && ( (this.getSuggestionOptions() == null && castObject.getSuggestionOptions() == null) ||
            (this.getSuggestionOptions() != null && this.getSuggestionOptions().equals(castObject.getSuggestionOptions())));

        return equals;
    }


}