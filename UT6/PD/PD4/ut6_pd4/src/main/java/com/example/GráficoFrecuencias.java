package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Map;

public class GráficoFrecuencias {

    public GráficoFrecuencias(String titulo, Map<String, Integer> frecuencias) {
        super();
        JFreeChart grafico = crearGrafico(frecuencias);
        ChartPanel panel = new ChartPanel(grafico);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
    }

    private JFreeChart crearGrafico(Map<String, Integer> frecuencias) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entrada : frecuencias.entrySet()) {
            dataset.addValue(entrada.getValue(), "Frecuencia", entrada.getKey());
        }

        return ChartFactory.createBarChart(
                "Top 10 Palabras Más Frecuentes",
                "Palabras",
                "Frecuencia",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}
