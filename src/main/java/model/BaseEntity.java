package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
