pipeline {
  agent {
    node {
      label 'agent_22'
    }

  }
  stages {
    stage('Clean') {
      steps {
        sh 'make clean'
      }
    }

    stage('Build') {
      steps {
        sh 'make build'
      }
    }

    stage('Test') {
      steps {
        sh 'make test'
        jacoco(classPattern: '**/*Test.class', maximumLineCoverage: '70')
      }
    }

    stage('Exec') {
      steps {
        sh '''make exec
'''
      }
    }

    stage('Package & Save') {
      steps {
        sh 'make package'
        archiveArtifacts 'target/*.jar'
      }
    }

    stage('Manual Approval') {
      steps {
        input(message: 'Would you like to deploy to production?', ok: 'Yes, go ahead!')
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deployment successful!'
      }
    }

  }
}