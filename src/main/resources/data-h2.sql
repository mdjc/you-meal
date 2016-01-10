-- password = 'a' (encrypted)
INSERT INTO users(user_name, user_email, user_password) VALUES ('mirna', 'mdjc@gmail.com', '$2a$10$BcK5Gta9418SK5I2bLUhOeFtFXqE742ni7/xedJ8f2oZoYzWWQgfi'); 
INSERT INTO users(user_name, user_email, user_password) VALUES ('testUser', 'test123@gmail.com', '$2a$10$BcK5Gta9418SK5I2bLUhOeFtFXqE742ni7/xedJ8f2oZoYzWWQgfi');
INSERT INTO users(user_name, user_email, user_password) VALUES ('john', 'john23@gmail.com', '$2a$10$BcK5Gta9418SK5I2bLUhOeFtFXqE742ni7/xedJ8f2oZoYzWWQgfi');

insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Green Bananas with scrambled eggs', true, false, true);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Fried Chicken', false, true, false);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Tuna Salad', false, true, true);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Papa Johns Pizza', false, true, true);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Chocolate and toasts', true, false, true);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Corn flakes and milk', true, false, true);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Veggie soup', false, true, true);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('Sea-food soup', false, true, false);
insert into meals (description, is_breakfast, is_lunch, is_dinner) values ('3 Hits: salami-eggs-cheese and mangu', true, false, false);