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
```gradle
android {
    ...
    buildTypes {
        debug {
            minifyEnabled false
        }
        release {
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    ...
}
```
## Flavors
Represent different versions of your app that you may release to users, such as free and paid versions of your app. You can customize product flavors to use different code and resources, while sharing and reusing the parts that are common to all versions of your app. 
```gradle
android {
    ...
    productFlavors {
        spain {
        }
        france {
        }
    }
    ...
}
```
## Build variants
A cross product of a build type and product flavor.

![Build Variants Selector][build_variants]


# 3. UI
## Activity
It is basically the screen of your app:

* Implements the user interface.
* Has to be declared on the manifest.

[More info](https://developer.android.com/guide/components/activities.html)
## Fragment
It is a modular section of an activity, which has its own lifecycle, receives its own input events, and which you can add or remove while the activity is running.

![Fragment][fragment]
## View and ViewGroup
	
__View__

* View objects are the basic building blocks of User Interface(UI) elements in Android.
* Examples are: EditText, Button, CheckBox, ...
* View refers to the android.view.View class, which is the base class of all UI classes.

__ViewGroup__

* ViewGroup is the invisible container. It holds View and ViewGroup
* Examples are: LinearLayout, RelativeLayout, FrameLayout, ...
* ViewGroup is the base class for Layouts.

![ViewGroup][viewgroup]

__Linear Layout Vertical__
![Linear Layout Vertical][linearlayout_vertical]
__Linear Layout Horizontal__
![Linear Layout Horizontal][linearlayout_horizontal]
__Relative Layout__
![Relative Layout][relativelayout]


# 4. Hands On
## Helloworld
![Hello World Exercise][helloworld_exercise]

_[time aprox: 15 min]_
## Run on emulator
![Android Emulator Button][emulator]
Enable keyboard

![Android Emulator Enable Keyboard][enable_keyboard]
## Calculator with Tests
![Calculator Exercise][calculator_exercise]

[Mockito Cheat Sheet](https://github.com/romanrodriguez-sp/android-workshop/blob/master/docs/mockito-dzone-refcard.pdf)

[Espresso Cheat Sheet](https://github.com/romanrodriguez-sp/android-workshop/blob/master/docs/espresso-cheat-sheet-2.1.0.pdf)

_[time aprox: 1h]_
## Activity lifecycle
![Activity Lifecycle Flow][activity_lifecycle]

[Training](https://developer.android.com/training/basics/activity-lifecycle)
## Starting another activity 
[Training](https://developer.android.com/training/basics/firstapp/starting-activity.html)
## Supporting different languages & devices
[Training](https://developer.android.com/training/basics/supporting-devices)
## Fragments
[Training](https://developer.android.com/training/basics/fragments)
## Saving data
[Training](https://developer.android.com/training/basics/data-storage)
### Shared preferences
Private primitive data in key-value pairs, like Java Protperties file.

```java
public class MainActivity extends AppCompatActivity {

    public static final String SHARED_FILE_NAME = "my_shared_preferences_file_name";
    public static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences;

        // Activity context
        Context context = MainActivity.this;
        // Application context
        context = getApplicationContext();

        // API 16+
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
        // API 24+
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_NO_LOCALIZED_COLLATORS);
        // Deprecated. Do not use.
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_WORLD_READABLE);
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_MULTI_PROCESS);
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_WORLD_READABLE);
        // Private (only your app can access it), and append mode
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_APPEND);
        sharedPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_PRIVATE);

        // Inserts a value and ensures its storage
        sharedPreferences.edit().putString(KEY_NAME, "Roman Rodriguez").commit();

    }
}
```
__WARNING__: Activity and Application have different shared preferences becasue its context it is not the same.

[More info](https://developer.android.com/guide/topics/data/data-storage.html#pref)
### Files
[More info: Internal storage](https://developer.android.com/guide/topics/data/data-storage.html#filesInternal)

[More info: External storage](https://developer.android.com/guide/topics/data/data-storage.html#filesExternal)

__WARNING__: https://developer.android.com/training/secure-file-sharing/index.html
### Database
[More info](https://developer.android.com/training/basics/data-storage/databases.html)
## Interacting with Other Apps
[Training](https://developer.android.com/training/basics/intents/sending.html)
## Supporting different platform versions
[Training](https://developer.android.com/training/basics/supporting-devices/platforms.html)


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
[activity_lifecycle]: https://developer.android.com/images/activity_lifecycle.png "Activity Lifecycle Flow"
[enable_keyboard]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/enable_keyboard.png?raw=true "Android Emulator Enable Keyboard"
[helloworld_exercise]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/helloworld_exercise.png?raw=true "Hello World Exercise"
[calculator_exercise]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/calculator_exercise.png?raw=true "Calculator Exercise"
[fragment]: https://developer.android.com/images/training/basics/fragments-screen-mock.png "Fragment"
[viewgroup]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/viewgroup.png?raw=true "ViewGroup"
[linearlayout_vertical]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/linearlayout_vertical.png?raw=true "Linear Layout Vertical"
[linearlayout_horizontal]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/linearlayout_horizontal.png?raw=true "Linear Layout Horizontal"
[relativelayout]: https://github.com/romanrodriguez-sp/android-workshop/blob/master/screenshots/relativelayout.png?raw=true "Relative Layout"