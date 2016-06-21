package com.austinv11.d4g;

/**
 * Gradle plugin settings
 */
public class Discord4GradlePluginExtension {
	
	/**
	 * If true, the plugin will automatically find IModule implementations, if false they must be provided by {@link #modules}.
	 */
	private boolean scanForModules = true;
	/**
	 * If {@link #scanForModules} is false, it loads these modules.
	 */
	private String[] modules = new String[0];
	/**
	 * The Discord4J version to use;
	 */
	private String version = "dev-SNAPSHOT";
	/**
	 * The bot API token to use to log into discord with.
	 */
	private String apiKey;
	
	public boolean isScanForModules() {
		return scanForModules;
	}
	
	public void setScanForModules(boolean scanForModules) {
		this.scanForModules = scanForModules;
	}
	
	public String[] getModules() {
		return modules;
	}
	
	public void setModules(String[] modules) {
		this.modules = modules;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
