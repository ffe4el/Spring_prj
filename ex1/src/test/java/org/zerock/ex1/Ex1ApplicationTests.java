package org.zerock.ex1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex1ApplicationTests {

	@Test //작성되어 있는 Ex1ApplicationTest 파일에서 @test가 있는 메서드를 선택해서 실행해 볼 수 있다.
	void contextLoads() {
			System.out.println("contextLoads...");
	}

}
