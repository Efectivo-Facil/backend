package com.Backend.Inmobiliaria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.ProductoRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Menu;
import com.Backend.Inmobiliaria.model.Prestamo;
import com.Backend.Inmobiliaria.model.Producto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoRepo productoRepository;

	@GetMapping("/listarProductos")
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}

	@PostMapping("/crearProducto")
	public Producto guardarproducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> listaProductoPorId(@PathVariable Integer id) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El Producto con ese ID no existe : " + id));
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/actualizarPrecio")
	public ResponseEntity<Producto> modEstadoPrestamo(@RequestBody Producto pro) {
		Producto presMod = productoRepository.save(pro);
		return ResponseEntity.ok(presMod);
	}

	@PutMapping("/actualizarProducto/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRequest) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El Producto con ese ID no existe : " + id));

		producto.setNombre_pro(productoRequest.getNombre_pro());
		producto.setDesc_pro(productoRequest.getDesc_pro());
		producto.setMarca_pro(productoRequest.getMarca_pro());
		producto.setModelo_pro(productoRequest.getModelo_pro());
		producto.setValor_inv(productoRequest.getValor_inv());
		producto.setValor_sup(productoRequest.getValor_sup());
		producto.setEn_prenda(productoRequest.isEn_prenda());
		producto.setActivo_pro(productoRequest.isActivo_pro());

		Producto productoActualizado = productoRepository.save(producto);
		return ResponseEntity.ok(productoActualizado);
	}

	@PutMapping("/actualizarProductoMonto/{id}")
	public ResponseEntity<Producto> actualizarProductoMonto(@PathVariable int id,
			@RequestBody Producto productoRequest) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El Producto con ese ID no existe : " + id));

		// Obtener el nuevo valor de valor_inv del cuerpo de la solicitud
		double nuevoValorInv = productoRequest.getValor_inv();
		// Obtener el nuevo valor de valor_sup del cuerpo de la solicitud
		double nuevoValorSup = productoRequest.getValor_sup();

		// Establecer el nuevo valor_inv en el producto
		producto.setValor_inv(nuevoValorInv);
		producto.setValor_sup(nuevoValorSup);

		// Actualizar los demás campos del producto
		producto.setNombre_pro(productoRequest.getNombre_pro());
		producto.setDesc_pro(productoRequest.getDesc_pro());
		producto.setMarca_pro(productoRequest.getMarca_pro());
		producto.setModelo_pro(productoRequest.getModelo_pro());
		producto.setEn_prenda(productoRequest.isEn_prenda());
		producto.setActivo_pro(productoRequest.isActivo_pro());

		// Guardar el producto actualizado en la base de datos
		Producto productoActualizado = productoRepository.save(producto);

		return ResponseEntity.ok(productoActualizado);
	}

	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El Producto con ese ID no existe : " + id));
		productoRepository.delete(producto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}
