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
      }
    }

    stage('Exec') {
      steps {
        ansiColor(colorMapName: 'yellow') {
          sh 'make exec'
        }

      }
    }

    stage('Package & Save') {
      steps {
        sh 'mvn jar:jar'
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