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

	@Mock
	private PremiumCalculator premiumCalculator;

	@InjectMocks
	private Calculator calculator;

	@Test
	public void calculatesZeroPremiumWhenNoObjectsExist() {

		given(policy.getPolicyObjects()).willReturn(emptyList());

		BigDecimal premium = calculator.calculate(policy);

		assertThat(premium).isEqualTo(BigDecimal.ZERO);

	}


	@Test
	public void calculatesPolicyPremium() {
		given(policy.getPolicyObjects()).willReturn(singletonList(policyObject));
		given(policyObject.getSumInsured()).willReturn(BigDecimal.TEN);

		System.out.println(policy.getPolicyObjects());

		BigDecimal premium = calculator.calculate(policy);

		assertThat(premium).isEqualTo(BigDecimal.TEN);
	}

	@Test
	public void calculatesPolicyPremiumWhenObjectTypeVehicle() {

	}

	@Test
	public void calculatesPolicyPremiumWhenObjectTypeRealEstate() {

	}
}