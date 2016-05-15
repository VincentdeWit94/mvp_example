# MVP Example Application
Our implementation of Android MVP together with Retrofit and RxJava
This is still in development, but can be used as an example to start with. 

## What is the idea?
Android MVP is a way to structure your application, to make it more simple, to increase the realiabillity, and most important of all;
to seperate background tasks from the activities/fragments/ 

The basic idea behind this custom implementation is to seperate the application in 3 parts. First the model part, which we write down in plain Java.
This is usefull since we now can test that part, without the need to run any Android environment or simulation and make testing much more easy.

The other part is the view part, which basically are our views and together with the presenter this fetches the data and show them in the views.

## What is the structure?
First of all we split up the application in 2 parts, the 'Android' part and the 'Java' part let's say.
Our Android part consist the views, presenters, network clients and so on...

Our 'Java' part consist of data managers, stores, entities etc. 
