import java.util.Scanner;

public class ManajemenNilaiSiswa11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] namaSiswa = new String[100];
        double[] nilaiSiswa = new double[100];
        int jumlahSiswa = 0;
        
        while (true) {
            System.out.print("Masukkan nama siswa atau ( ketik 'selesai' untuk berhenti ): ");
            String nama = sc.nextLine();
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }
            System.out.print("Masukkan nilai untuk " + nama + ": ");
            double nilai = sc.nextDouble();
            sc.nextLine(); 
            
            namaSiswa[jumlahSiswa] = nama;
            nilaiSiswa[jumlahSiswa] = nilai;
            jumlahSiswa++;
        }
        
        double totalNilai = 0;
        for (int i = 0; i < jumlahSiswa; i++) {
            totalNilai += nilaiSiswa[i];
        }
        double rataRata = totalNilai / jumlahSiswa;
        System.out.printf(" Rata-rata nilai kelas: ", rataRata);
        
        System.out.print("Siswa dengan nilai di atas rata-rata: ");
        String siswaDiAtasRataRata = " ";
        int jumlahDiAtasRataRata = 0;
        int jumlahDiBawahRataRata = 0;
        for (int i = 0; i < jumlahSiswa; i++) {
            if (nilaiSiswa[i] > rataRata) {
                siswaDiAtasRataRata += namaSiswa[i] + ", ";
                jumlahDiAtasRataRata++;
            } else {
                jumlahDiBawahRataRata++;
            }
        }
        
        if (!siswaDiAtasRataRata.equals( "")) {
            System.out.println(siswaDiAtasRataRata.substring(0, siswaDiAtasRataRata.length() - 2));
        } else {
            System.out.println("Tidak ada siswa dengan nilai di atas rata-rata.");
        }
        
        System.out.println("Jumlah siswa di atas rata-rata: " + jumlahDiAtasRataRata);
        System.out.println("Jumlah siswa di bawah rata-rata: " + jumlahDiBawahRataRata);
        
        if (jumlahDiAtasRataRata > jumlahSiswa / 2) {
            System.out.println("Mayoritas siswa memiliki nilai di atas rata-rata.");
        } else {
            System.out.println("Mayoritas siswa memiliki nilai di bawah rata-rata.");
        }
        
    }
}
