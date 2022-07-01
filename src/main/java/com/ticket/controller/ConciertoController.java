/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticket.controller;

/**
 *
 * @author Diana Jiménez
 */
import com.ticket.entity.Concierto;
import com.ticket.entity.Lugar;
import com.ticket.service.IConciertoService;
import com.ticket.service.ILugarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConciertoController {

    @Autowired
    private IConciertoService conciertoService;

    @Autowired
    private ILugarService lugarService;

    @GetMapping("/concierto")
    public String index(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("titulo", "Tabla Conciertos");
        model.addAttribute("conciertos", listaConcierto);
        return "conciertos";
    }

    @GetMapping("/conciertoN")
    public String crearConcierto(Model model) {
        List<Lugar> listaLugares = lugarService.listEvento();
        model.addAttribute("concierto", new Concierto());
        model.addAttribute("lugares", listaLugares);
        return "crear";
    }

    @PostMapping("/save")
    public String guardarConcierto(@ModelAttribute Concierto concierto) {
        conciertoService.saveConcierto(concierto);
        return "redirect:/concierto";
    }

    @GetMapping("/editConcierto/{id}")
    public String editarConcierto(@PathVariable("id") Long idConcierto, Model model) {
        Concierto concierto = conciertoService.getConciertoById(idConcierto);
        List<Lugar> listaLugares = lugarService.listEvento();
        model.addAttribute("concierto", concierto);
        model.addAttribute("lugares", listaLugares);
        return "crear";
    }
    @GetMapping("/delete/{id}")
    public String eliminarConcierto(@PathVariable("id") Long idConcierto) {
      conciertoService.delete(idConcierto);
        return "redirect:/concierto";
    }
}
