package edu.javaAlishev.sorttest.stops;

public class GreedyAlgorithms2 {
    public static void main(String[] args) {
        int[] station = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(station, 400));
    }

    private static int minStops(int[] stations, int capacity) {
        // Количество остановок и текущий диапазон топлива
        int stops = 0, reach = 0;
        for (int i = 0; i < stations.length - 1 && reach < stations[stations.length - 1]; i++) {
            if (reach < stations[i]) { // Если текущий диапазон меньше расстояния до следующей станции
                reach = stations[i - 1] + capacity; // Обновляем диапазон до предыдущей станции + емкость
                stops++; // Увеличиваем количество остановок
                if (stations[i] > reach) return -1; // Если следующая станция недостижима, возвращаем -1
            }
        }
        return stops;
    }
}
