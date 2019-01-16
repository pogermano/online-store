#!/usr/bin/env groovy

node {


  stage('init') {
       sh 'echo $(whoami)'
    sh 'node -v'
     sh 'where yarn'
    }




    stage('checkout') {
        checkout scm
    }

    stage('check java') {
        sh "java -version"
    }

    stage('clean') {
        sh "chmod +x gradlew"
        sh "./gradlew clean --no-daemon"
    }

    stage('npm install') {
        sh "./gradlew npm_install -PnodeInstall --no-daemon"
    }
/*
    stage('backend tests') {
        try {
            sh "./gradlew test -PnodeInstall --no-daemon"
        } catch(err) {
            throw err
        } finally {
            junit '** /build/** /TEST-*.xml'
        }
    }
*/


    stage('frontend tests') {
        try {
            sh "npm install yarn  -g"
            sh "yarn --version"

        } catch(err) {
            throw err
        } finally {
            junit '**/build/test-results/jest/TESTS-*.xml'
        }
    }

    stage('packaging') {
        sh "./gradlew bootWar -x test -Pprod -PnodeInstall --no-daemon"
        archiveArtifacts artifacts: '**/build/libs/*.war', fingerprint: true
    }

    stage('deployment') {
        sh "./gradlew deployHeroku --no-daemon"
    }

}
