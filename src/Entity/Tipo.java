package Entity;

public class Tipo {
    
    private int codigo;
    
    private String tipo;
    
    
    public Tipo(int codigo) {
        this.codigo = codigo;
        if (codigo == 1) {
            this.tipo = "3D";
        } else if (codigo == 2) {
            this.tipo = "35mm";
        } else if (codigo == 3) {
            this.tipo = "GENERAL";
        } else if (codigo == 4) {
            this.tipo = "PREFERENCIAL";
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Tipo(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
    
    

}
