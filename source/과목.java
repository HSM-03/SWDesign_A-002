package haksa;

public class 과목 {
	private String 과목Id;
	private String 학번;
	private String 교수Id;
	private String 과목명;
	private int 과목점수;
	private String 학점;
	
	private 학생 _stu;
	private 교수 _pro;
	
	public 과목() {
		_stu = new 학생();
		_pro = new 교수();
	}
	
	public boolean 과목조회(String 과목Id) {
		return true;
	}
	
	public String 과목점수입력(String 교수Id, String 암호, String 과목Id, int 과목점수, String 학번) {
		if (_pro.교수인증(교수Id, 암호)) {
			if(_stu.학생조회(학번)) {
				if(this.과목조회(과목Id)) {
					if(과목점수 > 90) this.학점 = "A";  
					else if (과목점수 > 80) this.학점 = "B";
					else if (과목점수 > 70) this.학점 = "C";
					else this.학점 = "0";
					return this.학점;
				} else {
					return "과목 조회 실패..";
				}
			} else {
				return "학생 조회 실패..";
			}
		} else {
			return "교수 인증 실패..";
		}
	}
}
