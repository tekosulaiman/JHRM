package jcodev.jbpm.api.common;

/**
 * 
 * @author Sugar Pramana
 *
 */
public interface JBPMRequestMapping {
	
	/**
	 * 
	 * @author Sugar Pramana
	 *
	 */
	public interface Deployment {
		
		/**
		 * 
		 */
		public static final String ALL							= JBPM + "/deployment";
		
		/**
		 * 
		 */
		public static final String ALL_DEPLOYMENT_PROCESSES		= Deployment.ALL + "/processes";
	}
	
	/**
	 * 
	 */
	public static final String JBPM_PREFIX 						= "http://";
	
	/**
	 * 
	 */
	public static final String JBPM_ENDPOINT					= "127.0.0.1";
	
	/**
	 * 
	 */
	public static final String JBPM_PORT_SEPARATOR				= ":";
	
	/**
	 * 
	 */
	public static final String JBPM_PORT						= "8080";
	
	/**
	 * 
	 */
	public static final String JBPM_ROOT_PATH					= "/jbpm-console";
	
	/**
	 * 
	 */
	public static final String JBPM_REST_PATH					= "/rest";
	
	/**
	 * 
	 */
	public static final String JBPM								= JBPM_PREFIX + JBPM_ENDPOINT + JBPM_PORT_SEPARATOR + JBPM_PORT + JBPM_ROOT_PATH + JBPM_REST_PATH;
}

