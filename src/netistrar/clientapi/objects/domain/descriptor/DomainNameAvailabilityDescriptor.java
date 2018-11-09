package netistrar.clientapi.objects.domain.descriptor;

import java.util.Map;


/**
 * Descriptor for a domain name hinted availability operation.  This is passed to the getHintedAvailability function on the Domains API.
 *
 */
public class DomainNameAvailabilityDescriptor  {

    /**
     */
    private String searchString;

    /**
     */
    private String[] tldCategories;

    /**
     */
    private String[] tlds;

    /**
     */
    private Boolean suggestions;




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
    */
    public DomainNameAvailabilityDescriptor(String searchString, String[] tldCategories, String[] tlds, Boolean suggestions){

        this.searchString = searchString;
        this.tldCategories = tldCategories;
        this.tlds = tlds;
        this.suggestions = suggestions;
        
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
     */
    public void setSearchString(String searchString){
        this.searchString = searchString;
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
     */
    public void setTldCategories(String[] tldCategories){
        this.tldCategories = tldCategories;
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
     */
    public void setTlds(String[] tlds){
        this.tlds = tlds;
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
     */
    public void setSuggestions(Boolean suggestions){
        this.suggestions = suggestions;
    }


}