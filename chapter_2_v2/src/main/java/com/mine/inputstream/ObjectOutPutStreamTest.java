package com.mine.inputstream;

import com.sun.corba.se.impl.ior.ObjectAdapterIdNumber;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;

/**
 * @author yanyimim
 * @since 2019/12/19 18:19
 */
public class ObjectOutPutStreamTest {

    @Test
    public void method1(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","employee.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(inpath.toFile()));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(inpath.toString()))){
            Employee s = new Employee("秘书",12586, LocalDate.of(2019,12,25));
            Employee e1 = new Employee("张经理",12586, LocalDate.of(2019,12,25),s);
            Employee e2 = new Employee("王经理",12586, LocalDate.of(2019,12,25),s);
            out.writeObject(e1);
            out.writeObject(e2);
            Employee[] earr = new Employee[2];
            earr[0] = (Employee) in.readObject();
            earr[1] = (Employee) in.readObject();
            System.out.println(earr[0] == e1);
            System.out.println(earr[1] == e2);
            for (Employee e : earr) {
                System.out.println(e.hashCode());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method2() throws FileNotFoundException {
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","employee.dat");
        try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(inpath.toString()))){
            Employee e1 = (Employee) oin.readObject();
            Employee e2 = (Employee) oin.readObject();
            System.out.println(e1.hashCode());
            System.out.println(e2.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method3(){
        Path path = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","singleton.dat");
        try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path.toString()));
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toString()))){
            out.writeObject(Singletons.wangwu);
            out.writeObject(Singletons.lisi);
            out.flush();
            out.close();
            Singletons[] s = new Singletons[2];
            s[0]=(Singletons)oin.readObject();
            s[1]=(Singletons)oin.readObject();
            System.out.println(s[0] == Singletons.wangwu);
            System.out.println(s[1] == Singletons.lisi);
            for (Singletons ss:s) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method4(){
        Path path = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","singleton.dat");
        try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path.toString()))){
            Singletons s1 = (Singletons) oin.readObject();
            System.out.println(s1 == Singletons.wangwu);
            System.out.println(s1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method5() throws IOException {
            @Cleanup ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bout);) {
                out.writeObject(new Employee("王五",123,LocalDate.of(2019,12,12)));
                @Cleanup ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
                @Cleanup ObjectInputStream oin = new ObjectInputStream(bin);
                Employee e = (Employee) oin.readObject();
                System.out.println(e);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    @Test
    public void method6() throws IOException {
        Path o = FileSystems.getDefault().getPath("resources", "access.log");
        System.out.println(o.toString());
        @Cleanup BufferedReader reader = Files.newBufferedReader(o, StandardCharsets.UTF_8);
        String comtent= null;
        while((comtent = reader.readLine()) != null){
            System.out.println(comtent);
        }
    }
}
