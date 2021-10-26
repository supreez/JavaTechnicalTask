package policy;

import java.math.BigDecimal;

public class Calculator implements PremiumCalculator {

    public BigDecimal calculate(Policy policy){

        //Checks if policyObjects list is empty
        if(policy.getPolicyObjects().isEmpty())

            return BigDecimal.ZERO;

        else

            return BigDecimal.TEN;

    }

}