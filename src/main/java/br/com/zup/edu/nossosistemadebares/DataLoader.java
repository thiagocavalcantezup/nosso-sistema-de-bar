package br.com.zup.edu.nossosistemadebares;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.edu.nossosistemadebares.bar.Mesa;
import br.com.zup.edu.nossosistemadebares.bar.MesaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final MesaRepository mesaRepository;

    public DataLoader(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (mesaRepository.count() == 0) {
            load();
        }
    }

    private void load() {
        mesaRepository.save(new Mesa(2));
        mesaRepository.save(new Mesa(3));
        mesaRepository.save(new Mesa(4));
    }

}
