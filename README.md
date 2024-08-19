# 원티드 프리온보딩 백엔드 인턴십 선발 사전과제  
<br>
<hr>
  
## 서비스 개요  
  
- 본 서비스는 기업의 채용을 위한 웹 서비스 입니다.  
- 회사는 채용공고를 생성하고, 이에 사용자는 지원합니다.  
  
## 요구사항  

- **채용공고 등록** : 기업은 채용공고를 등록할 수 있다.  
- **채용공고 수정** : 기업은 등록한 채용공고를 수정할 수 있다.  
- **채용공고 삭제** : 기업은 등록한 채용공고를 삭제할 수 있다.  
- **채용공고 조회** : 사용자는 채용공고 목록을 확인/검색 할 수 있다.  
- **채용공고 상세** : 사용자는 채용공고 상세 페이지를 확인할 수 있다.  
- **채용공고 지원** : 사용자는 관심 있는 공고에 지원할 수 있다.   

## 개발환경  

- **Java (JDK21)**  
- **Spring Boot (3.3.2)** : 웹 어플리케이션 개발을 위한 프레임워크, 통합 환경 제공  
- **Spring Data JPA** : 데이터 접근을 간소화하는 JPA(Java Persistence API) 추상화 라이브러리  
- **MySQL (8.0.37)** : 데이터베이스 관리 시스템  
- **IntelliJ IDEA (Community Edition 2024.1.1)** : IDE 통합개발환경  
  
## 프로젝트 디렉터리 구조
```
jobpost/
└── controller/
    └── JobPostController.java
    └── JobRegisterController.java
└── dto/
    └── JobPostDTO.java 
└── entity/
    └── BaseEntity.java
    └── CompanyEntity.java
    └── JobPostEntity.java
    └── JobRegisterEntity.java
    └── JobRegisterId.java
    └── UserEntity.java
└── repository/
    └── CompanyRepository.java
    └── JobPostRepository.java
    └── JobRegisterRepository.java
    └── UserRepository.java
└── service/
    └── JobPostService.java 
    └── JobRegisterService.java
```
### controller/
> 사용자의 요청을 받아 서비스 레이어에 전달하고, 결과를 반환합니다.
- JobPostController.java : 채용 공고 등록에 관한 요청을 확인합니다. 
- JobRegisterController.java : 채용 공고 지원에 관한 요청을 확인합니다.

### dto/
> 데이터 전달 객체로, 화면에서 사용자의 요청을 서버로 전달하는 역할을 합니다.
- JobPostDTO.java : 화면에서 보이는 채용공고의 정보들을 담아 서버로 전달합니다.

### entity/
> Java ORM 에서 DataBase 테이블에 매핑되는 자바 객체를 의미합니다.
- BaseEntity.java : 날짜와 관련하여 다른 엔티티에서 공통으로 사용할 수 있도록 구성하였습니다.
- CompanyEntity.java : 기업 관련 엔티티입니다.
- JobPostEntity.java : 채용공고 관련 엔티티입니다.
- JobRegisterEntity.java : 채용공고 지원 관련 복합 PK 를 가진 엔티티입니다. 
- JobRegisterId.java : 채용공고 지원 엔티티의 복합키로 사용할 수 있도록 구성하였습니다.
- UserEntity.java : 사용자 관련 엔티티입니다.

### repository/
> 서비스에서 받은 요청을 처리하여 DB와 상호작용하여 Query를 수행합니다.
- CompanyRepository.java : 기업 관련 DB Query 입니다. 
- JobPostRepository.java : 채용 공고 관련 DB Query 입니다. 
- JobRegisterRepository.java : 채용 공고 지원 관련 DB Query 입니다.
- UserRepository.java : 사용자 관련 DB Query 입니다.

### service/
> 컨트롤러에서 받은 요청을 비즈니스 로직에 따라 처리하며, repository 와 상호작용합니다.
- JobPostService.java : 채용 공고와 관련된 비즈니스 로직들이 위치합니다.
- JobRegisterService.java : 채용 공고 지원과 관련된 비즈니스 로직들이 위치합니다.

