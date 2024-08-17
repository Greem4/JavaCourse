package com.greem4.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        addHelloTask(project)
    }

    static void addHelloTask(Project project) {
        project.task("Hello", type: DefaultTask) {
            description = "Hello task"
            group = "greem4"

            println "configuration phase. Task hello"

            doLast {
                println "execution phase, Action 1"
                println "execution phase, Action 2"
                println "execution phase, Action 3"
            }

            println "task: $description, group: $group, action: ${actions.size()}"
            println "path task: $path"
        }
    }
}
