pipeline {
    agent any

    tools{
        maven 'Maven3'
        jdk 'Java17'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ebru-celik/devops-pipeline-project']])
                //sh 'mvn clean install' //for linux and macos
                bat 'mvn clean install'  // for windows
            }
        }

        stage('Docker Image') {
            steps {
               //sh 'docker build -t ebrucinarr/devops-pipeline-application .'
               bat 'docker build -t ebrucinarr/devops-pipeline-application .'
            }
        }

        stage('Docker Image to DockerHub') {
            steps {
                withCredentials([string(credentialsId: 'Dockerhub', variable: 'dockerhub')]) {
                    bat 'echo docker login -u ebrucinarr -p${dockerhub}'
                    bat 'docker push ebrucinarr/devops-pipeline-application:latest'
                }
            }
        }

        stage('Deploy Kubernetes') {
            steps {
                kubernetesDeploy (configs: 'deploymentservice.yml', kubeconfigId: 'Kubernetes')
            }
        }
    }
}
