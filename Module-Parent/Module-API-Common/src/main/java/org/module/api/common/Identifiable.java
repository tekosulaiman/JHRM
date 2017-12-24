package org.module.api.common;

import java.io.Serializable;

public interface Identifiable<T extends Serializable>{
	
	T getId();
}
