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
		
		Jar jar = (Jar) getProject().getTasks().findByName("jar");
		setArgs(Collections.singletonList(extension.getApiKey()));
//		setJvmArgs(Collections.singletonList("-Dorg.slf4j.simpleLogger.defaultLogLevel=DEBUG"));
		setMain("sx.blah.discord.Discord4J");
		List<File> deps = new ArrayList<>();
		File discordDir = new File("discord4j");
		File modulesDir = new File("modules");
		discordDir.mkdir();
		modulesDir.mkdir();
		getProject().getConfigurations().getByName("runtime").forEach(file -> {
			File newFile = new File(discordDir, file.getName());
			file.renameTo(newFile);
			deps.add(newFile);
		});
		setClasspath(getProject().files(deps.toArray()));
		
		jar.getOutputs().getFiles().forEach(file -> {
			if (file.exists() && !file.isDirectory() && file.getAbsolutePath().endsWith(".jar"))
				file.renameTo(new File(modulesDir, file.getName()));
		});
		
		super.exec();
	}
}
