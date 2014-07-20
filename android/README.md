### Development Options

* Java is the default env
* [NetRexx](http://www.netrexx.org/)  Little known, but very people-friendly, easy to learn and use
* [Processing](http://processing.org/) Must be something to this;
  somebody wrote a whole book about it:
  [Rapid Android Development: Build Rich, Sensor-Based Applications with Processing](http://pragprog.com/book/dsproc/rapid-android-development)
* Other JVM languages (jython, etc.): possible, but doesn't seem to be a very popular choice
* Non-java: possible, but not recommended for app development


Scripting environment:  [sl4a](https://github.com/damonkohler/sl4a) (Scripting Layer for Android) Currently supports:
* Python
* Perl
* JRuby
* Lua
* BeanShell
* JavaScript
* Tcl
* shell

# Android KDE - Keyboard Development Environment

The Android KDE is my tongue-in-cheek way of referring to Android
development without an IDE.  All you need is a command line and an
editor.  Oh, and fingers.

See also [Building Android Application Bundles (APKs) by Hand](http://spin.atomicobject.com/2011/08/22/building-android-application-bundles-apks-by-hand/) (2011)

CAVEAT: the online documentation, including blogs etc. has the usual
problems.  Don't assume it's up to date.

[Android Open Source Project](http://source.android.com/)

[Android git repos](https://android.googlesource.com/)

## Installation

Download and unzip the SDK, not the ADT; park it someplace convenient
(I put it at /usr/local/android-sdk-macosx).

Set the ANDROID_HOME env var.

cd to $ANDROID_HOME/tools and run `$ android sdk`.  Install the
goodies. Include the SDK source code.

### SDK Tools

Forget the ADT (Android Development Tools) - that's all GUI crap.

See [Android Tools Project Site](http://tools.android.com/)

[Android source](http://source.android.com/source/downloading.html)

Some of the SDK tools are documented
[here](http://developer.android.com/tools/help/index.html).  To get
started, you need to know about:

* [android](http://developer.android.com/tools/help/android.html) -
  this is really more of a meta-tool than a tool; it allows you to
  launch other tools (AVD, SDK managers) and to create and update
  "projects" - i.e. the source code and directory layout of an Android
  app or library.
* adb - "Android Debug Bridge".  This is what installs your code etc.

There are a bunch of generally useful dev tools; to get started you will probably want to
use:

* lint
* logcat - capable of dumping log messages from a hardware device, among other things
* etc.

Then there are the "build" tools, located in
`$ANDROID_HOME/build-tools/$VERSION/`,
e.g. `$ANDROID_HOME/build-tools/19.1.0/`, which include:

* aapt - Android Asset Packaging Tool, which turns resources into an
  R.java file and compiled versions;
* aidl - android IDL thingee;
* dx - compiles class files, 3rd party libraries and class files, to
  .dex code (Dalvik bytecode)

The
[Building and Running](http://developer.android.com/tools/building/index.html)
page has a pretty good diagram showing how the build is structured and
which tools are used where.  As of June 2014 the whole thing is
controlled by an Ant file, $SDK/tools/ant/build.xml.  (Apparently they
are getting ready to inflict a new Gradle-based build system on us.)
Which means that the various build tools are complemented by custom
Ant tasks (see the
[Tools Technical Docs](http://tools.android.com/tech-docs).

For
example, here is what the `aapt` Ant task invocation looks like in
build.xml:

```
            <aapt executable="${aapt}"
                    command="package"
                    verbose="${verbose}"
                    manifest="${out.manifest.abs.file}"
                    originalManifestPackage="${project.app.package}"
                    androidjar="${project.target.android.jar}"
                    rfolder="${gen.absolute.dir}"
                    nonConstantId="${android.library}"
                    libraryResFolderPathRefid="project.library.res.folder.path"
                    libraryPackagesRefid="project.library.packages"
                    libraryRFileRefid="project.library.bin.r.file.path"
                    ignoreAssets="${aapt.ignore.assets}"
                    binFolder="${out.absolute.dir}"
                    proguardFile="${out.absolute.dir}/proguard.txt">
                <res path="${out.res.absolute.dir}" />
                <res path="${resource.absolute.dir}" />
            </aapt>
```

Compare this to what you see running

```
$ $ANDROID_HOME/build-tools/19.1.0/aapt 2>&1 | less
```

Source coce:  [legacy ant tasks](https://android.googlesource.com/platform/tools/base/+/master/legacy/ant-tasks/src/main/java/com/android/ant)


CAVEAT: the Ant tasks don't always match up to something found in the
SDK; case in point is apkbuilder.

### SDK Examples

See [Android SDK: Samples](http://code.tutsplus.com/tutorials/android-sdk-samples--mobile-20901)  (caveat: IDE-based)
