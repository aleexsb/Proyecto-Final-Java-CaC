/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import modelo.Persona;

/**
 *
 * @author Alex
 */
public interface CRUD { //DEFINIMOS LOS METODOS DEL PROYECTO - PERSONADAO LOS IMPLEMENTA
    public List listar();
    public Persona list(int id);
    public boolean add(Persona per);
    public boolean edit(Persona per);
    public boolean eliminar(int id);
    
}
