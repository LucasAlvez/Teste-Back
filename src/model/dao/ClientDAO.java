package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Client;

/**
 *
 * @author Lucas Alves
 */
public class ClientDAO {

    private Connection con = null;

    public ClientDAO() {
        con = ConnectionFactory.getConnection();
    }

    // Insere clientes no banco
    public boolean save(Client client) {

        String sql = "INSERT INTO tb_customer_account (id_customer, nm_customer, cpf_cnpj, is_active, vl_total) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getCpf_cnpj());
            stmt.setString(4, client.getStatus()+"");
            stmt.setDouble(5, client.getTotalBalance());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Busca todos os clientes di banco
    public List<Client> findAll() {

        String sql = "SELECT * FROM tb_customer_account";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Client> clientList = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Client client = new Client();

                client.setId(rs.getInt("id_customer"));
                client.setName(rs.getString("nm_customer"));
                client.setCpf_cnpj(rs.getString("cpf_cnpj"));
                client.setStatus(rs.getString("is_active").charAt(0));
                client.setTotalBalance(rs.getDouble("vl_total"));
                clientList.add(client);
            }

            ConnectionFactory.closeConnection(con, stmt, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar clientes: " + ex);
        }

        return clientList;
    }

    // Busca os clientes que seguem as regras do teste
    public List<Client> findRule() {

        String sql = "SELECT * FROM tb_customer_account WHERE id_customer >= 1500 AND id_customer <= 2700 AND vl_total > 560 ORDER BY vl_total DESC";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Client> clientList = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Client client = new Client();

                client.setId(rs.getInt("id_customer"));
                client.setName(rs.getString("nm_customer"));
                client.setCpf_cnpj(rs.getString("cpf_cnpj"));
                client.setStatus(rs.getString("is_active").charAt(0));
                client.setTotalBalance(rs.getDouble("vl_total"));
                clientList.add(client);
            }

            ConnectionFactory.closeConnection(con, stmt, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar clientes da regra: " + ex);
        }

        return clientList;
    }

    // Calcula a media da coluna vl_total seguindo as regras do teste
    public Double findAverage() {
        String sql = "SELECT AVG(vl_total) AS Media FROM tb_customer_account WHERE id_customer >= 1500 AND id_customer <= 2700 AND vl_total > 560 ORDER BY vl_total";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double media = 0;

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                media = rs.getDouble("Media");
            }

            ConnectionFactory.closeConnection(con, stmt, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar a media: " + ex);
        }

        return media;
    }

}
