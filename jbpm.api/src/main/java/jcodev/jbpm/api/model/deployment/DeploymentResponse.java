package jcodev.jbpm.api.model.deployment;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deployment-unit-list")
public class DeploymentResponse {

	private List<DeploymentUnit> deploymentUnitList;

	@XmlElement(name = "deployment-unit")
	public List<DeploymentUnit> getDeploymentUnitList() {
		return deploymentUnitList;
	}

	public void setDeploymentUnitList(List<DeploymentUnit> deploymentUnitList) {
		this.deploymentUnitList = deploymentUnitList;
	}

}