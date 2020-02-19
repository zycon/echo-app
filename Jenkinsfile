pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh "/usr/local/bin/mvn clean install"
            }
        }
    }
}