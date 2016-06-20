package com.austinv11.d4g.tasks;

import com.austinv11.d4g.Discord4GradlePluginExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * This task launches and runs the Discord4J modules in this project.
 */
public class ModuleTask extends DefaultTask {
	
	@TaskAction
	public void launchModules() {
		Discord4GradlePluginExtension extension = getProject().getExtensions().findByType(Discord4GradlePluginExtension.class);
		if (extension == null)
			extension = new Discord4GradlePluginExtension();
	}
}
