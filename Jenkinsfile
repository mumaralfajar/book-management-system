pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mumaralfajar/book-management-system']])
                echo 'Git Checkout Completed'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package'
                    sh ''' mvn clean verify sonar:sonar -Dsonar.projectKey=book-management -Dsonar.projectName='book-management' -Dsonar.host.url=http://localhost:9000 '''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t mumarual/book-management-system .'
                    echo 'Build Docker Image Completed'
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhub-password')]) {
                        sh ''' docker login -u mumarual -p "%dockerhub-password%" '''
                    }
                    sh 'docker push mumarual/book-management-system'
                }
            }
        }

        stage ('Docker Run') {
            steps {
                script {
                    sh 'docker run -d --name book-management-system -p 8099:8080 mumarual/book-management-system'
                    echo 'Docker Run Completed'
                }
            }
        }

    }
    post {
        always {
            sh 'docker logout'
        }
    }
}