/*
 * Copyright (c) 2019. Hiberbee https://hiberbee.com"
 *
 * This file is part of the Hiberbee OSS. Licensed under the MIT License
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 *
 */

package com.hiberbee.gradle.plugin

import com.hiberbee.gradle.task.VaultTask
import com.hiberbee.gradle.task.TelepresenceTask
import com.hiberbee.gradle.task.TemplatesTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class AnsiblePlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.tasks.create("templates", TemplatesTask)
    project.tasks.register("telepresence", TelepresenceTask)
    project.tasks.register("encypt", VaultTask)
    project.tasks.register("decrypt", VaultTask)
  }
}
