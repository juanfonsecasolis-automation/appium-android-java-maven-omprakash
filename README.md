# appium-omprakash
Repository for the course https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/

## Set up

### Android Studio (neccesary to set-up the phone emulator)
1. Download Android Studio from https://developer.android.com/studio/install and follow the instructions to install it.
1. Add an Android Studio desktop entry by running `/usr/local/android-studio/bin/studio.sh` and selecting the gear icon > create desktop entry. 

### Kernel Virtual Machine (KVM) Accelerator
1. Follow the instructions on https://developer.android.com/studio/run/emulator-acceleration#vm-linux for a generic linux.
1. Follow the instructions on https://help.ubuntu.com/community/KVM/Installation for Ubuntu.
1. HAXM is deprecated (see https://developer.android.com/studio/run/emulator-acceleration#haxm-uninstall)

### Sample Apps
* [Appium Sample App](https://github.com/appium/appium/blob/master/packages/appium/sample-code/apps/ApiDemos-debug.apk).
* [Sauce Demo App](https://github.com/saucelabs/my-demo-app-android/releases).

### Appium
```
apt-get install nodejs
apt-get install npm
npm install -g appium@next
appium driver update uiautomator2
appium driver install uiautomator2
```

### Appium Inspector
1. Download the corresponding Linux AppImage from https://github.com/appium/appium-inspector/releases
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
  "appium:app": "/home/juanf/repositorios/appium-android-java-maven-omprakash/apps/ApiDemos-debug.apk",
  "appium:app": "/home/juanf/Downloads/mda-2.2.0-25.apk",
}
```

### Find appPackage and appActivityName [5]
* Start the app in the Android device and execute the commands below:
```
adb devices
adb shell
dumpsys window displays | grep -E 'mCurrentFocus'
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

### Project setup with Maven [2, 3]
* Install the "Maven for Java" extension.
* Install Maven:
```
sudo apt-get install maven
mvn --version
```
* Right-click on the solution explorer > Maven > New Project > "maven-archetype-quickstart" archetype
* Check your Java version `java --version`
* Run `mvn test`

## Execution [4]
```
export ANDROID_HOME=~/Android/Sdk/
export PATH=$PATH:$ANDROID_HOME/platform-tools
appium
/usr/local/appium-inspector/appium-inspector.AppImage --no-sandbox
mvn clean test -DsuiteXmlFilePath=src/test/resources/AppiumDemoAppTest.xml
mvn clean test -DsuiteXmlFilePath=src/test/resources/SauceLabsDemoAppTest.xml
```

## Locator strategies
|Locator strategy|Speed|Definition|Example|
|---|---|---|---|
|Accessibility ID|Fast|Adhoc|`<unique_element_name>`|
|ID|Fast|Adhoc|`<app_package><resource_id>`|
|Class Name|Fast|Fixed|`android.widget.TextView`|
|Name|?|?|`<static_test>`|
|XPath|Slow|Fixed|`//<UiAutomator2 Class>[@<attribute_name>="attribute value"]/<axes>::<expressions>`|
|UiAutomator2 (UiSelector)|Very fast|Fixed|`new UiSelector().text("Animation")`|

## Insights from some of the quices
* Appium 2.0 follows the W3C WebDriver Protocol, not the JSON 2.0 Wire protocol anymore.
* To execute iOS automation Appium needs XCode (which is only available on MacOS).
* Appium is a Node.js server (Javascript that runs on desktop).
* Appium can automate different types of mobile applications (native, hybrid, and web-apps).
* Appium is designed for end-to-end (E2E) functional tests.
* Driver UiAutomator2 is used for Android, whereas XCUITest is used for iOS.
* Appium doesn't require re-compilation of the apps when interacting with real devices.

## Notes
* Expresso is a faster an alternative to UiAutomator2 for android automation, however it's challenging to learn and is more recomended for unit testing rather than E2E testing.

## References
1. Omprakash Chavan. Appium Mobile Automation - Android & iOS + Frameworks + CICD. Udemy. URL: https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/
2. Microsoft. Java build tools in VS Code. URL: https://code.visualstudio.com/docs/java/java-build
3. GitBook. Creating Your Project with Maven. URL: https://gorkem1.gitbooks.io/visual-studio-code-for-java/content/chapter-1/Maven-Create.html (last consulted on 04/23/25).
4. TutorialsPoint. Run Specific TestNG Suite with Maven from Command Line. URL: https://www.tutorialspoint.com/how-to-run-specific-testng-suite-with-maven-from-command-line (last consulted on 04/25/24).
5. Anish. 2 Ways to find appPackage and appActivity name of your App. URL: https://www.automationtestinghub.com/apppackage-and-appactivity-name/ (last consulted on 04/29/24).