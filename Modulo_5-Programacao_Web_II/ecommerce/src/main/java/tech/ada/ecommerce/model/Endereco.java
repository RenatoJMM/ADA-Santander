package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String logradouro;
    @Column()
    private String numero;
    @Column()
    private String complemento;
    @Column()
    private String bairro;
    @Column()
    private String cep;

    @Column()
    private String cidade;
    @Column()
    private String uf;


}
