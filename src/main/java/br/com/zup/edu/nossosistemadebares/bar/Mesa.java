package br.com.zup.edu.nossosistemadebares.bar;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zup.edu.nossosistemadebares.exceptions.MesaOcupadaException;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOcupacao status = StatusOcupacao.LIVRE;

    @Column
    private String reservadoPara;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime atualizadoEm = LocalDateTime.now();

    @Column(nullable = false)
    private Integer capacidade;

    public Mesa(Integer capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Mesa() {}

    public void reservar(String reservadoPara) {
        if (isOcupado()) {
            throw new MesaOcupadaException("A mesa já está ocupada e não pode ser reservada.");
        }

        this.reservadoPara = reservadoPara;
        this.status = StatusOcupacao.OCUPADO;
        this.atualizadoEm = LocalDateTime.now();
    }

    public boolean isOcupado() {
        return status.equals(StatusOcupacao.OCUPADO);
    }

    public Long getId() {
        return id;
    }

}
