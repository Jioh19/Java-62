import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemaVentas {
    public static void main(String[] args) {
        // Clase interna para representar una venta
        class Venta {
            private String producto;
            private String categoria;
            private double monto;
            private String region;

            public Venta(String producto, String categoria, double monto, String region) {
                this.producto = producto;
                this.categoria = categoria;
                this.monto = monto;
                this.region = region;
            }

            public String getProducto() { return producto; }
            public String getCategoria() { return categoria; }
            public double getMonto() { return monto; }
            public String getRegion() { return region; }
        }

        // Crear lista de ventas de ejemplo
        List<Venta> ventas = Arrays.asList(
            new Venta("Laptop", "Electrónicos", 1200.0, "Norte"),
            new Venta("Smartphone", "Electrónicos", 800.0, "Sur"),
            new Venta("Tablet", "Electrónicos", 500.0, "Norte"),
            new Venta("Escritorio", "Muebles", 300.0, "Centro"),
            new Venta("Silla", "Muebles", 150.0, "Sur"),
            new Venta("TV", "Electrónicos", 900.0, "Centro")
        );

        // 1. Calcular el total de ventas por categoría
        Map<String, Double> ventasPorCategoria = ventas.stream()
            .collect(Collectors.groupingBy(
                Venta::getCategoria,
                Collectors.summingDouble(Venta::getMonto)
            ));
        
        System.out.println("1. Ventas totales por categoría:");
        ventasPorCategoria.forEach((categoria, total) -> 
            System.out.println(categoria + ": $" + total));

        // 2. Encontrar la región con la venta más alta
        Map.Entry<String, Double> regionMayorVenta = ventas.stream()
            .collect(Collectors.groupingBy(
                Venta::getRegion,
                Collectors.summingDouble(Venta::getMonto)
            ))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get();
        
        System.out.println("\n2. Región con mayor venta:");
        System.out.println(regionMayorVenta.getKey() + ": $" + regionMayorVenta.getValue());

        // 3. Filtrar ventas mayores a $500 y mostrar productos
        System.out.println("\n3. Productos con ventas mayores a $500:");
        ventas.stream()
            .filter(v -> v.getMonto() > 500)
            .map(Venta::getProducto)
            .forEach(System.out::println);

        // 4. Calcular el promedio de ventas en la región Norte
        double promedioNorte = ventas.stream()
            .filter(v -> v.getRegion().equals("Norte"))
            .mapToDouble(Venta::getMonto)
            .average()
            .orElse(0.0);
        
        System.out.println("\n4. Promedio de ventas en región Norte: $" + promedioNorte);
    }
}
