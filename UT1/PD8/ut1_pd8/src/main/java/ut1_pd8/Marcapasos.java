package ut1_pd8;

public class Marcapasos {
    Short PresionSanguinea; // 2 Bytes,  Valor entero entre -32768 y 32767, necesita 0-250
    Short FrecuenciaCardiaca; // 2 Bytes, necesita 0-226
    Short AzucarEnSangre; // 2 Bytes, necesita 0-1000
    Long MaximaFuerza; // 8 Bytes, Valor entre -9.223.372.036.854.775.808 y 9.223.372.036.854.775.807, necesita 0-3.000.000.000
    Float MinimoTiempoEntreLatidos; // 4 Bytes, entre 6 y 7 cifras decimales equivalentes, necesita 0-100 con decimales
    Double BateriaRestante; // 8 Bytes, unas 15 cifras decimales equivalentes, necesita % de batería restante con decimales con la mayor precisión posible
    char[] CodigoDelFabricante; // 2 Bytes por cada caracter, Unicode. Comprende el código ASCII, necesita números y letras, máximo 8 caracteres
}

/* b) 2 + 2 + 2 + 8 + 4 + 8 + 16 = 42 Bytes*/