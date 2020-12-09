package netistrar.clientapi.objects.gsuite.descriptor;

import java.util.Map;

/**
 * Update descriptor for a GSuite subscription
 * Class GSuiteActivationDescriptor
*/
public class GSuiteUpdateDescriptor  {





    /**
    * Blank Constructor
    *
    */
    public GSuiteUpdateDescriptor(){
    }





    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof GSuiteUpdateDescriptor))
            return false;

        GSuiteUpdateDescriptor castObject = (GSuiteUpdateDescriptor)otherObject;

        boolean equals = true;

        return equals;
    }


}