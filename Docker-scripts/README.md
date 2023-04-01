<h2>DOCKER AGENTS - JENKINS NODES</h2>  

You need to be logged in as the jenkins user. Then you can run the script ***run.sh*** to create 2 containers that represent 2 docker agents  
connected to 2 jenkins nodes:  

    sudo chmod +x run.sh  
    sudo ./run.sh  

To check the connection run: 

    sudo ssh jenkins@10.0.2.100
    sudo ssh jenkins@10.0.2.101

***<h3>JENKINS NODES DEFINITION</h3>***  

AGENT_11

<img width="1792" alt="Screenshot 2023-04-02 at 01 50 45" src="https://user-images.githubusercontent.com/118285718/229323373-6ddde6c4-3412-4283-9d46-e0c146dcc408.png">




    
    
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
