package it.edu.iisgubbio.helloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Hello {
	@GetMapping("/hello")
	public String saluta() {
		return "Hello world!";
	}
	@GetMapping("/ciao")
	public String salutaPersona(@RequestParam(name="X",required=false, defaultValue="Carlo") String name) {
		return "Hello "+name+"!";
	}
	@GetMapping("/hello2/{nome}")
	public String hello2(@PathVariable String nome) {
		return "Ciao "+nome+"!";
	}
}