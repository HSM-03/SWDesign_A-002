```mermaid
graph LR
    subgraph "학사관리 시스템"
        UC1(학생 등록)
        UC2(학생 조회)
        UC3(학생 인증)
        UC4(교수 등록)
        UC5(교수 조회)
        UC6(교수 인증)
        
        UC7(과목 등록)
        UC8(과목 조회)
        UC9(과목 점수 입력)
        UC10(수강 신청)
        UC11(학점 조회)

        %% 포함 관계 (인증 필수 조건)
        UC7 -.->|include| UC6
        UC9 -.->|include| UC6
        UC10 -.->|include| UC3
        UC11 -.->|include| UC3
    end

    ST((학생))
    PR((교수))

    %% 학생 연관 관계
    ST --- UC1
    ST --- UC2
    ST --- UC3
    ST --- UC8
    ST --- UC10
    ST --- UC11

    %% 교수 연관 관계
    PR --- UC4
    PR --- UC5
    PR --- UC6
    PR --- UC7
    PR --- UC8
    PR --- UC9

    %% 제약 조건 메모
    note1[학생: 3~5과목 수강 신청 가능]
    note2[과목: 정원 30~35명]
    note3[교수: 1~3과목 등록 가능]
    
    UC10 -.-> note1
    UC10 -.-> note2
    UC7 -.-> note3