## API Doc
<details>
    <summary>채용 공고 등록</summary>
    <blockquote>
        새로운 채용 공고를 등록합니다.<br>
        - API Endpoint URL : POST http://localhost/jobpost <br>
        - 요청 데이터 : JobPostDTO <br>    
    </blockquote>
    <pre><code>
        {
            "jp_num": null,
            "nation": "한국",
            "region": "서울",
            "position": "프론트엔드",
            "rewards": 500000,
            "technic": "ES6",
            "title": "2025 상반기 삼성 SDS 채용",
            "contents": "상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.",
            "created": "2024-08-10T00:00:00"
        }
    </code></pre>
</details>
<details>
    <summary>채용 공고 조회</summary>
    <blockquote>
        새로운 채용 공고를 조회/검색 합니다.<br>
        search 의 값에 따라 검색 됩니다.<br>
        - API Endpoint URL : GET localhost:8090/jobpost/all?search="" <br>
        - 요청 데이터 : String <br>    
    </blockquote>
    <pre><code>
        {
            "list": [
                {
                    "jp_num": 66,
                    "nation": "한국",
                    "region": "서울",
                    "position": "백엔드",
                    "rewards": 1000000,
                    "technic": "java",
                    "title": "codeit 하반기 백엔드 개발자 채용",
                    "contents": "상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.",
                    "created": "2024-08-19T16:35:10.44979",
                    "comp_nm": "코드잇"
                },
                {
                    "jp_num": 67,
                    "nation": "한국",
                    "region": "서울",
                    "position": "UI/UX",
                    "rewards": 0,
                    "technic": "Javascript(ES6)",
                    "title": "삼성SDS 2025 상반기 채용",
                    "contents": "해당 채용 공고는 하기 이미지와 당사 채용 페이지를 참고하시어 지원 부탁드립니다.",
                    "created": "2024-08-19T16:35:10.501975",
                    "comp_nm": "삼성SDS"
                }
            ]
        }
    </code></pre>
</details>
<details>
    <summary>채용 공고 상세 조회</summary>
    <blockquote>
        채용 공고 한 건을 조회합니다.<br>
        - API Endpoint URL : GET http://localhost/jobpost/detail/{id} <br>
        - 요청 데이터 : JobPostDTO <br>    
    </blockquote>
    <pre><code>
        {
            "detail": {
                "jp_num": 66,
                "nation": "한국",
                "region": "서울",
                "position": "백엔드",
                "rewards": 1000000,
                "technic": "java",
                "title": "codeit 하반기 백엔드 개발자 채용",
                "contents": "상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.",
                "created": "2024-08-19T16:35:10.44979",
                "comp_nm": "코드잇"
            },
            "list": [] # 해당 회사의 다른 공고가 있을 경우 
        }
    </code></pre>
</details>
<details>
    <summary>채용 공고 수정</summary>
    <blockquote>
        채용 공고를 수정합니다.<br>
        - API Endpoint URL : PUT http://localhost/jobpost/detail/{id}<br>
        - 요청 데이터 : JobPostDTO <br>    
    </blockquote>
    <pre><code>
        {
            "jp_num": 67,
            "nation": "한국",
            "region": "서울",
            "position": "프론트엔드",
            "rewards": 500000,
            "technic": "JavaScript",             # 변경됨
            "title": "2026 하반기 삼성 SDS 채용",  # 변경됨
            "contents": "상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.",
            "created": "2024-08-10T00:00:00"
        }
    </code></pre>
</details>
<details>
    <summary>채용 공고 삭제</summary>
    <blockquote>
        채용 공고를 삭제합니다.<br>
        - API Endpoint URL : DELETE http://localhost/jobpost/detail/{id}<br>
        - 요청 데이터 : JobPostDTO <br>    
    </blockquote>
    <pre><code>
        {
            "jp_num": 67
        }
    </code></pre>
</details>
<details>
    <summary>채용 공고 지원</summary>
    <blockquote>
        채용 공고에 지원합니다.<br>
        - API Endpoint URL : POST http://localhost/jobregister<br>
        - 요청 데이터 : JobPostDTO <br>    
    </blockquote>
    <pre><code>
        {
            "jp_num": 67
        }
    </code></pre>
</details>