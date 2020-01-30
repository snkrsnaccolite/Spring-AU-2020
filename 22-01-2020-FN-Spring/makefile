all: clean build start

clean:
	@mvn clean

build:
	@mvn package

start:
	@java -cp target/test-app-1.0-SNAPSHOT.jar one.traction.testapp.App

test:
	@mvn test
