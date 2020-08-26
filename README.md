# shoppingmall
 


## mypage branch
### 테이블 명령어

CREATE TABLE member(

    id VARCHAR(20) NOT NULL,

    pw VARCHAR(20) NOT NULL,

    name VARCHAR(20) NOT NULL,

    phone VARCHAR(20),

    admin NUMBER NOT NULL

  );

  ### jquery 위치 변경

webapp/resources/jquery-3.2.1.min.js


  ### pom.xml


		<!-- jdbc 연결 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>

		<!-- mysql -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.41</version>
		</dependency>

		<!-- mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.4.1</version>
		</dependency>

		<!-- mybatis-spring 연결 -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.3.0</version>
		</dependency>

