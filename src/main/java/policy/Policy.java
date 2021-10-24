package policy;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import policy.object.PolicyObject;

@Builder
@Getter
public class Policy{

	private final List<PolicyObject> policyObjects;

}