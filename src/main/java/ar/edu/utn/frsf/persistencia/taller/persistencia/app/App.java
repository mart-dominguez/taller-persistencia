/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.persistencia.taller.persistencia.app;

import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.Alumno;
import ar.edu.utn.frsf.persistencia.taller.persistencia.modelo.CursoGeneral;
import ar.edu.utn.frsf.persistencia.taller.persistencia.service.AlumnoService;
import ar.edu.utn.frsf.persistencia.taller.persistencia.service.AlumnoServiceImpl;
import ar.edu.utn.frsf.persistencia.taller.persistencia.service.CursoService;
import ar.edu.utn.frsf.persistencia.taller.persistencia.service.CursoServiceImpl;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class App {
    
    public static void main (String[] args){
    
        AlumnoService aluSrv= new AlumnoServiceImpl();
        Alumno alu = new Alumno();
        alu.setNombre("Jesse Pinkman");
        alu.setNroLegajo(123456);
        aluSrv.nuevoAlumno(alu);
        Alumno alu2 = new Alumno();
        alu2.setNombre("Walter White");
        alu.setNroLegajo(987654);
        aluSrv.nuevoAlumno(alu2);
        List<Alumno> listaAlumnos = aluSrv.listaAlumnos();
        for(Alumno unAlumno : listaAlumnos){
            System.out.println(unAlumno.getId()+" : "+unAlumno.getNombre()+" : "+unAlumno.getNroLegajo());
        }
        
        CursoService cursoSrv= new CursoServiceImpl();
        CursoGeneral curso = new CursoGeneral();
        curso.setNombre("Quimica basica");
        curso.setCupoMaximo(3);
        curso.setCreditos(5);
        cursoSrv.nuevoCurso(curso);

        cursoSrv.inscribirAlumno(curso, alu);
        
        cursoSrv.cargarInscriptos(curso);
        System.out.println("Alumnos inscriptos");
        for(Alumno unAlumno : curso.getAlumnos()){
            System.out.println(unAlumno.getNombre()+" : "+unAlumno.getNroLegajo());
        }
        
    }
}
