pipeline {
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
