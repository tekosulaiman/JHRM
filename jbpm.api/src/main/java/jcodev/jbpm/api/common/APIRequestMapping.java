package jcodev.jbpm.api.common;

/**
 * 
 * @author Sugar Pramana
 *
 */
public interface APIRequestMapping {
	
	/**
	 * 
	 * @author Sugar Pramana
	 *
	 */
	public interface Deployment {
		
		/**
		 * 
		 */
		public static final String ALL							= API + "/deployment";
		
		/**
		 * 
		 */
		public static final String ALL_DEPLOYMENTS_PROCESSES	= Deployment.ALL + "/processes";
	}
	
	public static final String API								= "/jbpm.api";
}

