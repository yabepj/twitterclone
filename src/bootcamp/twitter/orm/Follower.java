package bootcamp.twitter.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//create table Followers(id int primary key, user_id1 int, user_id2 int, foreign key(user_id1) references Users(id), foreign key(user_id2) references Users(id));

@DatabaseTable(tableName = "Followers")
public class Follower {

	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField
	int user1;
	@DatabaseField
	int user2;
	
	
	public Follower() {
		// TODO Auto-generated constructor stub
	}


	public Follower(int user1, int user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser1() {
		return user1;
	}


	public void setUser1(int user1) {
		this.user1 = user1;
	}


	public int getUser2() {
		return user2;
	}


	public void setUser2(int user2) {
		this.user2 = user2;
	}

}
