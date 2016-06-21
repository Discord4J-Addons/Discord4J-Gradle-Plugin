package com.austinv11.d4g;

import com.austinv11.d4g.tasks.ModuleTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * The actual plugin.
 */
public class Discord4GradlePlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		project.getExtensions().add("d4gSettings", Discord4GradlePluginExtension.class);
		
//		Task setup = project.getTasks().create("setupD4J", SetupD4JTask.class);
		project.getTasks().create("modules", ModuleTask.class).dependsOn(project.getTasks().getByName("jar"));
		
//		project.getTasks().forEach(task -> {//Ensures all tasks run setupD4J
//			if (!(task instanceof SetupD4JTask) && !(task instanceof ModuleTask))
//				task.dependsOn(setup);
//		});
	}
	
}
