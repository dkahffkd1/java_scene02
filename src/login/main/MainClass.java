package login.main;

import java.net.URL;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controller.Controller;
import login.url.URLService;

public class MainClass extends Application {

	public void start(Stage arg0) throws Exception {
			System.out.println(getClass().getResource("")); // ("")현재 경로 확인
			System.out.println(Paths.get("").toAbsolutePath().toString()); // 경로 불러오는 명령어
			System.out.println("file:/"+(Paths.get("").toAbsolutePath().toString())); // 경로 불러오는 명령어
			System.out.println("file:/"+(Paths.get("").toAbsolutePath().toString())+ "/bin/login/fxml/Login.fxml"); // 경로 불러오는 명령어
			
			URL url = new URL(URLService.fxPath + "login/fxml/Login.fxml");// 경로 불러오는 명령어 URLinterface에 경로 저장 되있음
			
			FXMLLoader loader = new FXMLLoader(url);// 경로 불러오는 명령어
			
			Parent root = loader.load(); // loader를 이용해서 controller 객체를 불러올 수 있음
			
			Controller ctrl = loader.getController(); // new와 loader는 다름 new로 객체를 설정하면 값들이 안들어옴
			//Controller ctrl 12 = new.getController(); -> X
			
			ctrl.setRoot(root);
			
			
			Scene scene = new Scene(root);
			
			arg0.setScene(scene);
			
			arg0.show();
			
			
		}
	public static void main(String[] args) {
		launch(args);
	}
}
