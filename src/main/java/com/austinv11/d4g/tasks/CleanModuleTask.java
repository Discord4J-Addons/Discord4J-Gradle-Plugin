package com.austinv11.d4g.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;

/**
 * Cleans the files produced by the modules task.
 * @see ModuleTask
 */
public class CleanModuleTask extends DefaultTask {
	
	@TaskAction
	public void exec() {
		File discordDir = new File("discord4j");
		File modulesDir = new File("modules");
		
		if (discordDir.exists()) {
			if (!discordDir.delete()) {
				throw new RuntimeException("Unable to delete the "+discordDir.getPath()+" file");
			}
		}
		
		if (modulesDir.exists()) {
			if (!modulesDir.delete()) {
				throw new RuntimeException("Unable to delete the "+modulesDir.getPath()+" file");
			}
		}
	}
}
