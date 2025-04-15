# qvick-design-system-AOS
![Image](https://github.com/user-attachments/assets/551b3e46-7091-40b4-8c1d-6617949e7106) 
[![](https://jitpack.io/v/Team-C0nnect/qvick-design-system-AOS.svg)](https://jitpack.io/#Team-C0nnect/qvick-design-system-AOS)

## qvick-design-system 적용법
1. 빌드파일에 JitPack저장소 추가 (gradle.kts 기준)   
   ```
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           mavenCentral()
           maven { url = uri("https://jitpack.io") }
       }
   }
   ```
2. dependency부분에 의존성 추가   
    ```
    dependencies {
        implementation("com.github.Team-C0nnect:qvick-design-system-AOS:Tag")
    }
   ```
   
## 앱 호환성 및 요구사항 
이 라이브러리는 Android 앱 개발에 최적화되어 있으며, 다음과 같은 호환성 및 요구사항을 갖추고 있습니다.  

**최소/타깃 SDK**
- minSdkVersion 26  
라이브러리는 Android 8.0 (API 26) 이상에서 동작하도록 설계되었습니다. 
이는 최신 Android 기능 및 보안 업데이트를 활용함과 동시에, 상당수의 기기에서 안정적으로 사용할 수 있도록 한 설정입니다.

- compileSdkVersion 35  
최신 API를 사용하여 컴파일 되므로, 앱 내 최신 Android 기능 및 최적화 기법을 활용할 수 있습니다.

**언어 및 컴파일 옵션**
- Java 1.8 호환  
   compileOptions와 kotlinOptions를 통해 Java 1.8 및 해당 JVM 타겟 버전을 지정했습니다. 
   이를 통해, 람다, 스트림 API 등 Java 8의 기능과 Kotlin의 최신 기능을 안전하게 사용할 수 있습니다.

## 디자인 컴포넌트 소개
- 텍스트 필드
   
- 버튼
   
- 체크박스
   
- 공지
   
- 링크 텍스트
   
- 컬러 시스템
   