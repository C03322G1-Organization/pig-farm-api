package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Storage;

public class IFoodDto {
    private Integer id;
    private Integer amount;
    private Storage storage;
    private Pigsty pigsty;
    private Boolean isDeleted;

    public IFoodDto() {
    }

    public IFoodDto(Integer id, Integer amount, Storage storage, Pigsty pigsty, Boolean isDeleted) {
        this.id = id;
        this.amount = amount;
        this.storage = storage;
        this.pigsty = pigsty;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Pigsty getPigsty() {
        return pigsty;
    }

    public void setPigsty(Pigsty pigsty) {
        this.pigsty = pigsty;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
