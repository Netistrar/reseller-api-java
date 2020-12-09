package netistrar.clientapi.objects.gsuite.descriptor;

import java.util.Map;

/**
 * Create descriptor for a GSuite subscription
 * Class GSuiteActivationDescriptor
*/
public class GSuiteCreateDescriptor  {





    /**
    * Blank Constructor
    *
    */
    public GSuiteCreateDescriptor(){
    }





    /**
    * Overridden equals method for doing field based equals comparison.
    */
    public boolean equals(Object otherObject) {

        if (otherObject == this)
            return true;

        if (!(otherObject instanceof GSuiteCreateDescriptor))
            return false;

        GSuiteCreateDescriptor castObject = (GSuiteCreateDescriptor)otherObject;

        boolean equals = true;

        return equals;
    }


}