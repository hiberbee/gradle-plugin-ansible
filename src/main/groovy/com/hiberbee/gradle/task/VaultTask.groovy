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

class VaultTask extends Exec {

  @Input
  String file

  VaultTask() {
    group = "vault"
    description = "Encrypts or decrypts secret files"
    executable = "ansible-vault"
  }

  @TaskAction
  void encrypt() {
    super.args(new File(file).path)
    super.exec()
  }

  @TaskAction
  void decrypt() {
    super.args(new File(file).path)
    super.exec()
  }

}
