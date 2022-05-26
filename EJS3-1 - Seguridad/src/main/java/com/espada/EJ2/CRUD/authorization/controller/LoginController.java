package com.espada.EJ2.CRUD.authorization.controller;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.ErrorsHandling.UnprocesableException;
import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestParam("user") String username, @RequestParam("password") String password) throws Exception {

        List<PersonaOutputDTO> lista = personaService.findByUser(username);
        if(lista.size()==0) throw new NotFoundException("Usuario "+username+" no encontrado");
        if(lista.size()>1) throw new UnprocesableException("Usuario ambiguo");
        PersonaOutputDTO personaOutputDTO = lista.get(0);
        String pwd = personaOutputDTO.getPassword();
        if(!password.equals(password)) throw new UnprocesableException("Contraseña incorrecta");
        String rol = (personaOutputDTO.isAdmin()) ? "ROLE_ADMIN" : "ROLE_USER";
        return new ResponseEntity<>(getJWTToken(username, rol), HttpStatus.OK);

    }

    private String getJWTToken(String username, String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
