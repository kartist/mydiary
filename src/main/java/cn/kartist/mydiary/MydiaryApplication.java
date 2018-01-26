package cn.kartist.mydiary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.kartist.mydiary.**.dao")
public class MydiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydiaryApplication.class, args);
	}
}
