package com.austinv11.d4g.tasks;

import org.gradle.api.DefaultTask;

//FIXME: Intellij doesn't recognize the dependencies
public class SetupD4JTask extends DefaultTask {
//	
//	@TaskAction
//	public void exec() {
//		addRepo("https://jitpack.io"); //Adds jitpack.io
//		getProject().getRepositories().add(getProject().getRepositories().jcenter()); //Adds jcenter
//		
//		Dependency d4jdep = getProject().getDependencies().create("com.github.austinv11:Discord4j:" //Adds Discord4J
//				+getProject().getExtensions().getByType(Discord4GradlePluginExtension.class).getVersion()+":shaded");
//		getProject().getDependencies().add("compile", d4jdep);
//	}
//	
//	private void addRepo(String url) {
//		getProject().getRepositories().add(getProject().getRepositories().maven(mavenArtifactRepository -> {
//			try {
//				mavenArtifactRepository.setUrl(new URI(url));
//			} catch (URISyntaxException e) {
//				e.printStackTrace();
//			}
//		}));
//	}
}
