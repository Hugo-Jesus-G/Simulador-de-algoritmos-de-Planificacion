package sistemas.Nuevacarpeta.Nuevacarpeta;

import java.util.LinkedList;
import java.util.Queue;

public class Fifo extends Algoritmo2 {

    Queue<String> cola = new LinkedList<String>();

    Fifo() {
    }

    public void AsignacionProceos() {
        SetUnitTiempo();
        for (int i = 0; i <= unit_tiempo; i++) {
            TablaTiempos tT = new TablaTiempos();
            tT.SetUnidadTiempo(i);

            for (int j = 0; j < procesos.size(); j++) {
                if (procesos.get(j).GetTiempoLlegada() == i) {
                    tT.AddListo(procesos.get(j).GetNombre());

                    for (int k = 0; k < procesos.get(j).GetTDuracion(); k++) {
                        cola.add(procesos.get(j).GetNombre());
                    }
                }
            }
            tablas.add(tT);
        }
    }

    public void EvaluacionFifo() {
        int min = procesos.get(0).GetTiempoLlegada();
        for (int j = 0; j < procesos.size(); j++) {
            if (procesos.get(j).GetTiempoLlegada() < min) {
                min = procesos.get(j).GetTiempoLlegada();
            }
        }
        for (int i = min; i < tablas.size(); i++) {
            if (!cola.isEmpty()) {
                tablas.get(i).SetEjecucion(cola.poll());
            } else {
                tablas.get(i).SetEjecucion("");
            }
        }

        setTiempoArranque();
        setTiempoFinalizacion();
        setTiempoRetorno();
        setTiempoRespuesta();
        setTasaDesperdicio();
        setTasaPenalizacion();
        setTiempoEspera();
    }
    /*
  public void setTiempoArranque() {
    Queue<String> cola = new LinkedList<String>();
    for (int i = 0; i < tablas.size(); i++) {
      for (int j = 0; j < procesos.size(); j++) {
        if (procesos.get(j).GetNombre().equals(tablas.get(i).getEjecucion())
            && !cola.contains(procesos.get(j).GetNombre())) {
          procesos.get(j).setTa(tablas.get(i).getUnidadTiempo());
          cola.add(procesos.get(j).GetNombre());
        }
      }
    }
    cola.clear();
  }

  public void setTiempoFinalizacion() {
    for (int i = 0; i < procesos.size(); i++) {
      int count = 0;
      for (int j = 0; j < tablas.size(); j++) {
        if (tablas.get(j).getEjecucion().equals(procesos.get(i).GetNombre())) {
          count++;
          if (count == procesos.get(i).GetTDuracion())
            procesos.get(i).setTf(tablas.get(j).getUnidadTiempo() + 1);
        }
      }
    }
  }*/
 /*
  public void setTiempoRetorno() {
    for (int i = 0; i < procesos.size(); i++) {
      procesos.get(i).setTret(procesos.get(i).getTf() - procesos.get(i).getTa());
    }
  }

  public void setTiempoRespuesta() {
    for (int i = 0; i < procesos.size(); i++) {
      procesos.get(i).setT(procesos.get(i).getTf() - procesos.get(i).GetTiempoLlegada());
    }
  }

  public void setTasaDesperdicio(){
    for(int i=0; i < procesos.size(); i++){
      procesos.get(i).setW(procesos.get(i).getT()-procesos.get(i).GetTDuracion());
    }
  }

  public void setTasaPenalizacion(){
    for(int i=0; i<procesos.size(); i++){
      procesos.get(i).setP((double)procesos.get(i).getT()/(double)procesos.get(i).GetTDuracion());
    }
  }

  public void setTiempoEspera(){
    for(int i=0; i<procesos.size();i++){
      procesos.get(i).setTe(procesos.get(i).getTa()-procesos.get(i).GetTiempoLlegada());
    }
  }
     */

}
