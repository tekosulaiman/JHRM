package org.module.hr.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaritalStatusType implements Serializable{
	
	private static final long serialVersionUID = -4808788227180776721L;
	
	final public static List<MaritalStatusType> ALLTYPES;
	final private static Map<Integer, MaritalStatusType> STDID_MAP;
	final public static MaritalStatusType EMPTY_RELATIONSHIPTYP = new MaritalStatusType(-1,"");
	
	final private int stpId;
	final private String stpTypname;
	
	static{
		List<MaritalStatusType> result = new ArrayList<MaritalStatusType>();
		
		result.add(new MaritalStatusType(0, "Singel"));
		result.add(new MaritalStatusType(1, "Maried"));
		result.add(new MaritalStatusType(2, "Other"));
		
		ALLTYPES = Collections.unmodifiableList(result);
		STDID_MAP = new HashMap<Integer, MaritalStatusType>(result.size());
		
		for (MaritalStatusType maritalStatusType : result) {
			STDID_MAP.put(Integer.valueOf(maritalStatusType.getStpId()), maritalStatusType);
		}
	}
	
	public static MaritalStatusType getTypById(int typId) {
		return STDID_MAP.get(Integer.valueOf(typId));
	}
	
	public MaritalStatusType(int stpId, String stpTypname) {
		this.stpId = stpId;
		this.stpTypname = stpTypname;
	}

	public int getStpId() {
		return stpId;
	}

	public String getStpTypname() {
		return stpTypname;
	}
	
	static public List<MaritalStatusType> getAllTypes() {
		return ALLTYPES;
	}

	@Override
	public int hashCode() {
		return stpId;
	}

	public boolean equals(MaritalStatusType maritalStatusType) {
		return getStpId() == maritalStatusType.getStpId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof MaritalStatusType) {
			MaritalStatusType maritalStatusType = (MaritalStatusType) obj;
			return equals(maritalStatusType);
		}

		return false;
	}

}
