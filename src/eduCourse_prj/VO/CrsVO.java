package eduCourse_prj.VO;

public class CrsVO {
	private String courCode;//과목코드
	private String courName;//과목명
	private int creditHour;//학점
	private String courInputDate;//입력일
	private String CourDelFlag;//삭제플레그
	private int deptCode;//학과번호
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getCourCode() {
		return courCode;
	}
	public String getCourName() {
		return courName;
	}
	public int getCreditHour() {
		return creditHour;
	}
	public String getCourInputDate() {
		return courInputDate;
	}
	public String getCourDelFlag() {
		return CourDelFlag;
	}
	public int getDeptCode() {
		return deptCode;
	}
	@Override
	public String toString() {
		return "CrsVO [courCode=" + courCode + ", courName=" + courName + ", creditHour=" + creditHour
				+ ", courInputDate=" + courInputDate + ", CourDelFlag=" + CourDelFlag + ", deptCode=" + deptCode + "]";
	}
	
	
	

}
