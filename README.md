# qvick-design-system-AOS
대구소프트웨어마이스터고등학교 기숙사 관리 플랫폼 Qvick V3 Android Design System

## qvick-design-system 적용법
1. 빌드파일에 JitPack저장소 추가 (gradle.kts 기준)
    <aside>
        dependencyResolutionManagement {
            repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
            repositories {
                mavenCentral()
                maven { url = uri("https://jitpack.io") }
            }
        }
    </aside>
2. dependency부분에 의존성 추가
    <aside>
        dependencies {
            implementation("com.github.Team-C0nnect:qvick-design-system-AOS:Tag")
        }
    </aside>
