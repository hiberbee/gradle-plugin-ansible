/*
 * Copyright (c) 2019. Hiberbee https://hiberbee.com"
 *
 * This file is part of the Hiberbee OSS. Licensed under the MIT License
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 *
 */

package com.hiberbee.gradle.task

import com.hubspot.jinjava.Jinjava
import com.hubspot.jinjava.JinjavaConfig
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.yaml.snakeyaml.Yaml

import java.nio.charset.Charset

class TemplatesTask extends DefaultTask {

  static final Jinjava jinjava = new Jinjava(JinjavaConfig.newBuilder().withTrimBlocks(true).build())

  TemplatesTask() {
    this.group = "build"
  }

  @TaskAction
  void template() {
    def configFile = new File(this.project.projectDir, "config.yml")
    Map<String, ?> values = this.project["config"]
    if (configFile.exists()) {
      Map<String, ?> configValues = new Yaml().load(configFile.newInputStream())
      values.putAll(configValues)
    }
    values.get("templates") .each { String path ->
      println("Templating ${path} for project ${this.project.name}")
      def content = jinjava.resourceLocator.getString("templates/${path}.j2", Charset.defaultCharset(), jinjava.newInterpreter())
      new File(this.project.projectDir.absolutePath, path).write(jinjava.render(content, values))
    }
  }

}
