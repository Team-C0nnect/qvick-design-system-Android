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

## 디자인 & 컴포넌트 소개
- 텍스트 필드
  ![Image](https://github.com/user-attachments/assets/96352bf2-9ccf-4dd0-a579-4425fe0bd8b0)
- 버튼
  ![Image](https://github.com/user-attachments/assets/d9b47ecb-f857-416c-99fd-1cbd5e948a6b)
- 체크박스
  ![Image](https://github.com/user-attachments/assets/619a8276-cfc7-4775-bbf8-7a12dd786ec4)
- 공지
  ![Image](https://github.com/user-attachments/assets/4e08ede4-f6db-41d3-a227-d9861acff8d2)
- 링크 텍스트
  ![Image](https://github.com/user-attachments/assets/92852823-15f8-4a6c-89cb-23094afda1ae)
- 정보 바
  ![Image](https://github.com/user-attachments/assets/04874639-b594-4f88-8bae-76be745ae618)
- 출석체크
  ![Image](https://github.com/user-attachments/assets/fa578a50-3acc-4210-8b69-bbc1fce17626)
- 아이콘  
  ![Image](https://github.com/user-attachments/assets/14607a6b-1b4e-4696-88fb-22a47a4bce9d)
- 컬러 - 팔레트, 시멘틱
  ![Image](https://github.com/user-attachments/assets/d96b4487-330a-4608-b63a-de1063ae1760)