package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;

@Controller
@RequestMapping("/Categoria")                 //path principal
public class CategoriaController {
	
	
	/// JSP .- Java Server Page, son las paginas web de tecnologia 
	@Autowired
	private CategoriaDAO CategoriaDAO;
	
	
	@GetMapping("/findAll")  		//path secundario
	public String findAll (Model model ) {
		
		
		//try {
		
		List<Categoria> Categorias = CategoriaDAO.findALL();
		
		model.addAttribute("Categorias", Categorias);
		
		return "listar-Categorias" ;  //Esto es el nombre del formulario 
		
//		}catch (Exception e) {
//		//TODO: handle exception
//		e.printStackTrace();
//	  }
	
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCategoria") @Nullable Integer idCategoria
						 ,@RequestParam("opcion") @Nullable Integer opcion
						 ,Model model
			) {
		//try {

		if(idCategoria != null) {
			Categoria Categoria = CategoriaDAO.findOne(idCategoria);
			model.addAttribute("Categoria", Categoria);	
		}
		
		if(opcion ==1) return "add-Categorias";
		else return "del-Categorias";

//		}catch (Exception e) {
//		//TODO: handle exception
//		e.printStackTrace();
//	  }
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idcategoria")@Nullable Integer idcategoria
					,@RequestParam("categoria")@Nullable String Categoria
					, Model model 
			) {
		
		//try {

		if(idcategoria == null) {
			Categoria categoria1 = new Categoria();
		CategoriaDAO.add(categoria1);
		
		}else {
			
			Categoria Categoria2 = new Categoria();
		CategoriaDAO.up(Categoria2);	
		}
		return "redirect:/Categorias/findAll";
		
//		}catch (Exception e) {
//		//TODO: handle exception
//	  }
	
	}
	

	//try {

	@GetMapping ("/del")
	public String del(@RequestParam("idCategoria")@Nullable Integer idcategoria) {
		
		CategoriaDAO.del(idcategoria);
		return "redirect:/Categorias/finAll";
		
//		}catch (Exception e) {
//		//TODO: handle exception
//	  }
	
	}
	
}






