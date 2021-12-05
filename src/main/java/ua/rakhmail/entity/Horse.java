package ua.rakhmail.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "horse")
@NoArgsConstructor
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int place;
    private boolean isChosen = false;
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    public Horse(String name, int place, boolean isChosen, Race race) {
        this.name = name;
        this.place = place;
        this.isChosen = isChosen;
        this.race = race;
    }
}
