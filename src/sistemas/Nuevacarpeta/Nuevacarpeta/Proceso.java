package sistemas.Nuevacarpeta.Nuevacarpeta;

public class Proceso {
  // ATRIBUTOS PROCESO
  private String nombre;
  private int tiempo_llegada;
  private int t_duracion;
  private int prioridad;
  private int ta, tf, tret, t, w, te;
  private double p;

  // CONSTRUCTOR
  Proceso() {
    nombre = "";
    tiempo_llegada = 0;
    t_duracion = 0;
    prioridad = 0;
  }

  Proceso(String _nombre, int _tiempo_llegada, int _t_duracion, int _prioridad) {
    nombre = _nombre;
    tiempo_llegada = _tiempo_llegada;
    t_duracion = _t_duracion;
    prioridad = _prioridad;
  }

  // METODOS
  public void SetNombre(String _nombre) {
    nombre = _nombre;
  }

  public void SetTiempoLlegada(int _tiempo_llegada) {
    tiempo_llegada = _tiempo_llegada;
  }

  public void SetTDuracion(int _t_duracion) {
    t_duracion = _t_duracion;
  }

  public void SetPrioridad(int _prioridad) {
    prioridad = _prioridad;
  }

  public String GetNombre() {
    return nombre;
  }

  public int GetTiempoLlegada() {
    return tiempo_llegada;
  }

  public int GetTDuracion() {
    return t_duracion;
  }

  public int GetPrioridad() {
    return prioridad;
  }

  public void setTa(int ta) {
    this.ta = ta;
  }

  public void setTf(int tf) {
    this.tf = tf;
  }

  public void setTret(int tret) {
    this.tret = tret;
  }
  public void setT(int t) {
    this.t = t;
  }
   public void setW(int w) {
    this.w = w;
  }
  public void setP(double p) {
    this.p = p;
  }
  public void setTe(int te) {
    this.te = te;
  }
  public int getTa() {
    return ta;
  }
  public int getTf() {
    return tf;
  }
  public int getTret() {
    return tret;
  }
  public int getT() {
    return t;
  }
  public int getW() {
    return w;
  }
  public double getP() {
    return p;
  }

  public int getTe() {
    return te;
  }
}
