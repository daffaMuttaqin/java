package com.tutorial;

// Class Polos
// class Mahasiswa{
//     String name;
//     String NIM;
//     String jurusan;
//     double IPK;
//     int umur;
// }

// Class dengan constructor
class Mahasiswa{
    String nama;
    String NIM;
    String jurusan;

    Mahasiswa(String inputNama, String inputNIM, String inputJurusan){
        nama = inputNama;
        NIM = inputNIM;
        jurusan = inputJurusan;
    }
    // Method tanpa return dan tanpa parameter
    void show(){
        System.out.println("Nama    : " + this.nama);
        System.out.println("NIM     : " + this.NIM);
        System.out.println("Jurusan : " + this.jurusan);
    }

    // Method tanpa return dan dengan parameter
    void setNama(String nama){
        this.nama = nama;
    }

    // Method dengan return tanpa parameter
    // Pakai nya didalam print line
    String getNama(){
        return this.nama;
    }
}

public class Main {
    public static void main(String[] args) {

        Mahasiswa mahasiswa1 = new Mahasiswa("Daffa Muttaqin", "1806419", "Ilmu Komputer");
        // mahasiswa1.nama = "Daffa Muttaqin";
        // mahasiswa1.NIM = "1806419";
        // mahasiswa1.jurusan = "Ilmu Komputer";

        // System.out.println(mahasiswa1.nama);
        // System.out.println(mahasiswa1.NIM);
        // System.out.println(mahasiswa1.jurusan);

        mahasiswa1.setNama("Andi");
        mahasiswa1.show();
        System.out.println(mahasiswa1.getNama());
    }
}
