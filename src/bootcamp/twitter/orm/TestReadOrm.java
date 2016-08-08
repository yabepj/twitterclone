package bootcamp.twitter.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class TestReadOrm {

	ConnectionSource  connectionSource;
	Dao<User, Integer> userDao; 
	Dao<Follower, Integer> followerDao; 
	Dao<Tweet, Integer> tweetDao; 
	
	@Before
	public void setUp() throws Exception {
		connectionSource =
				  new JdbcConnectionSource("jdbc:sqlite:test.db");
	
		
		userDao = 
				  DaoManager.createDao(connectionSource, User.class);
		followerDao = 
				  DaoManager.createDao(connectionSource, Follower.class);
		tweetDao = 
				  DaoManager.createDao(connectionSource, Tweet.class);
	}

	@After
	public void tearDown() throws Exception {
		connectionSource.close();
	}
	
	@Test
	public void testUser() throws SQLException {
		for (User user : userDao) {
		    System.out.println(user.getUsername());
		}
	}

	@Test
	public void testTweet() throws SQLException {
		for (Tweet tweet: tweetDao) {
		    System.out.println(tweet.getMessage());
		}
	}

	
	@Test
	public void testFollower() throws SQLException {
		for (Follower follow : followerDao) {
		    System.out.println(follow);
		}
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);  
		return json;
	}
	
	

}
