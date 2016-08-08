package bootcamp.twitter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import bootcamp.twitter.orm.Follower;
import bootcamp.twitter.orm.Tweet;
import bootcamp.twitter.orm.User;

public class ViewFollowersServlet extends HttpServlet
{
    private String greeting="Twitter Clone!";
    public ViewFollowersServlet(){}
    public ViewFollowersServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        
        ConnectionSource  connectionSource;
    	Dao<User, Integer> userDao; 
    	Dao<Follower, Integer> followerDao = null; 
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