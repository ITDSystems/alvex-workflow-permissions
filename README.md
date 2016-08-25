# UNDER HEAVY DEVELOPMENT! DO NOT USE!

[![Build Status](https://travis-ci.org/ITDSystems/alvex-workflow-shortcut-dashlet.svg?branch=master)](https://travis-ci.org/ITDSystems/alvex-workflow-shortcut-dashlet)

Alvex workflow shortcut dashlet
========================

Alvex dashlet that provides one-click access to start workflows directly from your dashboard.

Build
-----
Preferable way of building this component is using the [alvex-meta](https://github.com/ITDSystems/alvex-meta) packaging_pom.xml:
```
  mvn -f packaging_pom.xml -P workflow-shortcut-dashlet package
```
Maven alone will build in all dependencies and create complete zip with suitable configuration. If you want to build this component by yourself then dependencies is all yours pain.

### Note!
This component depends on [alvex-common](https://github.com/ITDSystems/alvex-common) so you should install it first.

The component may be packaged in two ways: *amp* and *jar*.
To build amp use `mvn clean package`, to build installable jar use `mvn -P make-jar clean package`.

**Note**: this project requires Maven 3.3.9 at least.
