/*
 * Copyright (c) 2019. Hiberbee https://hiberbee.com"
 *
 * This file is part of the Hiberbee OSS. Licensed under the MIT License
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 *
 */

package com.hiberbee.gradle.model

enum VaultOperation {
  ENCRYPT, DECRYPT

  String getCommandLineArg() {
    return this.name().toLowerCase()
  }
}
