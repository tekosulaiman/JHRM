package jcodev.jbpm.api.model.deployment;

import java.util.Collection;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;


public class VariableEntryValue extends HashMap<String, String>{
	private static final long serialVersionUID = 1L;

	@Override
	@XmlElement(name = "value")
	public Collection<String> values() {
		// TODO Auto-generated method stub
		return super.values();
	}
}
