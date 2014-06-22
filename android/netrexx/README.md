NetRexx Android Development
==========

Examples of using [netrexx](http://www.netrexx.org/) to develop
android apps.

The trick is to use the netrexx translator to generate java code but
not compile it.  To make that work, we expose the `-code-gen` task
found in the Android SDK ant file at
`$ANDROID_HOME/tools/ant/build.xml` by copying it to our project
`build.xml` and adding the required dependencies.

  In brief:

```
$ ant clean

$ ant code-gen      ## code-gen is cribbed from the sdk build.xml

$ javac -d bin/classes gen/com/example/myfirstapp/R.java

$ nrc -nocompile -keepasjava -replace src/com/example/myfirstapp/*nrx

$ ant debug

$ adb install -r bin/MyFirstApp-debug.apk

```

Here `nrc` is our shell script that takes care of running the NetRexx
translator.

To make this work the PATH and CLASSPATH, and ANDROID_HOME env vars
must to be properly set; that's the job of the other shell scripts:

* `.netrexx` adds the NetRexx translator jar (`NetRexxC.jar`) to CLASSPATH
* `.android-cp` adds adds the ADT jars and the project class dirs to CLASSPATH
* `.android-dev` sets ANDROID_HOME and adds the ADT tool dirs to PATH,
  then sources .android-cp

These three scripts are designed to live in `~/` (or somewhere else
convenient); if you want the NetRexx/Android dev environment to be set
up for every session, add something like the following to `~/.bash_proile`:

```
. ~/.android-dev
. ~/.netrexx
```

An alternative is to only source these files when you work on
NetRexx/Android projects; just execute the above commands from the
command line.

And of course the NetRexx runtime is required.  The Android ant build
scripts will dexify (compile to Dalvik) anything in the `libs`
directory of the project, so all we need to do is copy `NetRexxR.jar`
to `libs`.

## examples

### Basic examples

* [legacy](legacy)
* [actionbar](actionbar)

These examples use netrexx to implement the code from the Android
tutorials

[Building Your First App](http://developer.android.com/training/basics/firstapp/index.html)
and
[Adding the Action Bar](http://developer.android.com/training/basics/actionbar/index.html).

The "legacy" example uses the Support library to support action bars
in min SDK versions from 7 to 10.

The "kitkat" example is for min sdk versions 11 and over.

