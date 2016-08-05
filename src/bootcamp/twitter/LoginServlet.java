package bootcamp.twitter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
    private String greeting="Twitter Clone!";
    public LoginServlet(){}
    public LoginServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        
    	Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        response.getWriter().print("[");
        response.getWriter().println("{ 'message0': 'Data Base Opened!' }");
    	response.getWriter().println(",{ 'class': '"+getClass().getName()+"' }");
        response.getWriter().println(",{ 'session': '" + request.getSession(true).getId() + "'}");
        response.getWriter().print("]");
    }
}