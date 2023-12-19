# Gradle Quarkus Extra Plugin

[![Build Status](https://github.com/Scalified/gradle-quarkus-extra-plugin/actions/workflows/build.yml/badge.svg)](https://github.com/Scalified/gradle-quarkus-extra-plugin/actions)
[![Changelog CI Status](https://github.com/Scalified/gradle-quarkus-extra-plugin/workflows/Changelog%20CI/badge.svg)](CHANGELOG.md)
[![Gradle Plugin Portal](https://img.shields.io/maven-metadata/v?label=Plugin&metadataUrl=https://plugins.gradle.org/m2/com/scalified/plugins/gradle/quarkus-extra/com.scalified.plugins.gradle.quarkus-extra.gradle.plugin/maven-metadata.xml)](https://plugins.gradle.org/plugin/com.scalified.plugins.gradle.quarkus-extra)

## Description

[Gradle Quarkus Extra Plugin](https://plugins.gradle.org/plugin/com.scalified.plugins.gradle.quarkus-extra) provides
an extra configuration options for the [Quarkus](https://quarkus.io) framework

## Requirements

* [Gradle 8+](https://gradle.org/)

## Applying

```gradle
plugins {
  id "com.scalified.plugins.gradle.quarkus-extra" version "$version"
}
```

## Usage

## Configuration

**QuarkusExtraPlugin** extension:

```kotlin
configure<QuarkusExtraExtension> {
    configDir = file("$rootDir/config")
    configFileName = "application"
    defaultProfile = "local"
}
```

### List of supported configuration parameters

| Name               | Description                                                                                         |     Default Value     |
|:-------------------|:----------------------------------------------------------------------------------------------------|:---------------------:|
| **configDir**      | Configuration files directory                                                                       | **`$rootDir/config`** |
| **configFileName** | Configuration file name. **Quarkus** profile will be added (if present) as well as file extension   |    **application**    |
| **defaultProfile** | Default profile. If no profile was passed, this value will be used. Use empty string for no profile |       **local**       |

## License

```
MIT License

Copyright (c) 2023 Scalified

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Scalified Links

* [Scalified](http://www.scalified.com)
* [Scalified Official Facebook Page](https://www.facebook.com/scalified)
* <a href="mailto:info@scalified.com?subject=[Gradle Quarkus Extra Plugin]: Proposals And Suggestions">Scalified Support</a>
