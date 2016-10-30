INSERT INTO users (ID, firstName, lastName, password, pictureLink) VALUES (1,'Tony', 'Stark', 'password', 'http://b1.filmpro.ru/c/138600.660xp.jpg')
INSERT INTO users (ID, firstName, lastName, password, pictureLink) VALUES (2,'Natalia', 'Romanoff', 'password', 'http://vignette1.wikia.nocookie.net/marvelcinematicuniverse/images/e/e2/Widow_avengers.jpg/revision/latest?cb=20140317040028')
INSERT INTO users (ID, firstName, lastName, password, pictureLink) VALUES (3,'Bruce', 'Wane', 'password', null)

INSERT INTO users_friends (user_id, follower_id) VALUES (1, 2)
INSERT INTO users_friends (user_id, follower_id) VALUES (2, 1)