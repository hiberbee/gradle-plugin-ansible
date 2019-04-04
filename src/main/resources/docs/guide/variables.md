# Variables

Variables example:

```
project:
  name: hiberbee.com
  maintainer:
    email: vlad@hiberbee.com
    organization: Hiberbee
    name: Vlad Volkov
    websiteUrl: https://hiberbee.github.io

default:
  module: &defaultModule
    group: com.hiberbee
    templates: &defaultTemplates
      .dockerignore: ~
      .gitignore: ~
    ignoredDirectories:
      - build
    travisYml:
      language: generic

module:
  <<: *defaultModule
  name: test-module
  repository: https://github.com/hiberbee/test-module
  directoryLayout:
    - src/main/java
    - tests
    - src/main/js
  templates:
    <<: *defaultTemplates
    build.gradle: ~
    composer.json: ~
    docker-compose.yml: ~
    package.json: ~
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
  composerJson:
    require:
      phpunit/phpunit: '3.8'
```
