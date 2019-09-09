# CCE Holistic Calendar
CCE Holistic Calender is based upon CompactCalendarView which is a simple calendar view that provides scrolling between months. It's based on Java's Date and Calendar classes. We've adapted this calenderview to our needs and added the events of Christ College of Engineering to it. There is also a notification tab which shows the latest updates in realtime.The app is still under active development.


# Database

We use the database from google firebase toolkit to store data on the cloud. Unlike SQL databases, firebase database uses a simple json tree-like structure that can be used much easier and has better integration. If you don't know what json is, just think it as of a text document with key:value pairs. The database we use is "Firebase Realtime Database" and NOT "Firebase Firestore". Please do not confuse the two as both of them are found in firebase website side by side.

# Compiling

The master branch can be directly downloaded and compiled without much setting up. However, you will need a "google-services.json" which links the app with external google services such as firebase database and firbase cloud messaging (for notification push). 

This particular file is not uploaded in this repository as it contains sensitive data. If you try to compile the app without it, Android Studio will throw a file not found error. 

You'll have to create a firebase account (http://firebase.google.com) which is really easy, follow the instructions to add an app, and download the google-services.json for that particular account and copy it to the "sample" directory. The app should then compile succesfully.


# Contributing  
We welcome all kinds of contributions from our peers in Christ College of Engineering which this app has been developed for. If there's something that can be improved upon that you're capable of, please feel free to raise a pull request and we'll merge those changes after proper testing.

If you're aiming to do more than just layout changes, you'll need to have the database structure that we're using. The database.json in this repository will have what you're looking for. It can be imported into your own firebase database in a few clicks to create an identical database as of the official app. Changes you make in that database will reflect immediately on your version of the app.




```
The MIT License (MIT)

Copyright (c) [2018] [Sundeepk]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
