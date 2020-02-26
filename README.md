



# 아트앤테크놀로지 어드밴티지 & 페널티 시스템

## 프로젝트에 대해서

본 프로젝트는 서강대학교 아트앤테크놀로지 학과 소속 학부생 관리를 위한 어드벤티지 & 페널티 시스템입니다.

## 주요 기능

### 일반 유저 

1. **회원가입** : 이미 등록되어 있는 학생 DB에 자신의 비밀번호를 등록하는 방식
2. **로그인** : 자신이 등록된 비밀번호와 기존의 학번으로 로그인
3. **본인의 어드벤티지/패널티 목록 및 전체 점수 조회**

### 일반 유저 

1. **일반 유저의 기능**
2. **어드벤티지 정보 등록/수정/삭제**
3. **패널티 정보 등록/수정/삭제**
4. **학생 별 패널티 정보 등록**
5. **학생 별 어드벤티지 정보 삭제 및 학생 점수 수정**
6. **학생 별 패널티 정보 삭제 및 학생 점수 수정**
7. **전체 학생 어드벤티지/패널티 정보 조회**
8. **특정 학생 어드벤티지/패널티 정보 조회**

### 관리자 (권한 등급 2)

1. **관리자 권한 등급 1의 기능**
2. **학생 정보 등록**

## API

### USERS

- users/signup (POST)(회원가입)(ALL)
- users/signin (POST)(로그인)(ALL)
- users/registration (POST)(학생 정보 등록)(ADMIN)

### ADVANTAGES

- advantages (POST)(어드벤티지 정보 등록)(ADMIN)
- advantages (PUT)(어드벤티지 정보 수정)(ADMIN)
- advantages (DELETE)(어드벤티지 정보 삭제)(ADMIN)

### PENALTIES

- penalties (POST)(패널티 정보 등록)(ADMIN)
- penalties (PUT)(패널티 정보 수정)(ADMIN)
- penalties (DELETE)(패널티 정보 삭제)(ADMIN)

### USER-ADVANTAGES

- userAdvantages?advantageId={advantageId} (GET)(학생 별 패널티 정보 등록)(ADMIN)
- userAdvantages/deletion?advantageId={advantageId} (GET)(학생 별 패널티 정보 삭제 및 학생 점수 수정)(ADMIN)
- userAdvantages (GET) (패널티 정보 조회)(ALL)

### USER-PENALTIES

- userPenalties?penaltyId={penaltyId} (GET)(학생 별 패널티 정보 등록)(ADMIN)
- userPenalties/deletion?penaltyId={penaltyId} (GET)(학생 별 패널티 정보 삭제 및 학생 점수 수정)(ADMIN)
- userPenalties (GET) (패널티 정보 조회)(ALL)

### ADMIN

- admin(GET)(전체 학생 어드벤티지/패널티 정보 조회)(ADMIN)
- admin?userId={userId}(특정 학생 어드벤티지/패널티 정보 조회)(ADMIN)

## ERD 

![image](https://user-images.githubusercontent.com/23696493/75359976-7bc71600-58f8-11ea-90d9-85837445d440.png)

## 개발 상황

- 기능(API) 개발은 80~90% 완료한 상태입니다.
- UI는 React로 구축해서 개발 진행중이며, 회원가입(일반 학생) 및 로그인 UI는 나온 상태입니다.
- 남은 개발 TO-DO
  - 우선순위
    - 어드밴티지 / 패널티 정보 등록 UI
    - 학생 별 어드밴티지 / 패널티 정보 등록 UI
    - 일반 학생용 개인별 어드밴티지 및 패널티 정보 조회 UI
    - 관리자용 전체 학생 어드밴티지 및 패널티 정보 조회 UI  
    - 관리자용 특정 학생 어드밴티지 및 패널티 정보 조회 UI
    - 서버 배포  
  - 후순위
    - 관리자용 어드밴티지 / 패널티 정보 수정 UI
    - 관리자용 어드밴티지 / 패널티 정보 삭제 UI

<div><img width="50%" src="https://user-images.githubusercontent.com/23696493/75369199-5214eb80-5906-11ea-90d8-3f1e8560bdc7.png"></img><img width="50%" src="https://user-images.githubusercontent.com/23696493/75369724-51c92000-5907-11ea-8570-f3d0d4c0fb58.png"</img></div>
