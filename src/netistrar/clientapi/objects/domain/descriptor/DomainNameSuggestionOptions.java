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
     * Max length of domain name to return for suggestions - between 2 and 63.
     */
    private Integer maxNameLength;



    /**
    * Blank Constructor
    *
    */
    public DomainNameSuggestionOptions(){
    }

    /**
     * Updatable Constructor
     *
    * @param includeTlds the includeTlds
    * @param includeCategories the includeCategories
    * @param fillCount the fillCount
    * @param maxNameLength the maxNameLength
    */
    public DomainNameSuggestionOptions(Boolean includeTlds, Boolean includeCategories, Integer fillCount, Integer maxNameLength){

        this.includeTlds = includeTlds;
        this.includeCategories = includeCategories;
        this.fillCount = fillCount;
        this.maxNameLength = maxNameLength;
        
    }


    /**
     * Get the includeTlds
     *
     * @return includeTlds
     */
    public Boolean getIncludeTlds(){
        return this.includeTlds;
    }

    /**
     * Set the includeTlds
     *
     * @param includeTlds the includeTlds
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setIncludeTlds(Boolean includeTlds){
        this.includeTlds = includeTlds;
        return this;
    }

    /**
     * Get the includeCategories
     *
     * @return includeCategories
     */
    public Boolean getIncludeCategories(){
        return this.includeCategories;
    }

    /**
     * Set the includeCategories
     *
     * @param includeCategories the includeCategories
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setIncludeCategories(Boolean includeCategories){
        this.includeCategories = includeCategories;
        return this;
    }

    /**
     * Get the fillCount
     *
     * @return fillCount
     */
    public Integer getFillCount(){
        return this.fillCount;
    }

    /**
     * Set the fillCount
     *
     * @param fillCount the fillCount
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setFillCount(Integer fillCount){
        this.fillCount = fillCount;
        return this;
    }

    /**
     * Get the maxNameLength
     *
     * @return maxNameLength
     */
    public Integer getMaxNameLength(){
        return this.maxNameLength;
    }

    /**
     * Set the maxNameLength
     *
     * @param maxNameLength the maxNameLength
     * @return DomainNameSuggestionOptions
     */
    public DomainNameSuggestionOptions setMaxNameLength(Integer maxNameLength){
        this.maxNameLength = maxNameLength;
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
        equals = equals && ( (this.getMaxNameLength() == null && castObject.getMaxNameLength() == null) ||
            (this.getMaxNameLength() != null && this.getMaxNameLength().equals(castObject.getMaxNameLength())));

        return equals;
    }


}