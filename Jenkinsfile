#!groovy

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                withSonarQubeEnv('sonar-local') {
                    sh 'mvn clean package sonar:sonar -Dsonar.projectKey=echo-app -Dsonar.host.url=http://localhost:9000'
                }

            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    script {
                        sleep(time:30,unit:"SECONDS")
                        sh "curl GET -H 'Accept: application/json' http://localhost:9000/api/qualitygates/project_status?projectKey=echo-app > status.json"
                        def statusJson = readJSON file: 'status.json'
                        def status = statusJson.projectStatus.status
                        echo status
                        if (status != "OK") throw new hudson.AbortException('Quality Check Failed, Please check report')
                    }
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImageTag = "tibinlukose/echo-app:${env.BUILD_NUMBER}"
                    dockerImage = docker.build("$dockerImageTag", "./")
                    dockerImage.push();
                }
            }
        }
    }

}