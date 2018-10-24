package netistrar.clientapi.objects.utility;

import java.util.Map;


/**
 * Encodes progress information about a single element within a bulk operation.  These are returned as part of the <a href="bulk-operation-progress">BulkOperationProgress</a> object as subordinate objects for e.g. use in GUIs to
 * update the progress as it completes.
 *
 */
public class BulkOperationProgressItem  {

    /**
     */
    protected String title;

    /**
     */
    protected Integer progressPercentage;

    /**
     */
    protected String status;

    /**
     */
    protected Object[] failureErrors;




    /**
    * Blank Constructor
    *
    */
    public BulkOperationProgressItem(){
    }



    /**
     * Get the title
     *
     * @return String
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Get the progressPercentage
     *
     * @return Integer
     */
    public Integer getProgressPercentage(){
        return this.progressPercentage;
    }

    /**
     * Get the status
     *
     * @return String
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Get the failureErrors
     *
     * @return Object[]
     */
    public Object[] getFailureErrors(){
        return this.failureErrors;
    }


}