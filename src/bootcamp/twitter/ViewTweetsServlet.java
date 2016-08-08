package bootcamp.twitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bootcamp.twitter.facade.ViewTweets;

public class ViewTweetsServlet extends HttpServlet
{
    
	private static final long serialVersionUID = 1L;
    public ViewTweetsServlet(){}
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String query = request.getQueryString();
    	
    	response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
      
        ViewTweets view = new ViewTweets();
        Map map = new HashMap();
        map.put("user", request.getParameter("user"));
        
        String message = request.getParameter("message");
        if( message != null )
             {
        	 map.put("message", message);
        	 view.add(map);
        	 }        
        List<Object> result =  view.execute(map);       
        
        Gson gson = new Gson();
		String json = gson.toJson(result);  
        
        response.getWriter().print(json);
    }
}