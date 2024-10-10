package com.lojaAPP.applicationAPI.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProcessaImagem {

    @Value("${image.microsservice.baseurl}")
    private String microServiceBaseURL;

    public String salvarImagem(MultipartFile imagem){
        WebClient.Builder builder = WebClient.builder();

        String response = builder.build()
                .post()
                .uri(microServiceBaseURL + "/saveimage")
                .body(BodyInserters.fromMultipartData("file", imagem.getResource()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
