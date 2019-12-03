package com.mine.clones;

/**
 * 对象克隆实验
 */
public class Person implements Cloneable{
    private String name;
    private int age;
    private String sex;
    private Work work;

    public Person(String name,int age,String sex,Work work){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.work = work;
    }

    public Work getWork() {
        return work;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", work=" + work +
                '}';
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

class Work{
    private String jobName;

    public Work(String jobName) {
        this.jobName = jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "Work{" +
                "jobName='" + jobName + '\'' +
                '}';
    }
}