# currency_convartor
This README provides an overview of a simple currency converter app that utilizes the RapidAPI service to fetch a list of
currencies and perform currency conversion. This app is written in Kotlin for Android.

# Table of Contents
Introduction
Features
Prerequisites
Getting Started
RapidAPI Setup
App Configuration
Usage
Contributing
License
# Introduction
The Currency Converter App is designed to help users quickly and easily convert currencies from one unit to another. It utilizes the
 RapidAPI service to provide real-time currency exchange rate data, allowing users to convert between various currencies.

# Features
Select source and target currencies using spinners.
Enter the quantity to convert.
Perform real-time currency conversion.
Display the converted amount.
Utilizes the RapidAPI service for currency exchange rate data.
# Prerequisites
Before you can use the Currency Converter App, you'll need the following:

Android Studio installed on your development machine.
A RapidAPI account to access currency exchange rate data.
# Getting Started
Clone this repository to your local machine.
Open the project in Android Studio.
# RapidAPI Setup
To use the RapidAPI service for currency exchange rate data, you'll need to set up an account and obtain an API key. Follow these steps:

Visit the RapidAPI website.
Sign up for an account or log in if you already have one.
Search for a currency exchange rate API and subscribe to it.
Obtain your API key.
# App Configuration
In the app source code, you'll need to configure the RapidAPI key. Locate the CurrencyViewModel class in your Android project (you already have it in your code), and set the API key using the RapidApiService:

kotlin
Copy code
RapidApiService.apiKey = "YOUR_RAPIDAPI_KEY"
Make sure to replace "YOUR_RAPIDAPI_KEY" with the actual API key you obtained from RapidAPI.

# Usage
Build and run the Currency Converter App in Android Studio.
Select the source and target currencies using the spinners.
Enter the quantity to convert in the EditText field.
Click the "Convert" button.
The converted amount will be displayed on the screen.
# Screenshots
![Screenshot (46)](https://github.com/AnshulThiraniya/currency_convartor/assets/70026554/d0519e78-4afa-4125-b433-d86b2c0b39c0)
![Screenshot (47)](https://github.com/AnshulThiraniya/currency_convartor/assets/70026554/42df07cc-bcf8-4d49-975c-f50102d54748)
![Screenshot (48)](https://github.com/AnshulThiraniya/currency_convartor/assets/70026554/5732e69d-e1ab-426b-99c0-a06eb50bfea3)
![Screenshot (48)](https://github.com/AnshulThiraniya/currency_convartor/assets/70026554/3f8c2fac-8083-4abf-a064-8f40f5d0f3e0)
