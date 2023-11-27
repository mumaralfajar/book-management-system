pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'Java17'
        docker 'Docker'
    }
    environment {
        DOCKER_IMAGE = 'mumarual/book-management-system'
        DOCKER_CONTAINER = 'book-management-system'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mumaralfajar/book-management-system'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean verify sonar:sonar'
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                    echo 'Docker Build Completed'
                }
            }
        }
        stage('Docker Push') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhub-password')]) {
                        sh ''' docker login -u mumarual -p "%dockerhub-password%" '''
                    }
                    docker.image("${DOCKER_IMAGE}").push()
                    echo 'Docker Push Completed'
                }
            }
        }
        stage ('Docker Run') {
            steps {
                script {
                    docker.run("--name ${DOCKER_CONTAINER} -d -p 8099:8080 ${DOCKER_IMAGE}")
                    echo 'Docker Run Completed'
                }
            }
        }
    }
}