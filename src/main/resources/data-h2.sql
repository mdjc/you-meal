-- password = 'a' (encrypted)
INSERT INTO users(user_name, user_email, user_password) VALUES ('mirna', 'mdjc@gmail.com', '$2a$10$BcK5Gta9418SK5I2bLUhOeFtFXqE742ni7/xedJ8f2oZoYzWWQgfi'); 
INSERT INTO users(user_name, user_email, user_password) VALUES ('testUser', 'test123@gmail.com', '$2a$10$BcK5Gta9418SK5I2bLUhOeFtFXqE742ni7/xedJ8f2oZoYzWWQgfi');
INSERT INTO users(user_name, user_email, user_password) VALUES ('john', 'john23@gmail.com', '$2a$10$BcK5Gta9418SK5I2bLUhOeFtFXqE742ni7/xedJ8f2oZoYzWWQgfi');

insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'),'Green Bananas with scrambled eggs', true, false, true);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner)
	values ((select user_id from users where user_name='mirna'), 'Fried Chicken', false, true, false);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), 'Tuna Salad', false, true, true);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), 'Papa Johns Pizza', false, true, true);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), 'Chocolate and toasts', true, false, true);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), 'Corn flakes and milk', true, false, true);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), 'Veggie soup', false, true, true);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), 'Sea-food soup', false, true, false);
insert into meals (user_id, description, is_breakfast, is_lunch, is_dinner) 
	values ((select user_id from users where user_name='mirna'), '3 Hits: salami-eggs-cheese and mangu', true, false, false);