import java.io.*;

/**
 * Created by tianhe on 2017/1/24.
 */

class LowerCaseInputStream extends FilterInputStream{
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }
    @Override
    public int read() throws IOException {
        int c =  super.read();
        return (c == -1 ? c: Character.toLowerCase(c));
    }
}

abstract class Catt{
    String description = "unknown cat";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}

abstract class CatDecorator extends Catt{
    public abstract String getDescription();
}

class NiuNiu extends Catt{
    public NiuNiu() {
        description = "xiaomaomi";
    }

    public double cost() {
        return 1;
    }
}

class Beautiful extends  CatDecorator{
    Catt cat;
    public Beautiful(Catt cat) {
        this.cat = cat;
    }

    public double cost() {
        return 2+cat.cost();
    }

    public String getDescription() {
        return cat.getDescription() + " beautilful";
    }
}
class Cute extends  CatDecorator{
    Catt cat;
    public Cute(Catt cat) {
        this.cat = cat;
    }

    public double cost() {
        return 3+cat.cost();
    }

    public String getDescription() {
        return cat.getDescription() + " cute";
    }
}
public class DecoratePattern {
    public static void main(String[] args){
        Catt niuniu = new Cute(new Beautiful(new NiuNiu()));
        System.out.println(niuniu.getDescription());

//        int c;
//        try{
//            InputStream in = new LowerCaseInputStream(new BufferedInputStream(
//                    new FileInputStream("/Users/tianhe/IdeaProjects/design_patterns/src/main/java/a.txt")));
//            while((c = in.read())>=0){
//                System.out.print((char)c);
//            }
//            in.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
