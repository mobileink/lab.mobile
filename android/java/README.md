# Android - Java dev

Assuming you've put the path to the SDK tools dir on your PATH, run
the `android` tool to create a project:

```
$ android -h create
```

result:

```
...
                         Action "create project":
  Creates a new Android project.
Options:
  -n --name          : Project name.
  -v --gradle-version: Gradle Android plugin version.
  -t --target        : Target ID of the new project. [required]
  -p --path          : The new project's directory. [required]
  -g --gradle        : Use gradle template.
  -k --package       : Android package name for the application. [required]
  -a --activity      : Name of the default Activity that is created.
                       [required]
...
```

To find available "targets" (i.e. target SDK versions), run

```
$ android list targets
Available Android targets:
----------
id: 1 or "android-19"
     Name: Android 4.4.2
     Type: Platform
     API level: 19
     Revision: 3
...
```

So:

```
$ android create project -n myproj -t 1 -p myproj -k com.example.proj -a MainActivity
```

Yielding:

```
myproj
- AndroidManifest.xml
- ant.properties
+ bin
  - <empty>
- build.xml
+ libs
  - <empty>
- local.properties
- proguard-project.txt
- project.properties
+ res
  + drawable-hdpi     ## hi-resolution resources
    - ic_launcher.png
  + drawable-ldpi     ## lo-resolution resources
    - ic_launcher.png
  + drawable-mdpi     ## med-resolution resources
    - ic_launcher.png
  + drawable-xhdpi    ## extra-hi-resolution resources
    - ic_launcher.png
  + layout
    - main.xml
  + values
    - strings.xml
+ src
  + com
    + example
	  + android
	    - MainActivity.java
```


