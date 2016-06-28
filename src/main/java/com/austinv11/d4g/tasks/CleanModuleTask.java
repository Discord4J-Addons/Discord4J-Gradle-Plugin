package com.austinv11.d4g.tasks;

import org.apache.commons.io.FileUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;

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
			try {
				FileUtils.deleteDirectory(discordDir);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		if (modulesDir.exists()) {
			try {
				FileUtils.deleteDirectory(modulesDir);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
