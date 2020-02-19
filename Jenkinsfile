pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh "/usr/local/bin/mvn clean test"
                echo "Test Success"
                sh "/usr/local/bin/mvn install"
                echo "Maven Build Success"
                sh 'mvn sonar:sonar -Dsonar.projectKey=echo-app -Dsonar.host.url=http://localhost:9000'
                def qg = waitForQualityGate("Waiting for the SonarQube Response")
                if (qg.status != 'OK') {
                    error "Quality Gate Failed , Please Check the sonarQube: ${qg.status}"
                }
            }
        }
    }
}