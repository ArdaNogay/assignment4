package kodlama.io.ProgrammingLanguage.dataAccess.concretes;

import kodlama.io.ProgrammingLanguage.dataAccess.abstracts.LanguageRepository;
import kodlama.io.ProgrammingLanguage.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private List<Language> languages = new ArrayList<>();

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language add(Language language) {
        languages.add(language);
        return language;
    }

    @Override
    public void delete(int id) {
        languages.remove(id);
    }

}
