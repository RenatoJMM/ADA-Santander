package tech.ada.ecommerce.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import tech.ada.ecommerce.dto.CEP;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.repository.EnderecoRepository;

import java.util.HashMap;

@Service
public class EnderecoService {

    EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

//    public CEP buscarPorCEP(String cep){
//
//        // AQUI ESTAMOS UTILIZANDO O RESTTEMPLATE (ANTIGO)
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "https://viacep.com.br/ws/";
//
//        ResponseEntity<HashMap> response = restTemplate.getForEntity(url + cep + "/json", HashMap.class);
//        HashMap<String,String> map = response.getBody();
//        String uf = map.get("uf");
//
////        restTemplate.postForEntity()
//
//        // return response.getBody();
//        return null;
//    }

    public CEP buscarPorCEP(String cep) {
        String url = "https://viacep.com.br/ws/";
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        CEP result = webClient.get().uri(cep + "/json").retrieve().bodyToMono(CEP.class).block();
        // pode ser CEP result ou HashMap result. mudando o CEP.class
//        uri constroi o url, retrive faz a chamada do get (transforma no response, dps transforma em uma classe mono. e block gera a classe de resposta

        return result;
    }

    public Endereco cadastrarEndereco(Endereco endereco){

        CEP cep = buscarPorCEP(endereco.getCep());

        endereco.setLogradouro(cep.getLogradouro());
        endereco.setComplemento(cep.getComplemento());
        endereco.setBairro(cep.getBairro());
        endereco.setCidade(cep.getLocalidade());
        endereco.setUf(cep.getUf());

        return enderecoRepository.save(endereco);
    }


    // 2:20 2023-10-18
}
