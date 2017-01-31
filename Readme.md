#Network Technology Applied on Medical Services

##Abstract
With the repaid development of the Internet, various network services have been provided into every aspect of our life. For example, it is a commonplace to book everything from hotels and flights to restaurant reservations all online. The latest studies have shown a growing demand amongst patients for the ability to book their healthcare appointments online, which is also essential for a hospital to manage and keep track of its day-to-day functionalities efficiently. A well-designed online booking system is highly favored by doctors, dentists and their staff as it saves them substantial time for scheduling appointments and allows them to allocate resources to other, more pertinent areas.

In this project, a highly adaptable and user-friendly medical appointment system is proposed to meet this growing demand. When a patient makes an appointment request, the system is able to evaluate the patient’s needs for that appointment and automatically check the availability of the doctors, any assisting staff, and equipment. The system utilizes a multi-thread architecture to ensure that multiple patients are able to communicate with the server simultaneously, and come up with various timeslots for all the patient’s appointments, thus providing them with multiple options to choose from. Besides, if the patient chooses a timeslot that has be booked already, the
system is also able to detect it and return failure information. What’s more, every time a patient makes an appointment, a confirmation reminder will be automatically sending to him/her via email. Besides, different levels of privileges are assigned to patients and doctors by granting them different authorities to access the information of the hospital’s database. Also the information of patients is stored in database through encryption, which can protect the patients’ privacy effectively and efficiently. We believe that our medical appointment system cannot only facilitate the patient’s access to making an appointment, it also frees up the staff, who would otherwise spend tedious amounts of time checking the availability of these resources manually.

Key words: Computer Network; Medical Application; Multiple communication; Access Control; Crash Detection; Automatic Reminder; Confidentiality

##Specific Aims
1. A remote medical appointment scheduling system. Through this convenient system, patients could make appointments with doctors at home;
2. Automatic sign up function. The patient first time use the system could register their information and the system could store them in the database.
3. An intelligent login system would be built;
4. Applying multithread technology to approve several users to access this system at the same time;
5. Applying intelligent crash detection to prevent different patients from selecting the same timeslot.
6. Achieve access control. Normal users could only visit permitted information from server, while administrator could manage all of the data;
7. A SQLite database would be built;
8. Achieve patients’ privacy by encrypting their information in database;
9. After registration success, a notification email would be sent to patient’s email automatically.

##Design process of the system
When the patient would like to see a doctor, he first signs up and then logins
online using its own user ID and password; The server then verifies the received user information by checking the corresponding information saved in the database. If this user information is authorized to be valid, then the server will send an acknowledgement to the patient and asks which department and doctor the patient wants to visit; The patient chooses the department and the doctor, and sends this information to the server; The server retrieves the time schedule of the chosen doctor, which is saved in the database, then sends the available timeslots to the patient; The patient chooses one or several timeslots and sends the information to the server; The server sends the chosen timeslots to the chosen doctor. If the doctor agrees with the time and doesn’t want to cancel the appointment, the system then informs the patient his appointment is complete (we might use email or other methods to inform patients, where the detail is still in discussion now). Or else, go back to step 3.
 ![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/flowchart.png)

##Architecture of System
Based on the design, we try to set up the following architecture. In our system, there are one server and two different kinds of clients. We also have set up databases to both of them. Moreover, they are assigned different level authority to the databases. In order to protect the privacy of the patients, each patient client is assigned with restricted, corresponding read/write privileges by the system. In contrast with the patient client, the doctor client is assigned with full read/write privileges by the system. It can access and modify any data from the database without any block.
 ![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/architecture.png)

## Design
# Sign up and login
An illustration of the proposed appointment system is shown in Figure 3.2. It is
consisted of multiple patient clients, a doctor client, a server and a related database. As described in Section 2.1, the appointment system utilizes the classical client-server model to realize its functionalities. In the proposed system, we use a multi-thread technology so that multiple patients are able to communicate with the server simultaneously. First time the patient use this system, he can choose sign up to the system. Then he can use the ID and Password to login the system to make an appointment.
# Access control
The clients include the patients and the doctors, where they are granted with
different level of privileges to access the database. The server works as the central controller of the appointment system, which verifies the identity of each patient or doctor client, assigns different level of privileges to the clients and manages the data information in the database. The database, which is directly connected to the server, stores all the patients’ and doctors’ information, appointment schedules and many other related messages. When receiving the messages from different clients, the server authorizes their access rights corresponding to their assigned read/write privileges, respectively.
# Privacy protection
Also some information of patients, especially the password is encrypted in the database in order to protect the privacy of patients and enhance security of our system. In our project, we use MD5 to make a digest of the password. Each patient client uses its own personal information (e.g., user ID and password) to login and connect to the server. Every time the client input the password, the server is able to make a hash function to it and then compared with digest in the database to verify each user’s identity and exchange messages with it.
# Crash detection
In an appointment system, time is always a critical factor. We cannot allow two patients to book a same time slot. Therefore, our system has an import function to detection the crash of appointment. For example, if patient A has already made an appointment with doctor C on Monday AM, then when patient B choose the same time of doctor C’s schedule, the server would return the failure message and suggest to select another time slot.
# Automatic email notification
After the patients successfully make an appointment, the server would automatically send an email to remind the patient. This email will include the detail information of the appointment, such as the time and doctor.

##Implementation Details or Test Bed
# On Patient Side
Our project is programming using java. When the patient first uses this system, he would be able to sign up in the system so that the database could store their information and return to the doctors when they make an appointment in the next steps.
 ![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/Signup.png)
After the patient sign up into the system, he could use the ID and password login
to the system, the server would check the database if there exists such a client. For the authorized users, it will return the login successful message. Otherwise, the warning message would be sent.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/login.png)
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/Warning1.png)

After the patient get into the system, he could make an appointment by choosing the time, AM/PM and doctor as he want.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/appointment.png)
When he selects the time and doctor, he could click the button to register to the
server. At the same time the server check if the time and the doctor is available. If is, the server would return the success message as below.

![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/register.png)
If not, the patient would get the warning information as below.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/Warning2.png)
Finally, the patient could get an email sent by the system to notify him the success of register and remind him the appointment detail.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/email.png)

#On Doctor Side
The doctor could also login to the system as patient. Besides that, he could see his schedule as below. He has the authority to cancel or reappoint the schedule.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/DoctorUI.png)
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/delete.png)

#On Database Side
For patient, the database only stores the register information in it. To protect the privacy of patient, their passwords are encrypted in the database.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/encrypt.png)
For doctors, the database stores the schedule of them. Every time a patient make an appointment, the database would update so that doctor could know it in time.
![image](https://github.com/qshi/Network-Technology-Applied-on-Medical-Services/tree/master/image/schedule.png)

##Test case 
1.	Sign up:  clicking sign up button, in the window that appears, enter the password and ID, click on the "submit" button. A new account will be saved into the database.
2.	Log in with wrong password:  enter the ID and wrong password, there will be new window alerting: PLEASE ENTER THE RIGHT USERNAME AND PASSWORD!
3.	Log in with right password： enter the ID and right password， there will be a reminder “login successful”, with pop-up window for making appointment
4.	Choose proper time and the doctor you want to meet. If the time you reserve is idle, you will receive a reminder “register successful ”. And a registration successful email will be send to your email address. If the time you choose is not idle, you will receive a reminder “Your time might crash with others”.




 