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
	private Calculator calculator;

	@Test
	public void calculatesZeroPremiumWhenNoObjectsExist() {

		given(policy.getPolicyObjects()).willReturn(emptyList());

		BigDecimal premium = calculator.calculate(policy);

		assertThat(premium).isEqualTo(BigDecimal.ZERO);

	}


	@Test
	public void calculatesPolicyPremium() {

		given(policyObject.getSumInsured()).willReturn(BigDecimal.TEN);
		given(policy.getPolicyObjects()).willReturn(singletonList(policyObject));
		//Couldn't figure out how to attach sumInsured to policyObjects list

		BigDecimal premium = calculator.calculate(policy);

		assertThat(premium).isEqualTo(BigDecimal.TEN);
	}

	@Test
	public void calculatesPolicyPremiumWhenObjectTypeVehicle() {

		//Calculates premium based on object type being Vehicle

	}

	@Test
	public void calculatesPolicyPremiumWhenObjectTypeRealEstate() {

		//Calculates premium based on object type being Real Estate

	}
}