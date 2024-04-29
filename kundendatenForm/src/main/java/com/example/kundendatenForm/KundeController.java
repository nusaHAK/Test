package com.example.kundendatenForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KundeController {

    @Autowired
    private KundeRepository kundeRepository;

    @GetMapping("/formular")
    public String zeigeFormular(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "formular";
    }

    @PostMapping("/formular")
    public String verarbeiteFormular(Kunde kunde, Model model) {
    	//Validierung fehlt noch: @Valid Kunde kunde
    	/*
        if(kundeRepository.save(kunde) != null) {
        return "redirect:/erfolg"; // Weiterleitung nach erfolgreicher Speicherung
        }else return "redirect:/error"; */
    	try {
    		kundeRepository.save(kunde);
    		return "redirect:/erfolg";
    	}catch (Exception e) {
    		//Fehlergrund
    		String fehlermeldung = e.getMessage();
    		model.addAttribute("fehlermeldung", fehlermeldung);
    		return "error";
    	}
    }

    @GetMapping("/erfolg")
    public String zeigeErfolg() {
        return "erfolg";
    }
    
    @GetMapping("/error")
    public String zeigeError() {
        return "error";
    }
}