package login.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import login.service.LoginService;
import login.service.LoginServiceImpl;

public class Controller implements Initializable{ // Initializable = 초기화
	@FXML public TextField fxId;
	@FXML public TextField fxPwd;
	Parent root;
	LoginService ls;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { //Controller 오버라이드
		ls = new LoginServiceImpl();
		System.out.println("초기화 메소드");
	}
	public void loginFunc() {
		ls.loginFunc(fxId,fxPwd);
		
		System.out.println("확인 버튼 클릭");
		System.out.println("id : "+ fxId.getText());
		System.out.println("id : "+ fxPwd.getText());
		LoginDTO dto = LoginDAO.db.get(fxId.getText());
		System.out.println("dto : " + dto);
		String msg = null;
		Alert alert = new Alert(AlertType.INFORMATION);
		if(dto != null ) {
			if(dto.getPwd().equals(fxPwd.getText())) {
				msg = dto.getName()+ "인증 성공";
			}else {
				msg = " 비밀번호 틀림";
			}
		}else {
			msg = "존재하지 않는 아이디입니다.";
			}
		alert.setContentText(msg); alert.show();
		System.out.println(msg);

	}
	public void cancelFunc() {
		System.out.println("취소 버튼 클릭");
		ls.cancelFunc(root);
	
	}
	public void registerFunc() {
		System.out.println("회원가입 클릭");
		ls.registerFunc(root);
	}

}
