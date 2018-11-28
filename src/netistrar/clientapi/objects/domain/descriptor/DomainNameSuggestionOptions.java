package netistrar.clientapi.objects.domain.descriptor;

import java.util.Map;


/**
 * Configuration options for domain name suggestions.
 *
 * Class DomainNameSuggestionOptions
 */
public class DomainNameSuggestionOptions  {

    /**
     */
    private Boolean includeTlds;

    /**
     */
    private Boolean includeCategories;

    /**
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
    * @param Boolean $includeTlds
    * @param Boolean $includeCategories
    * @param Integer $fillCount
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
     * @param Boolean $includeTlds
     */
    public void setIncludeTlds(Boolean includeTlds){
        this.includeTlds = includeTlds;
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
     * @param Boolean $includeCategories
     */
    public void setIncludeCategories(Boolean includeCategories){
        this.includeCategories = includeCategories;
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
     * @param Integer $fillCount
     */
    public void setFillCount(Integer fillCount){
        this.fillCount = fillCount;
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