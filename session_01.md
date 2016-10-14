# 1. Installation

## 1.1 Java JDK

The use of the new Java 8 features requires the new Jack tool set:
* Instant Run currently is not compatible with the Jack compiler.
* Various tools that read .class files (such as JaCoCo, Mockito, and some lint checks) are currently not compatible with the Jack compiler.

__WARNING__: To prevent issues __it is recommended to use Java 7 features__ only.

[Download link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## 1.2. Android Studio
[Download link](https://developer.android.com/studio/index.html)

_[time aprox: 23 min]_

## 1.3. Android
* __SDK__: Android API. Use the last, Android 7.0 Nougat API level 24.
* __SDK Tools__: Improves the SDK features.
![SDK Installed Options][sdk_installed]
* __Build Tools__: Improves build features of Android Studio.
* __Repository__: Google own repository.
* __Emulator image__: Android device simulator. For Intel based PC use intel based image, it improves emulation.
![Android Emulator Button][emulator]
* __USB Driver__: To connect phisical devices, for Windows only.

You should always __keep them updated__ by downloading the latest versions using the Android SDK Manager.

![Android SDK Manager Button][sdk_manager]


# 2. Project Structure
## Gradle files
The Android build system compiles app resources and source code, and packages them into APKs that you can test, deploy, sign, and distribute. 

Any change has to be synchronized.

![Sync Gradle Button][sync_gradle]

## Manifest
Provides essential information about your app to the Android system:
* Names the Java package for the application
* Describes the components of the application: activities, services, broadcast receivers, content providers, ...
* Declares the permissions that the application must have in order to access protected parts of the API
* Declares the permissions that others are required to have in order to interact with the application's components
* Declares the minimum level of the Android API

[More info](https://developer.android.com/guide/topics/manifest/manifest-intro.html)

## Sources
The Java source code.

## Resources
Support specific device configurations such as different languages or screen sizes:
* [Types](https://developer.android.com/guide/topics/resources/available-resources.html)
* [Values](https://developer.android.com/guide/topics/resources/providing-resources.html)

## Build types
Define certain properties that Gradle uses when building and packaging your app, and are typically configured for different stages of your development lifecycle. For example, the debug build type enables debug options and signs the APK with the debug key, while the release build type may shrink, obfuscate, and sign your APK with a release key for distribution.

## Flavors
Represent different versions of your app that you may release to users, such as free and paid versions of your app. You can customize product flavors to use different code and resources, while sharing and reusing the parts that are common to all versions of your app. 

## Build variants
A cross product of a build type and product flavor.

![Build Variants Selector][build_variants]


# 3. Hands On 


# References
Android Studio
https://developer.android.com/studio

Android Developers
https://developer.android.com


[sdk_manager]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/sdk_manager.png?raw=true "Android SDK Manager Button"
[emulator]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/emulator.png?raw=true "Android Emulator Button"
[sync_gradle]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/sync_gradle.png?raw=true "Sync Gradle Button"
[sdk_installed]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/sdk_intalled.png?raw=true "SDK Installed Options"
[build_variants]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/build_variants.png?raw=true "SDK Installed Options"