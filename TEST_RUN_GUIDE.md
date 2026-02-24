# Test 실행 가이드

## 개요
현재 Gradle 설정 기준으로 테스트 태스크는 아래처럼 분리되어 있습니다.

- `./gradlew test`: Cucumber BDD 테스트만 실행
- `./gradlew step1Test`: 기존 RestAssured 인수 테스트(1단계)만 실행

## 1) Cucumber 테스트 실행
명령어:

```bash
./gradlew test
```

실행 대상:

- `gift.cucumber.CucumberTest`
- `src/test/resources/features/*.feature` 시나리오
- step definition: `src/test/java/gift/cucumber/AcceptanceStepDefinitions.java`

설정 근거:

- `build.gradle`의 `test` 태스크 필터가 `gift.cucumber.CucumberTest`로 제한되어 있음

## 2) 1단계 인수 테스트 실행
명령어:

```bash
./gradlew step1Test
```

실행 대상:

- `gift.CategoryAcceptanceTest`
- `gift.ProductAcceptanceTest`
- `gift.GiftAcceptanceTest`

설정 근거:

- `build.gradle`의 `step1Test` 태스크 `includeTestsMatching` 필터

## 3) 개별 테스트 클래스만 실행
특정 클래스만 실행할 때:

```bash
./gradlew test --tests gift.cucumber.CucumberTest
./gradlew step1Test --tests gift.GiftAcceptanceTest
```

## 주의사항
- 현재 DB는 `H2`(`runtimeOnly 'com.h2database:h2'`)로 동작합니다.
- 인수 테스트 데이터는 `cleanup.sql`, `test-data.sql`을 통해 초기화/셋업됩니다.
