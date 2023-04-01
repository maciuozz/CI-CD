<h2>DOCKER AGENTS</h2>  
You need to be logged in as the jenkins user. Then you can run the script ***run.sh*** to create 2 containers that represent 2 docker agents 
connected to 2 jenkins nodes:  

    sudo chmod +x run.sh
    sudo ./run.sh

To check the connection run: 

    sudo ssh jenkins@10.0.2.100
    sudo ssh jenkins@10.0.2.100

    
    
    job('Make-test-30') {
        triggers {
          cron('*/30 * * * *')
        }
        scm {
            git {
                remote {
                    url('https://github.com/maciuozz/ci-cd-private.git')
                    credentials('ci-cd-private')
                }
                branch('main')
            }
        }
        steps {
            shell('make test')
        }
    }
