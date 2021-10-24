package policy;

import policy.object.PolicyObject;
import java.math.BigDecimal;

public class Calculator implements PremiumCalculator {

    public BigDecimal calculate(Policy policy){

        if(policy.getPolicyObjects().isEmpty())

            return BigDecimal.ZERO;

        else

            return null;

    }

}