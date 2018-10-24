package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainNameSummary;
import java.util.Map;


/**
 * A results object which wraps an array of <a href="domain-name-summary-object">DomainNameSummaryObject</a> items returned from a call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
 * This object encodes the criteria used to obtain and sort this list as well as the total number of items for the list criteria ignoring supplied page and pageSize which allows for the development of paging GUIs.
 *
 */
public class DomainNameListResults  {

    /**
     */
    protected String searchTerm;

    /**
     */
    protected Integer pageSize;

    /**
     */
    protected Integer page;

    /**
     */
    protected String orderBy;

    /**
     */
    protected String orderDirection;

    /**
     */
    protected Integer numberOfDomainsReturned;

    /**
     */
    protected Integer totalNumberOfDomains;

    /**
     */
    protected Integer totalNumberOfPages;

    /**
     */
    protected DomainNameSummary[] domainNameSummaries;




    /**
    * Blank Constructor
    *
    */
    public DomainNameListResults(){
    }



    /**
     * Get the searchTerm
     *
     * @return String
     */
    public String getSearchTerm(){
        return this.searchTerm;
    }

    /**
     * Get the pageSize
     *
     * @return Integer
     */
    public Integer getPageSize(){
        return this.pageSize;
    }

    /**
     * Get the page
     *
     * @return Integer
     */
    public Integer getPage(){
        return this.page;
    }

    /**
     * Get the orderBy
     *
     * @return String
     */
    public String getOrderBy(){
        return this.orderBy;
    }

    /**
     * Get the orderDirection
     *
     * @return String
     */
    public String getOrderDirection(){
        return this.orderDirection;
    }

    /**
     * Get the numberOfDomainsReturned
     *
     * @return Integer
     */
    public Integer getNumberOfDomainsReturned(){
        return this.numberOfDomainsReturned;
    }

    /**
     * Get the totalNumberOfDomains
     *
     * @return Integer
     */
    public Integer getTotalNumberOfDomains(){
        return this.totalNumberOfDomains;
    }

    /**
     * Get the totalNumberOfPages
     *
     * @return Integer
     */
    public Integer getTotalNumberOfPages(){
        return this.totalNumberOfPages;
    }

    /**
     * Get the domainNameSummaries
     *
     * @return DomainNameSummary[]
     */
    public DomainNameSummary[] getDomainNameSummaries(){
        return this.domainNameSummaries;
    }


}