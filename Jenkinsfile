pipeline {
    agent none

    stages {
        stage('Compile') {
            steps {
                echo "mvn clean compile.."
				bat "mvn clean compile"
            }
        }
        stage('Unit Test') {
            steps {
                echo 'verify -P all-tests..'
				bat "mvn verify -P all-tests" 
            }
        }
        stage('Package') {
            steps {
                echo 'Package....'
				bat "mvn  package" 
            }
        }
		stage('Verify') {
            steps {
                echo 'verify....'
				bat "mvn verify" 
            }
        }
    }
}
