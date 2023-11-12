package ActividadFinalEv1;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("pais")
public class PaisSerializable implements Serializable {
    private String region;
    private String nombre_pais;
    private String presidente;
    private String pib;
    private String gini;
    public PaisSerializable() {
        // Constructor vacío necesario para XStream
    }

    public PaisSerializable(String region, String nombre, String presidente, String pib, String gini) {
        this.region = region;
        this.nombre_pais = nombre;
        this.presidente = presidente;
        this.pib = pib;
        this.gini = gini;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getGini() {
        return gini;
    }

    public void setGini(String gini) {
        this.gini = gini;
    }

    @Override
    public String toString() {
        return "PaisSerializable{" +
                "region='" + region + '\'' +
                ", nombre='" + nombre_pais + '\'' +
                ", presidente='" + presidente + '\'' +
                ", pib=" + pib +
                ", gini=" + gini +
                '}';
    }
}
