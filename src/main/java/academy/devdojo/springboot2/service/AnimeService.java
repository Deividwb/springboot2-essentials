package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor//faz injecão de dependencias das classes outras classe instanciadas, subst.@Autowired
public class AnimeService {

    //@Autowired
    AnimeRepository animeRepository;

    public Anime save(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public List<Anime> list(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestExeption(Long id){
        return animeRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Anime not found"));
    }

    public void delete(Long id){
        animeRepository.delete(findByIdOrThrowBadRequestExeption(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findByIdOrThrowBadRequestExeption(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();
        animeRepository.save(anime);

    }
}
