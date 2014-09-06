# basic gradle netrexx android app

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