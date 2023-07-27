package com.insurance.life;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PolicyUserController {
	
	
	@Autowired
	PolicyUserService policyUserService;
	
	@GetMapping("/helloworld")
	public String sayHelloWorld() {
		
		return "Hello world from Sprint boot";
	}
	
	@PostMapping("/createPolicy")
	public PolicyUser createPolicy(@RequestBody PolicyUser newpolicy ) {
		
		
		PolicyUser savedPolicy=policyUserService.createNewPolicy(newpolicy);
		
		if(savedPolicy!=null) {
			
			return savedPolicy;
					/*"login has been successfully registered";*/
		
		}
		
		else {
			return null;
		}

	}
	

	@GetMapping("/viewPolicy/{policyId}")
	public PolicyUser viewPolicy(@PathVariable Long policyId ) {
		
		PolicyUser policyUser =policyUserService.getPolicyUser(policyId);
		
		if(policyUser!=null) {
			
			return policyUser;
		
		}
		
		else {
			return null;
		}
		
	}
	
	@PutMapping("/update/")	
	public String modifiedPolicy(@RequestBody PolicyUser updateUser){
		
		String policyUser =policyUserService.updatePolicyuser(updateUser);
		
		if(policyUser!=null) {
			
			return "sucess";
		
		}
		
		else {
			return null;
		}
	
	}
	
	@DeleteMapping("/deletePolicy/{policyId}")
	public void deletePolicy(@PathVariable Long policyId ) {
		
		policyUserService.deletePolicyUser(policyId);
		
		
	
	}	
}
	
	
	
	