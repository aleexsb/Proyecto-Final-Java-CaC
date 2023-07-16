/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDao;

import config.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author Alex
 */
public class PersonaDao implements CRUD { //IMPLEMENTACION DE LOS METODOS - VA A HACER LA CONSULTA A LA BASE DE DATOS

    //Instanacias    
    Conexion cn = new Conexion();
    Connection con; // 
    PreparedStatement ps; //EJECUTA LA CONSULTA
    ResultSet rs; //PERMITE VER LOS RESULTADOS DE LA CONSULTA
    Persona p = new Persona();

    @Override
    public List listar() {
        ArrayList<Persona> list = new ArrayList();
        String sql = "select * from persona";
        try {
            con = cn.getConnection(); //LEVANTA LA CONEXION
            ps = con.prepareStatement(sql); //PREPARA LA CONSULTA
            rs = ps.executeQuery(); //EJECUTA LA CONSULTA
            while (rs.next()) { //ESTE WHILE RECORRE LA TABLA X FILA
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setDni(rs.getString("dni"));
                persona.setNom(rs.getString("nombres"));
                //agregar a la lista
                list.add(persona); //TODAS LAS TABLAS VAN DENTRO DEL ARRAY LIST                           
            }
        } catch (Exception e) {

        }
        return list; //LIST ES EL ARRAY 
    }

    @Override
    public Persona list(int id) {
        String sql = "select * from persona where id =" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) { //ESTE WHILE RECORRE LA TABLA X FILA
                p.setId(rs.getInt("id"))  ;              
                p.setDni(rs.getString("dni"));
                p.setNom(rs.getString("nombres"));
                                         
            }
        } catch (Exception e) {
        }
        return p;

    }

    @Override
    public boolean add(Persona per) {
        String sql = "insert into persona(dni,nombres)values('" + per.getDni() + "','" + per.getNom() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql = "update persona set dni = '" + per.getDni() + "',nombres='" + per.getNom() + "'where id="+per.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
            }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from persona where id = " + id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
        return false;
        }

}
