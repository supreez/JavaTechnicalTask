package policy;

import policy.object.PolicyObject;

import java.math.BigDecimal;

public interface PremiumCalculator {

	BigDecimal calculate(Policy policy);

}


