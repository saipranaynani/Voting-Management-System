package com.sdp3.main;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sdp3.main.controller.AdminController;


@SpringBootApplication

public class Sdp3Application {

	public static void main(String[] args) {
		
		
		SpringApplication.run(Sdp3Application.class, args);
	}

}
