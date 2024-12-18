#!/bin/bash
workdir=../../../DIH.Domain/
java -jar ../tools/openapi-generator-cli.jar generate -g java -i "$1" -o "$workdir" -c build_schemas_config.yaml --artifact-version "$2" --minimal-update &&
  rm "$workdir"src/main/AndroidManifest.xml &&
  rm -rf "$workdir"src/main/java/org &&
  rm -rf "$workdir".github/ &&
  rm "$workdir".travis.yml &&
  rm "$workdir"build.gradle &&
  rm "$workdir"build.sbt &&
  rm "$workdir"settings.gradle &&
  rm -rf "$workdir"gradle* &&
  rm -rf "$workdir"api &&
  rm -rf "$workdir"src/test &&
  rm -rf "$workdir"git_push.sh &&
  head -n -1 "$workdir"pom.xml >"$workdir"tmp.xml && mv "$workdir"tmp.xml "$workdir"pom.xml &&
  echo "    <distributionManagement>
          <repository>
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/Redpill-Linpro-DK/dih-fair-common</url>
          </repository>
    </distributionManagement>
</project>" >>"$workdir"pom.xml &&
  mvn clean compile -f "$workdir"pom.xml
