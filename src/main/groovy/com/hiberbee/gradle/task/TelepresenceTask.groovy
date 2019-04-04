/*
 * Copyright (c) 2019. Hiberbee https://hiberbee.com"
 *
 * This file is part of the Hiberbee OSS. Licensed under the MIT License
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 *
 */

package com.hiberbee.gradle.task

import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class TelepresenceTask extends Exec {

  @Input
  String containerCommand

  TelepresenceTask() {
    this.group = "application"
    this.commandLine.addAll(["telepresence", "--mount", "--volume", "/tmp/known/var/run/secrets:/var/run/secrets", "--volume",
                             "${this.project.projectDir.absolutePath}:/${this.project.projectDir}", "--new-deployment", this.project.name, "--docker-run",
                             "--workdir", "/${this.project.projectDir}", "--rm", "ansible-dock8s"])
  }

  @TaskAction
  void run() {
    this.commandLine.add(this.containerCommand)
    super.exec()
  }

}
