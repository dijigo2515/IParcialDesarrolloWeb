/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticket.service;

/**
 *
 * @author Diana Jiménez
 */
import com.ticket.entity.Lugar;
import com.ticket.repository.LugarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LugarService implements ILugarService {
    
    @Autowired
    private LugarRepository lugarRepository;
    
    @Override
    public List<Lugar> listEvento(){
        return (List<Lugar>)lugarRepository.findAll();}
}
