package app.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Slot slot;

    @Column(nullable = false)
    private int stamina;

    @Column(nullable = false)
    private int strength;

    @Column(nullable = false)
    private int attack;

    @Column(nullable = false)
    private int defense;

    @ManyToMany(mappedBy = "items")
    private List<Hero> heroes;
}
