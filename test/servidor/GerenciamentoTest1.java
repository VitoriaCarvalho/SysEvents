/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitoria
 */
public class GerenciamentoTest1 {
    /**
     * Test of BuscarUmEvento method, of class Gerenciamento.
     */
    @Test
    public void testBuscarUmEvento() throws Exception {
        System.out.println("BuscarUmEvento");
        String codEvento = "1201";
        Gerenciamento instance = new Gerenciamento();
        // codEvento,titulo,dataEvento,valorInscricao,descricao
        String expResult = "1201,Geek day,10/10/2018,15.90,Um evento bem legal\n";
        String result = instance.BuscarUmEvento(codEvento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BuscarDadosEventoUsuario method, of class Gerenciamento.
     */
    @Test
    public void testBuscarDadosEventoUsuario() throws Exception {
        System.out.println("BuscarDadosEventoUsuario");
        String dados = "1201,vitoriiacb@gmail.com";
        Gerenciamento instance = new Gerenciamento();
        // titulo,valorInscricao,nome,cpf,email,dataNasc
        String expResult = "Geek day,15.90,Vitória,05173598395,vitoriiacb@gmail.com,29/11/1998\n";
        String result = instance.BuscarDadosEventoUsuario(dados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BuscarMinicursoDeEvento method, of class Gerenciamento.
     */
    @Test
    public void testBuscarMinicursoDeEvento() throws Exception {
        System.out.println("BuscarMinicursoDeEvento");
        String codEvento = "1201";
        Gerenciamento instance = new Gerenciamento();
        // codMinicurso,tituloMinicurso,dataMinicurso,horarioMinicurso,valorMinicurso,ministrante
        String expResult = "100,Programação Funcional,12/12/2018,12:00,12,Pedro%\n";
        String result = instance.BuscarMinicursoDeEvento(codEvento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BuscarMinhasInscricoes method, of class Gerenciamento.
     */
    @Test
    public void testBuscarMinhasInscricoes() throws Exception {
        System.out.println("BuscarMinhasInscricoes");
        String email = "vitoriiacb@gmail.com";
        Gerenciamento instance = new Gerenciamento();
        String expResult = "6052,Geek day,10/10/2018,15.90%"
                + "6431,Dia do esporte,10/12/2018,50%\n";
        String result = instance.BuscarMinhasInscricoes(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BuscarDadosMinhaInscricao method, of class Gerenciamento.
     */
    @Test
    public void testBuscarDadosMinhaInscricao() throws Exception {
        System.out.println("BuscarDadosMinhaInscricao");
        String dados = "6052,vitoriiacb@gmail.com";
        Gerenciamento instance = new Gerenciamento();
        String expResult = "1201,Geek day,10/10/2018,Um evento bem legal,"
                + "Vitória,05173598395,vitoriiacb@gmail.com,29/11/1998\n";
        String result = instance.BuscarDadosMinhaInscricao(dados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BuscarDescMinicursos method, of class Gerenciamento.
     */
    @Test
    public void testBuscarDescMinicursos() throws Exception {
        System.out.println("BuscarDescMinicursos");
        String dados = "7548,11111111111";
        Gerenciamento instance = new Gerenciamento();
        String expResult = "9,9%\n";
        String result = instance.BuscarDescMinicursos(dados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BuscarMeuPerfil method, of class Gerenciamento.
     */
    @Test
    public void testBuscarMeuPerfil() throws Exception {
        System.out.println("BuscarMeuPerfil");
        String email = "vitoriiacb@gmail.com";
        Gerenciamento instance = new Gerenciamento();
        String expResult = "Vitória,05173598395,29/11/1998,vitoriiacb@gmail.com,Campo Grande\n";
        String result = instance.BuscarMeuPerfil(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
