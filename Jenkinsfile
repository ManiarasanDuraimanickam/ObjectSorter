pipeline {
    agent any
    stage 'Compile' 
	bat 'mvn clean compile' 
 
	stage 'Unit Test' 
	bat 'mvn verify -P all-tests' 
 
	stage 'Package' 
	bat 'mvn package' 
 
	stage 'Verify' 
	bat 'mvn verify' 
}
