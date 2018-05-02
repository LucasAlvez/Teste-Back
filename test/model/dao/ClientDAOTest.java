/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Client;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Alves
 */
public class ClientDAOTest {

    public ClientDAOTest() {
    }

    @Test
    public void save() {
        Client client = new Client(1, "teste", "12345678910", 's', 561);
        ClientDAO dao = new ClientDAO();

        if (dao.save(client)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }

}
