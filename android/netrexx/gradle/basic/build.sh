#!/bin/sh

# ./gradlew clean \
# && ./gradlew compileDebugJava \

./nrc src/main/java/org/example/myapp/*nrx && ./gradlew assembleDebug


# /Applications/Android\ Studio.app/sdk/platform-tools/adb -d install -r build/outputs/apk/basic-debug.apk
