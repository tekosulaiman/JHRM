package jcodev.jbpm.api.common;

import java.util.Collections;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Sugar Pramana
 *
 */
public class JBPMRestTemplate extends RestTemplate{
	
	/**
	 * 
	 */
	public JBPMRestTemplate() {
		super();
		List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(new BasicAuthInterceptor());
		setRequestFactory(new InterceptingClientHttpRequestFactory(getRequestFactory(), interceptors));
	}
	
}
