<h2>DOCKER AGENTS - JENKINS NODES - JOB</h2>  

Log in as the jenkins user; then run the script ***run.sh*** to create 2 docker agents that will be connected to 2 jenkins nodes:  

    sudo chmod +x run.sh  
    sudo ./run.sh  

Check the connection by running: 

    sudo ssh jenkins@10.0.2.100
    sudo ssh jenkins@10.0.2.101

***<h3>JENKINS NODES DEFINITION</h3>***  

AGENT_11

<img width="1792" alt="Screenshot 2023-04-02 at 01 50 45" src="https://user-images.githubusercontent.com/118285718/229323373-6ddde6c4-3412-4283-9d46-e0c146dcc408.png">
<img width="1790" alt="Screenshot 2023-04-02 at 02 00 17" src="https://user-images.githubusercontent.com/118285718/229323427-4f9c8464-ee0e-4229-9f75-05ee29034179.png">

AGENT_22

<img width="1791" alt="Screenshot 2023-04-02 at 02 02 15" src="https://user-images.githubusercontent.com/118285718/229323480-5183eb80-72aa-40a4-8cc8-1a2a88579e05.png">
<img width="1783" alt="Screenshot 2023-04-02 at 02 03 41" src="https://user-images.githubusercontent.com/118285718/229323509-44281ac5-8d7b-4954-b049-a1aecc9583b5.png">

***<h3>JOB DSL</h3>***  

This  Job DSL script defines a Jenkins job named "Make-test-30" with the following configuration:  

- It is triggered every 30 minutes using a cron schedule.
- It uses Git as the source code management (SCM) system, with a specific remote URL and Git credentials.
- It checks out the code from the "main" branch.
- It runs a single shell command, "make test", as the build step.  

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
  
Within the context of this project, we have a parent job or project called 'Cron-job', which was created to run the above build script. The build script includes a command to generate a child job with the name 'Make-test-30':  

<img width="768" alt="Screenshot 2023-04-02 at 03 27 49" src="https://user-images.githubusercontent.com/118285718/229325845-27b9e6e7-6023-4efc-9393-4641de8e950a.png">

Given that we have two agents available, I am going to assign this job to agent_11. In order to do so I need to select this option for both 'Cron-job' and 'Make-test-30':  

<img width="831" alt="Screenshot 2023-04-02 at 03 14 45" src="https://user-images.githubusercontent.com/118285718/229325433-bcf1521b-7bfc-454f-ba12-f96378a16c3a.png">

