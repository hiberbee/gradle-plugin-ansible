# Welcome to MkDocs

* [mkdocs documentation](http://mkdocs.org).
* [mkdocs-material documentation](https://squidfunk.github.io/mkdocs-material/).

## Usage example

    ansible galaxy install askent.ansible_role_intellij
    ansible-playbook configure-modules.yml
    
## Playbook example:

```
- hosts: localhost
  roles:
    - askent.ansible_role_intellij
  vars:
    project:
      name: hiberbee.com
      maintainer:
        email: vlad@hiberbee.com
        organization: Hiberbee
        name: Vlad Volkov
        websiteUrl: https://hiberbee.github.io
    module:
      <<: *defaultModule
      name: test-module
      group: com.hiberbee
      repository: https://github.com/hiberbee/test-module
      directoryLayout:
        - src/main/java
        - src/main/resources
        - tests
        - src/main/js
      ignoredDirectories:
        - build
      templates:
        build.gradle: ~
        src/main/resources/application.yml: ~
        composer.json: ~
        docker-compose.yml: ~
        package.json: ~
        .dockerignore: ~
        .gitignore: ~
      buildGradle:
        repositories:
          - mavenCentral()
      packageJson:
        dependencies:
          graphql: '1.11'
        scripts:
          run: yarn start
      ignoredDirectories:
        - build
      dockerComposeYml:
        version: '3.5'
        services:
          postgresql:
            image: postgres
      springApplication:
        application.yml
          spring:
            application:
              name: example-demo
          server:
            port: 8080
      composerJson:
        require:
          phpunit/phpunit: '3.8'

```
