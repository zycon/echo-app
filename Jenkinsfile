pipeline {
    agent none
    stages {
        stage('build') {
            agent any
            steps {
                withSonarQubeEnv('sonar-local') {
                    sh 'mvn clean package sonar:sonar -Dsonar.projectKey=echo-app -Dsonar.host.url=http://localhost:9000'
                }

            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}