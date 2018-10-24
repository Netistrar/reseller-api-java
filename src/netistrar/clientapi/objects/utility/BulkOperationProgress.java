package netistrar.clientapi.objects.utility;

import netistrar.clientapi.objects.utility.BulkOperationProgressItem;
import java.util.Map;


/**
 * Encodes information about the current progress of a bulk operation.  This includes the status of all contained <a href="bulk-operation-progress-item">BulkOperationProgressItem</a> objects which make up the bulk operation as well as general information about the progress of the whole operation both as a percentage and as a number of completed items for use in progressively updating GUIs etc.
 *
 */
public class BulkOperationProgress  {

    /**
     */
    protected String status;

    /**
     */
    protected Integer totalNumberOfItems;

    /**
     */
    protected Integer completedItems;

    /**
     */
    protected Integer percentageComplete;

    /**
     */
    protected Boolean hasFailedItems;

    /**
     */
    protected BulkOperationProgressItem[] progressItems;




    /**
    * Blank Constructor
    *
    */
    public BulkOperationProgress(){
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
     * Get the totalNumberOfItems
     *
     * @return Integer
     */
    public Integer getTotalNumberOfItems(){
        return this.totalNumberOfItems;
    }

    /**
     * Get the completedItems
     *
     * @return Integer
     */
    public Integer getCompletedItems(){
        return this.completedItems;
    }

    /**
     * Get the percentageComplete
     *
     * @return Integer
     */
    public Integer getPercentageComplete(){
        return this.percentageComplete;
    }

    /**
     * Get the hasFailedItems
     *
     * @return Boolean
     */
    public Boolean getHasFailedItems(){
        return this.hasFailedItems;
    }

    /**
     * Get the progressItems
     *
     * @return BulkOperationProgressItem[]
     */
    public BulkOperationProgressItem[] getProgressItems(){
        return this.progressItems;
    }


}