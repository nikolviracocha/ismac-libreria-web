package com.distribuida.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	@Qualifier("autorDAOImpl")
	private AutorDAO autorDAO;
	
	@GetMapping("/findAll")
	private String findAll(ModelMap modelMap) {
		
		List<Libro> libros = libroDAO.findALL();
		modelMap.addAttribute("libros",libros);
		
		return "libros-listar";
	}
	
	@GetMapping("/findOne")
	private String findOne(@RequestParam ("idLibro") @Nullable Integer idLibro
			              ,@RequestParam ("option") @Nullable Integer option
			              ,ModelMap modelMap
			
			
			) {
		if (idLibro !=null) {
			Libro libro= libroDAO.findOne(idLibro);
			modelMap.addAttribute("libro",libro);
			
		}
		
		modelMap.addAttribute("autores", autorDAO.findALL());
		modelMap.addAttribute("categorias", categoriaDAO.findALL());
		
			if(option == 1) return "add-libros";
			else return "del-libros";
	}
	
	@PostMapping("/add")
	private String add(@RequestParam ("idLibro") @Nullable Integer idLibro
			       ,@RequestParam ("titulo") @Nullable String titulo
			       ,@RequestParam ("editorial") @Nullable String editorial
			       ,@RequestParam ("numPaginas") @Nullable Integer numPaginas
			       ,@RequestParam ("edicion") @Nullable String edicion
			       ,@RequestParam ("idioma") @Nullable String idioma
			       ,@RequestParam ("fechaPublicacion") @Nullable Date fechaPublicacion
			       ,@RequestParam ("descripcion") @Nullable String descripcion
			       ,@RequestParam ("tipoPasta") @Nullable String tipoPasta
			       ,@RequestParam ("ISBN") @Nullable String ISBN
			       ,@RequestParam ("numEjemplares") @Nullable Integer numEjemplares
			       ,@RequestParam ("portada") @Nullable String portada
			       ,@RequestParam ("presentacion") @Nullable String presentacion
			       ,@RequestParam ("precio") @Nullable Double precio
			       ,@RequestParam ("id_categoria") @Nullable Integer id_categoria
			       ,@RequestParam ("id_autor") @Nullable Integer id_autor
			       ,ModelMap modelMap
			) {
		
		if (idLibro == null) {
			Libro libro = new Libro(0,titulo,editorial,numPaginas,edicion,idioma,fechaPublicacion,descripcion,tipoPasta,ISBN,numEjemplares,portada,presentacion,precio);
			libro.setCategoria(categoriaDAO.findOne(id_categoria));
			libro.setAutor(autorDAO.findOne(id_autor));
			
			libroDAO.add(libro);	
			
		}else {
			
			Libro libro = new Libro(idLibro,titulo,editorial,numPaginas,edicion,idioma,fechaPublicacion,descripcion,tipoPasta,ISBN,numEjemplares,portada,presentacion,precio);
			libro.setCategoria(categoriaDAO.findOne(id_categoria));
			libro.setAutor(autorDAO.findOne(id_autor));
			
			libroDAO.up(libro);
			
		}
		
		return "redirect:/libros/libros-listar";
		
	}
	
	@GetMapping ("/del")
	public String del(@RequestParam("idLibro") @Nullable Integer idLibro) {
		 libroDAO.del(idLibro);
		return "redirect:/libros/libros-listar";
	}

}
