package jcodev.jbpm.api.model.deployment;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "process-definition")
public class ProcessDefinition {

	private String id;
	private String name;
	private String version;
	private String packageName;
	private String deploymentId;
	//private HashMap<String, VariableEntryValue> variables;
	private VariableEntryValue variables;

	@XmlElement(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement(name = "package-name")
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@XmlElement(name = "deployment-id")
	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	@XmlElement(name = "variables")
	public VariableEntryValue getVariables() {
		return variables;
	}

	public void setVariables(VariableEntryValue variables) {
		this.variables = variables;
	}

	/*
	@XmlElement(name = "variables")
	public HashMap<String, VariableEntryValue> getVariables() {
		return variables;
	}

	public void setVariables(HashMap<String, VariableEntryValue> variables) {
		this.variables = variables;
	}
	*/
	
	
}
