package netistrar.clientapi.objects.account;

import java.util.Map;

/**
 * A generic account notification.  This are used to encode events described by the <a href="#notificationType">notificationType</a> and <a href="#notificationSubType">notificationSubType</a> properties.
 * A human readable message is also returned along with the description of an associated object contained in the <a href="#refersTo">refersTo</a> property if relevant to this notification.
*/
public class AccountNotification  {


    /**
     * The id for this notification.
     */
    protected Integer id;
    /**
     * The date/time that this notification was created.
     */
    protected String dateTime;
    /**
     * The general type for this notification
     */
    protected String notificationType;
    /**
     * A more specific sub type for this notification
     */
    protected String notificationSubType;
    /**
     * A description for an item that this notification refers to if applicable.
     */
    protected String refersTo;
    /**
     * A descriptive message giving more detail about this notification.
     */
    protected String message;



    /**
    * Blank Constructor
    *
    */
    public AccountNotification(){
    }



    /**
     * Get the id
     *
     * @return
     */
    public Integer getId(){
        return this.id;
    }

    /**
     * Get the dateTime
     *
     * @return
     */
    public String getDateTime(){
        return this.dateTime;
    }

    /**
     * Get the notificationType
     *
     * @return
     */
    public String getNotificationType(){
        return this.notificationType;
    }

    /**
     * Get the notificationSubType
     *
     * @return
     */
    public String getNotificationSubType(){
        return this.notificationSubType;
    }

    /**
     * Get the refersTo
     *
     * @return
     */
    public String getRefersTo(){
        return this.refersTo;
    }

    /**
     * Get the message
     *
     * @return
     */
    public String getMessage(){
        return this.message;
    }



    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof AccountNotification))
            return false;

        AccountNotification castObject = (AccountNotification)otherObject;

        boolean equals = true;
        equals = equals && ( (this.getId() == null && castObject.getId() == null) ||
            (this.getId() != null && this.getId().equals(castObject.getId())));
        equals = equals && ( (this.getDateTime() == null && castObject.getDateTime() == null) ||
            (this.getDateTime() != null && this.getDateTime().equals(castObject.getDateTime())));
        equals = equals && ( (this.getNotificationType() == null && castObject.getNotificationType() == null) ||
            (this.getNotificationType() != null && this.getNotificationType().equals(castObject.getNotificationType())));
        equals = equals && ( (this.getNotificationSubType() == null && castObject.getNotificationSubType() == null) ||
            (this.getNotificationSubType() != null && this.getNotificationSubType().equals(castObject.getNotificationSubType())));
        equals = equals && ( (this.getRefersTo() == null && castObject.getRefersTo() == null) ||
            (this.getRefersTo() != null && this.getRefersTo().equals(castObject.getRefersTo())));
        equals = equals && ( (this.getMessage() == null && castObject.getMessage() == null) ||
            (this.getMessage() != null && this.getMessage().equals(castObject.getMessage())));

        return equals;
    }


}