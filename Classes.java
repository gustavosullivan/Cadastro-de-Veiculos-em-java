public class Classes {
    class Veiculo{
         private String marca;
         private String modelo;
         private int ano;
         private String placa;
        
    public Veiculo() {
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.placa = "";
        }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public int getAno() {
        return ano;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String toString(){
        return "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Placa: "+ placa;
    }


    }
}