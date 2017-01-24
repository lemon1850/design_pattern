/**
 * Created by tianhe on 2017/1/24.
 */


abstract  class Animal{
    int headSize = 20;
    int height = 180;
    // 每个动物都有自己装逼的技巧，
    EatBeaviour eatBeaviour;
    public void display(){
        System.out.println("zhuanbi");
    }
    public void performEat(){
        eatBeaviour.eat();
    }
}

interface EatBeaviour{
    void eat();
}
class DogEatBeavior implements  EatBeaviour{
    public void eat() {
        System.out.println("偷偷的吃");
    }
}
class CatEatBeavior implements  EatBeaviour{
    public void eat() {
        System.out.println("小口小口的吃");
    }
}

class Cat extends Animal{
    public Cat() {
        eatBeaviour = new CatEatBeavior();
    }
}

class Dog extends Animal{
    public Dog() {
        eatBeaviour = new DogEatBeavior();
    }
}

public class StrategyPattern {
    public static void  main(String[] args){
        Animal aCat = new Cat();
        aCat.performEat();
    }
}