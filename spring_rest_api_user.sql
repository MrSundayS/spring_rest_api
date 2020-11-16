# CI - capitalize insensitive
# CTRL + ENTER -> RUN ONLY LINE WHERE CURSOR IS
# CTRL + SHIFT + ENTER -> RUN WHOLE SCRIPT OR SELECTED LINES

create database spring_rest_api_db;   	#	database is created
use spring_rest_api_db;					#	spring_rest_api_db is actually active

# CREATE new user with limited privileges
create user 'spring_rest_api_user'@'localhost' identified by 'qwe123';
# specify priviliges to user
grant CREATE, DROP, ALTER, SELECT, UPDATE, INSERT, DELETE, REFERENCES
on spring_rest_api_db.* to 'spring_rest_api_user'@'localhost';