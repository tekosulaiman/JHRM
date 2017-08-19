package jcodev.jbpm.api.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import jcodev.jbpm.api.common.JBPMRequestMapping;
import jcodev.jbpm.api.common.JBPMRestTemplate;
import jcodev.jbpm.api.model.deployment.DeploymentProcessesResponse;
import jcodev.jbpm.api.model.deployment.DeploymentResponse;
import jcodev.jbpm.api.service.JBPMDeploymentService;

@Service
public class JBPMDeploymentServiceImpl implements JBPMDeploymentService {
	
	@Override
	public DeploymentResponse getAllDeployments() throws Exception {
		return new JBPMRestTemplate().getForObject(JBPMRequestMapping.Deployment.ALL, DeploymentResponse.class, new HashMap<>());
	}

	@Override
	public DeploymentProcessesResponse getAllDeploymentsProcesses() throws Exception {
		return new JBPMRestTemplate().getForObject(JBPMRequestMapping.Deployment.ALL_DEPLOYMENT_PROCESSES, DeploymentProcessesResponse.class, new HashMap<>());
	}
	
}
