Actionbar Example - Android 3.0 and above (SDK > 10)
==========

This example demonstrates action bars for SDK versions > 10:

`AndroidManifest.xml` sets

* sets minSdkVersion to 11: `<uses-sdk android:minSdkVersion="11"...`
* sets theme to `android:theme="@android:style/Theme.Holo.Light` on
  `<application...` element

In the source code, `Activity` implementations extend
`android.app.Activity` rather than
`android.support.v7.app.ActionBarActivity`, as the legacy version
does.

The compatibility support libs `android-support-v4.jar` and ... are not needed.
