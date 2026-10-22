# Appium Framework

Android UI sample for the YouTube app. TestNG, Appium Java client 8, and Selenium. The driver setup is in `src/test/java/com/sample/test/BaseTest.java`.

## What you need

- JDK 8
- Maven
- Node.js, then Appium 2 with the UiAutomator2 driver
- An Android emulator or device
- The YouTube app installed on that device

`BaseTest` connects to `http://0.0.0.0:4723/wd/hub` and expects:

- `udid`: `emulator-5554`
- `platformVersion`: `14.0`
- `appPackage`: `com.google.android.youtube`

Change those values in `BaseTest` if your emulator name or Android version is different.

## Setup

```bash
git clone https://github.com/Mandeep-Singh-Chawla/Appium-Framework.git
cd Appium-Framework
npm install -g appium
appium driver install uiautomator2
```

Start the emulator, then start Appium in another terminal:

```bash
appium
```

## Run

```bash
mvn test
```

`Youtube.xml` is the TestNG suite for `com.sample.test.YoutubeTest`. Surefire runs that class by name.
