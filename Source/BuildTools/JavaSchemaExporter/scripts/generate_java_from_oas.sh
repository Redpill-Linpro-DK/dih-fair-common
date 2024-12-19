#!/bin/bash
java -jar ../tools/openapi-generator-cli.jar generate -g java -c generate_java_from_oas_config.yaml --minimal-update -o "$GNR_OUTPUT_DIR" "$@" &&
  rm "$GNR_OUTPUT_DIR"src/main/AndroidManifest.xml &&
  rm -rf "$GNR_OUTPUT_DIR"src/main/java/org &&
  rm -rf "$GNR_OUTPUT_DIR".github/ &&
  rm "$GNR_OUTPUT_DIR".travis.yml &&
  rm "$GNR_OUTPUT_DIR"build.gradle &&
  rm "$GNR_OUTPUT_DIR"build.sbt &&
  rm "$GNR_OUTPUT_DIR"settings.gradle &&
  rm -rf "$GNR_OUTPUT_DIR"gradle* &&
  rm -rf "$GNR_OUTPUT_DIR"api &&
  rm -rf "$GNR_OUTPUT_DIR"src/test &&
  rm -rf "$GNR_OUTPUT_DIR"git_push.sh &&
  head -n -1 "$GNR_OUTPUT_DIR"pom.xml >"$GNR_OUTPUT_DIR"tmp.xml && mv "$GNR_OUTPUT_DIR"tmp.xml "$GNR_OUTPUT_DIR"pom.xml &&
  echo "    <distributionManagement>
          <repository>
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/Redpill-Linpro-DK/dih-fair-common</url>
          </repository>
    </distributionManagement>
</project>" >>"$GNR_OUTPUT_DIR"pom.xml &&
  mvn clean compile -f "$GNR_OUTPUT_DIR"pom.xml
