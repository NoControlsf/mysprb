package com.mysprb.mysprb.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

//加载指定的配置文件,不支持yml
//@PropertySource(value = {"classpath:MyConf.properties"})
//必须在容器中 加上Component
@Component
@ConfigurationProperties(prefix = "mybean")
//@Validated
public class MyBean {
    //value不支持松散绑定
    //@Value("${mybean.main-name}")
    private String mainName;
    //value支持springEL表达式
    //@Value("#{1+2+3}")
    private int id;
    //@Value("true")
    private Boolean flag;
    //校验数据格式注解
    //@Email
    private Date birthday;
    private HashMap<String, Object> map;
    private List<Object> list;
    private Person p;

    @Override
    public String toString() {
        return "MyBean{" +
                "mainName='" + mainName + '\'' +
                ", id=" + id +
                ", flag=" + flag +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", p=" + p +
                '}';
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
}
