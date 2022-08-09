package tesaapp.login;

public class Login {
    private String idPegawai;
    private String namaPengguna;
    private String namaPegawai;
    private String password;
    private String jabatan;
    
    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getJabatanPegawai() {
        return jabatan;
    }

    public void setJabatanPegawai(String jabatanPegawai) {
        this.jabatan = jabatanPegawai;
    }
}