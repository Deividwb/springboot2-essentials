package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    AnimeService animeService;

    @GetMapping("list")
    private List<Anime> list(){
        return animeService.list();
        //return List.of(new Anime("Deivid"),new Anime("Davi"));
    }

}
