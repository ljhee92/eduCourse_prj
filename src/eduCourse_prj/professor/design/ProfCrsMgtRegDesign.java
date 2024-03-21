package eduCourse_prj.professor.design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProfCrsMgtRegDesign extends JDialog {
	
	private JLabel jlBack;// 배경
	private JLabel topLogin; // 우상단 로그인상태 확인창
	private JLabel jlprofCrsMgt, jlprofCrsMgtReg; // 상단 라벨
	private JLabel jlCrsName, jlCrsCode, jlDeptName, jlDeptCode, jlProfName,
					jlLectRoom, jlCredit, jlCapa, jlNecessary;
	private JComboBox<String> jcbCrsName, jcbLectRoom;
	private JTextField jtfCrsCode, jtfDeptName, jtfDeptCode, jtfProfName, 
						jtfCredit, jtfCapa;
	private JButton jbtnReg, jbtnCancel;
	
	public ProfCrsMgtRegDesign(ProfCrsMgtDesign pcmd, String title) {
		super(pcmd, title, true);
		
		setLayout(null);
		
		String commonPath = "src/eduCourse_prj/image/common/";
		String profPath = "src/eduCourse_prj/image/prof/";
		String crsPath = "src/eduCourse_prj/image/crs/";
		
		// 우상단 로그인상태 확인창 추가
		topLogin = new JLabel(pcmd.getPhd().getlVO().getName() + " 교수님 로그인 중");
		Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		topLogin.setFont(font);
		topLogin.setForeground(Color.WHITE);
		topLogin.setBounds(670, 30, 200, 20);
		add(topLogin);
		
		// 강의 과목 관리, 등록 상단 라벨 추가
		jlprofCrsMgt = new JLabel(new ImageIcon(profPath + "ProfCrsMgt_Label.png"));
		jlprofCrsMgtReg = new JLabel(new ImageIcon(commonPath + "RegBanner_new.png"));
		
		jlprofCrsMgt.setBounds(10, 76, 967, 44);
		jlprofCrsMgtReg.setBounds(10, 118, 967, 45);
		
		add(jlprofCrsMgt);
		add(jlprofCrsMgtReg);
		
		// 과목, 과목 코드, 학과, 학과 코드, 담당 교수, 강의실, 학점, 정원, 필수입력사항 라벨 추가
		jlCrsName = new JLabel("과목");
		jlCrsCode = new JLabel("과목 코드");
		jlDeptName = new JLabel("학과");
		jlDeptCode = new JLabel("학과 코드");
		jlProfName = new JLabel("담당 교수");
		jlLectRoom = new JLabel("강의실");
		jlCredit = new JLabel("학점");
		jlCapa = new JLabel("정원");
		jlNecessary = new JLabel("학점은 필수입력사항입니다.");
		
		jlCrsName.setBounds(120, 220, 100, 20);
		jlCrsCode.setBounds(120, 280, 100, 20);
		jlDeptName.setBounds(120, 340, 100, 20);
		jlDeptCode.setBounds(120, 400, 100, 20);
		jlProfName.setBounds(520, 220, 100, 20);
		jlLectRoom.setBounds(520, 280, 100, 20);
		jlCredit.setBounds(520, 340, 100, 20);
		jlCapa.setBounds(520, 400, 100, 20);
		jlNecessary.setBounds(670, 450, 300, 20);
		
		jlCrsName.setFont(font);
		jlCrsCode.setFont(font);
		jlDeptName.setFont(font);
		jlDeptCode.setFont(font);
		jlProfName.setFont(font);
		jlLectRoom.setFont(font);
		jlCredit.setFont(font);
		jlCapa.setFont(font);
		jlNecessary.setFont(font);
		jlNecessary.setForeground(Color.RED);
		
		add(jlCrsName);
		add(jlCrsCode);
		add(jlDeptName);
		add(jlDeptCode);
		add(jlProfName);
		add(jlLectRoom);
		add(jlCredit);
		add(jlCapa);
		add(jlNecessary);
		
		// 과목, 과목 코드, 학과, 학과 코드, 담당 교수, 강의실, 학점, 정원 콤보박스, JTF 추가
		String[] lectRooms = {"A0527", "A0528", "A0529"};
		
		jcbCrsName = new JComboBox<String>();
		jtfCrsCode = new JTextField();
		jtfDeptName = new JTextField();
		jtfDeptCode = new JTextField();
		jtfProfName = new JTextField(pcmd.getPhd().getlVO().getName());
		jcbLectRoom = new JComboBox<String>(lectRooms);
		jtfCredit = new JTextField();
		jtfCapa = new JTextField();
		
		jcbCrsName.setBounds(220, 215, 220, 30);
		jtfCrsCode.setBounds(220, 275, 220, 30);
		jtfDeptName.setBounds(220, 335, 220, 30);
		jtfDeptCode.setBounds(220, 395, 220, 30);
		jtfProfName.setBounds(620, 215, 220, 30);
		jcbLectRoom.setBounds(620, 275, 220, 30);
		jtfCredit.setBounds(620, 335, 220, 30);
		jtfCapa.setBounds(620, 395, 220, 30);
		
		jtfCrsCode.setEditable(false);
		jtfDeptName.setEditable(false);
		jtfDeptCode.setEditable(false);
		jtfProfName.setEditable(false);
		
		add(jcbCrsName);
		add(jtfCrsCode);
		add(jtfDeptName);
		add(jtfDeptCode);
		add(jtfProfName);
		add(jcbLectRoom);
		add(jtfCredit);
		add(jtfCapa);
		
		// 등록, 취소 버튼 추가
		jbtnReg = new JButton(new ImageIcon(commonPath + "RegButton_new.png"));
		jbtnCancel = new JButton(new ImageIcon(commonPath + "CancelButton_new.png"));
		
		jbtnReg.setBounds(370, 510, 90, 50);
		jbtnCancel.setBounds(520, 510, 90, 50);
		
		add(jbtnReg);
		add(jbtnCancel);
		
		// 배경 추가
        jlBack = new JLabel(new ImageIcon(commonPath + "Back.png"));
        jlBack.setBounds(0,0,984,620);
        add(jlBack);
		setSize(1000,650);
		setLocationRelativeTo(null);
		setVisible(true);
	} // ProfCrsMgtRegDesign
	
} // class