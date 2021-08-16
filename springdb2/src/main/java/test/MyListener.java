package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//웹서버가 가동될때 감지하여, 원하는 메시지 심기
public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		//웹 어플리케이션을 서버를 중지할때 호출되는 메서드
		System.out.println("서버 가동하네요");
		
		ServletContext servltContext = sce.getServletContext();
		String value = servltContext.getInitParameter("contextConflgLocation");
		servltContext.setAttribute("obj", "야호~");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		//웹 어플리케이션을 서버를 가동할때 호출되는 메서드
		System.out.println("서버 중지하네요");
	}


}
