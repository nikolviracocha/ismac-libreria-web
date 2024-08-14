package com.distribuida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.Factura_detalleDAO;
import com.distribuida.dao.LibroDAO;

@Controller
@RequestMapping("/Facturacion")

public class FacturacionController {
	
	@Autowired
	private ClienteDAO ClienteDAO;
	
	@Autowired
	private LibroDAO LibroDAO;
	
	@Autowired
	private FacturaDAO FacturaDAO;
	
	@Autowired
	private Factura_detalleDAO factura_DetalleDAO;


	@GetMapping("/prinpal")
	public String principal() {
		return "principal";
	}
	
	@GetMapping("findAll")
	public String findAll(ModelMap modelMAl) {
		
		return "facturacion-listar";
	}
	
	@GetMapping("/findOneFactura")
	public String findOne(@RequestParam("idFactura") @Nullable Integer idFactura
						,ModelMap modelMap) {
	
	modelMap.addAttribute("factura", FacturaDAO.findOne(idFactura));
	
	return "facturacion-listar";
	
}
	@GetMapping("/findOneCliente")
	public String findOneCliente(@RequestParam("idCliente") @Nullable Integer idCliente
						,ModelMap modelMAp) {
		modelMAp.addAttribute("cliente", ClienteDAO.findOne(idCliente));

			return "redirect:/factruacion2/principal";
}
}


