package eduCourse_prj.student.design;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import eduCourse_prj.VO.ProfVO;
import eduCourse_prj.admin.event.AdminProfMgtEvent;
import eduCourse_prj.professor.dao.ProfDAO;
import eduCourse_prj.student.event.StdntCrsRegEvent;


@SuppressWarnings("serial")
public class StdntCrsRegDesign extends JDialog {
	
	private StdntHomeDesign shd;
    private JLabel jlBack; //배경
    private JLabel topLogin; // 우상단 로그인상태 확인창
    private JLabel jlCrsReg, jlCrsCart, jlAllCreditTxt, jlAllCreditHour;
    private JButton jbtnAdd, jbtnCancel, jbtnReg;
    private JTable jtbCrsReg, jtbCrsCart;
    private DefaultTableModel dtmCrsReg, dtmCrsCart;
   
	public StdntCrsRegDesign(StdntHomeDesign shd, String title) {
		super(shd, title, true);
		this.shd = shd;
		
		setLayout(null);
		
		String commonPath = "src/eduCourse_prj/image/common/";
		String stdntPath = "src/eduCourse_prj/image/stud/";
		
		// 우상단 로그인상태 확인창 추가
		topLogin = new JLabel(shd.getlVO().getName() + " 관리자님 로그인 중");
		Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		topLogin.setFont(font);
		topLogin.setForeground(Color.RED);
		topLogin.setBounds(670, 30, 200, 20);
		add(topLogin);
		
		// 수강신청, 수강바구니 상단 라벨 추가
		jlCrsReg = new JLabel(new ImageIcon(stdntPath + "CrsReg_Label.png"));
		jlCrsCart = new JLabel(new ImageIcon(stdntPath + "CrsCart_Label.png"));
		
		jlCrsReg.setBounds(10, 76, 967, 34);
		jlCrsCart.setBounds(10, 350, 967, 34);
		
		add(jlCrsReg);
		add(jlCrsCart);
		
		// 총학점 하단 라벨 추가
		jlAllCreditTxt = new JLabel("총 학점 : ");
		jlAllCreditHour = new JLabel("6");	// 합계 구현 필요함
		
		jlAllCreditTxt.setFont(font);
		jlAllCreditHour.setFont(font);
		jlAllCreditTxt.setForeground(Color.RED);
		jlAllCreditHour.setForeground(Color.RED);
		
		jlAllCreditTxt.setBounds(660, 555, 80, 30);
		jlAllCreditHour.setBounds(750, 555, 40, 30);
		
		add(jlAllCreditTxt);
		add(jlAllCreditHour);
		
		// 담기, 취소, 최종신청 버튼 추가
		jbtnAdd = new JButton(new ImageIcon(stdntPath + "AddCart.png"));
		jbtnCancel = new JButton(new ImageIcon(stdntPath + "Cancel.png"));
		jbtnReg = new JButton(new ImageIcon(stdntPath + "Reg.png"));
		
		jbtnAdd.setBounds(400, 300, 78, 40);
		jbtnCancel.setBounds(520, 300, 78, 40);
		jbtnReg.setBounds(800, 545, 140, 40);
		
		add(jbtnAdd);
		add(jbtnCancel);
		add(jbtnReg);
		
		// 테이블 추가
		String[] crsRegColumn = {"학과", "과목", "과목코드", "강의실", "정원", "학점"};
		String[] crsCartColumn = {"학과", "과목", "과목코드", "강의실", "정원", "학점"};
		
		dtmCrsReg = new DefaultTableModel(crsRegColumn, 0) {
			public boolean isCellEditable(int row, int column){
			    return false; // 테이블 셀 수정 불가하도록 설정
			} // isCellEditable
		};
		
		dtmCrsCart = new DefaultTableModel(crsCartColumn, 0) {
			public boolean isCellEditable(int row, int column){
			    return false; // 테이블 셀 수정 불가하도록 설정
			} // isCellEditable
		};
		
		jtbCrsReg = new JTable(dtmCrsReg);
		jtbCrsCart = new JTable(dtmCrsCart);
		
		JScrollPane jspReg = new JScrollPane(jtbCrsReg);
		JScrollPane jspCart = new JScrollPane(jtbCrsCart);
		
		// 테이블 컬럼 가운데 정렬
		setTbHorizontal();
		
		jspReg.setBounds(10, 110, 967, 182);
		jspCart.setBounds(10, 383, 967, 155);
		add(jspReg);
		add(jspCart);
		
		// 이벤트 클래스 연결
		StdntCrsRegEvent scre = new StdntCrsRegEvent(this);
		addWindowListener(scre);
		jbtnAdd.addActionListener(scre);
		jbtnCancel.addActionListener(scre);
		jbtnReg.addActionListener(scre);
		
		// 배경 추가
        jlBack = new JLabel(new ImageIcon(commonPath + "Back.png"));
        jlBack.setBounds(0,0,984,620);
        add(jlBack);
		setSize(1000,650);
		setLocationRelativeTo(null);
		setVisible(true);
	} // AdminProfMgtDesign

	public StdntHomeDesign getShd() {
		return shd;
	}
	
	/**
	 * 테이블의 컬럼을 가운데 정렬
	 */
	public void setTbHorizontal() {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm1 = jtbCrsReg.getColumnModel();
		for(int i = 0; i < tcm1.getColumnCount(); i++) {
			tcm1.getColumn(i).setCellRenderer(dtcr);
		} // end for
		
		TableColumnModel tcm2 = jtbCrsCart.getColumnModel();
		for(int i = 0; i < tcm2.getColumnCount(); i++) {
			tcm2.getColumn(i).setCellRenderer(dtcr);
		} // end for
	} // setTbHorizontal

	public JButton getJbtnAdd() {
		return jbtnAdd;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}

	public JButton getJbtnReg() {
		return jbtnReg;
	}
	
} // class