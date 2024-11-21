# appium-omprakash
Repository for the course https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/

## Set up
1. Install Android Studio
1. Install Appium
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
/usr/local/appium-inspector/appium-inspector.AppImage --no-sandbox
```

## Execution
```
appium
```

## References
1. Omprakash Chavan. Appium Mobile Automation - Android & iOS + Frameworks + CICD. Udemy. URL: https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/