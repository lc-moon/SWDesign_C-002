```mermaid
graph LR
    %% 액터 정의
    Customer((고객))
    Admin((관리자/시스템))

    subgraph "항공 예약 시스템"
        %% 유스케이스 정의
        UC1([고객등록])
        UC2([고객조회])
        UC3([고객인증])
        UC4([마일리지조회])
        
        UC5([항공권등록])
        UC6([항공권조회])
        UC7([항공권가격조회])
        
        UC8([예약])
        UC9([예약조회])
        UC10([구매])

        %% 포함 관계 (Include)
        UC8 -.->|include| UC3
        UC8 -.->|include| UC6
        
        UC10 -.->|include| UC3
        UC10 -.->|include| UC9
        UC10 -.->|include| UC4
    end

    %% 액터와 유스케이스 연결
    Customer --- UC1
    Customer --- UC2
    Customer --- UC3
    Customer --- UC4
    Customer --- UC6
    Customer --- UC7
    Customer --- UC8
    Customer --- UC9
    Customer --- UC10

    Admin --- UC5
    Admin --- UC2
    Admin --- UC7