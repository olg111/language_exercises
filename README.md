
## Here you can test my project   http://3.77.116.26:8080/

## About the project

This project is a prototype site for learning English grammar.
The functionality of the site is divided into administrator `/admin/**`
and guest `/guest/**`.

The administrator has the ability to create new topics, sentences and relevant exercises. The administrator has a username and password
to access `/admin/**`. 

You can find username and password in class **WebSecurityConfigAdapter**.

![img.png](assets/webSecurityConfigAdapter.png)

The user has access to perform and check exercises
without registration and SMS =).

## Technologies
The site was created in Java using
**Spring MVC + Hibernate MySQL + Spring Security**.
Configuration method - JavaConfig.

All program settings (configuration) are located in the package "configuration".

## How to run the project
1. Database dump is named `my_db_fp_english_exercises` and it
is placed at the root of a project.
Before starting the program, you need MySQL configured and database created.
2. According to the screenshot, change the following data
in the class HibernateConfig.java: 

![img_1.png](assets/hibernateConfig.png)

    (1) - your MySQL port;
    
    (2) - your MySQL username;
    
    (3) - your MySQL password;

3. The project can be launched in IntelliJ IDEA,
for this you need to connect **Smart Tomcat**.


![img.png](assets/Smartcat.png)

![img.png](assets/Smartcat_2.png)

![img.png](assets/Smartcat_3.png)

![img.png](assets/Smartcat_4.png)

## How to use the project

### For administrator:

After the project is launched and opened in the browser. Click on LOGIN.
![img.png](assets/browser2.png)

![img.png](assets/login_page.png)

You will be redirected to the authorization page.
Please type the required login and password specified in a class **WebSecurityConfigAdapter**.

On "Topic list" page you can add new topic (Add button),
change topic name (Update button), delete topic (Delete button),
log out of your account (LOGOUT).

![img.png](assets/topic_list.png)


---

To go to the page with exercises, you need to click on the topic
(for example Past Simple).
After clicking, a page "Exercise list" will appear. It that is identical
in structure to the page described above.

![img.png](assets/exercise_list.png)

---
To go to the page with sentences, you need to click on the exercise
(for example Exercise 1 Past Simple).
After clicking, a page "Sentence list" will appear. It that is identical
in structure to the page described above.

![img.png](assets/sentence_list.png)

---
To create a sentence, you need to use the pattern.
The word that the user will have to write
must be enclosed in special characters /{word}/.
In the second field you need to enter a hint.

![img.png](assets/create_a_sentence.png)

---

### For guest:

Click on the link "Topics" or "Theory" and go to the page with a choice of topics,
then select one of them and start doing the exercises.

![img.png](assets/guest.png)

![img.png](assets/guest_topics.png)

![img.png](assets/guest_exercise.png)

Fill in the empty field with your answer, click the "check" button.
If the entered answer is correct, then you will see the blue inscription "ok!",
otherwise the correct solution will be shown in red.

![img.png](assets/sentences.png)





