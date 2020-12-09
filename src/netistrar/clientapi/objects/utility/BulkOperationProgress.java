package netistrar.clientapi.objects.utility;

import netistrar.clientapi.objects.utility.BulkOperationProgressItem;
import java.util.Map;

/**
 * Encodes information about the current progress of a bulk operation.  This includes the status of all contained <a href="object:Netistrar/WebServices/Common/Objects/Utility/BulkOperationProgressItem">BulkOperationProgressItem</a> objects which make up the bulk operation as well as general information about the progress of the whole operation both as a percentage and as a number of completed items for use in progressively updating GUIs etc.
*/
public class BulkOperationProgress  {


    /**
     * The overall status of this bulk operation.  This will be set to one of the following values.<br />
     * <b>PENDING:</b> When the bulk operation has been created but not yet started.
     * <b>RUNNING:</b> When the bulk operation has been started.
     * <b>COMPLETED:</b> When the bulk operation has finished.
     */
    protected String status;
    /**
     * The total number of progress items making up this bulk operation.
     */
    protected Integer totalNumberOfItems;
    /**
     * The number of completed progress items (either successfully or not).
     */
    protected Integer completedItems;
    /**
     * The current percentage (between 0 and 100) of progress through the bulk operation.
     */
    protected Float percentageComplete;
    /**
     * An indicator as to whether or not there are currently any failed items in this bulk operation (useful for changing colours of progress bars etc).
     */
    protected Boolean hasFailedItems;
    /**
     * An array of <a href="object:Netistrar/WebServices/Common/Objects/Utility/BulkOperationProgressItem">BulkOperationProgressItem</a> items each representing the progress for an individual element within a bulk operation.
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
     * @return status
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Get the totalNumberOfItems
     *
     * @return totalNumberOfItems
     */
    public Integer getTotalNumberOfItems(){
        return this.totalNumberOfItems;
    }

    /**
     * Get the completedItems
     *
     * @return completedItems
     */
    public Integer getCompletedItems(){
        return this.completedItems;
    }

    /**
     * Get the percentageComplete
     *
     * @return percentageComplete
     */
    public Float getPercentageComplete(){
        return this.percentageComplete;
    }

    /**
     * Get the hasFailedItems
     *
     * @return hasFailedItems
     */
    public Boolean getHasFailedItems(){
        return this.hasFailedItems;
    }

    /**
     * Get the progressItems
     *
     * @return progressItems
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