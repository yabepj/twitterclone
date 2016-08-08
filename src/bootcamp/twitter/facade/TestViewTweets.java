package bootcamp.twitter.facade;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestViewTweets {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ViewTweets view = new ViewTweets();
		Map map = new HashMap();
		map.put("userid", "user");
		
		List list = view.execute(map);
		System.out.println(list);
	}

}
