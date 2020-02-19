#!groovy

import groovy.json.JsonSlurper
import java.net.URL

pipeline {
    agent none
    options {
        timeout(time: 1, unit: 'DAYS')
    }
    stages {
        stage("Build App") {
            agent any
            steps {
                script {
                    /usr/local/bin/mvn clean install
                }
            }
        }
    }
}


//def buildApp() {
//        withDockerContainer("maven:3.5.0-jdk-8-alpine") { sh "mvn clean install"}
//        archiveArtifacts '**/target/echo.jar'
//        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'] )
//}