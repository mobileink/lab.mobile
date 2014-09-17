NetRexx Android Development
==========

Examples of using [netrexx](http://www.netrexx.org/) to develop
android apps.

Originally the Android build system was Ant-based, and the IDE was
based on Eclipse.  This is changing to a Gradle-based build system
with a new IDE, "Android Studio", based on IntelliJ IDEA.

The examples here do not use the IDEs.

The Gradle-based build system is a huge improvement over the Ant-based
system, so we only include a few basic examples using Ant builds.

**_If you are just getting started you should ignore the Ant-based examples._**

The trick is to use the netrexx translator to generate java code but
not compile it.  The build system will treat those files just like any
other java files; but for our purposes they are intermediate files,
and thus not under version control.

And of course the NetRexx runtime - NetRexxR.jar, a measly 37K! - is
required.  The Android build scripts (both Ant- and Gradle-based) will
dexify (compile to Dalvik) anything in the `libs` directory of the
project, so all we need to do is copy `NetRexxR.jar` to `libs`.

## Gradle

To integrate NetRexx code, you just need to run a preparatory
compile (to generate compiled resources), then run the netrexx translator (to generate java files from netrexx source), and then build the whole thing using the standard gradle command.

1.  make sure you have gradle 1.10 installed
2.  adjust the paths in the files in bin
3.  $ source bin/android-dev
4.  cd basic
5.  $ gradle wrapper

Now compile the resources so the netrexx compile step doesn't complain:

6.  $ ./gradlew compileDebug

Translate netrexx source to java source:

7.  ./nrc src/main/java/org/example/myapp/*nrx

Now build the whole shebang:

8.  ./gradlew assembleDebug

Thereafter, just run $ ./build.sh when you change the netrexx source code.

## Ant

To make this work, we expose the `-code-gen` task found in the
Android SDK ant file at `$ANDROID_HOME/tools/ant/build.xml` by copying
it to our project `build.xml` and adding the required dependencies.

  In brief:

```
$ ant clean

$ ant code-gen      ## code-gen is cribbed from the sdk build.xml

$ javac -d bin/classes gen/com/example/myfirstapp/R.java

$ nrc -nocompile -keepasjava -replace src/com/example/myfirstapp/*nrx

$ ant debug

$ adb install -r bin/MyFirstApp-debug.apk
```

The [bin](bin) directory contains the shell scripts that make this work.

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

# Converting Android Java to NetRexx


Casting:  no parens.  So instead of `foo = (Bar) baz(...)` do `foo = Bar baz(...)`

Class constants: must be prefixed by classname, e.g. Context.MODE_WORLD_READABLE

Nested classes: not supported natively; instead use "minor" and
"dependent" classes.  When something in the containing class is
refered to it must be prefixed by "parent." or the classname.

Nested classes from java libs must be explicitly imported to be used.

Anonymous classes:  not supported.  Use minor/dependent classes instead.

Qualified names: netrexx is a little more finicky than Java.  This is
usually a good thing IMHO.  For example, in the Spinner example, in a
nested class in the original java, we make a call to `findViewById`, a
method of the `Activity` class.  The ref is unqualified, but the
compiler can figure it out since it is in a nested class.  In netrexx
we do not have nested classes, so such refs have to be explicitly
qualified, e.g. `SpinnerActivity.this.findViewById`.

Example: in the spinner example we have

```java
protected ArrayAdapter<CharSequence> mAdapter;
...
Spinner spinner = (Spinner) findViewById(R.id.Spinner01);
...
spinner.setAdapter(this.mAdapter);
```

In netrexx:

```netrexx
import android.widget.SpinnerAdapter
...
properties inheritable
mAdapter = ArrayAdapter	-- <CharSequence>
...
theSpinner = Spinner -- type declaration
theSpinner = Spinner findViewById(R.id.Spinner01)  -- cast
...
theSpinner.setAdapter(SpinnerAdapter this.mAdapter)
```

We use `theSpinner` instead of `spinner` to avoid a warning and to
make sure there is no confusion between classname ('Spinner') and
object name ('spinner').

We explicitly cast the arg to setAdapter, so we have to import SpinnerAdapter.  Otherwise NetRexxC will complain:

```
+++ theSpinner.setAdapter(this.mAdapter)
+++            ^^^^^^^^^^
+++ Error: More than one method matches the name and signature 'android.widget.Spinner.setAdapter(android.widget.ArrayAdapter)'
```

