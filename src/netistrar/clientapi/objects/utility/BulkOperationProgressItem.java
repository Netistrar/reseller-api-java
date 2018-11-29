package netistrar.clientapi.objects.utility;

import netistrar.clientapi.objects.transaction.TransactionError;
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
    protected Float progressPercentage;

    /**
     */
    protected String status;

    /**
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
     * @return String
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Get the progressPercentage
     *
     * @return Float
     */
    public Float getProgressPercentage(){
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
     * @return Map<String,TransactionError>
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