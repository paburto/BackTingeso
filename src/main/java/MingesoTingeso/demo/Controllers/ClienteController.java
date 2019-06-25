package MingesoTingeso.demo.Controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Repositories.ClienteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping
    @ResponseBody
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

	@GetMapping(value = "/{id}")
    @ResponseBody
    public String getNombreClienteById(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findClienteByIdCliente(id);
				return cliente.getNombreCliente();
    }

    @GetMapping(value = "/rut/{rut}")
    @ResponseBody
    public Cliente getClienteByRut(@PathVariable Integer rut){
	    return clienteRepository.findClienteByRut(rut);
    }
}
