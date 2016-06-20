package com.austinv11.d4g

import com.austinv11.d4g.tasks.ModuleTask
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.ArtifactRepository
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import java.util.function.Predicate
import java.util.stream.Collectors

import static org.junit.Assert.assertTrue

class Discord4GradleTest {
    
    @Test
    public void verify() {
        Project project = ProjectBuilder.builder().build()
        project.getPlugins().apply 'com.austinv11.d4g.plugin'

        assertTrue(project.tasks.modules instanceof ModuleTask)

        assertTrue(project.repositories.stream().filter(new Predicate<ArtifactRepository>() {
            @Override
            boolean test(ArtifactRepository artifactRepository) {
                return artifactRepository instanceof MavenArtifactRepository && (artifactRepository as MavenArtifactRepository).url.toString().equals("https://jitpack.io")
            }
        }).collect(Collectors.toList()).size() == 1)
        
        println("Plugin verified!")
    }
}
