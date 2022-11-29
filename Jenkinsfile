pipeline {
    agent any

    environment {
        imagename = "souress2/dbp_demo01"
        registryCredential = 'DockerHub'
        dockerImage = ''
    }
    
    options {
        gitLabConnection('gitlabDemo01')
        gitlabBuilds(builds: ['jenkins'])
    }
    
    stages {
        stage('01. Git Prepare'){
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
                    try {
                        sh 'chmod 755 ./gradlew'
                        sh './gradlew clean build -x test'
                    } catch (e) {
                        sh 'echo Gradle Build Fail!!!'
                    }
                }
            }
        }

        stage('03. JUnit test '){
            steps{
                script{
                    try {
                        // sh 'echo ./build/test-results/test/*.xml'
                        sh './gradlew test'
                    } catch (e) {
                        sh 'echo Gradle Test Fail!!!!'
                        slackSend (channel: '#jenkins', color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                    }
                }
            }
        }

        stage('04. Testing result'){
            steps{
                junit allowEmptyResults: true, testResults: '**/test-results/test/*.xml'
                // junit './build/test-results/test/*.xml'
            }
        }

        stage('05. Bulid Docker') {
            when {
                branch 'origin/main'
            }
            steps {
                echo 'Bulid Docker'
                script {
                    dockerImage = docker.build imagename
                }
            }
            post {
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        stage('06. Push Docker') {
            when {
                branch 'origin/main'
            }
            steps {
                echo 'Push Docker'
                script {
                    docker.withRegistry( '', registryCredential) {
                        dockerImage.push() 
                    }
                }
            }
            post {
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }
            
        stage('07. Deployment - Docker Run') {
            when {
                branch 'origin/main'
            }
            steps {
                echo 'Pull Docker Image & Docker Image Run'
                    sh "docker pull souress2/dbp_demo01'" 
                    sh "docker ps -q --filter name=dbpBook | grep -q . && docker rm -f \$(docker ps -aq --filter name=dbpBook)'"
                    sh "docker run -d --name dbpBook -p 8080:8080 souress2/dbp_demo01'"
                // sshagent (credentials: ['SSH Credential ID -> ssh']) {
                //     sh "ssh -o StrictHostKeyChecking=no [Spring Boot Server username]@[Spring Boot Server IP 주소] 'docker pull [도커이미지 이름]'" 
                //     sh "ssh -o StrictHostKeyChecking=no [Spring Boot Server username]@[Spring Boot Server IP 주소] 'docker ps -q --filter name=[컨테이너 이름] | grep -q . && docker rm -f \$(docker ps -aq --filter name=[컨테이너 이름])'"
                //     sh "ssh -o StrictHostKeyChecking=no [Spring Boot Server username]@[Spring Boot Server IP 주소] 'docker run -d --name [컨테이너 이름] -p 8080:8080 [도커이미지 이름]'"
                // }
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
        // always {
        // }
    }
}



// stage('do something for PRs opened against develop branch') {
//     when {
//         changeRequest target: 'develop'
//     }
//     steps {
//         sh 'pr-worker.sh'
//     }
// }

// stage('do something on merge or direct commits to the develop branch') {
//     when {
//         branch 'develop'
//     }
//     steps {
//         sh 'develop-worker.sh'
//     }
// }