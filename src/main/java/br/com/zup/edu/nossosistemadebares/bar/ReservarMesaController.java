package br.com.zup.edu.nossosistemadebares.bar;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/mesas/{mesaId}")
public class ReservarMesaController {

    private final MesaRepository mesaRepository;

    public ReservarMesaController(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @Transactional
    @PostMapping("/reservar")
    public ResponseEntity<Void> reservar(@PathVariable Long mesaId,
                                         @RequestBody @Valid ReservarMesaRequest ReservarMesaRequest) {
        Mesa mesa = mesaRepository.findById(mesaId)
                                  .orElseThrow(
                                      () -> new ResponseStatusException(
                                          HttpStatus.NOT_FOUND,
                                          "Não existe uma mesa com o id fornecido."
                                      )
                                  );

        mesa.reservar(ReservarMesaRequest.getReservadoPara());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
