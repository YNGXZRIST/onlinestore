package com.kulaginvasily.onlinestore.goods;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@ToString
@RequiredArgsConstructor
@Table(name = "CAKE")
 public class CakeEntity {

    @Setter(AccessLevel.NONE)
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(name = "NAME")

    private String name;

    @Column(name = "CALORIES")
    private BigDecimal calories;

    @Column(name = "IMAGE")

    private String image;
    @Column(name = "PRICE")

    private BigDecimal price;
    @Column(name = "WEIGHT")

    private BigDecimal weight;

    @Column(name="COMPOSITION")

    private String composition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CakeEntity that = (CakeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
