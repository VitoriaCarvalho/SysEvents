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
public class GerenciamentoTest {
    
//    /**
//     * Test of FazerLogin method, of class Gerenciamento.
//     */
//    @Test
//    public void testFazerLogin() throws Exception {
//        System.out.println("FazerLogin");
//        String texto = "vitoriiacb@gmail.com,123";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "user\n";
//        String result = instance.FazerLogin(texto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of CadastrarUsuario method, of class Gerenciamento.
//     */
//    @Test
//    public void testCadastrarUsuario() throws Exception {
//        System.out.println("CadastrarUsuario");
//        //texto = Vitória,05173598395,29/11/1998,vitoriiacb@gmail.com,123,Campo Grande
//        String texto = "Jederson Luz,06601519367,18/02/1997,jedersonalpha@gmail.com,123,Junco";
//        Gerenciamento instance = new Gerenciamento();
//        instance.CadastrarUsuario(texto);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of CadastrarEvento method, of class Gerenciamento.
//     */
//    @Test
//    public void testCadastrarEvento() throws Exception {
//        System.out.println("CadastrarEvento");
////      titulo,data,valor,descricao
//        String texto = "Game Jam,09/01/2019,10,Evento de desenvolvimento de games";
//        Gerenciamento instance = new Gerenciamento();
//        instance.CadastrarEvento(texto);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of CadastrarMinicurso method, of class Gerenciamento.
//     */
//    @Test
//    public void testCadastrarMinicurso() throws Exception {
//        System.out.println("CadastrarMinicurso");
//        // titulo,data,horario,valor,ministrante
//        String texto = "Blender,12/02/2019,14:00,10,Cínthia";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "true\n";
//        MinicursosDAO.codUltimoEventoInserido = "1201";
//        String result = instance.CadastrarMinicurso(texto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarEventos method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarEventos() throws Exception {
//        System.out.println("BuscarEventos");
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "1201,Geek day,10/10/2018,15.90,Um evento bem legal%"
//                + "7548,Dia do esporte,10/12/2018,35,uhwdeygwhvdhveygcedhb%"
//                + "9596,SINFO,10/10/2018,15,Simpósio de Sistemas de Informação%\n";
//        String result = instance.BuscarEventos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarInscritos method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarInscritos() throws Exception {
//        System.out.println("BuscarInscritos");
//        String codEvento = "7548";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "05173598395,Vitória,Campo Grande,vitoriiacb@gmail.com%"
//                + "11111111111,Joãozinho,Picos - PI,joaozinho@gmail.com%\n";
//        String result = instance.BuscarInscritos(codEvento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of ExcluirEvento method, of class Gerenciamento.
//     */
//    @Test
//    public void testExcluirEvento() throws Exception {
//        System.out.println("ExcluirEvento");
//        // insert into eventos (codEvento,titulo,dataEvento,valorInscricao,descricao) values('0101','Teste','10/10/2019','25','Evento teste');
//        String codEvento = "0101";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "true\n";
//        String result = instance.ExcluirEvento(codEvento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of EditarEvento method, of class Gerenciamento.
//     */
//    @Test
//    public void testEditarEvento() throws Exception {
//        System.out.println("EditarEvento");
//        //texto = codEvento,titulo,dataEvento,valorInscricao,descricao
//        String dados = "7548,Start-Up,10/02/2019,15,Evento de empreendedorismo";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "true\n";
//        String result = instance.EditarEvento(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarUmEvento method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarUmEvento() throws Exception {
//        System.out.println("BuscarUmEvento");
//        String codEvento = "1201";
//        Gerenciamento instance = new Gerenciamento();
//        // codEvento,titulo,dataEvento,valorInscricao,descricao
//        String expResult = "1201,Geek day,10/10/2018,15.90,Um evento bem legal\n";
//        String result = instance.BuscarUmEvento(codEvento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarDadosEventoUsuario method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarDadosEventoUsuario() throws Exception {
//        System.out.println("BuscarDadosEventoUsuario");
//        String dados = "1201,vitoriiacb@gmail.com";
//        Gerenciamento instance = new Gerenciamento();
//        // titulo,valorInscricao,nome,cpf,email,dataNasc
//        String expResult = "Geek day,15.90,Vitória,05173598395,vitoriiacb@gmail.com,29/11/1998\n";
//        String result = instance.BuscarDadosEventoUsuario(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
/** 
 * Estava aqui. 
 * Ideia: Separar testes de pesquisa num arquivo diferente que deve ser rodado primeiro para
 * evitar imprevisibilidade nas pesquisas.
 **/
//    /**
//     * Test of BuscarMinicursoDeEvento method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarMinicursoDeEvento() throws Exception {
//        System.out.println("BuscarMinicursoDeEvento");
//        String codEvento = "1201";
//        Gerenciamento instance = new Gerenciamento();
//        // codMinicurso,tituloMinicurso,dataMinicurso,horarioMinicurso,valorMinicurso,ministrante
//        String expResult = "100,Programação Funcional,12/12/2018,12:00,12,Pedro%\n";
//        String result = instance.BuscarMinicursoDeEvento(codEvento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of adicionarMinicurso method, of class Gerenciamento.
//     */
//    @Test
//    public void testAdicionarMinicurso() throws Exception {
//        System.out.println("adicionarMinicurso");
//        String dados = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.adicionarMinicurso(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of AdicionarInscricao method, of class Gerenciamento.
//     */
//    @Test
//    public void testAdicionarInscricao() throws Exception {
//        System.out.println("AdicionarInscricao");
//        String texto = "";
//        Gerenciamento instance = new Gerenciamento();
//        instance.AdicionarInscricao(texto);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarMinhasInscricoes method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarMinhasInscricoes() throws Exception {
//        System.out.println("BuscarMinhasInscricoes");
//        String email = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.BuscarMinhasInscricoes(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarDadosMinhaInscricao method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarDadosMinhaInscricao() throws Exception {
//        System.out.println("BuscarDadosMinhaInscricao");
//        String dados = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.BuscarDadosMinhaInscricao(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarDescMinicursos method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarDescMinicursos() throws Exception {
//        System.out.println("BuscarDescMinicursos");
//        String dados = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.BuscarDescMinicursos(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of BuscarMeuPerfil method, of class Gerenciamento.
//     */
//    @Test
//    public void testBuscarMeuPerfil() throws Exception {
//        System.out.println("BuscarMeuPerfil");
//        String email = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.BuscarMeuPerfil(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of ExcluirUsuario method, of class Gerenciamento.
//     */
//    @Test
//    public void testExcluirUsuario() throws Exception {
//        System.out.println("ExcluirUsuario");
//        String cpf = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.ExcluirUsuario(cpf);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of EditarPerfil method, of class Gerenciamento.
//     */
//    @Test
//    public void testEditarPerfil() throws Exception {
//        System.out.println("EditarPerfil");
//        String dados = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.EditarPerfil(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of VerificarSeJaSeInscreveu method, of class Gerenciamento.
//     */
//    @Test
//    public void testVerificarSeJaSeInscreveu() throws Exception {
//        System.out.println("VerificarSeJaSeInscreveu");
//        String dados = "";
//        Gerenciamento instance = new Gerenciamento();
//        String expResult = "";
//        String result = instance.VerificarSeJaSeInscreveu(dados);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
}
