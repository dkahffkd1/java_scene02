package login.url;

import java.nio.file.Paths;

public interface URLService {
	public String fxPath = "file:/"+(Paths.get("").toAbsolutePath().toString())+ "/bin/"; // 현재 프로젝트의 절대경로 + bin
	
	
}
