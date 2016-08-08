package bootcamp.twitter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

public class ViewNewsFeedServlet extends HttpServlet
{
    private String greeting="Twitter Clone!";
    public ViewNewsFeedServlet(){}
    public ViewNewsFeedServlet(String greeting)
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
        
        Map obj = new HashMap();
        obj.put("message", "database opened!");
        obj.put("class", getClass().getName());
        obj.put("session", request.getSession(true).getId());
        
        List list = new ArrayList();
        list.add(obj);
        
       
//        for (Follower follower: followerDao) {
//        	 JSONObject o = new JSONObject();
//        	 o.put("id", follower.getId());
//        	 o.put("user1", follower.getUser1());
//        	 o.put("user2", follower.getUser2());
//
//        	 
//        	 list.add(o);
//		}
        
        Gson gson = new Gson();
		String json = gson.toJson(list);  
        
        response.getWriter().print(json);
       
    }
}