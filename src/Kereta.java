import java.util.Arrays;

public class Kereta {
    private Ticket ticket;
    private String namaKereta;
    private int jumlahTiketTersedia;

    public Kereta() { //default constructor
        this.ticket = new Ticket();
        this.namaKereta = "Komuter";
        this.jumlahTiketTersedia = 1000;
    }

    public Kereta(String namaKereta, int jumlahTiketTersedia) {
        this.ticket = new Ticket(namaKereta, jumlahTiketTersedia);
        this.namaKereta = namaKereta;
        this.jumlahTiketTersedia = jumlahTiketTersedia;
    }

    public void tambahTiket(String namaPenumpang) { //menambah tiket untuk penumpangk
        if (this.jumlahTiketTersedia > 0) {
            String[] currentPenumpang = ticket.getNamaPenumpang();
            String[] newPenumpang = Arrays.copyOf(currentPenumpang, currentPenumpang.length + 1);
            newPenumpang[newPenumpang.length - 1] = namaPenumpang;
            ticket.setNamaPenumpang(newPenumpang);
            this.jumlahTiketTersedia--; //jumlah tiket dikurangi 1 setelah menambahkan penumpang
            System.out.println("==================================================");
            
            if (this.namaKereta.equals("Komuter")) {
                System.out.println("Tiket berhasil dipesan");
            }

            if (!this.namaKereta.equals("Komuter") && this.jumlahTiketTersedia < 30) {
                System.out.println("Tiket berhasil dipesan" + " Sisa tiket tersedia: " + this.jumlahTiketTersedia);
            } 
            
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            
        }
    }

    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (!asal.isEmpty() && !tujuan.isEmpty()) {
            tambahTiket(namaPenumpang + " \nAsal: " + asal + "\nTujuan: " + tujuan + "\n----------------------------");
        } else {
            System.out.println("==================================================");
            System.out.println("Penumpang KAJJ wajib memiliki asal dan tujuan tiket");
            System.out.println("==================================================");
        }
    }

    public void tampilkanTiket() { //menampilkan daftar penumpang sesuai nama kereta
        System.out.println("==================================================");
        System.out.println("Daftar penumpang kereta api " + this.namaKereta + ":");
        System.out.println("----------------------------");
        
        for (String penumpang : ticket.getNamaPenumpang()) {
            System.out.println("Nama: " + penumpang);
        }
    }
}
