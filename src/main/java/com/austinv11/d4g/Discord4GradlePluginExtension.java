package com.austinv11.d4g;

/**
 * Gradle plugin settings
 */
public class Discord4GradlePluginExtension {
	
	/**
	 * The bot API token to use to log into discord with.
	 */
	private String apiKey;
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
