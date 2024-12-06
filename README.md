# appium-omprakash
Repository for the course https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/

## Set up

### Android Studio
1. Download Android Studio from https://developer.android.com/studio/install and follow the instructions to install it.
1. Add an Android Studio desktop entry by running `/usr/local/android-studio/bin/studio.sh` and selecting the gear icon > create desktop entry. 

### Kernel Virtual Machine (KVM) Accelerator
1. Follow the instructions on https://developer.android.com/studio/run/emulator-acceleration#vm-linux for a generic linux.
1. Follow the instructions on https://help.ubuntu.com/community/KVM/Installation for Ubuntu.
1. HAXM is deprecated (see https://developer.android.com/studio/run/emulator-acceleration#haxm-uninstall)

### Sample App
* Download the SampleCode app from [this Appium's page](https://github.com/appium/appium/blob/master/packages/appium/sample-code/apps/ApiDemos-debug.apk)
* You can move the APK in /usr/local/appium-inspector `mv ~/Downloads/ApiDemos-debug.apk /usr/local/appium-inspector`.

### Appium
```
apt-get install nodejs
apt-get install npm
npm install -g appium@next
appium driver install uiautomator2
```

### Appium Inspector
1. Download the corresponding Linux AppImage fromm https://github.com/appium/appium-inspector/releases
1. Execute:
```
mkdir /usr/local/appium-inspector
mv Appium-Inspector-2024.9.1-linux-x86_64.AppImage /usr/local/appium-inspector/appium-inspector.AppImage
```
1. Capabilities:
```
{
  "automationName": "uiautomator2",
  "platformName": "Android",
  "deviceName": "SmallPhoneAPI35",
  "app": "/usr/local/appium-inspector/ApiDemos-debug.apk"
}
```

### Java Development Kit (JDK)
```
apt search openjdk
sudo apt-get install openjdk-11-jdk
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/bin
```

In case you get the error below, you need to upgrade your JDK version:
```
Class has been compiled by a more recent version of the Java Environment (class file version 53.0), this version of the Java Runtime only recognizes class file versions up to 52.0.
```

### Project setup [2]
```
apt-get install gradle
gradle init
```

## Execution
```
export ANDROID_HOME=~/Android/Sdk/
export PATH=$PATH:$ANDROID_HOME/platform-tools
appium
/usr/local/appium-inspector/appium-inspector.AppImage --no-sandbox
gradle test
```

## References
1. Omprakash Chavan. Appium Mobile Automation - Android & iOS + Frameworks + CICD. Udemy. URL: https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/
2. Microsoft. Java build tools in VS Code. URL: https://code.visualstudio.com/docs/java/java-build