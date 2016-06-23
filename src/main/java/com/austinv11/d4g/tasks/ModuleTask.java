package com.austinv11.d4g.tasks;

import com.austinv11.d4g.Discord4GradlePluginExtension;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.bundling.Jar;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This task launches and runs the Discord4J modules in this project.
 * @see CleanModuleTask
 */
public class ModuleTask extends JavaExec {
	
	public ModuleTask() {
		super();
	}
	
	@TaskAction
	@Override
	public void exec() {
		Discord4GradlePluginExtension extension = getProject().getExtensions().findByType(Discord4GradlePluginExtension.class);
		if (extension == null)
			extension = new Discord4GradlePluginExtension();
		
		//This module depends on the jar task, use it for output info
		Jar jar = (Jar) getProject().getTasks().findByName("jar");
		
		//Sets account info for d4j
		setArgs(Collections.singletonList(extension.getApiKey()));
//		setJvmArgs(Collections.singletonList("-Dorg.slf4j.simpleLogger.defaultLogLevel=DEBUG"));
		setMain("sx.blah.discord.Discord4J");
		
		List<File> deps = new ArrayList<>();
		File discordDir = new File("discord4j");
		File modulesDir = new File("modules");
		if ((!discordDir.mkdir() && !discordDir.exists() && !discordDir.isDirectory()) 
				|| (!modulesDir.mkdir() && !modulesDir.exists() && !modulesDir.isDirectory()))
			throw new RuntimeException("Unable to generate required directories for running the modules");
		
		getProject().getConfigurations().getByName("runtime").forEach(file -> { //Moves dependencies to a "discord4j" folder
			File newFile = new File(discordDir, file.getName());
			if (!file.renameTo(newFile))
				throw new RuntimeException("Unable to move "+file.getPath()+" to "+newFile.getPath());
			
			deps.add(newFile);
		});
		setClasspath(getProject().files(deps.toArray())); //Sets the classpath to include the dependencies
		
		jar.getOutputs().getFiles().forEach(file -> { //Moves compiled binaries to the "modules" folder
			if (file.exists() && !file.isDirectory() && file.getAbsolutePath().endsWith(".jar")) {
				File newFile = new File(modulesDir, file.getName());
				if (!file.renameTo(newFile))
					throw new RuntimeException("Unable to move "+file.getPath()+" to "+newFile.getPath());
			}
		});
		
		super.exec();
	}
}
