package arcmop.blog.springbootest.configuracion.controladores;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Hans
 */
@Entity
public class Simple{

    @Id
    @GeneratedValue
    private Long ID;
    private int sumando01;
    private int sumando02;
    private int resultado;

    public Simple() {
        super();
    }

    public Simple(Long ID, int sumando01, int sumando02, int resultado) {
        super();
        this.ID = ID;
        this.sumando01 = sumando01;
        this.sumando02 = sumando02;
        this.resultado = resultado;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getSumando01() {
        return sumando01;
    }

    public void setSumando01(int sumando01) {
        this.sumando01 = sumando01;
    }

    public int getSumando02() {
        return sumando02;
    }

    public void setSumando02(int sumando02) {
        this.sumando02 = sumando02;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
