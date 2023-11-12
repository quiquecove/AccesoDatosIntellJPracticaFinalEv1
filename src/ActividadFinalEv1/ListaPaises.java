package ActividadFinalEv1;

import java.util.ArrayList;
import java.util.List;

public class ListaPaises {
    private List<PaisSerializable> paises = new ArrayList<>();

    // Getter y Setter

    public List<PaisSerializable> getPaises() {
        return this.paises;
    }

    public void setPaises(List<PaisSerializable> paises) {
        this.paises = paises;
    }

    public void addPais(PaisSerializable pais) {
        this.paises.add(pais);
    }
}
