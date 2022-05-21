package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Entity.AppUser;
import com.binaracademy.Challange4.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping(value = "/singup")
    public ResponseEntity<?> createNewUser(@RequestBody AppUser user) {
        return loginService.add_user(user);
    }

//    @GetMapping("/refresh-token")
//    public void refreshTokenController(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
//
//            try {
//                String refresh_token = authorizationHeader.substring("Bearer ".length());
//                Algorithm algorithm = Algorithm.HMAC256("mantul".getBytes());
//                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
//                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
//                String usernameDecode = decodedJWT.getSubject();
//                UserLogin userLogin = UserServiceImpl.findByUserName(usernameDecode);
//                String accessToken = JWT.create()
//                        .withSubject(userLogin.getUserName())
//                        .withExpiresAt(new Date(System.currentTimeMillis() +10*60*1000))
//                        .withIssuer(request.getRequestURL().toString())
//                        .withClaim("roles", userLogin.getRoles().stream().map(Role::getRole).collect(Collectors.toList()))
//                        .sign(algorithm);
//
//                Map<String,String> map = new HashMap<>();
//                map.put("access_token", accessToken);
//                map.put("refresh_token", refresh_token);
//                response.setContentType(APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), map);
//            }catch (Exception e){
//                response.setHeader("error", e.getMessage());
//                response.setStatus(FORBIDDEN.value());
//
//                Map<String,String> errorMap = new HashMap<>();
//                errorMap.put("error_message", e.getMessage());
//                response.setContentType(APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), errorMap);
//            }
//
//        }else{
//            throw new RuntimeException("refresh token is missing");
//        }
//    }
}
