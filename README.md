# poc-crm-orders

## local mongo

`docker pull mongo`


## build image
`docker image build -t poc-order .`


`docker run --env MONGO_URL=mongodb://admin:admdev@ec2-18-217-111-150.us-east-2.compute.amazonaws.com:27017/admin --name some-mongo2 -p 27017:27017 -d mongo:latest`

## ENV

local dev : 

`MONGO_URL=mongodb://localhost:27017/admin`