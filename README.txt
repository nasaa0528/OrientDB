1. Dependencies: 
	- have to add following line of codes into POM.xml file 
	<dependency>
  		<groupId>com.orientechnologies</groupId>
  		<artifactId>orientdb-jdbc</artifactId>
  		
		<version>2.2.33</version>
		// the above should be version of DB server. 
		// for example, If we are writing a code for 3.0.1 version of orientDB, we have to substitute it with <version>3.0.1</version>
	</dependency>


2. Then we have to build maven project in order to apply dependency libraries to our project. In order to build it,
	- Navigate to Run (Green play button), 
	- Click on the down arrow. 
	- Choose "Run as" and then build as Maven project. 
   If you do this step correctly, the dependencies should show in the maven dependencies folder. 

3. Now we are ready to try source code. Run the OrientDB server and Run the code. 

4. Insert, update works fine, but Select works with limited capacity. It is going to be improved soon. 

Thanks

Nasa. 
