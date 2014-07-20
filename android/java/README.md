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
$ android create project -n myproj -t 1 -p myproj -k com.example.android -a MainActivity
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

### Build

Run `$ ant debug`.  If you follow the generic instructions on the
Android dev site you should see something like:

```
$ ant debug
...
-build-setup:
[getbuildtools] Using latest Build Tools: 19.1.0
     [echo] Resolving Build Target for actionbar...
[gettarget] Project Target:   Android 4.4.2
[gettarget] API level:        19
[gettarget] WARNING: No minSdkVersion value set. Application will install on all Android versions.
     [echo] ----------
...
```

We specified the target ID when we ran `android create project`; why
are we getting this message?  The answer is that the target specified
gets recorded in `project.properties` as `target=android-19`.  To set
the minimum SDK you have to edit AndroidManifest.xml:

```
  <uses-sdk android:minSdkVersion="11"
	    android:targetSdkVersion="19"/>

```
