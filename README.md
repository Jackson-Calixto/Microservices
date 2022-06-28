# Microservices
For this Microservice Project is required JRE, Maven, Java IDE, MySQL, Docker.
# docker run -p 9411:9411 -d openzipkin/zipkin:2.23.2 

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>jacksoncalixto/${project.artifactId}:${project.version}</name>
					</image>
					<pullPolicy>IF_NOT_PRESENT</pullPolicy>
				</configuration>
			</plugin>
		</plugins>
	</build>

RunAs -> Maven build
Goals: spring-boot:build-image -DskipTests

docker run -p 8761:8761 -d jacksoncalixto/naming-server:0.0.1-SNAPSHOT