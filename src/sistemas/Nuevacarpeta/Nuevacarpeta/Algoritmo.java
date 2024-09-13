package sistemas.Nuevacarpeta.Nuevacarpeta;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Algoritmo {
  protected int unit_tiempo = 0;
  protected ArrayList<TablaTiempos> tablas = new ArrayList<TablaTiempos>();
  protected ArrayList<Proceso> procesos = new ArrayList<Proceso>();

  Algoritmo() {
  }

  public void LeerProcesos() throws IOException {
    InputStreamReader entrada = new InputStreamReader(System.in);
    BufferedReader leer = new BufferedReader(entrada);
    System.out.print("Ingrese el numero de procesos : ");
    String n = leer.readLine();

    for (int i = 0; i < Integer.parseInt(n); i++) {
      Proceso proceso = new Proceso();
      System.out.print("\nIngrese el nombre del proceso : ");
      proceso.SetNombre(leer.readLine());
      System.out.print("\nIngrese el Tiempo de llegada : ");
      proceso.SetTiempoLlegada(Integer.parseInt(leer.readLine()));
      System.out.print("\nIngrese la Duracion : ");
      proceso.SetTDuracion(Integer.parseInt(leer.readLine()));
      System.out.print("\nIngrese la prioridad : ");
      proceso.SetPrioridad(Integer.parseInt(leer.readLine()));

      procesos.add(proceso);
    }
  }
  
  public void agregarProceso(Proceso p){
      procesos.add(p);
  }
public void limpiar(){
      procesos.clear();
  }
  public void ImprimirProceso() {
    System.out.println("Proceso\t TLl\t Duracion\t Prioridad\t TA\t TF\t Tret\t Tr\t W\t P\t Te\t");
    for (int i = 0; i < procesos.size(); i++) {
      System.out.print(procesos.get(i).GetNombre());
      System.out.print(" \t  " + procesos.get(i).GetTiempoLlegada());
      System.out.print(" \t\t" + procesos.get(i).GetTDuracion());
      System.out.print(" \t\t" + procesos.get(i).GetPrioridad());
      System.out.print(" \t  "+procesos.get(i).getTa());
      System.out.print(" \t  "+procesos.get(i).getTf());
      System.out.print(" \t  "+procesos.get(i).getTret());
      System.out.print(" \t  "+procesos.get(i).getT());
      System.out.print(" \t  "+procesos.get(i).getW());
      System.out.printf(" \t  %.2f",procesos.get(i).getP());
      System.out.print(" \t  "+procesos.get(i).getTe());
      System.out.println();
    }
  }

  public void SetUnitTiempo() {
    for (int i = 0; i < procesos.size(); i++) {

      if(procesos.get(i).GetTiempoLlegada()!=0)
        unit_tiempo+=procesos.get(i).GetTDuracion()+procesos.get(i).GetTiempoLlegada();
      else
        unit_tiempo += procesos.get(i).GetTDuracion();
    }
  }

  public void ImprimirTabla() {
 
    for (int i = 0; i < tablas.size(); i++) {
      System.out.print("L : ");
      tablas.get(i).getListos();
      System.out.print("\nU : "+tablas.get(i).getUnidadTiempo());
      System.out.print("\nE : \t"+tablas.get(i).getEjecucion()+"\n");
    }
  }
}
