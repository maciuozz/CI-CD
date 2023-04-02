# Practica CI-CD Paolo Scotto Di Mase

For this project, I utilized a virtual machine running Ubuntu 22.04 as the environment for Jenkins. I used 2 docker agents that connect to 2 Jenkins nodes.
I created the VM with the Vagrant script below: 

    Vagrant.configure("2") do |config|
        config.vm.define "cicd-vm" do |cicd|
            cicd.vm.box = "ubuntu/jammy64"
            cicd.vm.hostname = "cicd"
            cicd.vm.box_check_update = false
            cicd.vm.network "forwarded_port", guest: 8080, host: 8081
            cicd.vm.provider "virtualbox" do |vb|
                vb.name = "ubuntu_cicd"
                vb.memory = "4096"
                vb.cpus = 2
            end
        end
    end
    
In the Makefile there are 5 targets: ***clean, build, test, check_files, exec***. It is possible to execute all targets using a single command:

    make all
    
The presence of 2 files named ***texto.txt*** serves to demonstrate the calculation of the FILE_PATH variable in situations where multiple files share the same name.
