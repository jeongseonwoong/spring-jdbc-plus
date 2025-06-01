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

# 4. 프로젝트 디렉토리로 이동
cd spring-jdbc-plus-support/src/test/java/com/navercorp/spring/jdbc/plus/support/parametersource/converter

# 5. 테스트 코드 실행
javac -cp "/app/libs/*" DefaultJdbcParameterSourceConverterTest.java


```

## 디렉토리 구조
``` bash
/app
├── libs/                                  # 필요한 외부 라이브러리 JAR 파일들
└── spring-jdbc-plus-support/		
    ├── build.gradle			   # 복사된 build.gradle 
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
						 └── DefaultJdbcParameterSourceConverterTest.java
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
