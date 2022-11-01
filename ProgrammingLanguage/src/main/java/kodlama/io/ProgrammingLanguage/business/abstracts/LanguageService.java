package kodlama.io.ProgrammingLanguage.business.abstracts;

import kodlama.io.ProgrammingLanguage.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getAll();

    Language add(Language language);

    Language update(Language language);

    void delete(Language language);

    Language getById(int id);
}
