package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor//faz injecão de dependencias das classes outras classe instanciadas, subst.@Autowired
public class AnimeService {

    //@Autowired
    AnimeRepository animeRepository;

    public Anime save(Anime anime){
        return animeRepository.save(anime);
    }

    public List<Anime> list(){
        return animeRepository.findAll();
    }

    public Anime findById(Long id){
        return animeRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Anime not found"));
    }
}
