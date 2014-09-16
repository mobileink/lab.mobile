#!/bin/sh

# ./gradlew clean \
# && ./gradlew compileDebugJava \

#  add nrc arg '-format' to get pretty-printed output

./nrc src/main/nrx/org/example/myapp/*nrx && ./gradlew assembleDebug

# /Applications/Android\ Studio.app/sdk/platform-tools/adb -d install -r build/outputs/apk/basic-debug.apk
