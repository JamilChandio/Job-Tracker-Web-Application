# 🧭 Job Application Tracker

A **Spring Boot MVC web application** that helps users efficiently manage and track their job applications in one place.  
The system allows job seekers to record company details, job positions, statuses, and follow-up reminders — ensuring they stay organized and never miss an opportunity.

---

## 🚀 Features

- 👤 **User Management**
  - Register new users and handle duplicate account detection
  - Secure login/logout with session-based authentication

- 💼 **Job Applications**
  - Add, view, update, and delete job applications  
  - Track status (Pending, Interviewed, Accepted, Rejected)
  - Store company name, position, applied date, and notes

- 📊 **Dashboard Overview**
  - Summary of total, pending, interviewed, and accepted applications
  - Dynamic data visualization via Thymeleaf templates

- ⚠️ **Exception Handling**
  - Centralized global exception handling using `@ControllerAdvice`
  - Custom error pages for specific exceptions (e.g. user already exists)

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Frontend** | Thymeleaf, HTML5, CSS3, Bootstrap 5 |
| **Backend** | Spring Boot (MVC), Java 17 |
| **Database** | PostgreSQL |
| **ORM** | Spring Data JPA (Hibernate) |
| **Security** | Spring Security (Session-based authentication) |
| **Build Tool** | Maven |

---

## ⚙️ Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/job-tracker.git
cd job-tracker
