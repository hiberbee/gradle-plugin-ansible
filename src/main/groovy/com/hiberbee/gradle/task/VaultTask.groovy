/*
 * Copyright (c) 2019. Hiberbee https://hiberbee.com"
 *
 * This file is part of the Hiberbee OSS. Licensed under the MIT License
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 *
 */

package com.hiberbee.gradle.task


import com.hiberbee.gradle.model.VaultOperation
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class VaultTask extends Exec {

  @Input
  File[] files

  VaultTask() {
    this.group = 'vault'
    this.description = "Encrypts or decrypts secret files"
  }

  @TaskAction
  void encrypt() {
    this.files.each { file ->
      try {
        this.commandLine("ansible-vault", VaultOperation.ENCRYPT.getCommandLineArg(), file.absolutePath)
        super.exec()
      } catch (Throwable e) {
        println(e.message)
      }
    }
  }

  @TaskAction
  void decrypt() {
    this.files.each { file ->
      try {
        this.commandLine("ansible-vault", VaultOperation.DECRYPT.getCommandLineArg(), file.absolutePath)
        super.exec()
      } catch (Throwable e) {
        println(e.message)
      }


    }
  }

}
