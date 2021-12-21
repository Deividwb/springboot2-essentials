package academy.devdojo.springboot2.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

//Tambem nomeado como DTO
@Data

public class AnimePostRequestBody{

    private String name;
}
