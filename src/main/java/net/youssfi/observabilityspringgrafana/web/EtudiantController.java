package net.youssfi.observabilityspringgrafana.web;

import net.youssfi.observabilityspringgrafana.entities.Etudiant;
import net.youssfi.observabilityspringgrafana.model.Post;
import net.youssfi.observabilityspringgrafana.repository.EtudiantRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * @author mohamedyoussfi
 **/
@RestController
public class EtudiantController {
    private EtudiantRepository EtudiantRepository;
    private RestClient restClient;

    public EtudiantController(EtudiantRepository EtudiantRepository,
                             RestClient.Builder restClient) {
        this.EtudiantRepository = EtudiantRepository;
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants(){
        return EtudiantRepository.findAll();
    }

    @GetMapping("/posts")
    public List<Post> allPosts(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        return EtudiantRepository.findById(id)
                .map(Etudiant -> ResponseEntity.ok().body(Etudiant))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Etudiant> createNewTajilEtudiant(@RequestBody Etudiant tajilEtudiant){
        return new ResponseEntity<>(EtudiantRepository.save(tajilEtudiant), HttpStatus.CREATED);
    }
}
