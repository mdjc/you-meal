create table users (
	user_id bigint unsigned auto_increment primary key,
	user_name varchar(35) not null unique,
	user_email varchar(60) not null,
	user_password varchar(60) not null
);

create table meals (
	meal_id bigint unsigned auto_increment primary key,
	user_id bigint unsigned references users(user_id),
	description varchar(200) NOT NULL,
	is_breakfast boolean,
	is_lunch boolean,
	is_dinner boolean
);
