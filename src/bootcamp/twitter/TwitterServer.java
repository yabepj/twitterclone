package bootcamp.twitter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TwitterServer extends AbstractHandler {
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>" + getClass().getName() + "</h1>");
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(8090);
		server.setHandler(new TwitterServer());

		// 1.Creating the resource handler
		ResourceHandler resourceHandler = new ResourceHandler();
		
		// 2.Setting Resource Base
		resourceHandler.setResourceBase("resources");

		// 3.Enabling Directory Listing
		resourceHandler.setDirectoriesListed(true);

		// 4.Setting Context Source
		ContextHandler contextHandler = new ContextHandler("/bootcamp");

		// 5.Attaching Handlers
		contextHandler.setHandler(resourceHandler);
		
		server.setHandler(contextHandler);
		
		
		
//		 ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//	     context.setContextPath("/servlet");
//	     server.setHandler(context);
//	 
//	     context.addServlet(new ServletHolder(new TwitterServlet()),"/*");
		
		
		

		server.start();
		server.join();
	}
}