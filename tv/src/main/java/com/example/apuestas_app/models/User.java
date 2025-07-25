package com.example.apuestas_app.models;

public class User {
    private String nombre;
    private Double saldo = 1000.0;

    public User(){}

    public User(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    // Método para apostar
    public boolean apostar(Double cantidadApostar, boolean gano, Double gananciaAdicional){
        // 1. Verificar que el usuario tenga la cantidad de dinero
       /* if(cantidadApostar <= 0){
            System.out.println("Error: La cantidad de apostar debe ser mayor");
            return false;
        }*/

        // Si saldo es menor que la cantidad apostada, no puede apostar
        if(saldo < cantidadApostar){
            System.out.println("Saldo insuficiente. Tienes "+ saldo + "pesos y quieres apostar "+ cantidadApostar + "pesos.");
            return false;
        }

        // Se resta la cantidad apostada al inicio
        this.saldo -= cantidadApostar;
        System.out.println("Has apostado " + cantidadApostar + "pesos. Saldo actual: " + this.saldo);

        // Si gano se le devuelve la cantidad apostada y la ganancia, si perdio se le resta la cantidad apostada a su saldo inicial
        if(gano){
            this.saldo += (cantidadApostar + gananciaAdicional);
            System.out.println("Ganaste: " + gananciaAdicional);
        } else{
            System.out.println("Has perdido. Nuevo saldo: "+ this.saldo);
        }
        return true;
    }

    public void recargarSaldo(Double cantidad){
        this.saldo += cantidad;
        System.out.println("Saldo recargado. Nuevo saldo:  "+ this.saldo);
    }

}
