pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh "/usr/local/bin/mvn clean test"
                echo "Test Success"
                sh "/usr/local/bin/mvn install"
                echo "Maven Build Success"
                withSonarQubeEnv('Local SonarQube Server') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=echo-app -Dsonar.host.url=http://localhost:9000'
                }

            }
        }
        stage("Quality Gate") {
            steps {
                def qg = waitForQualityGate()
                if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }
            }
        }
    }
}