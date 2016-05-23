## Simple standalone Java Web Jetty Maven application

Project skeleton was created like this:
```code
mvn archetype:generate -DgroupId=eu.coreteam -DartifactId=wc -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

Initial POM file:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>eu.coreteam</groupId>
  <artifactId>webconverter</artifactId>
  <packaging>war</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>webconverter Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
<build>
        <finalName>webconverter</finalName>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.mortbay.jetty</groupId>
                    <artifactId>maven-jetty-plugin</artifactId>
                    <version>7.0.0.pre5</version>
                    <configuration>
                        <scanIntervalSeconds>10</scanIntervalSeconds>
                        <stopKey>foo</stopKey>
                        <stopPort>9999</stopPort>
                    </configuration>
                    <executions>
                        <execution>
                            <id>start-jetty</id>
                            <phase>pre-integration-test</phase>
                            <goals>
                                <goal>run</goal>
                            </goals>
                            <configuration>
                                <scanIntervalSeconds>0</scanIntervalSeconds>
                                <daemon>true</daemon>
                            </configuration>
                        </execution>
                        <execution>
                            <id>stop-jetty</id>
                            <phase>post-integration-test</phase>
                            <goals>
                                <goal>stop</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>
```

Start local web server:
```code
mvn jetty:run -Djetty.port=PORT
```
(port option is **not mandatory**)


## Usage of Apache POI test:

(Url + UrlEncoded path to file)
http://localhost:8080/wc/excel97?f=C%3A%5Cdelete%5C97.xls

http://localhost:8080/wc/word?f=C%3A%5Cdelete%5C97.doc


