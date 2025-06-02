[![GitHub release](https://img.shields.io/github/v/release/naver/spring-jdbc-plus.svg)](https://img.shields.io/github/v/release/naver/spring-jdbc-plus.svg?include_prereleases)
[![GitHub license](https://img.shields.io/github/license/naver/spring-jdbc-plus.svg)](https://github.com/naver/spring-jdbc-plus.js/blob/master/LICENSE)

## Goal
 Spring-jdbc-plus는 기존 Spring Data Jdbc의 기능을 확장하여 사용자가 간편하고 효과적으로 Repository 코드를 작성할 수 있도록 도와주는 오픈소스 라이브러리입니다.
 저는 sql에 바인딩 할 파라미터의 타입을 변환해주는 커스텀 컨버터를 추가해주는 작업과 길게 작성된 코드를 최신 문법을 사용하여 짧게 리팩토링 하는 작업을 하였습니다.

## Docker image 다운로드 및 설치하는 방법
* docker
```bash
# 1. Docker 이미지를 로드
docker pull kingseonwoong/final_2021040035:v1

# 2. 이미지 확인
docker images
```

## Docker container 생성하고 실행하는 방법
```bash
# 1. 컨테이너 생성 및 백그라운드 실행
docker run -dit kingseonwoong/final_2021040035:v1

# 2. 실행 중인 컨테이너 확인
docker ps	

# 3. 컨테이너에 접속 (CONTAINER_ID는 위에서 확인한 ID 사용)
docker exec -it <CONTAINER_ID> /bin/bash

# 4. 프로젝트 코드 컴파일
  ## 4-1. Converter 관련 main 클래스 컴파일
  javac -d /app/build/classes/java/main -cp "/app/libs/*" \
    spring-jdbc-plus-support/src/main/java/com/navercorp/spring/jdbc/plus/support/parametersource/converter/*.java

  ## 4-2. 기타 main 클래스 컴파일
  javac -d /app/build/classes/java/main -cp "/app/libs/*" \
    spring-jdbc-plus-support/src/main/java/com/navercorp/spring/jdbc/plus/support/parametersource/*.java

  ## 4-3. Converter 관련 테스트 클래스 컴파일
  javac -d /app/build/classes/java/test -cp "/app/libs/*" \
    spring-jdbc-plus-support/src/test/java/com/navercorp/spring/jdbc/plus/support/parametersource/converter/*.java

  ## 4-4. 기타 테스트 클래스 컴파일
  javac -d /app/build/classes/java/test -cp "/app/libs/*" \
    spring-jdbc-plus-support/src/test/java/com/navercorp/spring/jdbc/plus/support/parametersource/*.java

# 5. 컴파일 한 코드 실행 ( libs 내부에 존재하는 .jar파일들을 이용해서 컴파일 한 코드 테스트 실행. *를 통해서 .jar 파일을 가져오는 것이 인식이 되지 않아서 모두 명시적으로 적어줌) 
java -jar /app/libs/junit-console.jar \
--class-path=/app/build/classes/java/test:/app/build/classes/java/main:\
/app/libs/apiguardian-api-1.1.2.jar:\
/app/libs/assertj-core-3.6.2.jar:\
/app/libs/autoparams-0.1.1.jar:\
/app/libs/byte-buddy-1.16.1.jar:\
/app/libs/byte-buddy-agent-1.16.1.jar:\
/app/libs/commons-math3-3.6.1.jar:\
/app/libs/jsr305-3.0.2.jar:\
/app/libs/junit-jupiter-5.11.4.jar:\
/app/libs/junit-jupiter-api-5.11.4.jar:\
/app/libs/junit-jupiter-engine-5.11.4.jar:\
/app/libs/junit-jupiter-params-5.11.4.jar:\
/app/libs/junit-platform-commons-1.11.4.jar:\
/app/libs/junit-platform-engine-1.11.4.jar:\
/app/libs/junit-platform-launcher-1.11.4.jar:\
/app/libs/mockito-core-5.15.2.jar:\
/app/libs/mockito-junit-jupiter-5.15.2.jar:\
/app/libs/objenesis-3.3.jar:\
/app/libs/opentest4j-1.3.0.jar:\
/app/libs/spring-beans-6.2.2.jar:\
/app/libs/spring-core-6.2.2.jar:\
/app/libs/spring-jcl-6.2.2.jar:\
/app/libs/spring-jdbc-6.2.2.jar:\
/app/libs/spring-jdbc-plus-support-3.5.0-SNAPSHOT.jar:\
/app/libs/spring-tx-6.2.2.jar:\
/app/libs/validation-api-2.0.1.Final.jar \
--scan-class-path
```

## 디렉토리 구조
``` bash
/app
├── libs/                         # 도커 이미지 생성 시 build.gradle에 명시된 외부 라이브러리 JAR들을 모두 저장한 디렉토리 (JUnit 포함) (컨테이너에서 사용)
├── build/                        # 컴파일 한 클래스 파일 저장할 디렉토리 (컨테이너에서 사용)
└── spring-jdbc-plus-support/
    ├── build/                   # 로컬에서 Gradle 빌드시 생성되는 디렉토리를 복사한 디렉토리 (컨테이너 내에선 사용 x)	
    ├── build.gradle             # 로컬에서 사용한 Gradle 설정 파일을 복사한 디렉토리 (컨테이너 내에선 사용 x)
    └── src/				   # 소스코드 디렉토리
        ├── main/ 			   # main 코드 디렉토리 
        └── test/			   # test 코드 디렉토리
            └── java/
                └── com/
                    └── navercorp/
                        └── spring/
                            └── jdbc/
                                └── plus/
                                    └── support/
                                        └── parametersource/
                                            └── converter/
						 └── DefaultJdbcParameterSourceConverterTest.java , UuidParameterTypeConverterTest, ...	# Converter를 테스트하는 코드
```

## 실행을 마치고 종료하는 방법
``` bash
# 1. 컨테이너에서 나가기
exit

# 2. 컨테이너 중지
docker stop <CONTAINER_ID>

# 3. 컨테이너 삭제 
docker rm <CONTAINER_ID>

# 4. 이미지 삭제
docker image rm final_2021040035:v1
```


## License

```
   Copyright 2020-2021 NAVER Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
