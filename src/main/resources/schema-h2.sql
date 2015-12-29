create table meals (
	meal_id bigint unsigned auto_increment primary key,
	meal_description varchar(60) NOT NULL,
	breakfast boolean,
	lunch boolean,
	dinner boolean
);
