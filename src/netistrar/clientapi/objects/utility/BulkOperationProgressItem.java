package netistrar.clientapi.objects.utility;

import netistrar.clientapi.objects.transaction.TransactionError;
import java.util.Map;

/**
 * Encodes progress information about a single element within a bulk operation.  These are returned as part of the <a href="object:Netistrar/WebServices/Common/Objects/Utility/BulkOperationProgress">BulkOperationProgress</a> object as subordinate objects for e.g. use in GUIs to
 * update the progress as it completes.
*/
public class BulkOperationProgressItem  {


    /**
     * A descriptive string for the bulk operation element represented by this progress item.
     */
    protected String title;
    /**
     * The progress percentage through this item if supported by the bulk operation in question (otherwise this will always be set to 0)
     */
    protected Float progressPercentage;
    /**
     * The status of this bulk operation element.  This will be one of the following values:<br>
     * <b>PENDING:</b> If the element is still in the queue to be processed
     * <b>IN_PROGRESS:</b> If the element is currently being processed (in some cases the <b>progressPercentage</b> property will give more detail about progression through this item)
     * <b>SUCCEEDED:</b> If the element has finished successfully
     * <b>FAILED:</b> If the element has finished but failed.  In this case the <b>failureErrors</b> property may be populated with an array of errors qualifying the failure.
     */
    protected String status;
    /**
     * An array of supporting failure error objects populated when the <a href="#status">status</a> property is set to <b>FAILED</b>.  The set of failure errors expected can be found in the documentation for
     * specific bulk operations.
     */
    protected Map<String,TransactionError> failureErrors;



    /**
    * Blank Constructor
    *
    */
    public BulkOperationProgressItem(){
    }



    /**
     * Get the title
     *
     * @return title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Get the progressPercentage
     *
     * @return progressPercentage
     */
    public Float getProgressPercentage(){
        return this.progressPercentage;
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
     * Get the failureErrors
     *
     * @return failureErrors
     */
    public Map<String,TransactionError> getFailureErrors(){
        return this.failureErrors;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof BulkOperationProgressItem))
            return false;

        BulkOperationProgressItem castObject = (BulkOperationProgressItem)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getTitle() == null && castObject.getTitle() == null) ||
            (this.getTitle() != null && this.getTitle().equals(castObject.getTitle())));
        equals = equals && ( (this.getProgressPercentage() == null && castObject.getProgressPercentage() == null) ||
            (this.getProgressPercentage() != null && this.getProgressPercentage().equals(castObject.getProgressPercentage())));
        equals = equals && ( (this.getStatus() == null && castObject.getStatus() == null) ||
            (this.getStatus() != null && this.getStatus().equals(castObject.getStatus())));
        equals = equals && ( (this.getFailureErrors() == null && castObject.getFailureErrors() == null) ||
            (this.getFailureErrors() != null && this.getFailureErrors().equals(castObject.getFailureErrors())));

        return equals;
    }


}