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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Repositories.ClienteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getNombreClienteById(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findClienteByIdCliente(id);
				return cliente.getNombreCliente();
    }
}
