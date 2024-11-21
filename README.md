# appium-omprakash
Repository for the course https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/

## Set up

### Android Studio
1. Download Android Studio from https://developer.android.com/studio/install and follow the instructions to install it.
1. Add an Android Studio desktop entry by running `/usr/local/android-studio/bin/studio.sh` and selecting the gear icon > create desktop entry. 

### Kernel Virtual Machine (KVM) Accelerator
1. Follow the instructions on https://developer.android.com/studio/run/emulator-acceleration#vm-linux

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

## Execution
```
appium
/usr/local/appium-inspector/appium-inspector.AppImage --no-sandbox
```

## References
1. Omprakash Chavan. Appium Mobile Automation - Android & iOS + Frameworks + CICD. Udemy. URL: https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/