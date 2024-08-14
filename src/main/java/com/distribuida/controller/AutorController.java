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

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

@Controller
@RequestMapping("/autores")                 //path principal
public class AutorController {
	
	
	// JSP .- Java Server Page, son las paginas web de tecnologia 
		@Autowired
		private AutorDAO autorDAO;
		
		
		@GetMapping("/findAll")  		//path secundario
		public String findAll (Model model ) {
			
			
			//try {
			
			List<Autor> autores = autorDAO.findALL();
			
			model.addAttribute("autores", autores);
			
			return "listar-autores" ;  //Esto es el nombre del formulario 
			
//			}catch (Exception e) {
//			//TODO: handle exception
//			e.printStackTrace();
//		  }
		
		}
		
		@GetMapping("/findOne")
		public String findOne(@RequestParam("idAutor") @Nullable Integer idAutor
							 ,@RequestParam("opcion") @Nullable Integer opcion
							 ,Model model
				) {
			//try {

			if(idAutor != null) {
				Autor autor = autorDAO.findOne(idAutor);
				model.addAttribute("autor", autor);	
			}
			
			if(opcion ==1) return "add-autores";
			else return "del-autores";

//			}catch (Exception e) {
//			//TODO: handle exception
//			e.printStackTrace();
//		  }
		}
		
		@PostMapping("/add")
		public String add(@RequestParam("idAutor")@Nullable Integer idAutor
						,@RequestParam("cedula")@Nullable String cedula
						,@RequestParam("nombre")@Nullable String nombre
						,@RequestParam("apellido")@Nullable String apellido
						,@RequestParam("direccion")@Nullable String direccion
						,@RequestParam("telefono")@Nullable String telefono
						,@RequestParam("correo")@Nullable String correo
						, Model model 
				) {
			
			//try {

			if(idAutor == null) {
			Autor autor = new Autor(0, cedula, nombre, apellido, direccion, telefono, correo);
			autorDAO.add(autor);
			
			}else {
				
			Autor autor2 = new Autor(idAutor, cedula, nombre, apellido, direccion, telefono, correo);
			autorDAO.up(autor2);	
			}
			return "redirect:/autores/findAll";
			
//			}catch (Exception e) {
//			//TODO: handle exception
//		  }
		
		}
		

		//try {

		@GetMapping ("/del")
		public String del(@RequestParam("idAutor")@Nullable Integer idAutor) {
			
			autorDAO.del(idAutor);
			return "redirect:/Autor/finAll";
			
//			}catch (Exception e) {
//			//TODO: handle exception
//		  }
		
		}
		
	}






