package org.module.sysadmin.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


final public class SecType implements Serializable {
	private static final long serialVersionUID = 5129871978459891412L;
	
	final public static List<SecType> ALLTYPES;
	final private static Map<Integer, SecType> STDID_MAP;
	final public static SecType EMPTY_SECTYP = new SecType(-1, "");

	static {
		List<SecType> result = new ArrayList<SecType>();

		result.add(new SecType(0, "Page"));
		result.add(new SecType(1, "Menu Category"));
		result.add(new SecType(2, "Menu Item"));
		result.add(new SecType(3, "Method"));
		result.add(new SecType(4, "DomainObject/Property"));
		result.add(new SecType(5, "Tab"));
		result.add(new SecType(6, "Component"));

		ALLTYPES = Collections.unmodifiableList(result);
		STDID_MAP = new HashMap<Integer, SecType>(result.size());

		for (SecType secTyp : result) {
			STDID_MAP.put(Integer.valueOf(secTyp.stpId), secTyp);
		}
	}

	public static SecType getTypById(int typ_id) {
		return STDID_MAP.get(Integer.valueOf(typ_id));
	}

	final private int stpId;
	final private String stpTypname;

	private SecType(int stpId, String stp_typname) {
		this.stpId = stpId;
		this.stpTypname = stp_typname;

	}

	public int getStpId() {
		return stpId;
	}

	public String getStpTypname() {
		return stpTypname;
	}

	static public List<SecType> getAllTypes() {
		return ALLTYPES;
	}

	@Override
	public int hashCode() {
		return stpId;
	}

	public boolean equals(SecType secTyp) {
		return getStpId() == secTyp.getStpId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecType) {
			SecType secTyp = (SecType) obj;
			return equals(secTyp);
		}

		return false;
	}
}
