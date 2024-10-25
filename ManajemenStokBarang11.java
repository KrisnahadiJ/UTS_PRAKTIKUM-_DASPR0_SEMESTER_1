import java.util.Scanner;

public class ManajemenStokBarang11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String [] namaBarang = new String[100];
        int [] jumlahStok = new int [100];
        double [] hargaPerUnit = new double [100];
        int jumlahBarang = 0;
        
        while (true) {
            System.out.print("Masukkan nama barang (ketik 'selesai' untuk berhenti): ");
            String nama = sc.nextLine();
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }
            System.out.print("Masukkan jumlah stok untuk " + nama + ": ");
            int stok = sc.nextInt();
            System.out.print("Masukkan harga per unit untuk " + nama + ": ");
            double harga = sc.nextDouble();
            sc.nextLine();
            
            namaBarang  [jumlahBarang] = nama;
            jumlahStok [jumlahBarang] = stok;
            hargaPerUnit [jumlahBarang] = harga;
            jumlahBarang++;
        }
        
        System.out.println(" Data barang telah dimasukkan. ");
        
        while (true) {
            System.out.print(" Masukkan nama barang yang ingin dicek stoknya (ketik 'selesai' untuk berhenti): ");
            String nama = sc.nextLine();
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }
            
            int index = -1;
            for (int i = 0; i < jumlahBarang; i++) {
                if (namaBarang[i].equalsIgnoreCase(nama)) {
                    index = i;
                    break;
                }
            }
            
            if (index == -1) {
                System.out.println("Barang tidak ditemukan.");
                continue;
            }
            
            System.out.print("Masukkan jumlah permintaan produk: ");
            int permintaan = sc.nextInt();
            sc.nextLine();
            
            double totalNilaiStok = jumlahStok[index] * hargaPerUnit[index];
            System.out.printf("Total nilai stok barang : ", namaBarang[index], totalNilaiStok);
            
            if (permintaan <= jumlahStok[index]) {
                jumlahStok[index] -= permintaan;
                System.out.println("Permintaan dapat dipenuhi. Sisa stok: " + jumlahStok[index]);
            } else {
                System.out.println("Permintaan tidak dapat dipenuhi. Stok tidak mencukupi.");
            }
        }
        
        System.out.println("\nInformasi stok barang setelah pemrosesan:");
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.printf("Barang: %s, Jumlah Stok: %d, Harga per Unit: ", namaBarang[i], jumlahStok[i], hargaPerUnit[i]);
        }
        
    }
}
