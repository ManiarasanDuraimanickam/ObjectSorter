pipeline {
    agent any

    stage 'Compile' 
	cmd 'mvn -DskipTests -Dmaven.test.skip=true -s $MAVEN_SETTINGS -Ddummy.prop=$SONAR_PROPERTIES clean compile' 
 
	stage 'Unit Test' 
	cmd 'mvn -s $MAVEN_SETTINGS verify -P all-tests' 
 
	stage 'Package' 
	cmd 'mvn -DskipTests -Dmaven.test.skip=true -s $MAVEN_SETTINGS package' 
 
	stage 'Verify' 
	cmd 'mvn -DskipTests -Dmaven.test.skip=true -s $MAVEN_SETTINGS verify' 
}
