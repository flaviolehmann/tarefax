package com.flaviolehmann.tarefax.service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "documentos", url = "${application.feign.url}")
public interface TesteClient {

    @GetMapping("/api/teste")
    ResponseEntity<String> teste();

}
