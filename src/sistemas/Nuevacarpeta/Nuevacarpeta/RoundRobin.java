package sistemas.Nuevacarpeta.Nuevacarpeta;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin extends Algoritmo2 {

    int quatum;
    Queue<String> cola = new LinkedList<String>();
    Queue<String> cola2 = new LinkedList<String>();

    RoundRobin() {
    }

    public void setQuantum(int q) {
        quatum = q;
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

    public void EvaluacionRR() {
        int q_aux = 0;
        String aux_p = "";
        int min = procesos.get(0).GetTiempoLlegada();

        for (int j = 0; j < procesos.size(); j++) {
            if (procesos.get(j).GetTiempoLlegada() < min) {
                min = procesos.get(j).GetTiempoLlegada();
            }
        }
        for (int i = min; i < tablas.size(); i++) {
            if (!cola.isEmpty() && q_aux < quatum) {
                tablas.get(i).SetEjecucion(cola.poll());
                q_aux++;
                if (!aux_p.equals("") && !aux_p.equals(tablas.get(i).getEjecucion())) {
                    q_aux = 1;
                }
                aux_p = tablas.get(i).getEjecucion();
            } else if (!cola.isEmpty()) {
                q_aux = 0;
                String aux = cola.poll();
                while (!cola.isEmpty() && aux_p.equals(aux)) {
                    cola.add(aux_p);
                    aux = cola.poll();
                }
                tablas.get(i).SetEjecucion(aux);
                q_aux = 1;
                aux_p = tablas.get(i).getEjecucion();;
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

}
