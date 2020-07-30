# Ansible Gradle plugin

This plugin allows to create and configure Ansible tasks with Gradle

## Example

```
plugins {
  id "com.hiberbee.gradle.ansible" version "0.4.0"
}

# Configuration
ansible {
  inventory "inventory.yml"
}

# Playbook tasks
tasks.create("testPlaybook", PlaybookTask) {
  playbook "playbook.yml"
}

# Vault tasks
tasks.create("encryptVault", VaultTask) {
  file "secrets.yml"
}
```
