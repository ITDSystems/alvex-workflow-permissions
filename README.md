# UNDER HEAVY DEVELOPMENT! DO NOT USE!

[![Build Status](https://travis-ci.org/ITDSystems/alvex-workflow-shortcut-dashlet.svg?branch=master)](https://travis-ci.org/ITDSystems/alvex-workflow-shortcut-dashlet)

Alvex workflow shortcut dashlet
========================

Alvex dashlet that provides one-click access to start workflows directly from your dashboard. Also adds permissions for groups that allows different groups of uses to have different available workflows. For instance, document registration workflow can be available for secretaries only and budget approval workflow only for managers. Permissions are set by administrator and enforced through the whole system.

Build
-----
You could build this component from [alvex-meta](https://github.com/ITDSystems/alvex-meta).

**Note!**
If you build this component directly from this repo - don't forget to build and install dependecies! This component depends on [alvex-common](https://github.com/ITDSystems/alvex-common) so you should install it first.

The component may be packaged in two ways: *amp* and *jar*.
To build amp use `mvn clean package`, to build installable jar use `mvn -P make-jar clean package`.

**Note**: this project requires Maven 3.3.9 at least.
