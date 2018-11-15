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


}