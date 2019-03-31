package Entitu;

import javax.persistence.*;

@Entity
@Table(name = "Socks", schema = "main")
public class SocksEntity {
    private Integer id;

    private String size;
    private String colour;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "size", nullable = false, length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "colour", nullable = false, length = 50)
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocksEntity that = (SocksEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (colour != null ? !colour.equals(that.colour) : that.colour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        return result;
    }
}
