package com.austinv11.d4g;

import com.austinv11.d4g.tasks.ModuleTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencyResolutionListener;
import org.gradle.api.artifacts.ResolvableDependencies;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * The actual plugin
 */
public class Discord4GradlePlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		project.getExtensions().add("d4gSetting", Discord4GradlePluginExtension.class);
		
		project.getTasks().create("modules", ModuleTask.class);
		
		project.getRepositories().add(project.getRepositories().maven(mavenArtifactRepository -> { //Adds jitpack.io
			try {
				mavenArtifactRepository.setUrl(new URI("https://jitpack.io"));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}));
		
		project.getGradle().addListener(new DependencyResolutionListener() {
			
			@Override
			public void beforeResolve(ResolvableDependencies resolvableDependencies) {
				resolvableDependencies.getDependencies().add(new Dependency() {
					@Override
					public String getGroup() {
						return "com.github.austinv11";
					}
					
					@Override
					public String getName() {
						return "Discord4j";
					}
					
					@Override
					public String getVersion() {
						return project.getExtensions().getByType(Discord4GradlePluginExtension.class).getVersion();
					}
					
					@Override
					public boolean contentEquals(Dependency dependency) {
						return dependency.equals(this);
					}
					
					@Override
					public Dependency copy() {
						return this;
					}
				});
			}
			
			@Override
			public void afterResolve(ResolvableDependencies resolvableDependencies) {
				
			}
		});
	}
	
}
