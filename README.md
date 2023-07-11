# be-chess
소프티어 부트캠프 2기 체스 프로젝트



## 요구사항

----

- [X] 체스 규칙 익히기
    - [X] [체스 규칙 숙지](https://ko.wikipedia.org/wiki/체스_규칙)
    - [X] [체스 게임 체험](https://www.chess.com/ko/play/computer)
- [X] 미션 1 - 폰 생성
    - [X] Pawn 테스트
    - [X] Pawn 클래스 구현
    - [X] 리팩토링
- [X] 미션 2 - 체스판 생성
    - [X] Pawn 클래스 변경
    - [X] BoardTest 추가
    - [X] Board 객체 구현
    - [X] 패키지 분리
    - [X] 추가 테스트
    - [X] 중복 제거
- [X] 미션 3 - 체스판 초기화
    - [X] Pawn 색에 따른 출력 문자 부여
    - [X] Pawn 생성자에 representation 인자 제거
    - [X] Pawn 기본 생성자 변경
    - [X] 체스판 초기화 구현
    - [X] Board 클래스 중복 리팩토링
    - [X] 체스판 출력 구현
    - [X] 게임 시작 및 종료 구현
- [X] 미션 4 - 기물 배치
    - [X] "\n"의 반복 코드 제거
    - [X] Pawn 클래스 이름을 Piece로 rename
    - [X] 팩토리 메소드 생성
    - [X] 전체 기물의 상태를 볼 수 있는 체스판 구현 및 테스트
    - [X] 검은색 말과 흰색 말을 구분할 수 있는 메소드 추가
    - [X] 리팩토링
- [X] 미션 5 - 기물 위치 부여 및 점수계산
    - [X] 기물의 색, 기물의 종류에 따른 enum 구현
    - [X] Piece에 대한 색과 기물에 따라 분리된 팩토리 메소드에서 enum 사용
    - [X] 팩토리 메소드 리팩토링
    - [X] 보드 자료구조 개선
    - [X] 기물과 색에 해당하는 기물의 개수를 반환
    - [X] 주어진 위치의 기물을 조회
    - [X] 임의의 기물을 체스판 위에 추가
    - [X] 체스 프로그램 점수 계산하기
    - [X] 기물의 점수가 높은 순으로 정렬
- [X] 미션 6 - 기물 이동 구현
    - [X] 기물의 이동 구현
        - 체스 게임의 규칙은 무시하고 유효한 좌표에 대해서 무조건 이동 가능하도록 구현한다
        - [X] move 명령어를 추가
            - 사용자에게 직접 입력 받을 수 있게 구현한다
    - [X] Board 클래스 분리
        - [X] Board 클래스로부터 기물의 역할을 분리한다
        - [X] Board 클래스로부터 체스 게임 규칙에 대한 역할을 분리한다
        - [X] Board 클래스로부터 체스판 출력하는 역할을 분리한다
    - [ ] 각 기물의 이동 구현
        - 체스판 내 유효성을 검증한다
            - [X] 이동하려는 좌표에 같은 편 기물이 존재하는가
            - [X] 같은 좌표로 이동하는가
            - [X] 각 기물 별로 규칙에 어긋나게 이동하는가
            - [X] 유효한 좌표로 이동하는가
        - [X] No Piece
        - [X] King
        - [X] Queen
        - [X] Rook
        - [X] Bishop
        - [X] Pawn
        - [ ] Knight
- [ ] 미션 7 - 예외 처리
    - [ ] 예외 클래스 추가
    - [ ] 사용자 입력 처리
    - [ ] 기물이 유효하지 않은 위치로 이동할 때에 예외 처리
    - [ ] 다른 편의 기물을 이동하려고 할 때에 예외 처리
- [ ] 미션 8 - 웹으로 구현