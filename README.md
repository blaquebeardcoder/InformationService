# CodingBasicsProject5

Project 5 - Information Service

Phew!  We’ve learned a lot of concepts in our Coding Basics course.  We have covered basic Java language features, Object-Oriented-Programming (OOP) and class design, handling strings of characters, discussed basic data structures, learned how deal with errors in our code, found out how the Internet and Web work, and learned how to use basic Git commands to manage our software.

Our final project reminds us that most of the code in our programs are written by others.  As software developers, we use these libraries as building blocks to construct our applications.  The Java Development Kit (JDK) itself provides hundreds of classes and thousands of methods  to use.  There are classes for formatting numbers, managing dates, file input/output, network connections, database tools, cryptography for secure communication, advanced user interfaces, working with the web, etc.  And with many developers contributing to open-source-software (OSS), there are even many more thousands of libraries out there for you to use.

Our final project involves building a tool that makes use of some of this external functionality and retrieves information for our users.

Learning Goals
Learn how to use simple Web Application Programming Interfaces (APIs)
Design classes to minimize code changes
Choose useful data structures
Successfully handle user errors
Use Git to collaborate when we make code changes

Overall Problem
You are working for a company that provides research information on entertainment topics such as songs, TV programs and other related subjects.  The company needs to provide users with a tool that easily searches for this information using a simple user interface.  Your job is to provide an information service application that uses existing services on the web to obtain this information for your users.

There are several useful free services available on the web that provide this information that we will use in our Java application.  There are literally thousands of other public services on the web, but many charge a fee.  There are also many more private web services for companies, their partners and extended supply chain.  Most of the web is about all these services and not really browsers.

Duration 2-4 days

How to Use Web APIs
As we learned in our libraries and packages lesson, the vast majority of the web is accessed programmatically (ie, via an application programming interface or API), not just via a browser.  And most APIs use a web-friendly mechanism (it’s called “REST”, but its name is not important at this point).

Let’s see how we can use these services.  In a browser, enter the following URL:  	http://api.zippopotam.us/us/10011


Notice the result.  This zippopotam.us service gives us all sorts of information about the zip code 10011 (even latitude and longitude!).  It also lets us know zip code 10011 is “New York”.  Now let’s change the URL to search for another zip code,eg, 92024.

Using your browser, enter the following URL:  http://api.zippopotam.us/us/92024


This new URL makes a request to the service but with a different zip code in the URL (ie, 92024).  And the service returns to us and tells us it’s the Encinitas, CA zip code.

So by altering the URL string to a service, we are changing the request to the service.  Pretty cool, isn’t it?  And since we are using a web style of API (ie, a URL), the service can be accessed by any type of program that can handle strings, not just a browser.  In this lab, we will use a very similar approach to access other services on the web.  But instead of using a browser, we will use Java.

There are thousands of services on the web that provide all sorts of services.  Some of them cost money and most of them require specific authentication to access them.  Luckily there are some simple ones out there that we can use.




Tasks
If you’d like, use the same teammate(s) from the previous Project or team up with another student if you’d like.   Teams should not have more than 2 members if you use Qooper.  If you use another collaboration/chat tool like Slack or Discord, you can have larger teams.  But keep the team size to 4 or less so everyone gets involved on the project.  It’s always good to have another person to work on a project!

Go to Github and download the zip file from the repo CodingBasicsProject5.  This zip just contains two small Java files (it is not a git repo).  Create a new Git repo with these files.  If you have any trouble, ask your tutor or instructor for assistance.

The zip file contain two Java files:  ServiceCommunicator.java and MyApp.java
Load them into IntelliJ.  Notice each file has a main() routine.  As you recall, when you start a Java class, the main() method in that class is where execution begins.  Let’s ignore MyApp.java for the time being.



Build ServiceCommunicator.java using IntelliJ.   Run ServiceCommunicator and test it.  Notice the test uses the zipcode service that we described earlier.  Make sure you get results from the web (and make sure you’re connected to the Internet!).  If not, contact your tutor or instructor for assistance.

When the constructor to ServiceCommunicator is called in the main() method, notice we are using a URL string.   Design and create a new class called Zipcode that has a constructor that accepts only the target zipcode, ie, not a URL.  Notice all the work to connect to a service is already in the class ServiceCommunicator (in its constructor and get() method).  Use object-oriented thinking and avoid duplicating any code from ServiceCommunicator as you create your Zipcode.java class.  Create a main() in your Zipcode class that tests your constructor similar to the main() in ServiceCommunicator.

