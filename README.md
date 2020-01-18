# poc-crm-orders

## local mongo

`docker pull mongo`


## build image
`docker image build -t poc-order .`


## run container
`docker container run --env MONGO_URL=mongodb://admin:admdev@ec2-18-217-111-150.us-east-2.compute.amazonaws.com:27017/admin -d -p 8081:8081 poc-order`

## ENV

local dev : 

`MONGO_URL=mongodb://localhost:27017/admin`