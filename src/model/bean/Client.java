package model.bean;

/**
 *
 * @author Lucas Alves
 */
public class Client {

    private int id;
    private String name;
    private String cpf_cnpj;
    private char status;
    private double totalBalance;

    public Client(int id, String name, String cpf_cnpj, char status, double totalBalance) {
        this.id = id;
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.status = status;
        this.totalBalance = totalBalance;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

}
