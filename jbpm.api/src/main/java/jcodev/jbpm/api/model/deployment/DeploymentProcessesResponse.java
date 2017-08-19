package jcodev.jbpm.api.model.deployment;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "process-definition-list")
public class DeploymentProcessesResponse {

	private List<ProcessDefinition> processDefinitionList;

	@XmlElement(name = "process-definition")
	public List<ProcessDefinition> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(List<ProcessDefinition> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

}
