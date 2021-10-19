package policy;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import policy.object.PolicyObject;

@RunWith(MockitoJUnitRunner.class)
public class PolicyPremiumCalculatorTest {

	@Mock
	private Policy policy;
	@Mock
	private PolicyObject policyObject;

	@InjectMocks
	private PolicyPremiumCalculator premiumCalculator;

	@Test
	public void calculatesZeroPremiumWhenNoObjectsExist() {
		given(policy.getPolicyOvjects()).willReturn(emptyList());

		BigDecimal premium = premiumCalculator.calculate(policy);

		assertThat(premium).isZero();
	}

	@Test
	public void calculatesPolicyPremium() {
		given(policy.getPolicyOvjects()).willReturn(singletonList(policyObject));
		given(policyObject.getSumInsured()).willReturn(BigDecimal.TEN);

		BigDecimal premium = premiumCalculator.calculate(policy);

		assertThat(premium).isEqualTo(BigDecimal.TEN);
	}

}