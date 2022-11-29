pipeline {
    agent any
    stages {
        stage('01. Git check out'){
            steps{
                script{
                    sh 'echo GITLAB CHECKOUT PROCESS'
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
                        slackSend (channel: '#jenkins-test', color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
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

        // stage('Dockerfile build') {
        //     steps {
        //         script {
        //             try {
        //                 sh 'docker-compose -f docker-compose-dev.yml build'
        //             } catch (e) {
        //                 sh 'echo Dockerfile build Fail!!!'
        //                 slackSend (channel: '#jenkins-test', color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        //             }
        //         }
        //     }
        // }
        // stage('Docker-compose') {
        //     steps {
        //         script {
        //             try {
        //                 sh 'docker-compose -f docker-compose-dev.yml up -d'
        //                 slackSend (channel: '#jenkins-test', color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        //             } catch (e) {
        //                 sh 'echo Docker-compose Fail!!!'
        //                 slackSend (channel: '#jenkins-test', color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        //             }
        //         }
        //     }
        // }
    }
}

// pipeline {
//     agent any
//     stages {
//         stage('Example1') {
//             steps {
//                 echo 'Hello World1 TEST FININSH'
//             }
//         }
//     }
// }