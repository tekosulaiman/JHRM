package jcodev.jbpm.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jcodev.jbpm.api.common.APIRequestMapping;
import jcodev.jbpm.api.model.deployment.DeploymentProcessesResponse;
import jcodev.jbpm.api.model.deployment.DeploymentResponse;
import jcodev.jbpm.api.service.JBPMDeploymentService;

@RestController
public class ApiDeploymentController {

	@Autowired
	private JBPMDeploymentService jbpmDeploymentService;
	
	@RequestMapping(value=APIRequestMapping.Deployment.ALL, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	@ResponseBody
	public DeploymentResponse requestAllDeployment() {
		try {
			return jbpmDeploymentService.getAllDeployments();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value=APIRequestMapping.Deployment.ALL_DEPLOYMENTS_PROCESSES, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	@ResponseBody
	public DeploymentProcessesResponse requestAllDeploymentsProcesses() {
		try {
			return jbpmDeploymentService.getAllDeploymentsProcesses();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