Now let’s add a class that retrieves information about TV shows.  Here’s the URL to retrieve music information from that service:

http://api.tvmaze.com/singlesearch/shows?q=SEARCH

SEARCH is the TV show name or episode you want to use.  Create a Television class similar to Zipcode that passes the tv show name to the constructor.  Create a main() in your Television class that tests your constructor similar to the main() in ServiceCommunicator.  If your SEARCH term has spaces, use hyphens instead of spaces.


Now let’s add a very similar class that retrieves information about music.  Here’s the URL to retrieve music information from iTunes:

https://itunes.apple.com/search?term=SEARCH&limit=1

SEARCH is the song title or artist name that you want to use.  Create a Music class similar to Zipcode that passes the song title or artist name to the constructor.  Create a main() in your Music class that tests your constructor similar to the main() in ServiceCommunicator.   If your SEARCH term has spaces, use hyphens instead of spaces.

Now commit and push your working code to your repo.  Confirm your repo exists by visiting Github.com with a browser and inspecting your repos.  Awesome!  At this point, you have constructed tools to access information services on the web without a browser!

Build a simple app that tests your subclasses.  Be creative!


Challenge Problem

Use Qooper or another chat app (e.g., Discord) to find another partner team or another programmer that you can swap repositories (“repos”).

Using Intellij, create a brand new Project from Version Control.  Select Github.  Use the name of the other Github repository from the other team (the other team will create their new Project using your repo) and clone it.  Once the project is created and you see the source code files, make sure all the classes in your new Project build and run.

Now let’s add a simple user interface that uses the classes from the other team.  In your project you should have MyApp.java.  Let’s first build this class just to make sure it runs.

Modify MyApp.java to call the appropriate TV, Music and Zipcode functionality based on what the user wanted.  For example:


Command> music bob-marley-and-the-wailers	# use hyphens instead of spaces
… info on bob-marley-and-the-wailers from the Music service...

Command> tv star-trek
… info on star-trek from the Television service...

Don’t forget to add error checking to let your users know when they entered an incorrect command.  You may even want to have a ‘help’ command that tells your users what commands are available.

Command> info
Info is not a valid command.

Command> quit
Thank you for using Search Tool!





You could use a strategy like this:

public class Service {
public static void main(String[] args) {
String request;

	while (true) {
	  request = getRequest();		// System.in

	  if ( validateRequest(request) )
	 	doRequest(request);
	  else
	 	displayError(request);
     }
}

public String getRequest( ) {...}
public boolean validateRequest( ) {...}
public void doRequest( ) {...}
public void displayError( ) {...}
}



Extra Challenge Problem

Add a new service that calls the Wikipedia service.  Here’s the URL to retrieve music information from Wikipedia:

https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=SEARCH&format=json

SEARCH is the Wikipedia term that you want to use.  Create a Wiki class similar to Zipcode that passes your search term to the constructor.  Create a main() in your Wiki class that tests your constructor similar to the main() in ServiceCommunicator.  If your SEARCH term has spaces, use hyphens instead of spaces.

Add a new command “wiki” to MyApp.java that calls your new Wiki class with a search term.

...
Command> wiki sundar-pichai
… info on sundar-pichai from the Wikipedia service…


Submit a Git pull request to submit your new Wiki class contribution to the new repo.  Hopefully the other team likes your changes and accepts them!   Just to be clear, the other team is going to run their application (that’s in their repo) but with your Wiki class.  And to reciprocate, you can run the other team’s Wiki class in your application (that’s in your repo).


Really, Really Challenging Problem

Notice the verbose output, while readable, is formatted in an odd way.  This type of data format is called JSON, which is a standard format of exchanging data between two systems.  JSON stands for “JavaScript Object Notation”, because it was originally invented for JavaScript, but it really can be used by any computer language.  JSON-formatted data is great for exchanging data among machines, but it's usually not the best way to show data to your users.

See if you can find a JSON library for Java (and some documentation on that library would help too!) on the web.  Download the library and incorporate it into your information service app.  Now change the output so it's much more readable for your users.

It’s always good to have happy users!

 
 

