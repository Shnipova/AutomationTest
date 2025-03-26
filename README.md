# 🧪 Custom Product Builder – Automation Test (Java + Selenium)

This repository contains an automated test script for the Custom Product Builder app, written in Java using Selenium WebDriver and TestNG.

## 🔍 What This Test Does

The test automates the flow of creating a new product using a JSON file upload within the CPB (Custom Product Builder) admin interface. It simulates the following user actions:

- Navigates to the CPB admin panel
- Switches into the product builder iframe
- Clicks “Create New” to start a new product
- Uploads a JSON product configuration file
- Validates success modal and fills in product details
- Uploads a product image
- Submits the product and returns to the product list

## ⚙️ Tools & Tech Stack

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **ChromeDriver**
- **JavaScriptExecutor**
- **Explicit Waits (WebDriverWait)**

## 📂 Test Data

JSON file and product image paths are hardcoded in the test (`/src/testData/...`). Replace them with valid local paths when running the test on your machine.

---

> 📝 This is a sample test scenario built for automation practice and demonstration purposes only. It can be extended into a full suite with validations, reusable methods, and CI/CD integration.
