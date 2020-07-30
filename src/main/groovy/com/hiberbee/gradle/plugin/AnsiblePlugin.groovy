/*
 * Copyright (c) 2019. Hiberbee https://hiberbee.com"
 *
 * This file is part of the Hiberbee OSS. Licensed under the MIT License
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 *
 */

package com.hiberbee.gradle.plugin


import org.gradle.api.Plugin
import org.gradle.api.Project

class AnsiblePlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.extensions.create("ansible", AnsiblePluginExtension)
    project.sourceSets {
      ansible {
        resources.srcDirs = ["src/main/ansible"]
      }
    }

    project.configurations {
      ansible { visible = false }
      ansibleImplementation.extendsFrom(ansible)
    }
  }
}
