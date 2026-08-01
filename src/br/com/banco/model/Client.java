package br.com.banco.model;

import java.time.LocalDate;

public class Client {

    private String name;
    private String cpf;
    private final LocalDate dateOfBirth;
    private String telephoneNumber;
    private String email;

    public Client(String name, String cpf, LocalDate dateOfBirth, String telephoneNumber, String email) {
        this.name = name;

        if (isValidCpf(cpf)){
            this.cpf = cpf;
        }else {
            throw new IllegalArgumentException("CPF invalido");
        }

        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private boolean isValidCpf(String cpf) {
    }

    @Override public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", dateOfBirth=" + dateOfBirth +
                ", telephoneNumber=" + telephoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
