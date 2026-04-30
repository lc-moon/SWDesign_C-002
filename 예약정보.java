package air;

public class 예약정보 {
	private String 예약id;
	private String 주민번호;
	private String 비행기편;
	private String 좌석;
	private int 예약날짜;
	private boolean 구매여부;
	private double 구매비용;
	
	private 고객 _user;
	private 항공권 _ticket;
	
	public 예약정보() {
		_user = new 고객();
		_ticket = new 항공권();
	}
	
	public boolean 에약조회(String 예약id) {
		return true;
	}
	
	public double 구매(String 예약id, String 주민번호, String 암호, String 비행기편, String 좌석) {
		if(_user.고객인증(주민번호, 암호)) {
			if(this.에약조회(예약id)) {
				this.구매여부 = true;
				this.구매비용 = _ticket.항공권가격조회(비행기편, 좌석);
				double mile = _user.마일리지조회(주민번호, 암호);
				if(mile>0) this.구매비용 = this.구매비용-mile;
				return this.구매비용;
			}else {
				return -2;
			}
		}else {
			return -1;
		}
	}
}
