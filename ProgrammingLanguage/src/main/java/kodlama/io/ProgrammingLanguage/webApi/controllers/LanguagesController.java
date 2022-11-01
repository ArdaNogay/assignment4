package kodlama.io.ProgrammingLanguage.webApi.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.ProgrammingLanguage.business.abstracts.LanguageService;
import kodlama.io.ProgrammingLanguage.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    public Language add(@RequestBody Language language) {
        return languageService.add(language);
    }

    @PutMapping("/update")
    public Language update(@RequestBody Language languageToBeUpdate) {
        return languageService.update(languageToBeUpdate);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestBody Language language) {
        languageService.delete(language);
    }

    @GetMapping("/getById")
    public Language getById(@RequestParam int id) {
        return languageService.getById(id);
    }

}
