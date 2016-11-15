
package tallermecanicoclases;

public class trabajos {
    
   public int id;
   public int numero_horas;
   public int precio_material;
   public boolean finalizaciondeltrabajo;

    public trabajos(int id, int numero_horas, int precio_material, boolean finalizaciondeltrabajo) {
        this.id = id;
        this.numero_horas = numero_horas;
        this.precio_material = precio_material;
        this.finalizaciondeltrabajo = finalizaciondeltrabajo;
    }

    public void setFinalizaciondeltrabajo(boolean finalizaciondeltrabajo) {
        this.finalizaciondeltrabajo = finalizaciondeltrabajo;
    }

    public boolean getfinalizaciondeltrabajo(){
        return finalizaciondeltrabajo;
    }

    public int getId() {
        return id;
    }

    public int getNumero_horas() {
        return numero_horas;
    }

    public int getPrecio_material() {
        return precio_material;
    }

    public void setNumero_horas(int numero_horas) {
        this.numero_horas = numero_horas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio_material(int precio_material) {
        this.precio_material = precio_material;
    }

    
   
   
    
}
