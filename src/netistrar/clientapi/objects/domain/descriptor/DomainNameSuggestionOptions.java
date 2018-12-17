package netistrar.clientapi.objects.domain.descriptor;

import java.util.Map;

/**
 * Configuration options for domain name suggestions.
 * Class DomainNameSuggestionOptions
*/
public class DomainNameSuggestionOptions  {


    /**
     * Specify whether to include Tlds in general suggestions
     */
    private Boolean includeTlds;
    /**
     * Specify whether to include category tlds in general suggestions
     */
    private Boolean includeCategories;
    /**
     * If specified, this will fill the suggestions up to the supplied
     * number of results.  If supplied as null it will return one suggestion per
     * included TLD only.
     */
    private Integer fillCount;



    /**
    * Blank Constructor
    *
    */
    public DomainNameSuggestionOptions(){
    }

    /**
     * Updatable Constructor
     *
    * @param includeTlds
    * @param includeCategories
    * @param fillCount
    */
    public DomainNameSuggestionOptions(Boolean includeTlds, Boolean includeCategories, Integer fillCount){

        this.includeTlds = includeTlds;
        this.includeCategories = includeCategories;
        this.fillCount = fillCount;
        
    }


    /**
     * Get the includeTlds
     *
     * @return Boolean
     */
    public Boolean getIncludeTlds(){
        return this.includeTlds;
    }

    /**
     * Set the includeTlds
     *
     * @param includeTlds
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setIncludeTlds(Boolean includeTlds){
        this.includeTlds = includeTlds;
        return this;
    }

    /**
     * Get the includeCategories
     *
     * @return Boolean
     */
    public Boolean getIncludeCategories(){
        return this.includeCategories;
    }

    /**
     * Set the includeCategories
     *
     * @param includeCategories
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setIncludeCategories(Boolean includeCategories){
        this.includeCategories = includeCategories;
        return this;
    }

    /**
     * Get the fillCount
     *
     * @return Integer
     */
    public Integer getFillCount(){
        return this.fillCount;
    }

    /**
     * Set the fillCount
     *
     * @param fillCount
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setFillCount(Integer fillCount){
        this.fillCount = fillCount;
        return this;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameSuggestionOptions))
            return false;

        DomainNameSuggestionOptions castObject = (DomainNameSuggestionOptions)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getIncludeTlds() == null && castObject.getIncludeTlds() == null) ||
            (this.getIncludeTlds() != null && this.getIncludeTlds().equals(castObject.getIncludeTlds())));
        equals = equals && ( (this.getIncludeCategories() == null && castObject.getIncludeCategories() == null) ||
            (this.getIncludeCategories() != null && this.getIncludeCategories().equals(castObject.getIncludeCategories())));
        equals = equals && ( (this.getFillCount() == null && castObject.getFillCount() == null) ||
            (this.getFillCount() != null && this.getFillCount().equals(castObject.getFillCount())));

        return equals;
    }


}