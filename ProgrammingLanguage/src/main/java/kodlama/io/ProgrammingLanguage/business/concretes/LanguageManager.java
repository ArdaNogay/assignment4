package kodlama.io.ProgrammingLanguage.business.concretes;

import kodlama.io.ProgrammingLanguage.business.abstracts.LanguageService;
import kodlama.io.ProgrammingLanguage.dataAccess.concretes.InMemoryLanguageRepository;
import kodlama.io.ProgrammingLanguage.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LanguageManager implements LanguageService {

    private List<Language> languages = new ArrayList<>();

    private final InMemoryLanguageRepository inMemoryLanguageRepository;

    public LanguageManager(InMemoryLanguageRepository inMemoryLanguageRepository) {
        this.inMemoryLanguageRepository = inMemoryLanguageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languages = inMemoryLanguageRepository.getAll();
    }

    @Override
    public Language add(Language language) {
        isObjectNull(language);
        isNameEmpty(language);
        isIdEmpty(language);
        isNameExist(language);
        isIdExist(language);
        return inMemoryLanguageRepository.add(language);
    }

    private void isIdExist(Language language) {
        languages = inMemoryLanguageRepository.getAll();
        for (Language lang : languages) {
            if (lang.getId() == language.getId()) {
                throw new RuntimeException("Id tekrar edemez");
            }
        }
    }

    private void isNameExist(Language language) {
        languages = inMemoryLanguageRepository.getAll();
        for (Language lang : languages) {
            if (lang.getName().equals(language.getName())) {
                throw new RuntimeException("İsim tekrar edemez");
            }
        }
    }

    private void isIdEmpty(Language language) {
        if (String.valueOf(language.getId()).isEmpty()) {
            throw new RuntimeException("Id boş bırakılamaz");
        }
    }

    private void isNameEmpty(Language language) {
        if (language.getName() == null || language.getName().isEmpty()) {
            throw new RuntimeException("İsim boş bırakılamaz");
        }
    }

    @Override
    public Language update(Language language) {
        isObjectNull(language);
        isNameEmpty(language);
        isIdEmpty(language);
        isNameExist(language);
        Language updateLanguage = updateLanguageFields(language);
        return updateLanguage;
    }

    private Language updateLanguageFields(Language language) {
        Language languageById = getById(language.getId());
        languageById.setName(language.getName());
        return languageById;
    }

    @Override
    public void delete(Language language) {
        isObjectNull(language);
        inMemoryLanguageRepository.delete(language.getId() - 1);
    }

    private void isObjectNull(Language language) {
        if (Objects.isNull(language)) {
            throw new RuntimeException("Nesne boş bıraklamaz");
        }
    }

    @Override
    public Language getById(int id) {
        List<Language> languageList = inMemoryLanguageRepository.getAll();
        for (Language lang : languageList) {
            if (lang.getId() == id) {
                return lang;
            }
        }
        throw new RuntimeException("Dil bulunamadı");
    }
}
