package com.company.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Component {
private String name;

private List<Integer> result = new ArrayList<Integer>();


    public Component() {

    this.result.addAll(Arrays.asList(0,0));
    }


    public Component(String name, List<Integer> result) {
        this.name = name;

        this.result.addAll(Arrays.asList(0,0));
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Integer> getResult() {
        return result;
    }

    public void setResultValue(int result) {
        this.result.set(1,result);
    }
    public void setResultNeg(int result) {
        this.result.set(0,result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component)) return false;
        Component component = (Component) o;
        return Objects.equals(getName(), component.getName()) && Objects.equals(getResult(), component.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getResult());
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", result=" + result +
                '}';
    }
}
