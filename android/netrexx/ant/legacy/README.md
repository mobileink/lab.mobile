Legacy ActionBar Example - Android 2.1 and above (SDK 7 and over)
==========

This example demonstrates use of the compatibility libraries to
support action bars for SDK prior to 11 back to 7.

This requires two components:

* the [actionbar](actionbar) application, which uses
* the [appcompat_v7](appcompat_v7) library, which packages the support libs from the Android SDK as [dalvik](http://source.android.com/devices/tech/dalvik/) code

In the application (actionbar project) `AndroidManifest.xml` sets

* sets minSdkVersion to 7: `<uses-sdk android:minSdkVersion="7"...`
* sets theme to `android:theme="@style/Theme.AppCompat"` on `<activity...`
elements rather than `<application...` element

In the source code, the `Activity` implementations extend
`android.support.v7.app.ActionBarActivity`, rather than
`android.app.Activity` as the Kitkat version does.

The compatibility support libs `android-support-v4.jar` and ... are
required; they must be imported as android libraries, which are
implemented in the related `appcompat_v7` project.  This is
accomplished by adding the following line to project.properties:

```
android.library.reference.1=../appcompat_v7
```

See
[Referencing a Library Project](http://developer.android.com/tools/projects/projects-cmdline.html#ReferencingLibraryProject)
for details.
