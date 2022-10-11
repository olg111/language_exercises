CREATE TABLE my_db_fp.exercises (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE my_db_fp.sentences (
  id int NOT NULL AUTO_INCREMENT,
  sentence varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE my_db_fp.exercises_sentences (
  id int NOT NULL AUTO_INCREMENT,
  exercise_id int NOT NULL,
  sentence_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (exercise_id) REFERENCES my_db_fp.exercises(id),
  FOREIGN KEY (sentence_id) REFERENCES my_db_fp.sentences(id)
);

CREATE TABLE my_db_fp.answers (
  id int NOT NULL AUTO_INCREMENT,
  answer varchar(255),
  placeholder varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE my_db_fp.sentences_answers (
  id int NOT NULL AUTO_INCREMENT,
  sentence_id int NOT NULL,
  answer_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (sentence_id) REFERENCES my_db_fp.sentences(id),
  FOREIGN KEY (answer_id) REFERENCES my_db_fp.answers(id)
);

CREATE TABLE my_db_fp.topics (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE my_db_fp.topics_exercises (
  id int NOT NULL AUTO_INCREMENT,
  topics_id int NOT NULL,
  exercises_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (topics_id) REFERENCES my_db_fp.topics(id),
  FOREIGN KEY (exercises_id) REFERENCES my_db_fp.exercises(id)
);

CREATE TABLE my_db_fp.users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255),
  login varchar(255),
  password varchar(255),
  PRIMARY KEY (id)
);


