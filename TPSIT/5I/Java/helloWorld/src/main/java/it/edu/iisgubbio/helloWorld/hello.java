package it.edu.iisgubbio.helloWorld;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class hello {
	public String helloWorld() {
		return "Hello World!";
	}
}