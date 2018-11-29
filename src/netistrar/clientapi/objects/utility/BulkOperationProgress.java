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
    protected Float percentageComplete;

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
     * @return Float
     */
    public Float getPercentageComplete(){
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



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof BulkOperationProgress))
            return false;

        BulkOperationProgress castObject = (BulkOperationProgress)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getTotalNumberOfItems() == null && castObject.getTotalNumberOfItems() == null) ||
            (this.getTotalNumberOfItems() != null && this.getTotalNumberOfItems().equals(castObject.getTotalNumberOfItems())));
        equals = equals && ( (this.getCompletedItems() == null && castObject.getCompletedItems() == null) ||
            (this.getCompletedItems() != null && this.getCompletedItems().equals(castObject.getCompletedItems())));
        equals = equals && ( (this.getPercentageComplete() == null && castObject.getPercentageComplete() == null) ||
            (this.getPercentageComplete() != null && this.getPercentageComplete().equals(castObject.getPercentageComplete())));
        equals = equals && ( (this.getHasFailedItems() == null && castObject.getHasFailedItems() == null) ||
            (this.getHasFailedItems() != null && this.getHasFailedItems().equals(castObject.getHasFailedItems())));
        equals = equals && ( (this.getProgressItems() == null && castObject.getProgressItems() == null) ||
            (this.getProgressItems() != null && this.getProgressItems().equals(castObject.getProgressItems())));

        return equals;
    }


}