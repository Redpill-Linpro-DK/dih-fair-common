#!/bin/bash
java -jar ../tools/openapi-generator-cli.jar generate -g java -i "$1" -o ../../../DIH.Java.Domain/ -c build_schemas_config.yaml --artifact-version 1.0.1 --minimal-update &&
  rm ../../../DIH.Java.Domain/src/main/AndroidManifest.xml &&
  rm -rf ../../../DIH.Java.Domain/src/main/java/org &&
  rm -rf ../../../DIH.Java.Domain/.github/ &&
  rm ../../../DIH.Java.Domain/.travis.yml &&
  rm ../../../DIH.Java.Domain/build.gradle &&
  rm ../../../DIH.Java.Domain/build.sbt &&
  rm ../../../DIH.Java.Domain/settings.gradle &&
  rm -rf ../../../DIH.Java.Domain/gradle* &&
  rm -rf ../../../DIH.Java.Domain/api &&
  rm -rf ../../../DIH.Java.Domain/src/test &&
  rm -rf ../../../DIH.Java.Domain/git_push.sh
