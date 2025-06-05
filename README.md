# qvick-design-system-AOS
[![](https://jitpack.io/v/Team-C0nnect/qvick-design-system-AOS.svg)](https://jitpack.io/#Team-C0nnect/qvick-design-system-AOS)  
![Image](https://github.com/user-attachments/assets/551b3e46-7091-40b4-8c1d-6617949e7106)
Docs Language | [korea](https://github.com/Team-C0nnect/qvick-design-system-Android/blob/main/README_KR.md) | [english](https://github.com/Team-C0nnect/qvick-design-system-Android/blob/main/README.md)  
## Summary
Qvick's Design System is based on [Material3 Official Document](https://material.io/), which is maintained by Google's developers and designers.  
Developed as Jetpack Compose, it provides various components such as buttons and announcements.

## Apply qvick-design-system (gradle.kts)
1. Add JitPack Storage to Build File
   ```
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           mavenCentral()
           maven { url = uri("https://jitpack.io") }
       }
   }
   ```
2. Add dependency to the dependency part   
    ```
    dependencies {
        implementation("com.github.Team-C0nnect:qvick-design-system-AOS:Tag")
    }
   ```
   
## App Compatibility and Requirements
This library is optimized for Android app development and has the following compatibility and requirements.  

**min/target SDK**
- minSdkVersion 26  
  The library is designed to run on Android 8.0 (API 26) or later.
  This is a setup that utilizes the latest Android features and security updates, while also making it reliable for a significant number of devices.

- compileSdkVersion 35  
  It is compiled using the latest API, so you can take advantage of the latest Android features and optimization techniques in the app.

**Language and Compilation Options**
- Java 1.8 Compatible  
  You specified Java 1.8 and its JVM target versions through compileOptions and kotlinOptions.
  This ensures safe use of Java 8 features such as lambda, stream API, and the latest features from Kotlin.

## Introducing Design & Components
- Text field
  ![Image](https://github.com/user-attachments/assets/96352bf2-9ccf-4dd0-a579-4425fe0bd8b0)
- Button
  ![Image](https://github.com/user-attachments/assets/d9b47ecb-f857-416c-99fd-1cbd5e948a6b)
- Check Box
  ![Image](https://github.com/user-attachments/assets/619a8276-cfc7-4775-bbf8-7a12dd786ec4)
- Notice
  ![Image](https://github.com/user-attachments/assets/4e08ede4-f6db-41d3-a227-d9861acff8d2)
- Link Text
  ![Image](https://github.com/user-attachments/assets/92852823-15f8-4a6c-89cb-23094afda1ae)
- Information Bar
  ![Image](https://github.com/user-attachments/assets/04874639-b594-4f88-8bae-76be745ae618)
- Attendance Check Bar
  ![Image](https://github.com/user-attachments/assets/fa578a50-3acc-4210-8b69-bbc1fce17626)
- Icons 
  ![Image](https://github.com/user-attachments/assets/14607a6b-1b4e-4696-88fb-22a47a4bce9d)
- Color - palette, semantics
  ![Image](https://github.com/user-attachments/assets/8f032c0d-0645-43cc-9424-dee2d0bc50ee)

## Contributor
- [hyeong-eon](https://github.com/hyeong-eon)
- [hom237](https://github.com/hom237)
## Qvick App Download
<a href="https://play.google.com/store/apps/details?id=com.hs.dgsw.v3.qvick&hl=ko"><img alt="Get it on Google Play" src="docs/screenshot/img_google_play.webp" height="48px"/></a>
<br />
<a href="https://apps.apple.com/kr/app/큐빅-기숙사-관리-플랫폼/id6478103080"><img alt="Get it on App Store (iOS)" src="docs/screenshot/img_app_store_ios.webp" height="48px"/></a>