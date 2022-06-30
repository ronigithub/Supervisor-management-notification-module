# Supervisor-management-notification-module

Note: Before run all command use sudo keyword if there is any permission needed.

# Installing Docker
You are required to install docker on your system. Please follow this [link](https://docs.docker.com/get-docker/) to get your installation package for Docker 

Docker does a great job running you through on how to install docker on OSX, Windows or Linux based OS.

Once you installed Docker and this is your first time using it, we recommend you to go through the 2 minute tutorial found here:

https://docs.docker.com/get-started/#start-the-tutorial

#Installing Docker Compose

You are required to install docker compose on your system. follow this https://docs.docker.com/compose/install/

If you are using ubuntu then run before command for installing docker-compose
```
sudo apt install docker-compose
```

# Installing Git

You are required to install git on your system. Please follow this https://github.com/git-guides/install-git 

# Setup project
Clone the git repository by command

```
git clone https://github.com/ronigithub/Supervisor-management-notification-module.git
```

goto the project root directory

```
cd Supervisor-management-notification-module
```

# Run project into docker 

You will the see the docker-compose.yml file in root directory. 

Open terminal here and run below command 

```
sudo docker-compose up
```

# Use project

After running both application in docker

Open [http://localhost:3000](http://localhost:3000) to view it in the browser.
