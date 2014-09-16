

## Build Instructions

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

To see a list of all available commands, run "gradlew tasks".

## Dependencies

- Android SDK Build-tools v18.1
- Android Support Repository v2

Dependencies are available for download via the Android SDK Manager.

Android Studio is available for download at:
    http://developer.android.com/sdk/installing/studio.html


## Testing

1.  Define an avd: `android avd`
2.  run it:  `emulator -avd <avd_name> [<options>]`
3.  install the app:  `adb install -r SwipeRefreshLayoutBasicSample/build/apk/SwipeRefreshLayoutBasicSample-debug-unaligned.apk`
4.  On the emulator, find the app and launch
