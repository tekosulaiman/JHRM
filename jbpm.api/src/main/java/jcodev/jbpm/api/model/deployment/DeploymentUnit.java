package jcodev.jbpm.api.model.deployment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="deployment-unit")
public class DeploymentUnit {
	
	private String groupId;
	private String artifactId;
	private String kbaseName;
	private String ksessionName;
	private String status;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getKbaseName() {
		return kbaseName;
	}

	public void setKbaseName(String kbaseName) {
		this.kbaseName = kbaseName;
	}

	public String getKsessionName() {
		return ksessionName;
	}

	public void setKsessionName(String ksessionName) {
		this.ksessionName = ksessionName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
