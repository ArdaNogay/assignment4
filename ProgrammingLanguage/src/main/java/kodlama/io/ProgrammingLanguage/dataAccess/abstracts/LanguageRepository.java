package kodlama.io.ProgrammingLanguage.dataAccess.abstracts;

import kodlama.io.ProgrammingLanguage.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {

    List<Language> getAll();

    Language add(Language language);

    void delete(int id);

}
