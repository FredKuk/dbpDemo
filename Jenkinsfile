pipeline {
    agent any

    environment {
        imagename = "souress2/dbp_demo01:dbp"
        registryCredential = 'DockerHub'
        dockerImage = ''
    }
    
    options {
        gitLabConnection('gitlabDemo01')
        gitlabBuilds(builds: ['jenkins'])
    }
    
    stages {
        stage('01. Git Clone'){
            steps{
                script{
                    echo 'Clonning Repository'
                }
            }
            post {
                success { 
                    echo 'Successfully Cloned Repository'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        stage('02. Gradle build') {
            steps {
                script {
                    sh 'chmod 755 ./gradlew'
                    sh './gradlew clean build --stacktrace -x test'
                }
            }
            post {
                success { 
                    echo 'Successfully Gradle Build'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        // stage('03. JUnit test '){
        //     steps{
        //         script{
        //             try {
        //                 sh './gradlew test'
        //             } catch (e) {
        //                 sh 'echo Gradle Test Fail!!!!'
        //                 slackSend (channel: '#jenkins', color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        //             }
        //         }
        //     }
        // }

        // stage('04. Testing result'){
        //     steps{
        //         junit allowEmptyResults: true, testResults: '**/test-results/test/*.xml'
        //     }
        // }

        stage('03. Deployment - Clean') {
            steps {
                echo 'Docker PS and Image clean'
                sh (
                    script: "docker rm -f \$(docker ps -q -a --filter name=dbpBook)",
                    returnStatus: true
                )
                // sh (
                //     script: "docker ps -q --filter name=dbpBook | grep -q . && docker rm -f \$(docker ps -aq --filter name=dbpBook)",
                //     returnStatus: true
                // )
                sh (
                    script: "docker rmi \$(docker images -q --filter=reference='souress2/*')",
                    returnStatus: true
                )
             }
            post {
                success { 
                    echo 'Successfully Clean Docker Environment'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        stage('04. Deployment - Bulid Docker') {
            steps {
                echo 'Bulid Docker'
                script {
                    dockerImage = docker.build imagename
                }
            }
            post {
                success { 
                    echo 'Successfully Build Docker'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        stage('05. Deployment - Run') {
            steps {
                sh "docker run -d --name dbpBook -p 8081:8080 souress2/dbp_demo01:dbp"
            }
            post {
                success { 
                    echo 'Successfully Run Docker'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        stage('06. Finish - Image to DockerHub') {
            steps {
                echo 'Push Docker'
                script {
                    docker.withRegistry( '', registryCredential) {
                        dockerImage.push() 
                    }
                }
                echo 'docker rmi -f $(docker images --filter=reference="souress2/*" -q)'
            }
            post {
                success { 
                    echo 'Successfully Pull Docker Image'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

    }

    post {
        failure {
            updateGitlabCommitStatus name: 'jenkins', state: 'failed'
            slackSend (channel: '#jenkins', color: '#FF0000', message: "FAIL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }
        unstable {
            updateGitlabCommitStatus name: 'jenkins', state: 'failed'
            slackSend (channel: '#jenkins', color: '#FF0000', message: "UNSTABLE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }
        aborted {
            updateGitlabCommitStatus name: 'jenkins', state: 'canceled'
            slackSend (channel: '#jenkins', color: '#FF0000', message: "ABORTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }
        success {
            updateGitlabCommitStatus name: 'jenkins', state: 'success'
            slackSend (channel: '#jenkins', color: '#00FF00', message: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }
    }
}