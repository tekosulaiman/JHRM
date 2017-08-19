package jcodev.jbpm.api.service;

import jcodev.jbpm.api.model.deployment.DeploymentProcessesResponse;
import jcodev.jbpm.api.model.deployment.DeploymentResponse;

public interface JBPMDeploymentService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public DeploymentResponse getAllDeployments() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public DeploymentProcessesResponse getAllDeploymentsProcesses() throws Exception;
}
