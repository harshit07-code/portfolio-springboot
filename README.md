# 🌐 Portfolio Website with Contact Form (Spring Boot)

## 📌 Project Overview

This is a *personal portfolio website* that showcases my skills, projects, and profile. It also includes a *Contact Me feature*, allowing visitors to send messages directly to my email by filling out a form.

The project is built using:

* Frontend: HTML, CSS
* Backend: Spring Boot
* Email Service: Java Mail Sender (Spring Boot)

---

## 🚀 Live Demo

* Deployed Project: (https://harshit-caqu.onrender.com/)

---

## 🚀 Features

* Clean and responsive portfolio UI
* Section to showcase projects and skills
* Contact form with required fields (Name, Email, Message)
* Automatic email notification when someone submits the form
* Basic validation for form inputs

---

## 🛠️ Technologies Used

* HTML5
* CSS3
* Java
* Spring Boot
* Spring Web
* JavaMailSender

---

## 📁 Project Structure

```
portfolio-project/
|
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- com/portfolio/controller/
|   |   |       |-- ContactController.java
|   |
|   |   |-- resources/
|   |       |-- templates/
|   |       |   |-- index.html
|   |       |-- application.properties
|
|-- static/
|   |-- css/
|       |-- style.css
|
|-- README.md
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```
git clone https://github.com/your-username/portfolio-project.git
cd portfolio-project
```

### 2. Configure Email in application.properties

```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

* Note:

  * Use an App Password (not your real Gmail password)
  * Make sure SMTP is enabled for your email account

### 3. Run the Application

```
mvn spring-boot:run
```

### 4. Open in Browser

```
http://localhost:8080
```

---

## 📬 How Contact Feature Works

* User fills out the contact form
* Form data is sent to Spring Boot backend
* Backend processes the request
* Email is sent to your configured email ID using JavaMailSender

---

## 🧠 Future Improvements

* Add database to store messages
* Add CAPTCHA for spam protection
* Improve UI/UX with animations
* Add dark mode

---

## 🙋‍♂️ Author

* Harshit Raghuvanshi

---

## ⭐ Support

* If you like this project, feel free to star the repository and share feedback!
