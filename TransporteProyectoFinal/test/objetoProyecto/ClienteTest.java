/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoProyecto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gustavo
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Cliente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigoCliente method, of class Cliente.
     */
    @Test
    public void testGetCodigoCliente() {
        System.out.println("getCodigoCliente");
        Cliente instance = new Cliente();
        instance.setCodigoCliente("123");
        String expResult = "123";
        String result = instance.getCodigoCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigoCliente method, of class Cliente.
     */
    @Test
    public void testSetCodigoCliente() {
        System.out.println("setCodigoCliente");
        String codigoCliente = "1234";
        Cliente instance = new Cliente();
        instance.setCodigoCliente(codigoCliente);
        assertEquals(instance.getCodigoCliente(), codigoCliente);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombres method, of class Cliente.
     */
    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        Cliente instance = new Cliente();
        instance.setNombres("nombre 1");
        String expResult = "nombre 1";
        String result = instance.getNombres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombres method, of class Cliente.
     */
    @Test
    public void testSetNombres() {
        System.out.println("setNombres");
        String nombres = "zxc";
        Cliente instance = new Cliente();
        instance.setNombres(nombres);
        assertEquals(nombres, instance.getNombres());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidos method, of class Cliente.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Cliente instance = new Cliente();
        String expResult = "aaa";
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidos method, of class Cliente.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = "";
        Cliente instance = new Cliente();
        instance.setApellidos(apellidos);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Cliente instance = new Cliente();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Cliente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Cliente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Cliente instance = new Cliente();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class Cliente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class Cliente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Cliente instance = new Cliente();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getCedula method, of class Cliente.
     */
    @Test
    public void testGetCedula() {
        System.out.println("getCedula");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCedula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCedula method, of class Cliente.
     */
    @Test
    public void testSetCedula() {
        System.out.println("setCedula");
        String cedula = "";
        Cliente instance = new Cliente();
        instance.setCedula(cedula);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}