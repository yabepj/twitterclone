--create user table
create table Users(id smallint primary key, username varchar(25), avatar varchar(15), follows varchar(25));
create table Tweets(id smallint primary key, user_id smallint, message varchar(140), hit_time timestamp, foreign key(user_id) references Users(id));
create table Followers(id smallint primary key, user_id1 smallint, user_id2 smallint, foreign key(user_id1) references Users(id), foreign key(user_id2) references Users(id));
