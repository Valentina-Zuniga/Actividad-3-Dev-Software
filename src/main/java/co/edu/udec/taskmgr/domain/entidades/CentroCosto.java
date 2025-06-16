package co.edu.udec.taskmgr.domain.entidades;

public class CentroCosto {

    private int idCentro;
    private String nombreCentro;
    private int empleadoId;

    public CentroCosto() {
    }

    public CentroCosto(int idCentro, String nombreCentro, int empleadoId) {
        this.idCentro = idCentro;
        this.nombreCentro = (nombreCentro != null) ? nombreCentro : "";
        this.empleadoId = empleadoId;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }
}