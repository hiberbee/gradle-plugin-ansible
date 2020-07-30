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
import org.gradle.execution.commandline.TaskConfigurationException

class PlaybookTask extends Exec {

  @Input
  String playbook

  PlaybookTask() {
    group = "ansible"
    description = "Run Ansible Playbook"
    executable = "ansible-playbook"
  }

  @Override
  protected void exec() {
    def playbookFile = new File(playbook)
    super.args(playbookFile.path)
    super.exec()
  }
}
