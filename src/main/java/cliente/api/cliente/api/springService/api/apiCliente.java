package cliente.api.cliente.api.springService.api;

import cliente.api.cliente.api.springData.dto.clienteDto;

import cliente.api.cliente.api.springData.service.clienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cliente")
@Slf4j
public class apiCliente {


    @Autowired
    private clienteService clienteService;


    @PostMapping
    public void guardarCliente(@RequestBody clienteDto clienteDto){
        log.info("Busqueda de Cliente; {}" , clienteDto);
        clienteService.crearCliente(clienteDto);
    }

    @GetMapping(value = "/all")
    public List<clienteDto> buscarTodosClientes(){

        return clienteService.obtenerTodosClientes();
    }

    @GetMapping("/{id}")
    public clienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.obtenerClienteXIdentificacion(id);
    }

    @PutMapping
    public void ActualizarCliente(@RequestBody clienteDto clienteDto){
        log.info("Busqueda de Cliente; {}", clienteDto);
        clienteService.actualizarCliente(clienteDto);

    }

    @GetMapping("/estado/{id}")
    public clienteDto desactivarClientePorEstado(@PathVariable int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.desactivarClientePorEstado(id);
    }

    @PutMapping("/buscar/{id}")
    public clienteDto buscarClientexIdentificacon(@PathVariable int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.obtenerClienteXIdentificacion(id);
    }


}
