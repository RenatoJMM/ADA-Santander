package tech.ada.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.dto.CEP;
import tech.ada.ecommerce.dto.ClienteDTO;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.service.EnderecoService;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

    EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CEP> getByCEP(@PathVariable("cep") String cep) {
        return new ResponseEntity<>(enderecoService.buscarPorCEP(cep), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco){
        try{
            Endereco savedEndereco = enderecoService.cadastrarEndereco(endereco);
            if(savedEndereco != null){
                return new ResponseEntity<>(savedEndereco, HttpStatus.CREATED);
            } else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
