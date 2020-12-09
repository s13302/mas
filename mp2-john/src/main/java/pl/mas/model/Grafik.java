package pl.mas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Grafik {

    private LocalDateTime pracaOd;
    private LocalDateTime pracaDo;
    private BigDecimal stawka;

    private Instruktor instruktor;
    private MagazynSprzetu magazynSprzetu;

    public Grafik(BigDecimal stawka, Instruktor instruktor, MagazynSprzetu magazynSprzetu) {
        this(LocalDateTime.now(), stawka, instruktor, magazynSprzetu);
    }

    public Grafik(LocalDateTime pracaOd, BigDecimal stawka, Instruktor instruktor, MagazynSprzetu magazynSprzetu) {
        this(pracaOd, stawka);
        setInstruktor(instruktor);
        setMagazynSprzetu(magazynSprzetu);
    }

    Grafik(LocalDateTime pracaOd, BigDecimal stawka) {
        setPracaOd(pracaOd);
        setStawka(stawka);
    }

    public LocalDateTime getPracaOd() {
        return pracaOd;
    }

    private void setPracaOd(LocalDateTime pracaOd) {
        if (pracaOd != null) {
            this.pracaOd = pracaOd;
        } else {
            throw new IllegalArgumentException("Instruktor musi wiedzieć kiedy zaczyna pracę");
        }
    }

    public LocalDateTime getPracaDo() {
        return pracaDo;
    }

    public void setPracaDo(LocalDateTime pracaDo) {
        if (pracaDo != null) {
            if (pracaDo.isBefore(pracaOd) || pracaDo.isEqual(pracaOd)) {
                throw new IllegalArgumentException("Instruktor nie może w tym samym momencie zacząć i skończyć pracy");
            }
        }
        this.pracaDo = pracaDo;
    }

    public BigDecimal getStawka() {
        return stawka;
    }

    public void setStawka(BigDecimal stawka) {
        if (stawka != null && BigDecimal.ZERO.compareTo(stawka) <= 0) {
            this.stawka = stawka;
        } else {
            throw new IllegalArgumentException("Instruktor nie może pracować za darmo");
        }
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        if (this.instruktor != instruktor) {
            if (this.instruktor != null) {
                this.instruktor.removeGrafik(this);
            }
            this.instruktor = instruktor;
            if (instruktor != null) {
                instruktor.addGrafik(this);
            }
        }
    }

    public MagazynSprzetu getMagazynSprzetu() {
        return magazynSprzetu;
    }

    public void setMagazynSprzetu(MagazynSprzetu magazynSprzetu) {
        if (this.magazynSprzetu != magazynSprzetu) {
            if (this.magazynSprzetu != null) {
                this.magazynSprzetu.removeGrafik(this);
            }
            this.magazynSprzetu = magazynSprzetu;
            if (magazynSprzetu != null) {
                magazynSprzetu.addGrafik(this);
            }
        }
    }

    public Long getLiczbaGodzin() {
        if (pracaDo != null) {
            return pracaOd.until(pracaDo, ChronoUnit.HOURS);
        }
        return null;
    }

    public BigDecimal getWynagrodzenie() {
        if (pracaDo != null) {
            return stawka.multiply(BigDecimal.valueOf(getLiczbaGodzin()));
        }
        return null;
    }
}
