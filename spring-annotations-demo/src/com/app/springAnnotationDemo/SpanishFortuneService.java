package com.app.springAnnotationDemo;

import org.springframework.stereotype.Component;

@Component
public class SpanishFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Your Spanish Fortune: ¡Vas a rockear!";
	}

}
