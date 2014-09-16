### NetRexx/Android dev tools

`nrc` is the shell script that takes care of running the NetRexx
translator.

To make this work the PATH and CLASSPATH, and ANDROID_HOME env vars
must to be properly set; that's the job of the other shell scripts:

* `netrexx` adds the NetRexx translator jar (`NetRexxC.jar`) to CLASSPATH
* `android-cp` adds adds the ADT jars and the project class dirs to CLASSPATH
* `android-dev` sets ANDROID_HOME and adds the ADT tool dirs to PATH,
  then sources .android-cp

These three scripts are designed to live as dotfiles in `~/` (or
somewhere else convenient); if you want the NetRexx/Android dev
environment to be set up for every session, add something like the
following to `~/.bash_proile`:

```
. ~/.android-dev
```

(assuming you've renamed them as dotfiles).

An alternative is to only source these files when you work on
NetRexx/Android projects; just execute the above commands from the
command line.

