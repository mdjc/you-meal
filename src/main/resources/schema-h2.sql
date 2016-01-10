CREATE TABLE users (
	user_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(35) NOT NULL UNIQUE,
	user_email VARCHAR(60) NOT NULL,
	user_password VARCHAR(60) NOT NULL
);

create table meals (
	meal_id bigint unsigned auto_increment primary key,
	description varchar(60) NOT NULL,
	is_breakfast boolean,
	is_lunch boolean,
	is_dinner boolean
);
