package at.hakspittal.hak;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HakRestController {

    @Value("${schule.direktor}")
    private String direktorName;
    
    @Value("${schule.bildungsberater}")
    private String bildungsberater;
    
	@GetMapping("/")
	public String showLandingPage() {
		return "<h1>Startseite</h1>"
				+ "<h3>HAK-Direktor " + direktorName 
				+ " freut sich über Deine Anmeldung!</h3>"
				+ "<p>Unser Bildungsberater " + bildungsberater 
				+ " beantwortet alle Deine Fragen.</p>" ;
	}
	
	@GetMapping("/dbhak")
	public String showDigBizPage() {
		return "<h3>Hier stehen Infos zum DigBiz Zweig.</h3>";
	}
	@GetMapping("/cbhak")
	public String showClassicPage() {
		return "<h3>Hier stehen Infos zum classic HAK Zweig.</h3>";
	}
	
}
