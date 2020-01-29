all: clean compile start

clean:
	@rm ecommerce/*_.java &>/dev/null
	@rm ecommerce/*.class &>/dev/null

compile:
	@javac -classpath .:/home/traction/Desktop/Spring\ AU/Spring-AU-2020/24-01-2020-FN-AN-Hibernate/jars/* ecommerce/*.java

start:
	@java -classpath .:/home/traction/Desktop/Spring\ AU/Spring-AU-2020/24-01-2020-FN-AN-Hibernate/jars/* ecommerce.ECommerce
