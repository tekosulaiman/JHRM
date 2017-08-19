package jcodev.jbpm.api.common;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpExecution) throws IOException {
		HttpHeaders headers = httpRequest.getHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, this.encodeCredentialForBasicAuth());
		return clientHttpExecution.execute(httpRequest, bytes);
	}

	/**
	 * 
	 * @return
	 */
	private String encodeCredentialForBasicAuth() {
		return "Basic " + new Base64().encodeToString((CommonVariable.JBPMUser.JBPM_USERNAME + ":" + CommonVariable.JBPMUser.JBPM_PASSWORD).getBytes());
	}

}
