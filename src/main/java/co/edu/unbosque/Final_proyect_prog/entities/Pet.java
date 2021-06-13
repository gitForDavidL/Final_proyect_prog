package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable {
    @Id
    @Column(name = "Name_id")
    private Integer name_id;
    @Column(name = "Microship")
    private long microchip;
    @Column(name = "Name")
    private String name;
    @Column(name = "Species")
    private String species;
    @Column(name = "Race")
    private String race;
    @Column(name = "Size")
    private String size;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "Picture")
    private String picture;
    @Column(name = "Owner_id")
    private Integer owner_id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_name")
    private Owner owner;

    @OneToMany(mappedBy = "pet",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetCase> cases;

    @OneToMany(mappedBy = "pet",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Picture> pictures;


    public Pet(Integer name_id, long microchip, String name, String species, String race, String size, String sex, String picture, Integer owner_id) {
        this.name_id = name_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner_id = owner_id;
    }

    public void addPicture(Picture p){
        pictures.add(p);
        p.setPet(this);
    }

    public void removePicture(Picture p){
        pictures.remove(p);
        p.setPet(null);
    }

    public Pet(){

    }

    public void addCase(PetCase p){
        cases.add(p);
        p.setPet_id(this.getName_id());
    }

    public void removeCase(PetCase p){
        cases.remove(p);
        p.setPet_id(0);
    }

    public Integer getName_id() {
        return name_id;
    }

    public void setName_id(Integer name_id) {
        this.name_id = name_id;
    }

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
