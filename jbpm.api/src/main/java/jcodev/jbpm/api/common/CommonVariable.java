package jcodev.jbpm.api.common;

/**
 * 
 * @author Sugar Pramana
 *
 */
public interface CommonVariable {
	
	/**
	 * 
	 * @author Sugar Pramana
	 *
	 */
	public interface APIUser {
		
		/**
		 * 
		 */
		public static final String API_USERNAME 					= "jcodev";
		
		/**
		 * 
		 */
		public static final String API_PASSWORD		 				= "jcodev";
	}
	
	/**
	 * 
	 * @author Sugar Pramana
	 *
	 */
	public interface JBPMUser {
		
		/**
		 * 
		 */
		public static final String JBPM_USERNAME 					= "admin";
		
		/**
		 * 
		 */
		public static final String JBPM_PASSWORD 					= "admin";
	}
	
	/**
	 * 
	 * @author Sugar Pramana
	 *
	 */
	public interface JBPMHeaders {
		
		/**
		 * 
		 */
		public static final String AUTHORIZATION 					= "Authorization";
	}
}
