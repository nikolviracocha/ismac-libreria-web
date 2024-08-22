
package com.distribuida.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDAO;
import com.distribuida.dao.CategoriaDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.entities.Libro;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	@Qualifier("autorDAOImpl")
	private AutorDAO autorDAO;
	
	@GetMapping("/findAll")
	public String findAll(ModelMap modelMap) {
		List<Libro> libros = libroDAO.findALL();
		modelMap.addAttribute("libros", libros);
		return "libros-listar";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idLibro") @Nullable Integer idLibro,
	                      @RequestParam("opcion") @Nullable Integer opcion,
	                      ModelMap modelMap) {
		if (idLibro != null) {
			Libro libro = libroDAO.findOne(idLibro);
			modelMap.addAttribute("libro", libro);
		}
		
		modelMap.addAttribute("autores", autorDAO.findALL());
		modelMap.addAttribute("categorias", categoriaDAO.findALL());
		
		if (opcion != null && opcion == 1) {
			return "libros-add";
		} else {
			return "libros-del";
		}
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idLibro") @Nullable Integer idLibro,
	                  @RequestParam("titulo") @Nullable String titulo,
	                  @RequestParam("editorial") @Nullable String editorial,
	                  @RequestParam("numPaginas") @Nullable Integer numPaginas,
	                  @RequestParam("edicion") @Nullable String edicion,
	                  @RequestParam("idioma") @Nullable String idioma,
	                  @RequestParam("fechaPublicacion") @Nullable @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaPublicacion,
	                  @RequestParam("descripcion") @Nullable String descripcion,
	                  @RequestParam("tipoPasta") @Nullable String tipoPasta,
	                  @RequestParam("ISBN") @Nullable String ISBN,
	                  @RequestParam("numEjemplares") @Nullable Integer numEjemplares,
	                  @RequestParam("portada") @Nullable String portada,
	                  @RequestParam("presentacion") @Nullable String presentacion,
	                  @RequestParam("precio") @Nullable Double precio,
	                  @RequestParam("idCategoria") @Nullable Integer idCategoria,
	                  @RequestParam("idAutor") @Nullable Integer idAutor) {
		
		if (idLibro == null) {
			Libro libro = new Libro(0, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion, descripcion, tipoPasta, ISBN, numEjemplares, portada, presentacion, precio);
			libro.setCategoria(categoriaDAO.findOne(idCategoria));
			libro.setAutor(autorDAO.findOne(idAutor));
			libroDAO.add(libro);
		} else {
			Libro libro = new Libro(idLibro, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion, descripcion, tipoPasta, ISBN, numEjemplares, portada, presentacion, precio);
			libro.setCategoria(categoriaDAO.findOne(idCategoria));
			libro.setAutor(autorDAO.findOne(idAutor));
			libroDAO.up(libro);
		}
		
		return "redirect:/libros/findAll";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("idLibro") @Nullable Integer idLibro) {
		if (idLibro != null) {
			libroDAO.del(idLibro);
		}
		return "redirect:/libros/findAll";
	}
}
