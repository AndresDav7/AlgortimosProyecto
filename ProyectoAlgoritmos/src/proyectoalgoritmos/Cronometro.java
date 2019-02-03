/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

/**
 *
 * @author Erick
 */
public class Cronometro {
    public static final byte UNIDAD_MEDIDA_NANOSEGUNDOS = 0;
    public static final byte UNIDAD_MEDIDA_MILISEGUNDOS = 1;

    private byte UNIDAD_MEDIDA;

    long TiempoReferencia = -1;
    long Acumulado = 0;

    /*public static void main(String[] args) throws Exception {
        Cronometro cronometro = new Cronometro(UNIDAD_MEDIDA_NANOSEGUNDOS);
        cronometro.Iniciar();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
        System.out.println(cronometro.SegundosTranscurridos());
    }*/

    public Cronometro() {
        this(UNIDAD_MEDIDA_MILISEGUNDOS);
    }

    public Cronometro(byte UNIDAD_MEDIDA) {
        switch (UNIDAD_MEDIDA) {
            case UNIDAD_MEDIDA_MILISEGUNDOS:
            case UNIDAD_MEDIDA_NANOSEGUNDOS:
                this.UNIDAD_MEDIDA = UNIDAD_MEDIDA;
                break;
            default:
                throw new RuntimeException("No se reconoce la unidad de medida");
        }
    }

    public byte UNIDAD_MEDIDA() {
        return UNIDAD_MEDIDA;
    }

    public void Modificar_UNIDAD_MEDIDA(byte UnidadMedida) {
        if (TiempoReferencia != -1 && Acumulado != 0) {
            return;
        }
        UNIDAD_MEDIDA = UnidadMedida;
    }

    public void Reestablecer() {
        TiempoReferencia = -1;
        Acumulado = 0;
    }

    public void Reiniciar() {
        CalcularTiempoReferencia_Actual();
        Acumulado = 0;
    }

    public void Iniciar() {
        if (!estaEnPausa()) {
            return;
        }
        Reiniciar();
    }

    public void Pausar() {
        if (estaEnPausa()) {
            return;
        }
        Acumulado = TiempoTranscurrido();
        TiempoReferencia = -1;
    }

    public void Reanudar() {
        if (!estaEnPausa()) {
            return;
        }
        CalcularTiempoReferencia_Actual();
    }

    public long TiempoTranscurrido() {
        if (estaEnPausa()) {
            return Acumulado;
        }
        switch (UNIDAD_MEDIDA) {
            case UNIDAD_MEDIDA_MILISEGUNDOS:
                return System.currentTimeMillis() - TiempoReferencia + Acumulado;
            case UNIDAD_MEDIDA_NANOSEGUNDOS:
                return System.nanoTime() - TiempoReferencia + Acumulado;
            default:
                throw new RuntimeException("No se reconoce la unidad de medida");
        }
    }

    public boolean estaEnPausa() {
        return TiempoReferencia == -1;
    }

    public double SegundosTranscurridos() {
        return TiempoTranscurrido() / UnidadesPorSegundo();
    }

    private void CalcularTiempoReferencia_Actual() {
        switch (UNIDAD_MEDIDA) {
            case UNIDAD_MEDIDA_MILISEGUNDOS:
                TiempoReferencia = System.currentTimeMillis();
                break;
            case UNIDAD_MEDIDA_NANOSEGUNDOS:
                TiempoReferencia = System.nanoTime();
                break;
        }
    }

    private double UnidadesPorSegundo() {
        switch (UNIDAD_MEDIDA) {
            case UNIDAD_MEDIDA_MILISEGUNDOS:
                return 1000.0;
            case UNIDAD_MEDIDA_NANOSEGUNDOS:
                return 1000000000.0;
            default:
                throw new RuntimeException("No se reconoce la unidad de medida");
        }
    }

    public static String ConvertirTiempo_Cadena(long tiempo, byte UnidadMedida) {
        double factorConversión;
        switch (UnidadMedida) {
            case UNIDAD_MEDIDA_MILISEGUNDOS:
                factorConversión = 1 / 1000.0;
                break;
            case UNIDAD_MEDIDA_NANOSEGUNDOS:
                factorConversión = 1 / 1000000000.0;
                break;
            default:
                throw new RuntimeException("No se reconoce la unidad de medida");
        }
        double segundos = tiempo * factorConversión;
        int horas = (int) (segundos / 60 / 60);
        int minutos = (int) (segundos / 60) % 60;
        segundos %= 60;
        return (horas < 10 ? "0" : "") + horas
                + ":" + (minutos < 10 ? "0" : "") + minutos
                + ":" + (segundos < 10 ? "0" : "")
                + String.format(
                        "%." + (UnidadMedida == UNIDAD_MEDIDA_MILISEGUNDOS ? 3 : 9) + "f", segundos
                ).replace(",", ".");
    }
}
