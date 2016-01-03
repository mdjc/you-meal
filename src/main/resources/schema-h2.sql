create table meals (
	meal_id bigint unsigned auto_increment primary key,
	description varchar(60) NOT NULL,
	is_breakfast boolean,
	is_lunch boolean,
	is_dinner boolean
);
