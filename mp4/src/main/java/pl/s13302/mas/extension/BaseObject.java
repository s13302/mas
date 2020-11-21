package pl.s13302.mas.extension;

import java.util.Objects;
import java.util.UUID;

public abstract class BaseObject extends ObjectPlus {

    private Long id;
    private String uuid;

    public BaseObject() {
        super();
        setUuid(UUID.randomUUID().toString());
    }

    public BaseObject(long id) {
        this();
        this.id = id;
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
