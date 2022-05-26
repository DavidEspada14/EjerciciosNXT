package com.espada.EJ2.CRUD.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feignServer", url = "http://localhost:8081")
public interface IFeignServer {

    @GetMapping("/profesor/{id}")
    ResponseEntity<?> findProfesorByID(@PathVariable String id, @RequestParam(defaultValue = "simple", name = "outPutType") String outPutType);


}
