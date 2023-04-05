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
        jacoco(execPattern: '**/target/*.exec', classPattern: '**/classes', sourcePattern: '**/src/main/java', inclusionPattern: '**/*', exclusionPattern: '**/*Test*', minimumInstructionCoverage: 0.7, maximumInstructionCoverage: 0.9)
        publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/jacoco',
                reportFiles: 'index.html',
                reportName: 'JaCoCo Code Coverage Report'
              ])
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