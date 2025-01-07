package com.edutecno.springSec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.springSec.model.Producto;
import com.edutecno.springSec.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	ProductoService servicio;

	private Producto producto;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listado", servicio.findAll());
		return "producto";
	}

	@PostMapping("/agregar_producto")
	public String nuevo(@ModelAttribute Producto producto) {
		int precio = producto.getPrecio();
		producto.setPrecio(precio);
		servicio.create(producto);
		return "redirect:/productos/listar";
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView eliminar(@PathVariable Integer id) {

		servicio.delete(id);
		return new RedirectView("/productos/listar");
	}

	@GetMapping("/modificar_producto/{id}")
	public RedirectView modificarLibro(@PathVariable Integer id) {

		for (Producto temp : servicio.findAll()) {
			if (temp.getId() == id) {
				producto = temp;

				return new RedirectView("productos/listar_2");
			}
		}

		return new RedirectView("/productos/listar");
	}

	@GetMapping("/listar_2")
	public String listarDos(Model model) {
		
		model.addAttribute("objeto", producto);
		return "update";
	}

	@PostMapping("/modificar")
	public RedirectView update(@ModelAttribute Producto producto) {
		int precio = producto.getPrecio();
		producto.setPrecio(precio);
		producto.setId(producto.getId());
		producto = null;

		servicio.update(producto);
		return new RedirectView("/productos/listar");
	}

}
