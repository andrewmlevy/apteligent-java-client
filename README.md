# Apteligent (Crittercism) API Java Client Library

This is a Java client library for the [Apteligent (formerly Crittericsm) API](https://docs.apteligent.com/api/api.html).
You can use this library in a standard Java project, or inside an Android app.

The library binds the API responses to java objects. If you see a variable type "object" in a class then that usually
means it's a TODO item to properly map the json response.

### Dependencies

Requires the jackson core, annotations, and databind library. These dependencies are named in the included gradle file.

### API Coverage

Full or partial coverage for the following API calls:

+ /errorMonitoring/graph
+ /errorMonitoring/pie
+ /errorMonitoring/sparklines
+ /crash/{hash}
+ /{appId}/crash/{hash}/userData

### Java

The included gradle file will build the JAR. If you are not using gradle, you'll need to make sure to include the aforementioned jackson libraries.

### Android

Here are the three steps to include this in an Android app:

1. Add this project to a directory inside your app/libs folder
2. In app/build.gradle, make sure you add this as a dependency:

        android {
           dependencies {
               compile project(':apteligent-java-client')
               // add other dependencies as needed
           }
           // ... rest of android config
        }
        
        dependencies {
           compile fileTree(dir: 'libs', include: ['*.jar'])
           compile files('libs/apteligent-java-client/build/libs/apteligent-java-client-1.0.jar')
           // add other dependencies as needed
        }

3. In your project's settings.gradle, add:

        include ':app', ':apteligent-java-client'
        project(':apteligent-java-client').projectDir = new File('app/libs/apteligent-java-client')
