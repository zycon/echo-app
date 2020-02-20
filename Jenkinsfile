#!groovy

pipeline {
    def dockerImage

    def dockerImageName = "hello-world-java"
    def dockerImageTag = "${dockerImageName}:${env.BUILD_NUMBER}"
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
                        sh "curl GET -H 'Accept: application/json' http://localhost:9000/api/qualitygates/project_status?projectKey=echo-app > status.json"
                        def statusJson = readJSON file: 'status.json'
                        def status = statusJson.projectStatus.status
                        echo status
                        if (status != "OK") throw new hudson.AbortException('Quality Check Failed, Please check report')
                    }
                }
            }
        }
    }
    stage('Build Docker Image') {
        // build docker image
        sh "whoami"
        sh "ls -all /var/run/docker.sock"
        sh "mv ./target/echo.jar ./data"

        dockerImage = docker.build("hello-world-java")
    }
}