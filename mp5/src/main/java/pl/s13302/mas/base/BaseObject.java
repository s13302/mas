package pl.s13302.mas.base;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String uuid;

    public BaseObject() {
        setUuid(UUID.randomUUID().toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    private void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseObject that = (BaseObject) o;
        return Objects.equals(getUuid(), that.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseObject{");
        sb.append("id=").append(id);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
