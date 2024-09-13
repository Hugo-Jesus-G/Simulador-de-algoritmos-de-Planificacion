package sistemas.Nuevacarpeta.Nuevacarpeta;

import java.util.ArrayList;

public class TablaTiempos {
  private ArrayList<String> listos = new ArrayList<String>();
  private int unidadTiempo;
  private String ejecucion="";

  TablaTiempos() {}
 public void AddListo(String _listo) {
    listos.add(_listo); }

 public void SetUnidadTiempo(int _unidadTiempo) {
    unidadTiempo = _unidadTiempo; }

public void SetEjecucion(String _ejecucion) {
    ejecucion = _ejecucion;
  }
 public void getListos() {
   for (int i = 0; i < listos.size(); i++) {
      System.out.print(listos.get(i).toString()+" ");
    }}
public ArrayList<String> getListosArray(){
    return listos;
  }

  public int getUnidadTiempo() {
    return unidadTiempo;
  }

  public String getEjecucion() {
    return ejecucion;
  }
}