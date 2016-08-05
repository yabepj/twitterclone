package bootcamp.twitter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import bootcamp.twitter.orm.Follower;
import bootcamp.twitter.orm.Tweet;
import bootcamp.twitter.orm.User;

public class ViewTweetsServlet extends HttpServlet
{
    private String greeting="Twitter Clone!";
    public ViewTweetsServlet(){}
    public ViewTweetsServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
      
        ConnectionSource  connectionSource;
    	Dao<User, Integer> userDao; 
    	Dao<Follower, Integer> followerDao; 
    	Dao<Tweet, Integer> tweetDao = null;
        
        try {
			connectionSource =
					  new JdbcConnectionSource("jdbc:sqlite:test.db");
			
			userDao = 
					  DaoManager.createDao(connectionSource, User.class);
			followerDao = 
					  DaoManager.createDao(connectionSource, Follower.class);
			tweetDao = 
					  DaoManager.createDao(connectionSource, Tweet.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	
        JSONObject obj = new JSONObject();
        obj.put("message", "database opened!");
        obj.put("class", getClass().getName());
        obj.put("session", request.getSession(true).getId());
        
        
        JSONArray list = new JSONArray();
        list.add(obj);
        
        for (Tweet tweet: tweetDao) {
        	 JSONObject o = new JSONObject();
        	 o.put("id", tweet.getId());
        	 o.put("time", tweet.getHitTime());
        	 o.put("message", tweet.getMessage());
        	 o.put("user", tweet.getUserId());

        	 
        	 list.add(o);
		}
        
        
        
        
        response.getWriter().print(list.toJSONString());
    }
}