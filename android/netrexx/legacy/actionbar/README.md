```
$ ant clean

$ ant code-gen      ## code-gen is cribbed from the sdk build.xml

$ javac -d bin/classes gen/com/example/myfirstapp/R.java

$ nrc -nocompile -keepasjava -replace src/com/example/myfirstapp/*nrx

$ ant debug

$ adb install -r bin/MyFirstApp-debug.apk

```
