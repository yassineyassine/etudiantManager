package net.youssfi.observabilityspringgrafana;

import net.youssfi.observabilityspringgrafana.entities.Etudiant;
import net.youssfi.observabilityspringgrafana.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilitySpringGrafanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilitySpringGrafanaApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository EtudiantRepository){
        return args -> {
            EtudiantRepository.save(Etudiant.builder().name("yassine").lastname("kharroubi").email("ya@gmail.com").cin(11111111).build());
            EtudiantRepository.save(Etudiant.builder().name("imed").lastname("ben mohamed").email("ya2@gmail.com").cin(22222222).build());            ;
            EtudiantRepository.findAll().forEach(System.out::println);
        };
    }
}
