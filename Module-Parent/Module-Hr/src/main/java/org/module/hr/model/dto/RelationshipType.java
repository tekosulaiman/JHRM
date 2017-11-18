package org.module.hr.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


final public class RelationshipType implements Serializable{

	private static final long serialVersionUID = -1060144618443900336L;
	
	final public static List<RelationshipType> ALLTYPES;
	final private static Map<Integer, RelationshipType> STDID_MAP;
	final public static RelationshipType EMPTY_RELATIONSHIPTYP = new RelationshipType(null,"");
	
	final private Character stpId;
	final private String stpTypname;
	
	static{
		List<RelationshipType> result = new ArrayList<RelationshipType>();
		
		result.add(new RelationshipType('0', "Child"));
		result.add(new RelationshipType('1', "Other"));
		
		ALLTYPES = Collections.unmodifiableList(result);
		STDID_MAP = new HashMap<Integer, RelationshipType>(result.size());
		
		for (RelationshipType relationshipType : result) {
			STDID_MAP.put(Integer.valueOf(relationshipType.getStpId()), relationshipType);
		}
	}
	
	public static RelationshipType getTypById(int typId) {
		return STDID_MAP.get(Integer.valueOf(typId));
	}
	
	public RelationshipType(Character stpId, String stpTypname) {
		this.stpId = stpId;
		this.stpTypname = stpTypname;
	}

	public int getStpId() {
		return stpId;
	}

	public String getStpTypname() {
		return stpTypname;
	}
	
	static public List<RelationshipType> getAllTypes() {
		return ALLTYPES;
	}

	@Override
	public int hashCode() {
		return stpId;
	}

	public boolean equals(RelationshipType relationshipType) {
		return getStpId() == relationshipType.getStpId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof RelationshipType) {
			RelationshipType relationshipType = (RelationshipType) obj;
			return equals(relationshipType);
		}

		return false;
	}

}
