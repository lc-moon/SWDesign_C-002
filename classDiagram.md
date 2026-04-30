```mermaid
classDiagram
    class Customer {
        - ssn: String (주민번호)
        - password: String (암호)
        - name: String (성명)
        - mileage: int (마일리지)
        + registerCustomer()
        + lookupCustomer()
        + authenticate() bool
        + getMileage() int
    }

    class Ticket {
        - flightNumber: String (비행기편)
        - seat: String (좌석)
        - departureTime: String (출발시간)
        - arrivalTime: String (도착시간)
        - price: int (항공권가격)
        + registerTicket()
        + lookupTicket()
        + getPrice() int
    }

    class Reservation {
        - reservationId: String (예약id)
        - ssn: String (주민번호)
        - flightNumber: String (비행기편)
        - seat: String (좌석)
        - reservationDate: String (예약날짜)
        - isPurchased: boolean (구매여부)
        - purchaseCost: int (구매비용)
        
        %% 예약 생성: ID = ssn + flightNumber + seat
        + createReservation(ssn, flightNumber, seat, date)
        + lookupReservation(reservationId) Reservation
        
        %% 구매 로직: 마일리지 확인 및 가격 계산
        + purchase(reservationId): int
    }

    class ReservationSystem {
        <<Service>>
        + reserveProcess()
        + purchaseProcess()
    }

    Customer "1" -- "*" Reservation : "예약/조회/구매 수행"
    Ticket "1" -- "*" Reservation : "예약 대상"
    ReservationSystem ..> Customer : "고객인증/마일리지조회"
    ReservationSystem ..> Ticket : "항공권/가격조회"
    ReservationSystem ..> Reservation : "예약관리"

    note for Reservation "예약 ID 생성: ssn + 비행기편 + 좌석\n한 번에 최대 5개까지 예약 가능"
    note for Reservation "구매 비용 계산:\n마일리지 > 0 이면 (가격 - 마일리지)\n결과값 반환 및 isPurchased = true"