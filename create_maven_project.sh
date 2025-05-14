#!/bin/bash

read -p "Enter the project name: " ARTIFACT_ID

mvn archetype:generate \
  -DgroupId="App" \
  -DartifactId="$ARTIFACT_ID" \
  -Dversion="1.0" \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

if [ $? -eq 0 ]; then
  echo "Maven project '$ARTIFACT_ID' successfully created in the current directory."

  # Add the exec-maven-plugin to the pom.xml file
  POM_FILE="./$ARTIFACT_ID/pom.xml"
  if [ -f "$POM_FILE" ]; then
    sed -i '/<\/dependencies>/a\
    <build>\
      <plugins>\
        <plugin>\
          <groupId>org.codehaus.mojo</groupId>\
          <artifactId>exec-maven-plugin</artifactId>\
          <version>3.5.0</version>\
          <configuration>\
            <mainClass>App.App</mainClass>\
          </configuration>\
        </plugin>\
      </plugins>\
    </build>' "$POM_FILE"
    echo "Exec-maven-plugin added to the pom.xml file."
  else
    echo "Error: pom.xml file not found."
  fi
else
  echo "Error while creating the Maven project."
fi