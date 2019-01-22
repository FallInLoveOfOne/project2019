package cn.innosoft.en.releaseRecord.dataInterfaceManage.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_FCF_INTERFACE")
@NamedQuery(name = "TFcfInterfaceEntity.findAll", query = "SELECT t FROM TFcfInterfaceEntity t")
public class TFcfInterfaceEntity {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "INTERFACE_NAME")
    private String interfaceName;

    @Column(name = "URL")
    private String url;

    @Column(name = "CALL_TIME")
    private String callTime;

    @Column(name = "CALL_MODULE")
    private String callModule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getCallModule() {
        return callModule;
    }

    public void setCallModule(String callModule) {
        this.callModule = callModule;
    }
}
