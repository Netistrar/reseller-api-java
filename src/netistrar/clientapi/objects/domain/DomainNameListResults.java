package netistrar.clientapi.objects.domain;

import netistrar.clientapi.objects.domain.DomainNameSummary;
import java.util.Map;

/**
 * A results object which wraps an array of <a href="domain-name-summary-object">DomainNameSummaryObject</a> items returned from a call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
 * This object encodes the criteria used to obtain and sort this list as well as the total number of items for the list criteria ignoring supplied page and pageSize which allows for the development of paging GUIs.
*/
public class DomainNameListResults  {


    /**
     * The search term used to filter the list of domains as requested in the call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     */
    protected String searchTerm;
    /**
     * The maximum number of results as requested in the call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     */
    protected Integer pageSize;
    /**
     * The page to return of results (starting at 1) as requested in the call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     */
    protected Integer page;
    /**
     * The property within the <a href="domain-name-summary-object">DomainNameSummaryObject</a> used to sort the results as requested in the call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     */
    protected String orderBy;
    /**
     * The direction (either ASC or DESC) used to define the direction of sort as requested in the call to <i>listDomains</i> within the <a href="netistrar-domain-lifecycle-api">Netistrar Domain Lifecycle API</a>.
     */
    protected String orderDirection;
    /**
     * The number of domains actually returned
     */
    protected Integer numberOfDomainsReturned;
    /**
     * The total number of domains matching the <a href="#searchTerm">searchTerm</a> ignoring any paging parameters (useful for building GUIs).
     */
    protected Integer totalNumberOfDomains;
    /**
     * The total number of pages based upon the passed page size and the total number of domains matching the <a href="#searchTerm">searchTerm</a>
     */
    protected Integer totalNumberOfPages;
    /**
     * The results of the list query as an array of domain name summary objects.
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
     * @return
     */
    public String getSearchTerm(){
        return this.searchTerm;
    }

    /**
     * Get the pageSize
     *
     * @return
     */
    public Integer getPageSize(){
        return this.pageSize;
    }

    /**
     * Get the page
     *
     * @return
     */
    public Integer getPage(){
        return this.page;
    }

    /**
     * Get the orderBy
     *
     * @return
     */
    public String getOrderBy(){
        return this.orderBy;
    }

    /**
     * Get the orderDirection
     *
     * @return
     */
    public String getOrderDirection(){
        return this.orderDirection;
    }

    /**
     * Get the numberOfDomainsReturned
     *
     * @return
     */
    public Integer getNumberOfDomainsReturned(){
        return this.numberOfDomainsReturned;
    }

    /**
     * Get the totalNumberOfDomains
     *
     * @return
     */
    public Integer getTotalNumberOfDomains(){
        return this.totalNumberOfDomains;
    }

    /**
     * Get the totalNumberOfPages
     *
     * @return
     */
    public Integer getTotalNumberOfPages(){
        return this.totalNumberOfPages;
    }

    /**
     * Get the domainNameSummaries
     *
     * @return
     */
    public DomainNameSummary[] getDomainNameSummaries(){
        return this.domainNameSummaries;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof DomainNameListResults))
            return false;

        DomainNameListResults castObject = (DomainNameListResults)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getSearchTerm() == null && castObject.getSearchTerm() == null) ||
            (this.getSearchTerm() != null && this.getSearchTerm().equals(castObject.getSearchTerm())));
        equals = equals && ( (this.getPageSize() == null && castObject.getPageSize() == null) ||
            (this.getPageSize() != null && this.getPageSize().equals(castObject.getPageSize())));
        equals = equals && ( (this.getPage() == null && castObject.getPage() == null) ||
            (this.getPage() != null && this.getPage().equals(castObject.getPage())));
        equals = equals && ( (this.getOrderBy() == null && castObject.getOrderBy() == null) ||
            (this.getOrderBy() != null && this.getOrderBy().equals(castObject.getOrderBy())));
        equals = equals && ( (this.getOrderDirection() == null && castObject.getOrderDirection() == null) ||
            (this.getOrderDirection() != null && this.getOrderDirection().equals(castObject.getOrderDirection())));
        equals = equals && ( (this.getNumberOfDomainsReturned() == null && castObject.getNumberOfDomainsReturned() == null) ||
            (this.getNumberOfDomainsReturned() != null && this.getNumberOfDomainsReturned().equals(castObject.getNumberOfDomainsReturned())));
        equals = equals && ( (this.getTotalNumberOfDomains() == null && castObject.getTotalNumberOfDomains() == null) ||
            (this.getTotalNumberOfDomains() != null && this.getTotalNumberOfDomains().equals(castObject.getTotalNumberOfDomains())));
        equals = equals && ( (this.getTotalNumberOfPages() == null && castObject.getTotalNumberOfPages() == null) ||
            (this.getTotalNumberOfPages() != null && this.getTotalNumberOfPages().equals(castObject.getTotalNumberOfPages())));
        equals = equals && ( (this.getDomainNameSummaries() == null && castObject.getDomainNameSummaries() == null) ||
            (this.getDomainNameSummaries() != null && this.getDomainNameSummaries().equals(castObject.getDomainNameSummaries())));

        return equals;
    }


}