pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh "/usr/local/bin/mvn clean test"
                echo "Test Success"
                sh "/usr/local/bin/mvn install"
            }
        }
    }
}