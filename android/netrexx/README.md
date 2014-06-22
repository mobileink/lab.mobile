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

## Examples

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

