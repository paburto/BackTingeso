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

import MingesoTingeso.demo.Models.Producto;
import MingesoTingeso.demo.Repositories.ProductoRepository;

//Evaluacion 07-mayo-2019

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	ProductoRepository productoRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findProductoById(id);
    }

	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
    @ResponseBody
    public List<Producto> getProductoByCategoria(@RequestBody Map<String, Object> jsonData) {
        return productoRepository.findProductoByCategoria(jsonData.get("categoria").toString());
    }

	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Producto getProductoByCodigoProducto(@PathVariable int codigoProducto) {
        return productoRepository.findProductoByCodigoProducto(codigoProducto);
    }

	@PostMapping("/create")
    @ResponseBody
    public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Producto producto = productoRepository.findProductoByCodigoProducto(Integer.parseInt(jsonData.get("codigo_producto").toString()));
		if(producto == null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date productDate = formatter.parse(jsonData.get("fecha_vencimiento").toString());
			productoRepository.save(new Producto(jsonData.get("nombre_producto").toString(),
														jsonData.get("categoria").toString(),
														productDate,
														Integer.parseInt(jsonData.get("codigo_producto").toString()),
														Integer.parseInt(jsonData.get("precio").toString())));
			map.put("status", "201");
			map.put("message", "OK");
			map.put("item", jsonData.get("nombre_producto").toString());
			result.add(map);
			return result;
		}
		else {
			map.put("status", "401");
			map.put("message", "Product code already exist.");
			map.put("item", producto.getNombreProducto());
			result.add(map);
			return result;
		}
    }

	@PostMapping("/update/{id}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Producto producto = productoRepository.findProductoById(id);
		if(producto == null) {
			map.put("status", "404");
			map.put("message", "Product does not exist!.");
			map.put("item", "");
			result.add(map);
			return result;
		}
		else {
			producto.setCategoria(jsonData.get("categoria").toString());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date productDate = formatter.parse(jsonData.get("fecha_vencimiento").toString());
			producto.setFechaVencimiento(productDate);
			producto.setPrecio(Integer.parseInt(jsonData.get("precio").toString()));
			producto.setNombreProducto(jsonData.get("nombre_producto").toString());
			producto.setCodigoProducto(Integer.parseInt(jsonData.get("codigo_producto").toString()));
			productoRepository.save(producto);
			map.put("status", "200");
			map.put("message", "OK");
			map.put("item", producto.getNombreProducto());
			result.add(map);
			return result;
		}
    }

	@CrossOrigin(origins = "*")
	@PostMapping("/delete/{id}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable Long id) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Producto producto = productoRepository.findProductoById(id);
		if(producto == null) {
			map.put("status", "404");
			map.put("message", "Product does not exist!.");
			map.put("item", "");
			result.add(map);
			return result;
		}
		else {
			String erasedProduct = producto.getNombreProducto();
			productoRepository.deleteById(id);
			map.put("status", "200");
			map.put("message", "OK, product erased!.");
			map.put("item", erasedProduct);
			result.add(map);
			return result;
		}
    }
}
