package cliente.api.cliente.api.springData.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cliente.api.cliente.api.springData.repository.clienteRepository;

import cliente.api.cliente.api.springData.dto.clienteDto;


import cliente.api.cliente.api.springData.model.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class clienteService {

    private clienteRepository clienteRepository;

    public void crearCliente (clienteDto  clienteDto){
        cliente cliente = new cliente();
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setPaisResidencia(clienteDto.getPaisResidencia() );
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setNombres(clienteDto.getNombres());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setIdentificacion(clienteDto.getIdentificacion());
        clienteRepository.save(cliente);
    }


    public clienteDto obtenerClienteXIdentificacion (int idCliente){
        cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> {throw new RuntimeException("Cliente no Existe");});
        clienteDto clienteDto = new clienteDto();
        clienteDto.setDireccion(cliente.getDireccion());
        clienteDto.setPaisResidencia(cliente.getPaisResidencia());
        clienteDto.setTelefono(cliente.getTelefono());
        clienteDto.setNombres(cliente.getNombres());
        clienteDto.setPaisNacimiento(cliente.getPaisNacimiento());
        return clienteDto;
    }

    public List<clienteDto> obtenerTodosClientes (){
        List<clienteDto> clienteDtoList = new ArrayList<>();
        clienteRepository.findAll().
                stream().
                map(cliente -> {
                    clienteDtoList.add(fromClienteToDto(cliente));
                    return cliente;
                }).collect(Collectors.toList());
        return clienteDtoList;
    }
    private clienteDto fromClienteToDto(cliente cliente){
        clienteDto clienteDto = new clienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    public clienteDto actualizarCliente(clienteDto clienteDto) {
        cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {throw new RuntimeException("Cliente no Existe");});
        cliente.setPaisResidencia(clienteDto.getPaisResidencia());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setDireccion(cliente.getDireccion());
        clienteRepository.save(cliente);
        return null;
    }


    public clienteDto desactivarClientePorEstado(int id){
        cliente cliente = clienteRepository.findClientesByEstado(id);
        cliente.setEstado(false);
        clienteRepository.save(cliente);
        return fromClienteToDto(cliente);
    }

}

