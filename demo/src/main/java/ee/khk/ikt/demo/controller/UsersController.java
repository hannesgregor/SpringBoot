package ee.khk.ikt.demo.controller;

import ee.khk.ikt.demo.dto.UsersDto;
import ee.khk.ikt.demo.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException{
        log.info("Handling users saving: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers(){
        log.info("Handling users finding: ");
        return usersService.findAll();
    }

    @GetMapping("/findAll")
    public UsersDto findByLogin(@RequestParam String login){
        log.info("Find by login: " + login );
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Handling delete user: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
