package sistemas.Nuevacarpeta.Nuevacarpeta;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Algoritmo2 {

    protected int unit_tiempo = 0;
    protected ArrayList<TablaTiempos> tablas = new ArrayList<TablaTiempos>();
    protected ArrayList<Proceso> procesos = new ArrayList<Proceso>();
    protected double tiempototal = 0;

    Algoritmo2() {
    }

    public void agregarProceso(Proceso p) {
        procesos.add(p);
    }

    public void limpiar() {
        procesos.clear();
        tablas.clear();
    }

    public void SetUnitTiempo() {
        for (int i = 0; i < procesos.size(); i++) {

            if (procesos.get(i).GetTiempoLlegada() != 0) {
                unit_tiempo += procesos.get(i).GetTDuracion() + procesos.get(i).GetTiempoLlegada();
            } else {
                unit_tiempo += procesos.get(i).GetTDuracion();
            }
        }
    }

    public void ImprimirTabla() {
        for (int i = 0; i < tablas.size(); i++) {
            System.out.print("L : ");
            tablas.get(i).getListos();
            System.out.print("\nU : " + tablas.get(i).getUnidadTiempo());
            System.out.print("\nE : \t" + tablas.get(i).getEjecucion() + "\n");
        }
    }

    public void ImprimirProceso() {
        System.out.println("Proceso\t TLl\t Duracion\t Prioridad\t TA\t TF\t Tret\t Tr\t W\t P\t Te\t");
        for (int i = 0; i < procesos.size(); i++) {
            System.out.print(procesos.get(i).GetNombre());
            System.out.print(" \t  " + procesos.get(i).GetTiempoLlegada());
            System.out.print(" \t\t" + procesos.get(i).GetTDuracion());
            System.out.print(" \t\t" + procesos.get(i).GetPrioridad());
            System.out.print(" \t  " + procesos.get(i).getTa());
            System.out.print(" \t  " + procesos.get(i).getTf());
            System.out.print(" \t  " + procesos.get(i).getTret());
            System.out.print(" \t  " + procesos.get(i).getT());
            System.out.print(" \t  " + procesos.get(i).getW());
            System.out.printf(" \t  %.2f", procesos.get(i).getP());
            System.out.print(" \t  " + procesos.get(i).getTe());
            System.out.println();
        }
    }

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
                    if (count == procesos.get(i).GetTDuracion()) {
                        procesos.get(i).setTf(tablas.get(j).getUnidadTiempo() + 1);
                    }
                }
            }
        }
    }

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

    public void setTasaDesperdicio() {
        for (int i = 0; i < procesos.size(); i++) {
            procesos.get(i).setW(procesos.get(i).getT() - procesos.get(i).GetTDuracion());
        }
    }

    public void setTasaPenalizacion() {
        for (int i = 0; i < procesos.size(); i++) {
            procesos.get(i).setP((double) procesos.get(i).getT() / (double) procesos.get(i).GetTDuracion());
        }
    }

    public void setTiempoEspera() {
        for (int i = 0; i < procesos.size(); i++) {
            procesos.get(i).setTe(procesos.get(i).getTa() - procesos.get(i).GetTiempoLlegada());
        }
    }

    public double getTiempoTotalRet() {
        double suma = 0;
        for (int i = 0; i < procesos.size(); i++) {
            suma += procesos.get(i).getTret();
        }

        return suma;
    }

    public double getTiempoTotalRes() {
        double suma = 0;
        for (int i = 0; i < procesos.size(); i++) {
            suma += procesos.get(i).getT();
        }

        return suma;
    }

    public double getTiempoTotalDes() {
        double suma = 0;
        for (int i = 0; i < procesos.size(); i++) {
            suma += procesos.get(i).getW();
        }

        return suma;
    }

    public double getTiempoTotalPena() {
        double suma = 0;
        for (int i = 0; i < procesos.size(); i++) {
            suma += procesos.get(i).getP();
        }

        return suma;
    }

    public double getTiempoTotalES() {
        double suma = 0;
        for (int i = 0; i < procesos.size(); i++) {
            suma += procesos.get(i).getTe();
        }

        return suma;
    }
}
